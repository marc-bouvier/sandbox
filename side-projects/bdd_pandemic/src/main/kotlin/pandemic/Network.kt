package pandemic

class Network {
    private val cityLinks: MutableSet<LinkedCities>
    private val cities: MutableSet<City>

    constructor() {
        this.cityLinks = HashSet()
        this.cities = HashSet()
    }

    fun city(cityName: CityName?): City? {
        return cities.find { city -> city.cityName == cityName }
    }

    fun areLinked(it: CityName, cn: CityName): Boolean {
        return citiesLinkedTo(it).contains(cn);
    }

    fun infect(cityName: CityName) {
        city(cityName)?.infect()
    }

    fun addLinkedCities(city: City, city1: City) {
        cities.add(city)
        cities.add(city1)
        cityLinks.add(LinkedCities(city.cityName, city1.cityName))
    }

    private fun citiesLinkedTo(cityName: CityName): Set<CityName> {
        return setOf(
                cityLinks.filter { it.city1 == cityName }.map { it.city2 },
                cityLinks.filter { it.city2 == cityName }.map { it.city1 }
        ).flatten().toSet()
    }

}
