fun binarySearchRecursive(list: List<Int>, item: Int): Boolean {
    if (list.count() == 0) {
        return false
    }
    val midpoint = list.count() / 2
    if (list[midpoint] == item) {
        return true
    } else if (item < list[midpoint]) {
        val leftHalf = list.slice(0 ..< midpoint)
        return binarySearchRecursive(leftHalf, item)
    } else {
        val rightHalf = list.slice(midpoint+1 ..< list.count())
        return binarySearchRecursive(rightHalf, item)
    }
}

fun main() {
    val testList = listOf(1, 2, 8, 13, 17, 19, 32, 47)

    println(
        "Binary search for 3 returns " +
                binarySearchRecursive(testList, 3)     // false
    )
    println(
        "Binary search for 13 returns " +
                binarySearchRecursive(testList, 13)    // true
    )
}
