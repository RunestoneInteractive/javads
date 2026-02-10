fun <T> orderByAvail(
    graph: GraphADT<T>,
    tourVertices: MutableSet<T>,
    start: T,
): List<T>  {
    data class CountAndVertex(val count: Int, val vertex: T)
    val availCount = mutableListOf<CountAndVertex>()
    val startNeighbors = graph.getNeighbors(start)
    if (startNeighbors == null) { // no neighbors at all
        return listOf<T>()
    }
    for (v in startNeighbors) {
        if (v !in tourVertices) {   // v is not already visited
            var count = 0
            val vNeighbors = graph.getNeighbors(v)
            if (vNeighbors != null) {
                for (w in vNeighbors) {
                    if (w !in tourVertices) {
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
