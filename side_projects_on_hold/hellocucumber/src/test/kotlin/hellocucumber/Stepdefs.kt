package hellocucumber

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import cucumber.api.java8.En
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat


class Stepdefs : En {
    private lateinit var today: String
    private lateinit var actualAnswer: String

    @Given("^today is Sunday$")
    fun today_is_Sunday() {
        today = "Sunday"
    }

    @Given("^today is Friday$")
    fun today_is_Friday() {
        today = "Friday"
    }


    @Given("^today is \"([^\"]*)\"$")
    fun today_is(day: String) {
        today = day
    }

    @When("^I ask whether it's friday yet$")
    fun i_ask_whether_it_s_friday_yet() {
        actualAnswer = isItFriday(today)
    }

    @Then("^I should be told \"([^\"]*)\"$")
    fun i_should_be_told(expectedAnswer: String) {
        assertThat(actualAnswer, `is`(equalTo(expectedAnswer)))
    }

}
