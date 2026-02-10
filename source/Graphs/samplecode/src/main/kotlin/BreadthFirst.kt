class BfsSolver<V>(val graph: GraphADT<V>, val start: V) {
    val previous = mutableMapOf<V, V?>()
    val distance = mutableMapOf<V, Int>()

    init {
        previous[start] = null
        distance[start] = 0
        bfs(start)
    }

    private fun bfs(start: V) {
        val queue = ListQueue<V>()
        queue.enqueue(start)
        while (queue.size() > 0) {
            val current = queue.dequeue()
            val neighbors = graph.getNeighbors(current)!!
            for (neighbor in neighbors) {
                if (neighbor !in previous) {
                    previous[neighbor] = current
                    distance[neighbor] = distance[current]!! + 1
                    queue.enqueue(neighbor)
                }
            }
        }
    }
}
