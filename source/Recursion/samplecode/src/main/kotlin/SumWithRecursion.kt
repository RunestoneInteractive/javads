fun listSum(numList: List<Int>): Int {
    if (numList.count() == 1) {
        return numList[0]
    } else {
        return numList[0] + listSum(numList.drop(1))
    }
}

fun main() {
    println(listSum(listOf(1, 3, 5, 7, 9)))
}
