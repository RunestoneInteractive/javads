fun bubbleSortShort(list: MutableList<Int>) {
    for (i in list.count() - 1 downTo 1) {
        var exchanges = false
        for (j in 0..<i) {
            if (list[j] > list[j + 1]) {
                val temporary = list[j]
                list[j] = list[j + 1]
                list[j + 1] = temporary
                exchanges = true
            }
        }
        if (!exchanges) {
            break
        }
    }
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point: $testList")
    bubbleSortShort(testList)
    println("Final result: $testList")
}
