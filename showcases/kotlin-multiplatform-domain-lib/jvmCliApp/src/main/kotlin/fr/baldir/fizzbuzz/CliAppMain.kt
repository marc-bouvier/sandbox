package fr.baldir.fizzbuzz

import fr.baldir.fizzbuzz.app.FizzBuzzApp

// The main program is doing
// - dependencies configuration (here I/O)
fun main() {
    val app = FizzBuzzApp({ println(it)},{ readLine()!!})
    app.launch()
}