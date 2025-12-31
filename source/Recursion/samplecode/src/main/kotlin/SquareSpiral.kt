fun main() {
    val bob = TurtleSeward()

    for (i in 0..359) {
        bob.forward(i * 1.25)

        bob.left(90.25)
    }
}