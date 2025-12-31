// Given a String, return the string with only letters,
// and all in lower case.
 fun lettersOnly(s: String): String {
    return "" // placeholder
}

// Return true if the given string is a palindrome,
// false otherwise.
fun isPalindrome(s: String): Boolean {
    return false // placeholder
}

fun testResult(s: String, given: Boolean, expected: Boolean) {
    println("isPalindrome($s) returns $given; expected $expected.")
}

fun main() {
    testResult("x", isPalindrome(lettersOnly("x")), true)
    testResult("radar", isPalindrome(lettersOnly("radar")), true)
    testResult("hello", isPalindrome(lettersOnly("hello")), false)
    testResult("", isPalindrome(lettersOnly("")), true)
    testResult("hannah", isPalindrome(lettersOnly("hannah")), true)
    testResult(
        "Madam, I'm Adam.",
        isPalindrome(lettersOnly("Madam, I'm Adam.")), true
    )
}
