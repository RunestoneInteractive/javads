fun main() {
    var sum = 0.0

    print("Enter a number, or zero to quit: ")
    var n = readln().toDouble()
    while (n != 0.0) {
        sum = sum + n
        print("Enter another number, or zero to quit: ")
        n = readln().toDouble()
    }

    println(String.format("The sum is %.3f%n", sum))
}
