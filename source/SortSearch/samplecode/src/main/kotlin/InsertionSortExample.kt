fun insertionSort(list: MutableList<Int>) {
    for (i in 1 ..< list.count()) {
        val value = list[i]
        var position = i

        while (position > 0 && list[position - 1] > value) {
            list[position] = list[position - 1]
            position = position - 1
        }
        list[position] = value
    }
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point:  $testList")
    insertionSort(testList)
    println("Final result: $testList")
}
