fun main() {
    // write your code here
    val n = readLine()!!.toInt()
    val list = MutableList(n) { readLine()!!.toInt() }
    val rotations = readLine()!!.toInt()

    repeat(rotations % n) {
        list.add(0, list.removeAt(list.lastIndex))
    }
    println(list.joinToString(" "))
}

