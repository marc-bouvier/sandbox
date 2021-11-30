package flashcards

import flashcards.FlashCardsMenu.MenuOption.ADD
import flashcards.FlashCardsMenu.MenuOption.ASK
import flashcards.FlashCardsMenu.MenuOption.EXIT
import flashcards.FlashCardsMenu.MenuOption.EXPORT
import flashcards.FlashCardsMenu.MenuOption.HARDEST_CARD
import flashcards.FlashCardsMenu.MenuOption.IMPORT
import flashcards.FlashCardsMenu.MenuOption.LOG
import flashcards.FlashCardsMenu.MenuOption.REMOVE
import flashcards.FlashCardsMenu.MenuOption.RESET_STATS
import flashcards.FlashCardsMenu.MenuOption.UNSUPPORTED
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

// =============== Program boostraping ===============
// (glues all the parts together and runs a game)
fun main() {

    // =========== Setup dependencies ===========
    // Make implicit IO and randomness as explicit dependencies
    // TODO : also externalize File dependencies
    val scanner = Scanner(System.`in`)
    val logger = Logger(mutableListOf())
    val collectInput: () -> String = { scanner.nextLine().also { logger.append(it) } }
    val printOutput: (output: String) -> Unit = { output -> println(output).also { logger.append(output) } }

    val cardRandomizer: (deck: Deck) -> Card = { deck -> deck.cardsList().random() }
    val deckSerializer = ObjectDeckSerializer()
    val deckDeSerializer = ObjectDeckDeSerializer()

    // Create game state
    val deck = Deck(mutableListOf())

    // Bind dependencies to the application components
    val cardGuesser = CardGuesser(deck, printOutput, collectInput, cardRandomizer)
    val menu = FlashCardsMenu(printOutput, collectInput, cardGuesser, deck, deckSerializer, deckDeSerializer, logger)

    menu.loop()
}

// =============== Application ===============
// (user interaction logic)

class FlashCardsMenu(
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    private val cardGuesser: CardGuesser,
    private val deck: Deck,
    private val deckSerializer: DeckSerializer,
    private val deckDeSerializer: DeckDeSerializer,
    private val logger: Logger
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
                return values().find { options -> options.code == code } ?: UNSUPPORTED
            }
        }
    }

    fun loop() {
        var choice: MenuOption
        do {
            choice = promptAction()
            when (choice) {
                ADD -> addCardToDeck()
                EXPORT -> exportDeck()
                IMPORT -> importDeck()
                REMOVE -> removeCard()
                ASK -> askSeveralTimes()
                EXIT -> showExitMessage()
                LOG -> saveLogs()
                HARDEST_CARD -> hardestCard()
                RESET_STATS -> resetStats()
                UNSUPPORTED -> notifyUnsupportedChoice(choice)
            }
        } while (EXIT != choice)
    }

    private fun resetStats() {
        deck.resetStats()
        printOutput("Card statistics have been reset.")
    }

    private fun saveLogs() {
        val logFile = promptForFile()
        logFile.writeText(logger.asString())
        printOutput("The log has been saved.7")
    }

    private fun hardestCard() {
        val hardestCards = deck.hardestCards()
        when {
            hardestCards.isEmpty() -> {
                printOutput("There are no cards with errors.")
            }
            hardestCards.size == 1 -> {
                val hardestCard = hardestCards.single()
                printOutput("The hardest card is \"${hardestCard.term}\". You have ${hardestCard.timesGuessedWrong()} errors answering it.")
            }
            else -> {
                val terms = hardestCards.joinToString(", ") { "\"${it.term}\"" }
                val timesGuessedWrong = hardestCards.first().timesGuessedWrong()
                printOutput("The hardest cards are $terms. You have $timesGuessedWrong errors answering them.")
            }
        }
    }

    private fun promptAction(): MenuOption {
        printOutput("Input the action (add, remove, import, export, ask, exit):")
        val input: String = collectInput()
        return MenuOption.fromCode(input)
    }

    private fun addCardToDeck() {
        val term = inputTermForNewCard(deck) ?: return
        val definition = inputDefinitionForNewCard(deck) ?: return
        deck.add(Card(term, definition))
        printOutput("""The pair ("$term":"$definition") has been added""")
    }

    private fun inputTermForNewCard(deck: Deck): String? {
        printOutput("Card:")
        val term = collectInput()

        if (deck.containsTerm(term)) {
            printOutput("""The card "$term" already exists""")
            return null
        }
        return term
    }

    private fun inputDefinitionForNewCard(deck: Deck): String? {
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

    private fun showExitMessage() {
        printOutput("Bye bye!")
    }

    private fun notifyUnsupportedChoice(choice: MenuOption) {
        printOutput("""The command "$choice" is not supported.""")
    }
}

class CardGuesser(
    private val deck: Deck,
    val printOutput: (output: String) -> Unit,
    val collectInput: () -> String,
    val cardRandomizer: (deck: Deck) -> Card
) {
    fun guessRandomCard() {
        guess(cardRandomizer(deck))
    }

    private fun guess(cardToGuess: Card) {
        printOutput("""Print the definition of "${cardToGuess.term}":""")
        val guess = collectInput()
        printOutput(formatAnswerGuessing(guess, cardToGuess))
    }

    private fun formatAnswerGuessing(guess: String, cardToGuess: Card): String {
        val guessResult = deck.attemptGuess(cardToGuess.term, guess)
        return when (guessResult.type) {
            RIGHT -> "Correct!"
            WRONG -> """Wrong. The right answer is "${cardToGuess.definition}"."""
            RIGHT_BUT_WRONG_CARD -> """Wrong. The right answer is "${cardToGuess.definition}". but your definition is correct for "${guessResult.rightButForWrongTerm?.term}" """
            CARD_NOT_FOUND -> "Card not found!"
        }
    }
}

class Logger(private val logs: MutableList<String>) {
    fun append(logLine: String) {
        logs.add(logLine)
    }

    fun asString() = logs.joinToString("\n")
}

// =============== Domain ===============

class Card(val term: String, val definition: String, private var timesGuessedWrong: Int = 0) : Serializable {

    // Accessor for times guessed wrong
    // because it should not be changed from outside
    fun timesGuessedWrong(): Int {
        return timesGuessedWrong
    }

    fun resetStats() {
        timesGuessedWrong = 0
    }

    fun attemptGuess(guess: String): Boolean {
        return if (guess != definition) {
            timesGuessedWrong++
            false
        } else {
            true
        }
    }
}

/**
 * @see <a href="https://williamdurand.fr/2013/06/03/object-calisthenics/#4-first-class-collections">Object Calisthenics - First Class Collections</a>
 */
class Deck(private val cards: MutableCollection<Card>) : Serializable {
    fun cardsList(): List<Card> = cards.toList()
    fun add(card: Card): Card {
        cards.add(card)
        return card
    }

    fun remove(termOfCardToRemove: String): Boolean {
        return cards.removeIf { it.term == termOfCardToRemove }
    }

    fun numberOfCards(): Int = cards.size
    fun merge(deck: Deck) {
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

    fun hardestCards(): List<Card> {
        return cards.filter { it.timesGuessedWrong() > 0 }
            .groupBy { it.timesGuessedWrong() }
            .maxByOrNull { it.key }
            ?.value ?: listOf()
    }

    fun attemptGuess(term: String, guess: String): GuessResult {
        val cardToGuess: Card = cards.firstOrNull { it.term == term }
            ?: return GuessResult(CARD_NOT_FOUND)

        if (cardToGuess.attemptGuess(guess))
            return GuessResult(RIGHT)

        val rightGuessButWrongTerm: Card? =
            cardsList().firstOrNull { it.definition == guess }
        if (rightGuessButWrongTerm != null) {
            return GuessResult(RIGHT_BUT_WRONG_CARD, rightGuessButWrongTerm)
        }
        return GuessResult(WRONG)
    }

    fun resetStats() {
        cards.forEach { it.resetStats() }
    }
}

class GuessResult(val type: Type, val rightButForWrongTerm: Card? = null) {
    enum class Type {
        RIGHT, WRONG, RIGHT_BUT_WRONG_CARD, CARD_NOT_FOUND
    }
}

// =============== Ports ===============

interface DeckSerializer {
    fun serialize(deck: Deck): ByteArray
}

interface DeckDeSerializer {
    fun deserialize(rawDeck: ByteArray): Deck
}

// =============== Adapters ===============

class ObjectDeckSerializer : DeckSerializer {
    override fun serialize(deck: Deck): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        ObjectOutputStream(byteArrayOutputStream).writeObject(deck)
        return byteArrayOutputStream.toByteArray()
    }
}

class ObjectDeckDeSerializer : DeckDeSerializer {
    override fun deserialize(rawDeck: ByteArray): Deck {
        return ObjectInputStream(ByteArrayInputStream(rawDeck)).readObject() as Deck
    }
}
