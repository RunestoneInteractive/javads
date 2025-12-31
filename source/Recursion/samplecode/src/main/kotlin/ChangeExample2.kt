import kotlin.math.min

fun makeChange2(
    coinValues: List<Int>,
    change: Int,
    knownResults: MutableList<Int>
): Int {
    if (coinValues.contains(change)) {
        knownResults[change] = 1
        return 1
    } else if (knownResults[change] != 0) {
        return knownResults[change]
    } else {
        var minCoins = Int.MAX_VALUE
        for (coinValue in coinValues) {
            if (coinValue > change) {
                break
            }
            val numCoins = 1 + makeChange2(
                coinValues,
                change - coinValue,
                knownResults
            )
            minCoins = min(numCoins, minCoins)
            knownResults[change] = minCoins
        }
        return minCoins
    }
}

fun main() {
    val coinValues = listOf(1, 5, 10, 25)
    val changeAmount = 63
    val knownResults = MutableList(changeAmount + 1) { 0 }
    println("Min # of coins: ${makeChange2(coinValues, changeAmount, knownResults)}")
}
