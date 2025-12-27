fun main() {
    print("Enter your name: ")
    val name = readln()

    print("Enter your age in years: ")
    val years = readln().toInt()

    val days = years * 365
    println(String.format("You are about %d days old, %s.",
            days, name))
}