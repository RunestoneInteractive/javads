fun main() {
    val word = "Kotlin"
    val number = 123456
    val value = 12345.678901234

    /*
     * The vertical bars in the output let you see the
     * alignment more clearly.
     */
    println(String.format("|%s|", word))
    println(String.format("|%10s|", word)) // right-aligned
    println(String.format("|%-10s|", word)) // left-aligned

    println() // blank line for readability

    println(String.format("|%d|", number))
    println(String.format("|%10d|", number))
    println(String.format("|%-10d|", number))
    println(String.format("|%,10d|", number))

    println()

    println(String.format("|%f|", value))
    println(String.format("|%10.3f|", value))
    println(String.format("|%,10.3f|", value))
    println(String.format("|%10.3e|", value))
    println(String.format("|%10.7f|", value))
}