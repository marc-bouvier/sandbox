package flashcards.domain.application

// Only inner dependencies & dependencies to ports & domain
import flashcards.domain.application.FlashCardsMenu.MenuOption.*
import flashcards.domain.core.Card
import flashcards.domain.core.Deck
import flashcards.domain.ports.DeckDeSerializer
import flashcards.domain.ports.DeckSerializer
import flashcards.domain.ports.Logger
import flashcards.domain.ports.Persistance
import flashcards.domain.ports.PersistanceHandle

class FlashCardsMenu(
    private val printOutput: (output: String) -> Unit,
    private val collectInput: () -> String,
    private val cardGuesser: CardGuesser,
    private val deck: Deck,
    private val deckSerializer: DeckSerializer,
    private val deckDeSerializer: DeckDeSerializer,
    private val logger: Logger,
    private val dataPersistance: Persistance
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
            runAction(choice)
        } while (EXIT != choice)
    }

    private fun runAction(choice: MenuOption) {
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
    }

    private fun addCardToDeck() {
        val term = inputTermForNewCard(deck) ?: return
        val definition = inputDefinitionForNewCard(deck) ?: return
        deck.add(Card(term, definition))
        printOutput("""The pair ("$term":"$definition") has been added""")
    }

    private fun promptAction(): MenuOption {
        printOutput("Input the action (add, remove, import, export, ask, exit):")
        val input: String = collectInput()
        return MenuOption.fromCode(input)
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

    private fun promptForFile(): PersistanceHandle {
        printOutput("File name:")
        return dataPersistance.handleFor(collectInput())
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

    private fun resetStats() {
        deck.resetStats()
        printOutput("Card statistics have been reset.")
    }

    private fun notifyUnsupportedChoice(choice: MenuOption) {
        printOutput("""The command "$choice" is not supported.""")
    }
}