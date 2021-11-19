package pandemic

class  Game(var network: Network, var outbreakCounter: OutbreakCounter) {
    fun infect(cityName: CityName) {
        val city= this.network.city(cityName)
        if (city?.infectionLevel == 3) {
            increaseOutbreakCounter()
        }
        network.infect(cityName)

    }

    fun increaseOutbreakCounter() {
        if (outbreakCounter.counter < 9)
            outbreakCounter = OutbreakCounter(outbreakCounter.counter + 1)
    }

    fun isLost() = outbreakCounter.isLost()
    fun city(paris: CityName): City? {
        return network.city(paris)
    }

}