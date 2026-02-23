fun gcdLong(a: Long, b: Long): Long {
    if (b == 0L) {
        return a
    }
    return gcdLong(b, a % b)
}


fun modExpLong(x: Long, n: Long, p: Long): Long {
    if (n == 0L) {
        return 1
    }
    val t = (x * x) % p
    var result = modExpLong(t, n / 2, p)
    if (n % 2 != 0L) {
        result = (result * x) % p
    }
    return result
}

data class ExtGcdLongResult(val d: Long, val a: Long, val b: Long)
fun extGcdLong(x: Long, y: Long): ExtGcdLongResult {
    if (y == 0L) {
        return ExtGcdLongResult(x, 1, 0)
    } else {
        val (d, a, b) = extGcdLong(y, x % y)
        return ExtGcdLongResult(d, b, a - (x / y) * b)
    }
}

