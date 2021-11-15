package fr.baldir.fizzbuzz.app

import fr.baldir.fizzbuzz.domain.fizzbuzz

/**
 * App (domain service?) can here be part of the domain
 * since I/O dependencies have been externalized
 */
class FizzBuzzApp(
    val printOutput: (text: String) -> Unit,
    val promptInput: (message: String) -> String
) {
    fun launch() {
        val input = promptInput("Please enter a positive integer:")
        if (input == "q" || input.toIntOrNull() == null) return
        val number = input.toInt()
        printOutput(
            (1..number).joinToString("\n") { fizzbuzz(it) }
        )
    }
}