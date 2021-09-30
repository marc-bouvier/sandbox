package pandemic

class OutbreakCounter {

    val counter: Int

    constructor() {
        this.counter = 0
    }
    constructor(counter: Int) {
        this.counter = counter
    }

    fun isLost() = counter>=8

}
