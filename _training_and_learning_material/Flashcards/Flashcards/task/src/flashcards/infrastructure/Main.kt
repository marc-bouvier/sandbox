package flashcards.infrastructure

import flashcards.domain.application.CardGuesser
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

// =============== Program bootstrapping ===============
// (glues all the parts together and runs a game)
fun main() {

    // =========== Setup dependencies ===========
    // Make implicit IO and randomness as explicit dependencies
    // Since those things are not deterministic, we don't want them in our
    // domain logic
    val stdInScanner = Scanner(System.`in`)
    val logger = MutableListLogger(mutableListOf())
    val collectInput: () -> String = { stdInScanner.nextLine().also { logger.append(it) } }
    val printOutput: (output: String) -> Unit = { output -> println(output).also { logger.append(output) } }
    val cardRandomizer: (deck: Deck) -> Card = { deck -> deck.cardsList().random() }
    val deckSerializer = ObjectDeckSerializer()
    val deckDeSerializer = ObjectDeckDeSerializer()
    val dataPersistance = FilePersistence()

    // Create game state
    val deck = Deck()

    // Bind dependencies to the application components
    val cardGuesser = CardGuesser(deck, printOutput, collectInput, cardRandomizer)
    val menu = FlashCardsMenu(
        printOutput,
        collectInput,
        cardGuesser,
        deck,
        deckSerializer,
        deckDeSerializer,
        logger,
        dataPersistance
    )

    menu.loop()
}