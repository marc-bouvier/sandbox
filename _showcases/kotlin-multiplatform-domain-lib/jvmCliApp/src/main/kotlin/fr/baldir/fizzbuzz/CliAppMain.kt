package fr.baldir.fizzbuzz

import fr.baldir.fizzbuzz.fr.baldir.fizzbuzz.CliApp

// The main program is doing
// - dependencies configuration (here I/O)
fun main() {
    val app = CliApp({ println(it)},{ readLine()!!})
    app.launch()
}