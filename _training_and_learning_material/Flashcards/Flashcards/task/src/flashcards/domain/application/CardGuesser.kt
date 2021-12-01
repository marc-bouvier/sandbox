package flashcards.domain.application

// Only inner dependencies & dependencies to ports & domain
import flashcards.domain.core.Card
import flashcards.domain.core.Deck
import flashcards.domain.core.Deck.GuessResult.Type.CARD_NOT_FOUND
import flashcards.domain.core.Deck.GuessResult.Type.RIGHT
import flashcards.domain.core.Deck.GuessResult.Type.RIGHT_BUT_WRONG_CARD
import flashcards.domain.core.Deck.GuessResult.Type.WRONG

class CardGuesser(
    private val deck: Deck,
    private val printOutput: (output: String) -> Unit,
    private val collectInput: () -> String,
    private val cardRandomizer: (deck: Deck) -> Card
) {
    fun guessRandomCard() = guess(cardRandomizer(deck))

    private fun guess(cardToGuess: Card) {
        printOutput("""Print the definition of "${cardToGuess.term}":""")
        val guess = collectInput()
        printOutput(formatAnswerGuessing(guess, cardToGuess))
    }

    private fun formatAnswerGuessing(guess: String, cardToGuess: Card): String {
        val guessResult = deck.attemptGuess(cardToGuess.term, guess)
        return when (guessResult.type) {
            RIGHT -> "Correct!"
            WRONG -> """Wrong. The right answer is "${cardToGuess.definition}"."""
            RIGHT_BUT_WRONG_CARD -> """Wrong. The right answer is "${cardToGuess.definition}". but your definition is correct for "${guessResult.rightButForWrongTerm?.term}" """
            CARD_NOT_FOUND -> "Card not found!"
        }
    }


}