package flashcards.infrastructure.adapters

import flashcards.domain.ports.Persistance
import flashcards.domain.ports.PersistanceHandle
import java.io.File

class FilePersistence : Persistance {
    override fun handleFor(name: String): PersistanceHandle {
        return FilePersistanceHandle(File(name))
    }

    class FilePersistanceHandle(private val file: File) : PersistanceHandle {
        override fun exists(): Boolean = file.exists()
        override fun writeText(text: String) = file.writeText(text)
        override fun writeBytes(bytes: ByteArray) = file.writeBytes(bytes)
        override fun readBytes(): ByteArray = file.readBytes()
    }
}