fun sequentialSearch(list: List<Int>, item: Int): Boolean {
    var index = 0
    while (index < list.count()) {
        if (list[index] == item) {
            return true
        }
        index = index + 1
    }
    return false
}

fun main() {
    val testList = listOf(1, 2, 32, 8, 17, 19, 42, 13, 0)

    println(
        "Search for 3 returns " +
                sequentialSearch(testList, 3)     // false
    )
    println(
        "Search for 13 returns " +
                sequentialSearch(testList, 13)    // true
    )
}
