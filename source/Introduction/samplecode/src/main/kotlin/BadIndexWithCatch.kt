fun main() {
    val data = listOf(10, 66, 47, 11, 505, 217)

    print("Enter an index: ")
    val index = readln().toInt()

    try {
        val value = data[index]
        println("The element is $value.")
    } catch (e: Exception) {
        println("Index must be from 0 to ${data.count()}.")
    }
}