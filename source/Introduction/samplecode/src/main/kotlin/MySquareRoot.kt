fun squareRoot(n: Double): Double {
    var root = n / 2.0 // initial guess is 1/2 of n
    for (iter in 0..19) {
        root = 0.5 * (root + (n / root))
    }
    return root
}

fun main() {
    println(squareRoot(9.0))
    println(squareRoot(4563.0))
}
