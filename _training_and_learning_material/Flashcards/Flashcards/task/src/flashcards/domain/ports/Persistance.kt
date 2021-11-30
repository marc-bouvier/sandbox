package flashcards.domain.ports

// Only dependencies from domain

interface Persistance {
    fun handleFor(name: String): PersistanceHandle
}