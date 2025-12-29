fun square(n: Double): Double {
    return n * n
}

fun main() {
    println(square(3.0))
    println(square(square(3.0)))
}