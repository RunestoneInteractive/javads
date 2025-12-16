fun divideBy2(decimal: Int): String {
    val digitStack = ListStack<Int>()
    var remainingValue = decimal

    while (remainingValue > 0) {
        digitStack.push(remainingValue % 2)
        remainingValue = remainingValue / 2
    }

    var resultString = ""
    while (!digitStack.isEmpty()) {
        val digit = digitStack.pop()
        resultString = resultString + digit.toString()
    }
    return resultString
}

fun main() {
    println(divideBy2(42)) // expect 101010
    println(divideBy2(31)) // expect 11111
}
