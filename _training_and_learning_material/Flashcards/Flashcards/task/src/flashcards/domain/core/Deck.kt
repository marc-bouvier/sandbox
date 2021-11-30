package flashcards.domain.core

// Only dependencies from core domain
import java.io.Serializable

/**
 * @see <a href="https://williamdurand.fr/2013/06/03/object-calisthenics/#4-first-class-collections">Object Calisthenics - First Class Collections</a>
 */
class Deck : Serializable {
    private val cards: MutableCollection<Card> = mutableListOf()
    fun cardsList(): List<Card> = cards.toList()
    fun add(card: Card): Card {
        cards.add(card)
        return card
    }

    fun remove(termOfCardToRemove: String): Boolean {
        return cards.removeIf { it.term == termOfCardToRemove }
    }

    fun numberOfCards(): Int = cards.size
    fun merge(deck: Deck) {
        deck.cardsList().forEach { card ->
            this.merge(card)
        }
    }

    private fun merge(card: Card) {
        cards.removeIf { it.term == card.term }
        cards.add(card)
    }

    fun containsTerm(term: String): Boolean = cards.any { card -> card.term == term }
    fun containsDefinition(definition: String) = cards.any { card -> card.definition == definition }

    fun hardestCards(): List<Card> {
        return cards.filter { it.timesGuessedWrong() > 0 }
            .groupBy { it.timesGuessedWrong() }
            .maxByOrNull { it.key }
            ?.value ?: listOf()
    }

    fun attemptGuess(term: String, guess: String): GuessResult {
        val cardToGuess: Card = cards.firstOrNull { it.term == term }
            ?: return GuessResult(GuessResult.Type.CARD_NOT_FOUND)

        if (cardToGuess.attemptGuess(guess))
            return GuessResult(GuessResult.Type.RIGHT)

        val rightGuessButWrongTerm: Card? =
            cardsList().firstOrNull { it.definition == guess }
        if (rightGuessButWrongTerm != null) {
            return GuessResult(GuessResult.Type.RIGHT_BUT_WRONG_CARD, rightGuessButWrongTerm)
        }
        return GuessResult(GuessResult.Type.WRONG)
    }

    fun resetStats() {
        cards.forEach { it.resetStats() }
    }

    class GuessResult(val type: Type, val rightButForWrongTerm: Card? = null) {
        enum class Type {
            RIGHT, WRONG, RIGHT_BUT_WRONG_CARD, CARD_NOT_FOUND
        }
    }

}