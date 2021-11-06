fun main() {
    // write your code here
    val a = readLine()!!.toInt()
    val numbers = MutableList(a) { readLine()!!.toInt() }
    numbers.add(0, numbers.removeLast())
    println(numbers.joinToString(" "))

}