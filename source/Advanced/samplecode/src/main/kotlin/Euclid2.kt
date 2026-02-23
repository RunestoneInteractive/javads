fun gcdRevised(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return gcdRevised(b, a % b)
}

fun main() {
    println(gcdRevised(25, 35))
}
