package flashcards.infrastructure.adapters

import flashcards.domain.core.Deck
import flashcards.domain.ports.DeckSerializer
import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream

class ObjectDeckSerializer : DeckSerializer {
    override fun serialize(deck: Deck): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        ObjectOutputStream(byteArrayOutputStream).writeObject(deck)
        return byteArrayOutputStream.toByteArray()
    }
}