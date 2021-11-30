package flashcards.domain.ports

// Only dependencies from domain

interface Logger {
    fun append(logLine: String)
    fun asString(): String
}
