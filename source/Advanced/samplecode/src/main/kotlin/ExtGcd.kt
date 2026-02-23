data class ExtGcdResult(val d: Int, val a: Int, val b: Int)
fun extGcd(x: Int, y: Int): ExtGcdResult {
    if (y == 0) {
        return ExtGcdResult(x, 1, 0)
    } else {
        val (d, a, b) = extGcd(y, x % y)
        return ExtGcdResult(d, b, a - (x / y) * b)
    }
}