package flashcards.infrastructure.adapters

import flashcards.domain.core.Deck
import flashcards.domain.ports.DeckDeSerializer
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream

class ObjectDeckDeSerializer : DeckDeSerializer {
    override fun deserialize(rawDeck: ByteArray): Deck {
        return ObjectInputStream(ByteArrayInputStream(rawDeck)).readObject() as Deck
    }
}