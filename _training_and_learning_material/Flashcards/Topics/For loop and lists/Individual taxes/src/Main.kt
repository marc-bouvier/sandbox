fun main() {
    // write your code here
    val n = readLine()!!.toInt()
    val annualIncomes = List(n) { readLine()!!.toInt() }
    val taxesPaid = List(n) { readLine()!!.toInt() }
    annualIncomes.zip(taxesPaid)
        .mapIndexed { index, incomeAndTax -> Pair(index + 1, incomeAndTax.first * incomeAndTax.second) }
        .maxByOrNull { it.second }!!.first
        .also { lowerTaxCompanyNumber ->
            println(lowerTaxCompanyNumber)
        }
}