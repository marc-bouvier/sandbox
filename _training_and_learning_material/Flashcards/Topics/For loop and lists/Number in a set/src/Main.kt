fun main() {
    // write your code here
    val n = readLine()!!.toInt()
    val numbers = MutableList(n){readLine()!!.toInt()}
    val m = readLine()!!.toInt()
    println(if(numbers.contains(m)) "YES" else "NO")
}