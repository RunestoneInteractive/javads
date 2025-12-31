fun toString(number: Int, base: Int): String {
    var n = number
    val stack = ListStack<String>()

    val digitStrings = listOf("0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"
    )

    while (n > 0) {
        if (n < base) {
            stack.push(digitStrings[n])
        } else {
            stack.push(digitStrings[n % base])
        }
        n = n / base
    }

    var result = ""
    while (!stack.isEmpty()) {
        result = result + stack.pop()
    }
    return result
}

fun main() {
    println(toString(13, 2)) // 1101
}
