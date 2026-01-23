fun main() {
    val size = 5
    val kg = buildKnightGraph(size)
    val tourPath = knightTour(kg, mutableSetOf<Int>(), mutableListOf<Int>(), 0, size*size)
    println(tourPath)

    // Print out a chessboard, so can look at locations
    for (row in size-1 downTo 0) {
        for (col in 0 ..< size) {
            print(String.format("%3d", row*size + col))
        }
        println()
    }
}