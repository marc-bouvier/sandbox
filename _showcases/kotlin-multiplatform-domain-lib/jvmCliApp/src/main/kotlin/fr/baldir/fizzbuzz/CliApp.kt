package fr.baldir.fizzbuzz.fr.baldir.fizzbuzz

import fizzbuzz

class CliApp(
    val printOutput: (text: String) -> Unit,
    val readInput: () -> String
) {
    fun launch() {
        printOutput("Please enter a positive integer:")
        val input = readInput()
        if (input == "q" || input.toIntOrNull() == null) return
        val number = input.toInt()
        printOutput((1..number)
            .map { fizzbuzz(it) }.joinToString("\n")
        )
    }
}
