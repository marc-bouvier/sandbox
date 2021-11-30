package flashcards.domain.core

import java.io.Serializable

class Card(
    val term: String,
    val definition: String,
    private var timesGuessedWrong: Int = 0
) : Serializable {

    // Accessor for times guessed wrong
    // because it should not be changed from outside
    fun timesGuessedWrong(): Int {
        return timesGuessedWrong
    }

    fun resetStats() {
        timesGuessedWrong = 0
    }

    fun attemptGuess(guess: String): Boolean {
        return if (guess != definition) {
            timesGuessedWrong++
            false
        } else {
            true
        }
    }
}