package flashcards.infrastructure.adapters

import flashcards.domain.ports.Logger

class MutableListLogger(private val logs: MutableList<String>) : Logger {
    override fun append(logLine: String) {
        logs.add(logLine)
    }

    override fun asString() = logs.joinToString("\n")
}