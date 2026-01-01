fun binarySearch(list: List<Int>, item: Int): Boolean {
    var first = 0
    var last = list.count() - 1
    while (first <= last) {
        val midpoint = (first + last) / 2
        if (list[midpoint] == item) {
            return true
        } else if (item < list[midpoint]) {
            last = midpoint - 1
        } else {
            first = midpoint + 1
        }
    }
    return false
}

fun main() {
    val testList = listOf(1, 2, 8, 13, 17, 19, 32, 47)

    println(
        "Binary search for 3 returns " +
                binarySearch(testList, 3)       // false
    )
    println(
        "Binary search for 13 returns " +
                binarySearch(testList, 13)      // true
    )
}
