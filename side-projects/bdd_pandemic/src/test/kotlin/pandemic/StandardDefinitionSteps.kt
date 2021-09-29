package pandemic

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import pandemic.CityName.*

class StandardDefinitionSteps(var ctx: GlobalContext) {

    @Then("^(.*) should be linked to (.*)$")
    fun should_be_linked_to(cityName: String, cities: String) {
        // Write code here that turns the phrase above into concrete actions
        var cn = CityName.valueOf(cityName)
        val split = cities.split(',').map { it -> it.trim() }
        var cts = split.map { s: String -> valueOf(s) }

        //TODO : assert

        // Pour réutiliser les contextes dans plusieurs fichiers utiliser un conteneu
        cts.forEach {
            assertThat("""City ${it} should be linked to ${cn}""",
                    ctx.game.network.areLinked(it, cn), equalTo(true))
        }

    }


    @Given("the occidental sub-network")
    fun the_occidental_sub_network() {
        val network = Network()
        /*setOf(
                LinkedCities(),
                LinkedCities(City(Paris), City(Milan)),
                LinkedCities(City(Paris), City(Essen)),
                LinkedCities(City(Paris), City(London)),
                LinkedCities(City(Paris), City(Madrid)),

                LinkedCities(City(NewYork), City(London)),
                LinkedCities(City(NewYork), City(Madrid))*/
        val paris = City(Paris)
        val london = City(London)
        val madrid = City(Madrid)
        val newYork = City(NewYork)
        network.addLinkedCities(paris, City(Algiers))
        network.addLinkedCities(paris, City(Milan))
        network.addLinkedCities(paris, City(Essen))
        network.addLinkedCities(paris, london)
        network.addLinkedCities(paris, madrid)
        network.addLinkedCities(newYork, london)
        network.addLinkedCities(newYork, madrid)
        ctx.game = Game(
                network,
                OutbreakCounter(0))
    }
}
