// write your function here

fun main() {
    val letter = readLine()!!.first()
    val isVowel: (Char) -> Boolean = { it -> it.lowercaseChar() in listOf('a', 'e', 'i', 'o', 'u') }
    println(isVowel(letter))
}


fun solution(numbers: List<Int>) =
    numbers.filter { it % 2 == 0 }
        .joinToString(" ")
        .let(::println)