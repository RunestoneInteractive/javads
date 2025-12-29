fun main() {
    print("Enter a letter grade: ");
    val grade = readln()

    val score = when (grade) {
        "A" -> 90
        "B" -> 80
        "C" -> 70
        "D" -> 60
        else -> 0
    }

    println("The grade was at least $score")
}