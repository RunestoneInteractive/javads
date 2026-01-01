fun selectionSort(list: MutableList<Int>) {
    for (i in list.count()-1 downTo 1) {
        var maxIndex = i

        // find index of largest item in range
        for (j in 0..< i) {
            if (list[j] > list[maxIndex]) {
                maxIndex = j
            }
        }

        // if it's not this item, swap them
        if (maxIndex != i) {
            val temporary = list[i]
            list[i] = list[maxIndex]
            list[maxIndex] = temporary
        }
    }
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point:  $testList")
    selectionSort(testList)
    println("Final result: $testList")
}
