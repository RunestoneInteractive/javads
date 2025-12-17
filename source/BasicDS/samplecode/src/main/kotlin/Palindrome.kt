fun isPalindrome(str: String): Boolean {
    val charDeque = ListDeque<Char>()

    for (ch in str) {
        charDeque.addTail(ch)
    }

    while (charDeque.size() > 1) {
        val first = charDeque.removeHead()
        val last = charDeque.removeTail()
        if (first != last) {
            return false
        }
    }
    return true
}

fun main() {
    println(
        "Is \"regular\" a palindrome? " +
                isPalindrome("regular")
    )
    println(
        "Is \"rotator\" a palindrome? " +
                isPalindrome("rotator")
    )
    println(
        "Is \"deed\" a palindrome? " +
                isPalindrome("deed")
    )
}
