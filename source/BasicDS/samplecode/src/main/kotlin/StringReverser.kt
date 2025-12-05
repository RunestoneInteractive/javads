fun reverseString(str: String): String {
    // your code here; returns a String
    return "" // placeholder
}

fun testEqual(str1: String, str2: String) {
    if (str1 == str2) {
        println("{str1} and {str2} are equal.")
    } else {
        println("{str1} and {str2} are not equal.")
    }
}

fun main() {
    testEqual(reverseString("apple"), "elppa")
    testEqual(reverseString("x"), "x")
    testEqual(reverseString("1234567890"), "0987654321")
}