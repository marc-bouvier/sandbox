package flashcards.domain.ports

// Only dependencies from domain
import flashcards.domain.core.Deck

interface DeckDeSerializer {
    fun deserialize(rawDeck: ByteArray): Deck
}