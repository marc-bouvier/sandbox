package flashcards.domain.ports

// Only dependencies from domain

interface PersistanceHandle {
    fun exists(): Boolean
    fun writeText(text: String)
    fun writeBytes(bytes: ByteArray)
    fun readBytes(): ByteArray
}