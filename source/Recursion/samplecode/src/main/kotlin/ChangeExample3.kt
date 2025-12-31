fun makeChange3(
    coinValues: List<Int>,
    change: Int,
    minCoins: MutableList<Int>
): Int {
    for (cents in 0..change) {
        var coinCount = cents

        for (coinValue in coinValues) {
            if (coinValue > cents) {
                break
            }
            if (minCoins[cents - coinValue] + 1 < coinCount) {
                coinCount = minCoins[cents - coinValue] + 1
            }
        }
        minCoins[cents] = coinCount
    }
    return minCoins[change]
}

fun main() {
    val coinValues = listOf(1, 5, 10, 25)
    val changeAmount = 63
    val minCoins = MutableList(changeAmount + 1) { 0 }
    println("Min # of coins: ${makeChange3(coinValues, changeAmount, minCoins)}")
}
