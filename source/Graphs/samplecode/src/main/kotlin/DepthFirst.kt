class DfsSolver<V>(val graph: GraphADT<V>) {
    val previous = mutableMapOf<V, V?>()
    private val visited = mutableSetOf<V>()
    private var time = 0   // also referred to as "discovery time"
    val closingTime = mutableMapOf<V, Int>()

    init {
        dfsAll()
    }

    private fun dfsAll() {
        for (vertex in graph.getVertices()) {
            previous[vertex] = null
        }

        for (start in graph.getVertices()) {
            if (start !in visited) {
                dfs(start)
            }
        }
    }

    private fun dfs(vertex: V) {
        time += 1
        visited.add(vertex)
        val neighbors = graph.getNeighbors(vertex)
        if (neighbors == null) {
            return
        }
        for (neighbor in neighbors) {
            if (neighbor !in visited) {
                previous[neighbor] = vertex
                dfs(neighbor)
            }
        }
        time += 1
        closingTime[vertex] = time
    }
}
