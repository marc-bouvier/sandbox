import kotlin.random.Random

fun generateTemperature(seed: Int): String{
    val generator= Random (seed)

return List(7){generator.nextInt (20,31)}.joinToString(" ")
}
