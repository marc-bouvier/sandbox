package flashcards.domain.ports

// Only dependencies from domain
import flashcards.domain.core.Deck

interface DeckSerializer {
    fun serialize(deck: Deck): ByteArray
}