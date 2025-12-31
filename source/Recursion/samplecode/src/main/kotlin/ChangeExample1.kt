import kotlin.math.min

fun makeChange1(coinValues: List<Int>, change: Int): Int {
    if (coinValues.contains(change)) {
        return 1
    }

    var minCoins = Int.MAX_VALUE
    for (coinValue in coinValues) {
        if (coinValue > change) {
            break
        }
        val numCoins = 1 + makeChange1(
            coinValues,
            change - coinValue
        )
        minCoins = min(numCoins, minCoins)
    }
    return minCoins
}

fun main() {
    val coinValues = listOf(1, 5, 10, 25)
    println("Min # of coins: ${makeChange1(coinValues, 63)}")
}
