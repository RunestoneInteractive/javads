fun <T: Comparable<T>> quickSort(list: MutableList<T>) {
    quickSortHelper(list, 0, list.count())
}

fun <T: Comparable<T>> quickSortHelper(list: MutableList<T>, start: Int, stop: Int) {
    if (stop - start > 1) {
        val split = partition(list, start, stop)
        quickSortHelper(list, start, split)
        quickSortHelper(list, split + 1, stop)
    }
}

fun <T: Comparable<T>> partition(list: MutableList<T>, start: Int, stop: Int): Int {
    val pivotValue = list[start]
    var leftMark = start + 1
    var rightMark = stop - 1
    var done = false

    while (!done) {
        while (leftMark <= rightMark && list[leftMark] <= pivotValue) {
            leftMark = leftMark + 1
        }
        while (leftMark <= rightMark && list[rightMark] >= pivotValue) {
            rightMark = rightMark - 1
        }

        if (rightMark < leftMark) {
            done = true
        } else {
            val temporary = list[leftMark]
            list[leftMark] = list[rightMark]
            list[rightMark] = temporary
        }
    }

    val temporary = list[start]
    list[start] = list[rightMark]
    list[rightMark] = temporary

    return rightMark
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point:  $testList")
    quickSort(testList)
    println("Final result: $testList")
}
