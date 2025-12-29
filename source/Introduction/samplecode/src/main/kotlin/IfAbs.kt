import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    print("Enter a value: ");
    var n = readln().toDouble()
    if (n < 0) {
        n = abs(n)
    }

    println(sqrt(n))
}