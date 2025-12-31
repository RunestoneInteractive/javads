fun moveTower(height: Int, fromPole: String, toPole: String, withPole: String) {
    if (height >= 1) {
        moveTower(height - 1, fromPole, withPole, toPole)
        moveDisk(fromPole, toPole)
        moveTower(height - 1, withPole, toPole, fromPole)
    }
}

fun moveDisk(fromPole: String, toPole: String) {
    println("Moving disk from $fromPole to $toPole.")
}

fun main() {
    moveTower(3, "A", "B", "C")
}
