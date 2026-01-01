fun <T: Comparable<T>> shellSort (list: MutableList<T>) {
    var sublistCount = list.count() / 2
    while (sublistCount > 0) {
        for (startPos in 0 ..< sublistCount) {
            gapInsertionSort(list, startPos, sublistCount)
        }
        println("After increments of size $sublistCount, the list is $list")
        sublistCount = sublistCount / 2
    }
}

fun <T: Comparable<T>> gapInsertionSort(list: MutableList<T>, start: Int, gap: Int) {
    for (i in start + gap ..< list.count() step gap) {
        val value = list[i]
        var position = i
        while (position >= gap && list[position - gap] > value) {
            list[position] = list[position - gap]
            position = position - gap
        }
        list[position] = value
    }
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point:  $testList")
    shellSort(testList)
    println("Final result: $testList")
}
