package pandemic

class City(val cityName: CityName) {
    var infectionLevel = 0
        private set

    fun infect() {
        if (infectionLevel < 3)
            infectionLevel++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as City

        if (cityName != other.cityName) return false

        return true
    }

    override fun hashCode(): Int {
        return cityName.hashCode()
    }


}
