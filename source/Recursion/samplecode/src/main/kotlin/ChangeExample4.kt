fun makeChange4(
    coinValues: List<Int>,
    change: Int,
    minCoins: MutableList<Int>,
    coinsUsed: MutableList<Int>
): Int {
    for (cents in 0..change) {
        var coinCount = cents
        var newCoin = 1

        for (coinValue in coinValues) {
            if (coinValue > cents) {
                break
            }
            if (minCoins[cents - coinValue] + 1 < coinCount) {
                coinCount = minCoins[cents - coinValue] + 1
                newCoin = coinValue
            }
        }
        minCoins[cents] = coinCount
        coinsUsed[cents] = newCoin
    }
    return minCoins[change]
}

fun printCoins(coinsUsed: MutableList<Int>, change: Int) {
    var coin = change
    while (coin > 0) {
        val thisCoin = coinsUsed[coin]
        print("$thisCoin ")
        coin = coin - thisCoin
    }
    println()
}

fun main() {
    val coinValues = listOf(1, 5, 10, 21, 25)
    val changeAmount = 63
    val minCoins = MutableList(changeAmount + 1) { 0 }
    val coinsUsed = MutableList(changeAmount + 1) { 0 }
    print(
        String.format(
            "Making change for %d requires the following %d coins:  ",
            changeAmount,
            makeChange4(coinValues, changeAmount, minCoins, coinsUsed)
        )
    )
    printCoins(coinsUsed, changeAmount)
    println("The used list is as follows:")
    println(coinsUsed)
}
