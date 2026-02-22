class KnightTourSolver(val graph: GraphADT<Int>,
                       val startVertex: Int,
                       val limit: Int) {
    val tourPath = mutableSetOf<Int>()

    init {
        knightTour(startVertex)
    }

    private fun knightTour(newVertex: Int): Boolean {

        tourPath.add(newVertex)

        if (tourPath.count() == limit) {     // found a tour
            return true
        } else {
            // Try each neighbor
            val neighbors = graph.getNeighbors(newVertex)!!   // We know every node has a neighbor
            for (neighbor in neighbors) {
                if (neighbor !in tourPath) {
                    val done = knightTour(neighbor)
                    if (done) {
                        return true
                    }
                }
            }

            // If got to here, no tour found; remove current and return false
            tourPath.remove(newVertex)
            return false
        }
    }
}
