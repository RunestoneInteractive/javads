fun buildKnightGraph(boardSize: Int): GraphADT<Int> {
    val knightGraph = AdjacencyListGraph<Int>()

    for (row in 0..<boardSize) {
        for (col in 0..<boardSize) {
            val nodeId = row * boardSize + col
            val newPositions = genLegalMoves(row, col, boardSize)
            for ((row2, col2) in newPositions) {
                val otherNodeId = row2 * boardSize + col2
                knightGraph.addEdge(nodeId, otherNodeId)
            }
        }
    }
    return knightGraph
}