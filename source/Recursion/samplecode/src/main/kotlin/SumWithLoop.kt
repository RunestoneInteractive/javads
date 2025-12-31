fun listSumLoop(numList: List<Int>): Int {
    var theSum = 0
    for (number in numList) {
        theSum = theSum + number
    }
    return theSum
}

fun main() {
    println(listSumLoop(listOf(1, 3, 5, 7, 9)))
}
