fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    // put your code here

    return priceList.filter{ product -> product.key in shoppingList }
        .values.sum()
}