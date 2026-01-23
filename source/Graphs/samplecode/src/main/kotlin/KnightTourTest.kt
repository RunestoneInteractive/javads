fun main() {
    val size = 8
    val kg = buildKnightGraph(size)
    val tourVertices = mutableSetOf<Int>()
    val tourPath = mutableListOf<Int>()
    val solutionPath = knightTour(kg, tourVertices, tourPath, 0, size*size)
    println(solutionPath)

    // Print out a chessboard, so can look at locations
    for (row in size-1 downTo 0) {
        for (col in 0 ..< size) {
            print(String.format("%3d", row*size + col))
        }
        println()
    }
}