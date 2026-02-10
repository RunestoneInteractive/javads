class DfsSolver<V>(val graph: GraphADT<V>, val start: V) {
    val previous = mutableMapOf<V, V?>()
    val distance = mutableMapOf<V, Int>()
    var time = 0   // also referred to as "discovery time"
    val closingTime = mutableMapOf<V, Int>()

    init {
        previous[start] = null
        distance[start] = 0
        dfs(start)
    }

    fun dfs(vertex: V) {
        time += 1
        println("$vertex $time")
        val neighbors = graph.getNeighbors(vertex)
        if (neighbors == null) {
            return
        }
        for (neighbor in neighbors) {
            if (neighbor !in previous) {
                previous[neighbor] = vertex
                distance[neighbor] = distance[vertex]!! + 1
                dfs(neighbor)
            }
        }
        time += 1
        closingTime[vertex] = time
    }
}
