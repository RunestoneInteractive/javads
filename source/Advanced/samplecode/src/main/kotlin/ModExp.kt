fun modExp(x: Int, n: Int, p: Int): Int {
    if (n == 0) {
        return 1
    }
    val t = (x * x) % p
    var result = modExp(t, n / 2, p)
    if (n % 2 != 0) {
        result = (result * x) % p
    }
    return result
}