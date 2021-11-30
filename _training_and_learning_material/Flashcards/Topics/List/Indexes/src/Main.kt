fun solution(products: List<String>, product: String) {
    products.mapIndexed { index, s -> Pair(index, s) }
        .filter { pair -> pair.second == product }
        .map { pair -> pair.first }
        .joinToString(" ")
        .let(::println)
}