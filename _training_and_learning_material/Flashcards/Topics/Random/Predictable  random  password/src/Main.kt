import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    val generator = Random(seed)
    return List(10){generator.nextInt(33,127)}
.map{it.toChar()}
.joinToString("")
 
}
