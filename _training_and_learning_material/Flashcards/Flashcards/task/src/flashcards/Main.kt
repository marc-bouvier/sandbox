package flashcards

import java.io.File
import java.util.*
import kotlin.collections.ArrayList

typealias Cards = MutableCollection<Card>

fun main() {
    // Dependency management:
    // Externalize IO implementation as functions for better decouplage & CLI testability
    val scanner = Scanner(System.`in`)
    val collectInput: () -> String = scanner::nextLine
    val printOutput: (output: String) -> Unit = { output -> println(output) }
    // Rendom stuff is externalized for testability
    val randomCardChooser: (cards: Cards) -> Card = { deck -> deck.random() }

    //DeckBuilder(printOutput, collectInput).build()
    val deck = Deck(printOutput, collectInput)

    val cardGuesser = CardGuesser(deck, printOutput, collectInput, randomCardChooser)

    FlashCardsMenu(printOutput, collectInput, cardGuesser, deck).loop()
}

class FlashCardsMenu(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    val cardGuesser: CardGuesser,
    val deck: Deck
) {

    enum class Option(val code: String) {
        ADD("add"), REMOVE("remove"), IMPORT("import"), EXPORT("export"), ASK("ask"), EXIT("exit"), UNSUPPORTED("");

        companion object {
            fun fromCode(code: String): Option {
                val find: Option? = values().find { options -> options.code == code }
                if (find != null)
                    return find
                return UNSUPPORTED
            }
        }
    }

    fun loop() {
        var choice: Option
        do {
            choice = prompt()
            when (choice) {
                Option.ADD -> {
                    deck.add()
                }
                Option.EXPORT -> {
                    printOutput("File name:")
                    val fileName = collectInput()
                    val serializedDeck: String = DeckSerializer(deck).serializeToString()
                    TODO("Save to file")
                    printOutput("${deck.numberOfCards()} cards have been saved.")
                }
                Option.IMPORT -> {
                }
                Option.REMOVE -> remove()
                Option.ASK -> cardGuesser.guessRandomCard()
                Option.EXIT -> printExitMessage()
                Option.UNSUPPORTED -> printOutput("""The command "$choice" is not supported.""")
            }
        } while (Option.EXIT != choice)

    }

    private fun printExitMessage() {
        printOutput("Bye bye!")
    }

    private fun remove() {
        printOutput("Which card?")
        val termOfCard = collectInput()
        if (deck.remove(termOfCard)) {
            printOutput("The card has been removed")
        } else {
            printOutput("""Can't remove "$termOfCard": there is no such card.""")
        }
    }

    private fun prompt(): Option {
        printOutput("Input the action (add, remove, import, export, ask, exit):")
        val input: String = collectInput()
        return Option.fromCode(input)
    }
}

class DeckSerializer(val deck: Deck) {
    fun serializeToString(): String {

        val jsonCards = deck.cards.map { it.toJson() }.joinToString(",\n")
        return """
            {
            $jsonCards
            }
        """.trimIndent()
    }

    private fun Card.toJson() = """{ "term":"$term", "definition"="$definition" }"""
}


data class Card(val term: String, val definition: String)

class Deck(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
) {
    val cards: Cards = ArrayList()

    fun add() {
        // We abort the input if any input is incorrect
        val term = inputTermForNewCard() ?: return
        val definition = inputDefinitionForNewCard() ?: return

        val newCard = Card(term, definition)
        cards.add(newCard)
        printOutput("""The pair ("${newCard.term}":"${newCard.definition}") has been added""")

    }

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

    fun remove(termOfCardToRemove: String): Boolean {
        return cards.removeIf { it.term == termOfCardToRemove }
    }

    fun numberOfCards(): Int {
        return cards.size
    }
}

class CardGuesser(
    val deck: Deck,
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    val cardPicker: (cards: Cards) -> Card = { deck -> deck.random() }
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

