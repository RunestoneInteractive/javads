fun main() {
    print("Enter a number, or zero to quit: ")
    var n = readln().toDouble()
    var sum = n

    while (n != 0.0 && sum < 10) {
        print("Enter another number, or zero to quit: ")
        n = readln().toDouble()
        sum = sum + n
    }

    println(String.format("The sum is %.3f%n", sum))
}
