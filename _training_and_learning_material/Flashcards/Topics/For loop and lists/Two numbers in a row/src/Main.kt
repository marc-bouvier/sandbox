fun main() {
    // write your code here
    List(readLine()!!.toInt()) { readLine()!!.toInt() }
        .joinToString(" ")
        .let {
            val (p, m) = readLine()!!.split(" ")
            println(if ("$p $m" in it || "$m $p" in it) "NO" else "YES")
        }
}