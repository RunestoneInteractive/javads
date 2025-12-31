fun convert(n: Int, base: Int): String {
    val digitStrings = listOf("0", "1", "2", "3", "4", "5",
        "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
    if (n < base) {
        return digitStrings[n]
    } else {
        val remainder = n % base
        return convert(n / base, base) + digitStrings[remainder]
    }
}

fun main() {
    println(convert(13, 2)) // 1101
    println(convert(1066, 16)) // 42A
}
