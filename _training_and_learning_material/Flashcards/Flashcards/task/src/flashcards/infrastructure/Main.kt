package flashcards.infrastructure

import flashcards.domain.application.CardGuesser
import flashcards.domain.application.DeckExporter
import flashcards.domain.application.DeckImporter
import flashcards.domain.application.FlashCardsMenu
import flashcards.domain.core.Card
import flashcards.domain.core.Deck
import flashcards.infrastructure.adapters.FilePersistence
import flashcards.infrastructure.adapters.MutableListLogger
import flashcards.infrastructure.adapters.ObjectDeckDeSerializer
import flashcards.infrastructure.adapters.ObjectDeckSerializer
import java.util.*

// In this project I try to follow some Software Craftsmanship guidelines
// short methods, separation of concerns, decouplage, rich OOP, S.O.L.I.D, Ports & Adapters
//
// Some rules from Object Calisthenics I try to follow :
// - 1 level of indentation
// - First class collections
// - Don't abbreviate
// - No getters/setters/Properties (I'm more flexible with this rule, but I enforce it when an attribute is mutable)
//
// Domain logic should rely on abstractions
// This way we keep it clean from I/O, randomness and nondeterministic dependencies
// Ex. Even simple println() is abstracted so this side effect (print to some output) is moved away from core domain logic
class Configuration(
    val import: Boolean = false,
    val importPath: String?,
    val export: Boolean = false,
    val exportPath: String?
) {
    companion object {
        fun fromArgs(args: Array<String>): Configuration {

            val importIndex = args.indexOf("-import")
            val (import: Boolean, importPath: String?) = if (importIndex != -1) {
                val importPathIndex = importIndex + 1
                Pair(true, args[importPathIndex])
            } else {
                Pair(false, null)
            }

            val exportIndex = args.indexOf("-export")
            val (export, exportPath: String?) = if (exportIndex != -1) {
                val exportPathIndex = exportIndex + 1
                Pair(true, args[exportPathIndex])
            } else {
                Pair(false, null)
            }

            return Configuration(import, importPath, export, exportPath)
        }
    }
}

// =============== Program bootstrapping ===============
// (glues all the parts together and runs a game)
fun main(args: Array<String>) {
    val configuration = Configuration.fromArgs(args)

    // =========== Setup dependencies ===========
    // Make implicit IO and randomness as explicit dependencies
    // Since those things are not deterministic, we don't want them in our
    // domain logic
    val stdInScanner = Scanner(System.`in`)
    val logger = MutableListLogger(mutableListOf())
    val collectInput: () -> String = { stdInScanner.nextLine().also { logger.append(it) } }
    val printOutput: (output: String) -> Unit = { output -> println(output).also { logger.append(output) } }
    val cardRandomizer: (deck: Deck) -> Card = { deck -> deck.cardsList().random() }
    val dataPersistance = FilePersistence()
    val deckExporter = DeckExporter(ObjectDeckSerializer(), printOutput)
    val deckImporter = DeckImporter(ObjectDeckDeSerializer(), printOutput)

    // Create game state
    val deck = Deck()
    if (configuration.import) {
        deckImporter.import(dataPersistance.handleFor(configuration.importPath!!), deck)
    }

    // Bind dependencies to the application components
    val cardGuesser = CardGuesser(deck, printOutput, collectInput, cardRandomizer)
    val menu = FlashCardsMenu(
        printOutput,
        collectInput,
        cardGuesser,
        deck,
        deckExporter,
        deckImporter,
        logger,
        dataPersistance
    )

    menu.loop()

    if (configuration.export) {
        deckExporter.export(dataPersistance.handleFor(configuration.exportPath!!), deck)
    }
}