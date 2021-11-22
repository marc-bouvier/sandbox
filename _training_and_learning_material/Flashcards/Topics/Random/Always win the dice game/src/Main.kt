import kotlin.random.Random

const val DICE6_NUMBER_OF_SIDES = 6
const val DICE6_FIRST_VALUE = 1

fun createDiceGameRandomizer(n: Int): Int {
    var seed = 0
    var seedNotFound = true
    while (seedNotFound) {
        val generator = Random(seed)
        val firstPlayerScore = throwDicesAndSumValues(n, generator)
        val secondPlayerScore = throwDicesAndSumValues(n, generator)
        if (firstPlayerScore < secondPlayerScore) {
            seedNotFound = false
        }
        seed++
    }
    return seed
}

/**
 * Throws n dices and sums all the values.
 * Can be configured for many kinds of dices.
 * Defaults to 6 sided Dice
 */
private fun throwDicesAndSumValues(
    numberOfThrows: Int,
    generator: Random,
    diceFirstValue: Int = DICE6_FIRST_VALUE,
    diceNumberOfSides: Int = DICE6_NUMBER_OF_SIDES
) =
    List(numberOfThrows) { generator.nextInt(diceFirstValue, diceNumberOfSides + 1) }
        .sum()