package flashcards.domain.application

import flashcards.domain.core.Deck
import flashcards.domain.ports.DeckSerializer
import flashcards.domain.ports.PersistanceHandle

class DeckExporter(private val deckSerializer: DeckSerializer, private val printOutput: (output: String) -> Unit) {
    fun export(flashcardsFile: PersistanceHandle, deck: Deck) {
        val serializedDeck = deckSerializer.serialize(deck)
        flashcardsFile.writeBytes(serializedDeck)
        printOutput("${deck.numberOfCards()} cards have been saved.")
    }
}