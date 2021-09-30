package pandemic

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class InfectionSteps(var ctx:GlobalContext) {

    @Given("^(.*) is healthy$")
    fun paris_is_healthy(cityName: CityName) {
        // standard definition
    }

    @When("Paris gets infected")
    fun paris_gets_infected() {
        ctx.game.infect(CityName.Paris)

    }

    @Then("^(.*) infection level should (?:be|remain at) (\\d+)$")
    fun paris_infection_level_should_be(cityName: CityName, infectionLevel: Int) {
        val city = ctx.game.city(cityName)
        assertThat(city?.infectionLevel, equalTo(infectionLevel))
    }

    @Given("^(.*) infection level is (\\d+)$")
    fun paris_infection_level_is(cityName: CityName, infectionLevel: Int) {
        for (i in 1..infectionLevel)
            ctx.game.infect(cityName)
    }


    @And("^outbreak counter is (\\d+)$")
    fun outbreak_counter_is(counter: Int) {
        for (i in 1..counter)
            ctx.game.increaseOutbreakCounter()
    }


    @Then("^outbreak counter should be (\\d+)$")
    fun outbreak_counter_should_be(counter: Int) {
        assertThat(ctx.game.outbreakCounter.counter, equalTo(counter))
    }


    @Then("^the game should be lost$")
    fun the_game_should_be_lost() {
        assertThat("Game should be lost",
                ctx.game.isLost(), equalTo(true))
    }

}
