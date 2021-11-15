package fr.baldir.fizzbuzz.unit

import fr.baldir.fizzbuzz.fr.baldir.fizzbuzz.CliApp
import kotlin.test.Test
import kotlin.test.assertEquals

// Testing Cli interactions
class CliAppTest {


    // Test CLI behaviour
    // IO is mocked
    @Test
    fun shouldPromptForNumberWhenAppIsLaunched() {

        // Test dependencies
        val stdOutContent = mutableListOf<String>()
        val printOutput: (text: Any) -> Unit = { stdOutContent.add(it.toString()) }

        val app = CliApp(printOutput, { "q" })
        app.launch()

        // Should prompt for a number
        val actualCliOutput = stdOutContent.joinToString("\n")
        assertEquals("Please enter a positive integer:", actualCliOutput)
    }

    @Test
    fun shouldPrint1When1IsGiven() {

        // Test dependencies
        val stdOutContent = mutableListOf<String>()
        val printOutput: (text: Any) -> Unit = { stdOutContent.add(it.toString()) }
        val stdIntInputs = mutableListOf("1")
        val readInput: () -> String = { stdIntInputs.removeLast() }

        val app = CliApp(printOutput, readInput)
        app.launch()

        // Should prompt for a number
        val actualCliOutput = stdOutContent.joinToString("\n")
        assertEquals(
            """Please enter a positive integer:
                |1
            """.trimMargin(),
            actualCliOutput
        )
    }

    @Test
    fun shouldPrint12When2IsGiven() {

        // Test dependencies
        val stdOutContent = mutableListOf<String>()
        val printOutput: (text: Any) -> Unit = { stdOutContent.add(it.toString()) }
        val stdIntInputs = mutableListOf("2")
        val readInput: () -> String = { stdIntInputs.removeLast() }

        val app = CliApp(printOutput, readInput)
        app.launch()

        // Should prompt for a number
        val actualCliOutput = stdOutContent.joinToString("\n")
        assertEquals(
            """Please enter a positive integer:
                |1
                |2
            """.trimMargin(),
            actualCliOutput
        )
    }
}