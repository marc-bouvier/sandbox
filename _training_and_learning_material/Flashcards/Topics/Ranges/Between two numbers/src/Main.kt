fun main() {
    val number = readLine()!!.toInt()
    val lowBound = readLine()!!.toInt()
    val highBound = readLine()!!.toInt()

    println((lowBound..highBound).contains(number))

}