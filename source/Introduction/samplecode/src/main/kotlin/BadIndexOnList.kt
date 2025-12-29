fun main() {
    val data = listOf(10, 66, 47, 11, 505, 217)

    print("Enter an index: ")
    val index = readln().toInt()

    val value = data[index]
    println("The element is $value.")
}