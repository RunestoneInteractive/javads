data class XYPair(val x: Int, val y: Int)

fun genLegalMoves(row: Int, col: Int, boardSize: Int): List<XYPair> {

    val newMoves = mutableListOf<XYPair>()
    val offsets = listOf(
        XYPair(-1, -2),   // left-down-down
        XYPair(-1, 2),    // left-up-up
        XYPair(-2, -1),   // left-left-down
        XYPair(-2, 1),    // left-left-up
        XYPair(1, -2),    // right-down-down
        XYPair(1, 2),     // right-up-up
        XYPair(2, -1),    // right-right-down
        XYPair(2, 1)      // right-right-up
    )

    for ((rowOffset, colOffset) in offsets) {
        val newRow = row + rowOffset
        val newCol = col + colOffset
        if (newRow in 0 ..< boardSize && newCol in 0 ..< boardSize) {
            newMoves.add(XYPair(newRow, newCol))
        }
    }

    return newMoves
}

