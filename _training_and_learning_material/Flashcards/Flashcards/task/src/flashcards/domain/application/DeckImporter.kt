package flashcards.domain.application

import flashcards.domain.core.Deck
import flashcards.domain.ports.DeckDeSerializer
import flashcards.domain.ports.PersistanceHandle

class DeckImporter(private val deckDeSerializer: DeckDeSerializer, private val printOutput: (output: String) -> Unit) {
    fun import(deckFile: PersistanceHandle, deck: Deck) {
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
}
