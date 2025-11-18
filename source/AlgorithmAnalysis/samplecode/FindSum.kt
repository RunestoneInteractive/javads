fun sumOfN(n: Int): Long {
    var theSum = 0L
    for (i in 1..n) {
        theSum = theSum + i
    }
    return theSum
}

fun main() {
    println(sumOfN(10))
}