fun main() {
    print("Enter a score: ");
    val score = readln().toInt()

    var grade = ""

    if (score >= 90) {
        grade = "A"
    } else if (score >= 80) {
        grade = "B"
    } else if (score >= 70) {
        grade = "C"
    } else if (score >= 60) {
        grade = "D"
    } else {
        grade = "F"
    }

    println("The grade is $grade.")
}