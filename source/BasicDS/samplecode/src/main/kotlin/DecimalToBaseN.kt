fun baseConvert(decimal: Int, base: Int): String {
    val digits = "0123456789ABCDEF"
    val digitStack = Stack<Int>()
    var remainingValue = decimal

    while (remainingValue > 0) {
        digitStack.push(remainingValue % base)
        remainingValue = remainingValue / base
    }

    var resultString = ""
    while (!digitStack.isEmpty()) {
        val digit = digitStack.pop()
        resultString = resultString + digits[digit]
    }
    return resultString
}

fun main() {
    println(baseConvert(30, 2))  // expect 11110
    println(baseConvert(30, 8))  // expect 36
    println(baseConvert(30, 16)) // expect 1E
}
