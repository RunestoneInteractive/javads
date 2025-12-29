fun main() {
    print("Enter a letter grade: ");
    val grade = readln()

    var score = 0

    when (grade) {
        "A" -> score = 90
        "B" -> score = 80
        "C" -> score = 70
        "D" -> score = 60
        else -> score = 0
    }

    println("The grade was at least $score")
}