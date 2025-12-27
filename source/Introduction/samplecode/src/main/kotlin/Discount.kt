fun main() {
    val discountRate = 0.0725

    print("Enter price: $")
    val price = readln().toDouble()

    val newPrice = price * (1.0 - discountRate)
    println("Your new price is $$newPrice.")
}
