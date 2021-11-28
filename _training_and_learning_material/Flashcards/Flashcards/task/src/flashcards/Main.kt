package flashcards

import java.io.File
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

typealias Cards = MutableCollection<Card>

fun main() {

    // =========== Setup dependencies ===========
    // Make implicit IO and randomness as explicit dependencies
    val scanner = Scanner(System.`in`)
    val collectInput: () -> String = scanner::nextLine
    val printOutput: (output: String) -> Unit = { output -> println(output) }
    val randomCardChooser: (cards: Cards) -> Card = { deck -> deck.random() }

    val deck = Deck(printOutput, collectInput)
    val cardGuesser = CardGuesser(deck, printOutput, collectInput, randomCardChooser)
    FlashCardsMenu(printOutput, collectInput, cardGuesser, deck).loop()
}

class FlashCardsMenu(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    private val cardGuesser: CardGuesser,
    private val deck: Deck
) {

    enum class MenuOption(val code: String) {
        ADD("add"), REMOVE("remove"), IMPORT("import"), EXPORT("export"), ASK("ask"), EXIT("exit"), UNSUPPORTED("");

        companion object {
            fun fromCode(code: String): MenuOption {
                val find: MenuOption? = values().find { options -> options.code == code }
                if (find != null)
                    return find
                return UNSUPPORTED
            }
        }
    }

    fun loop() {
        var choice: MenuOption
        do {
            choice = promptAction()
            when (choice) {
                MenuOption.ADD -> addToDeck()
                MenuOption.EXPORT -> exportDeck()
                MenuOption.IMPORT -> importDeck()
                MenuOption.REMOVE -> removeCard()
                MenuOption.ASK -> askSeveralTimes()
                MenuOption.EXIT -> printExitMessage()
                MenuOption.UNSUPPORTED -> unsupportedChoice(choice)
            }
        } while (MenuOption.EXIT != choice)
    }

    private fun promptAction(): MenuOption {
        printOutput("Input the action (add, remove, import, export, ask, exit):")
        val input: String = collectInput()
        return MenuOption.fromCode(input)
    }

    private fun addToDeck() {
        deck.add()
    }

    private fun exportDeck() {
        printOutput("File name:")
        val pathName = collectInput()
        val serializedDeck: String = JsonDeckSerializer(deck).serializeToString()
        val flashcardsFile = File(pathName)
        flashcardsFile.writeText(serializedDeck)
        printOutput("${deck.numberOfCards()} cards have been saved.")
    }

    private fun importDeck() {
        printOutput("File name:")
        val pathName = collectInput()
        val deckFile = File(pathName)
        if (!deckFile.exists()) {
            printOutput("File not found.")
        } else {
            val rawDeck = deckFile.readText()
            val loadedDeck = JsonDeckDeSerializer(rawDeck, printOutput, collectInput)
                .deserialize()
            printOutput("${loadedDeck.numberOfCards()} cards have been loaded.")
            printOutput("${loadedDeck.cards}")
            deck.mergeWith(loadedDeck)
        }
    }

    private fun removeCard() {
        printOutput("Which card?")
        val termOfCard = collectInput()
        if (deck.remove(termOfCard)) {
            printOutput("The card has been removed")
        } else {
            printOutput("""Can't remove "$termOfCard": there is no such card.""")
        }
    }

    private fun askSeveralTimes() {
        printOutput("How many times to ask?")
        val timesToAsk = collectInput().toInt()
        repeat(timesToAsk) { cardGuesser.guessRandomCard() }
    }

    private fun printExitMessage() {
        printOutput("Bye bye!")
    }

    private fun unsupportedChoice(choice: MenuOption) {
        printOutput("""The command "$choice" is not supported.""")
    }
}

class JsonDeckSerializer(private val deck: Deck) {
    fun serializeToString(): String {

        val jsonCards = deck.cards.joinToString(",\n") { it.toJsonLine() }
        return """
            [
            $jsonCards
            ]
        """.trimIndent()
    }

    private fun Card.toJsonLine() = """{ "term":"$term", "definition":"$definition" }"""
}

class JsonDeckDeSerializer(
    private val rawDeck: String,
    private val printOutput: (output: String) -> Unit,
    private val collectInput: () -> String
) {

    private val cardLinePattern = """^.*\{ "term":"(.*)", "definition":"(.*)" }.*""".toRegex()

    fun deserialize(): Deck {

        val lines = rawDeck.split("\n")
        val cards = lines.filter { "[" !in it && "]" !in it }
            .map(this::fromJson)
        return Deck(cards, printOutput, collectInput)
    }

    private fun fromJson(jsonLine: String): Card {
        val groups = cardLinePattern.matchEntire(jsonLine.trim())
            ?: throw IOException("Cannot match pattern $cardLinePattern with line $jsonLine")

        val term = groups.groups[1]?.value ?: throw IOException("Missing 'term' value for line $jsonLine")
        val definition =
            groups.groups[2]?.value ?: throw IOException("Missing 'definition' value for line $jsonLine")
        return Card(term, definition)
    }
}

data class Card(val term: String, val definition: String)

class Deck(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
) {
    val cards: Cards = ArrayList()

    constructor(
        newCards: List<Card>, printOutput: (output: String) -> Unit,
        collectInput: () -> String
    ) : this(printOutput, collectInput) {
        cards.addAll(newCards)
    }

    fun add() {
        // We abort the input if any input is incorrect
        val term = inputTermForNewCard() ?: return
        val definition = inputDefinitionForNewCard() ?: return

        val newCard = Card(term, definition)
        cards.add(newCard)
        printOutput("""The pair ("${newCard.term}":"${newCard.definition}") has been added""")

    }

    private fun inputTermForNewCard(): String? {
        printOutput("Card:")
        val term = collectInput()

        if (termIsDuplicateInDeck(term)) {
            printOutput("""The card "$term" already exists""")
            return null
        }
        return term
    }

    private fun termIsDuplicateInDeck(term: String) =
        cards.any { card -> card.term == term }

    private fun inputDefinitionForNewCard(): String? {
        printOutput("The definition of the card:")
        val definition = collectInput()

        if (definitionIsDuplicateInDeck(definition)) {
            printOutput("""The definition "$definition" already exists. Try again: """)
            return null
        }
        return definition
    }

    private fun definitionIsDuplicateInDeck(definition: String) = cards.any { card -> card.definition == definition }

    fun remove(termOfCardToRemove: String): Boolean {
        return cards.removeIf { it.term == termOfCardToRemove }
    }

    fun numberOfCards(): Int {
        return cards.size
    }

    fun mergeWith(loadedDeck: Deck) {
        loadedDeck.cards.forEach { card ->
            this.merge(card)
        }
    }

    private fun merge(card: Card) {
        cards.removeIf { it.term == card.term }
        cards.add(card)
    }
}

class CardGuesser(
    private val deck: Deck,
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    val cardPicker: (cards: Cards) -> Card = { it.random() }
) {

    fun guessRandomCard() {
        guess(cardPicker(deck.cards))
    }

    private fun guess(cardToGuess: Card) {
        printOutput("""Print the definition of "${cardToGuess.term}":""")
        val guess = collectInput()

        printOutput(formatAnswerGuessing(guess, cardToGuess))
    }

    private fun formatAnswerGuessing(
        guess: String,
        cardToGuess: Card
    ): String {
        return if (cardIsGuessedRight(guess, cardToGuess)) {
            "Correct!"
        } else if (cardIsGuessedRightButForWrongTerm(guess, cardToGuess)) {
            val cardGuessedWithWrongTerm = cardsGuessedRightButForWrongTerm(guess, cardToGuess)[0]
            """Wrong. The right answer is "${cardToGuess.definition}". but your definition is correct for "${cardGuessedWithWrongTerm.term}" """
        } else {
            """Wrong. The right answer is "${cardToGuess.definition}"."""
        }
    }

    private fun cardIsGuessedRightButForWrongTerm(
        guess: String,
        cardToGuess: Card,
    ): Boolean {
        return cardsGuessedRightButForWrongTerm(guess, cardToGuess).isNotEmpty()
    }

    private fun cardsGuessedRightButForWrongTerm(guess: String, cardToGuess: Card): List<Card> {
        return deck.cards
            .filter { cardFromDeck -> cardFromDeck.definition == guess }
            .filter { cardWithMatchingDefinition -> cardWithMatchingDefinition.term != cardToGuess.term }
    }

    private fun cardIsGuessedRight(
        guess: String, cardToGuess: Card,
    ): Boolean {
        return deck.cards
            .filter { cardFromDeck -> cardFromDeck.definition == guess }
            .any { cardWithMatchingDefinition -> cardWithMatchingDefinition.term == cardToGuess.term }
    }
}
