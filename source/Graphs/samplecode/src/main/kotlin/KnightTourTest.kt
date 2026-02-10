fun main() {
    val size = 8
    val kg = buildKnightGraph(size)
    val solution = KnightTourSolver(kg, 0, size*size)
r    println(solution.tourPath)

    // Print out a chessboard, so can look at locations
    for (row in size-1 downTo 0) {
        for (col in 0 ..< size) {
            print(String.format("%3d", row*size + col))
        }
        println()
    }
}