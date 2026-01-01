fun orderedSequentialSearch(list: List<Int>, item: Int): Boolean {
    var index = 0
    while (index < list.count()) {
        if (list[index] == item) {
            return true
        }
        if (list[index] > item) {
            return false
        }
        index = index + 1
    }
    return false
}

fun main() {
    val testList = listOf(0, 1, 2, 8, 13, 17, 19, 32, 42)

    println(
        "Search for 3 returns " +
                orderedSequentialSearch(testList, 3)       // false
    )
    println(
        "Search for 13 returns " +
                orderedSequentialSearch(testList, 13)      // true
    )
}
