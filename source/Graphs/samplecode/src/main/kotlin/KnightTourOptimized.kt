class KnightTourOptimizedSolver(val graph: GraphADT<Int>, val startVertex: Int, val limit: Int) {
    val tourPath = mutableSetOf<Int>()

    init {
        knightTour(startVertex)
    }

    private fun orderByAvail(start: Int): List<Int>  {
        data class CountAndVertex(val count: Int, val vertex: Int)
        val availCount = mutableListOf<CountAndVertex>()
        val startNeighbors = graph.getNeighbors(start)
        if (startNeighbors == null) { // no neighbors at all
            return listOf()
        }
        for (v in startNeighbors) {
            if (v !in tourPath) {   // v is not already visited
                var count = 0
                val vNeighbors = graph.getNeighbors(v)
                if (vNeighbors != null) {
                    for (w in vNeighbors) {
                        if (w !in tourPath) {
                            count += 1
                        }
                    }
                }
                availCount.add(CountAndVertex(count, v))
            }
        }

        // Sort availCount by count
        val sortedCount = availCount.sortedBy { countAndVertex -> countAndVertex.count }

        // Return list consisting of just the vertices in the list
        return sortedCount.map { countAndVertex -> countAndVertex.vertex }
    }

    private fun knightTour(newVertex: Int): Boolean {

        tourPath.add(newVertex)

        if (tourPath.count() == limit) {     // found a tour
            return true
        } else {
            // Try each neighbor
            val neighbors = orderByAvail(newVertex)   // We know every node has a neighbor
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
