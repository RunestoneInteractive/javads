fun reverse(s: String): String {
    // your code here
    return "" // placeholder
}

fun testEqual(s1: String, s2: String) {
    if (s1 == s2) {
        println("$s1 and $s2 are equal.")
    } else {
        println("$s1 and $s2 are not equal.")
    }
}

fun main() {
    testEqual(reverse("hello"), "olleh")
    testEqual(reverse("m"), "m")
    testEqual(reverse("follow"), "wollof")
    testEqual(reverse(""), "")
}
