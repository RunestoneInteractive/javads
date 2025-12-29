import kotlin.math.sqrt

fun main() {
    print("Enter a number: ");
    val n = readln().toDouble()

    if (n >= 0) {
        println(sqrt(n))
    } else {
        println("Number can not be negative.")
    }
}