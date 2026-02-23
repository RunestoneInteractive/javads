fun gcd(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    } else if (a < b) {
        return gcd(b, a)
    }
    return gcd(a - b, b)
}

fun main() {
    println(gcd(25, 35))
}
