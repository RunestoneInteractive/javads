fun main() {
    val size = 9
    val kg = buildKnightGraph(size)
    val solution = KnightTourOptimizedSolver(kg, 0, size*size)
    println(solution.tourPath)

    // Print out a chessboard, so can look at locations
    for (row in size-1 downTo 0) {
        for (col in 0 ..< size) {
            print(String.format("%3d", row*size + col))
        }
        println()
    }
}