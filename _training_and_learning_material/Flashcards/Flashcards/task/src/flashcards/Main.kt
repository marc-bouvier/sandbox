package flashcards

import flashcards.GuessResult.Type.CARD_NOT_FOUND
import flashcards.GuessResult.Type.RIGHT
import flashcards.GuessResult.Type.RIGHT_BUT_WRONG_CARD
import flashcards.GuessResult.Type.WRONG
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

// =============== Program boostraping ===============
// (glue all the parts together)
fun main() {

    // =========== Setup dependencies ===========
    // Make implicit IO and randomness as explicit dependencies
    val scanner = Scanner(System.`in`)
    val logger = ArrayList<String>()
    val collectInput: () -> String = scanner::nextLine.also { logger.add(it.toString()) }
    val printOutput: (output: String) -> Unit = { output -> println(output).also { logger.add(output) } }

    val cardRandomizer: (deck: FlashCardsDeck) -> Card = { deck -> deck.cardsList().random() }
    val deckSerializer = ObjectDeckSerializer()
    val deckDeSerializer = ObjectDeckDeSerializer()

    // Create game state
    val deck = FlashCardsDeck(mutableListOf())

    // Bind dependencies to the application components
    val cardGuesser = CardGuesser(deck, printOutput, collectInput, cardRandomizer)
    val menu = FlashCardsMenu(printOutput, collectInput, cardGuesser, deck, deckSerializer, deckDeSerializer, logger)

    menu.loop()
}

// =============== Application ===============
// (interaction logic)

class FlashCardsMenu(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    private val cardGuesser: CardGuesser,
    private val deck: FlashCardsDeck,
    private val deckSerializer: DeckSerializer,
    private val deckDeSerializer: DeckDeSerializer,
    private val logger: ArrayList<String>
) {

    private enum class MenuOption(val code: String) {
        ADD("add"),
        REMOVE("remove"),
        IMPORT("import"),
        EXPORT("export"),
        ASK("ask"),
        EXIT("exit"),
        LOG("log"),
        HARDEST_CARD("hardest card"),
        RESET_STATS("reset stats"),
        UNSUPPORTED("");

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
                MenuOption.ADD -> promptNewCardToDeck()
                MenuOption.EXPORT -> exportDeck()
                MenuOption.IMPORT -> importDeck()
                MenuOption.REMOVE -> removeCard()
                MenuOption.ASK -> askSeveralTimes()
                MenuOption.EXIT -> printExitMessage()
                MenuOption.LOG -> {
                    println("*** LOGS ***")
                    println("************")
                    println(logger)
                    println("************")
                }
                MenuOption.HARDEST_CARD -> {
                    when (val hardestCard = deck.hardestCard()) {
                        null -> printOutput("There are no cards with errors.")
                        else -> printOutput("The hardest card is \"${hardestCard.term}\". You have ${hardestCard.timesGuessedWrong} errors answering it.")
                    }
                }
                MenuOption.RESET_STATS -> {
                    TODO()
                }
                MenuOption.UNSUPPORTED -> {
                    unsupportedChoice(choice)
                }
            }
        } while (MenuOption.EXIT != choice)
    }

    private fun promptAction(): MenuOption {
        printOutput("Input the action (add, remove, import, export, ask, exit):")
        val input: String = collectInput()
        return MenuOption.fromCode(input)
    }

    private fun promptNewCardToDeck() {
        val term = inputTermForNewCard(deck) ?: return
        val definition = inputDefinitionForNewCard(deck) ?: return
        deck.add(Card(term, definition))
        printOutput("""The pair ("$term":"$definition") has been added""")
    }

    private fun inputTermForNewCard(deck: FlashCardsDeck): String? {
        printOutput("Card:")
        val term = collectInput()

        if (deck.containsTerm(term)) {
            printOutput("""The card "$term" already exists""")
            return null
        }
        return term
    }

    private fun inputDefinitionForNewCard(deck: FlashCardsDeck): String? {
        printOutput("The definition of the card:")
        val definition = collectInput()

        if (deck.containsDefinition(definition)) {
            printOutput("""The definition "$definition" already exists. Try again: """)
            return null
        }
        return definition
    }

    private fun exportDeck() {
        val flashcardsFile = promptForFile()
        val serializedDeck = deckSerializer.serialize(deck)
        flashcardsFile.writeBytes(serializedDeck)
        printOutput("${deck.numberOfCards()} cards have been saved.")
    }

    private fun importDeck() {
        val deckFile = promptForFile()
        if (!deckFile.exists()) {
            printOutput("File not found.")
        } else {
            val rawDeck = deckFile.readBytes()
            val loadedDeck = deckDeSerializer
                .deserialize(rawDeck)
            printOutput("${loadedDeck.numberOfCards()} cards have been loaded.")
//            printOutput("${loadedDeck.cards}")
            deck.merge(loadedDeck)
        }
    }

    private fun promptForFile(): File {
        printOutput("File name:")
        return File(collectInput())
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

class CardGuesser(
    private val deck: FlashCardsDeck,
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    val cardRandomizer: (deck: FlashCardsDeck) -> Card
) {
    fun guessRandomCard() {
        guess(cardRandomizer(deck))
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

        val result = deck.guess(cardToGuess.term, guess)

        return when (result.type) {
            RIGHT -> "Correct!"
            WRONG -> """Wrong. The right answer is "${cardToGuess.definition}"."""
            RIGHT_BUT_WRONG_CARD -> """Wrong. The right answer is "${cardToGuess.definition}". but your definition is correct for "${result.cardGuessedRightButForWrongTerm?.term}" """
            CARD_NOT_FOUND -> "Card not found!"
        }
    }
}

// =============== Domain ===============

data class Card(val term: String, val definition: String, var timesGuessedWrong: Int = 0) : Serializable

/**
 * @see <a href="https://williamdurand.fr/2013/06/03/object-calisthenics/#4-first-class-collections">Object Calisthenics - First Class Collections</a>
 */
class FlashCardsDeck(private val cards: MutableCollection<Card>) : Serializable {
    fun cardsList(): List<Card> = cards.toList()
    fun add(card: Card): Card {
        cards.add(card)
        return card
    }

    fun remove(termOfCardToRemove: String): Boolean {
        return cards.removeIf { it.term == termOfCardToRemove }
    }

    fun numberOfCards(): Int = cards.size
    fun merge(deck: FlashCardsDeck) {
        deck.cardsList().forEach { card ->
            this.merge(card)
        }
    }

    private fun merge(card: Card) {
        cards.removeIf { it.term == card.term }
        cards.add(card)
    }

    fun containsTerm(term: String): Boolean = cards.any { card -> card.term == term }
    fun containsDefinition(definition: String) = cards.any { card -> card.definition == definition }

    fun hardestCard(): Card? {
        return cards.maxByOrNull { card: Card -> card.timesGuessedWrong }
    }

    fun guess(term: String, guess: String): GuessResult {
        val cardToGuess: Card = cards.firstOrNull { it.term == term }
            ?: return GuessResult(CARD_NOT_FOUND)

        if (cardToGuess.definition == guess) return GuessResult(RIGHT)

        cardToGuess.timesGuessedWrong++
        val cardWithRightDefinitionButWrongTerm: Card? =
            cardsList().firstOrNull { cardFromDeck -> cardFromDeck.definition == guess }
        if (cardWithRightDefinitionButWrongTerm != null) {
            return GuessResult(RIGHT_BUT_WRONG_CARD, cardWithRightDefinitionButWrongTerm)
        }
        return GuessResult(WRONG)
    }
}

class GuessResult(val type: Type, val cardGuessedRightButForWrongTerm: Card? = null) {
    enum class Type {
        RIGHT, WRONG, RIGHT_BUT_WRONG_CARD, CARD_NOT_FOUND
    }
}

// =============== Ports ===============

interface DeckSerializer {
    fun serialize(deck: FlashCardsDeck): ByteArray
}

interface DeckDeSerializer {
    fun deserialize(rawDeck: ByteArray): FlashCardsDeck
}

// =============== Adapters ===============

class ObjectDeckSerializer : DeckSerializer {
    override fun serialize(deck: FlashCardsDeck): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        ObjectOutputStream(byteArrayOutputStream).writeObject(deck)
        return byteArrayOutputStream.toByteArray()
    }
}

class ObjectDeckDeSerializer : DeckDeSerializer {
    override fun deserialize(rawDeck: ByteArray): FlashCardsDeck {
        return ObjectInputStream(ByteArrayInputStream(rawDeck)).readObject() as FlashCardsDeck
    }
}
