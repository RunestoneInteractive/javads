// Bfs returns two maps:
//   previous: keys are the vertices, values contain previous
//       vertex on shortest path (previous vertex from start is null)
//   distance: keys are the vertices, values are distance from start
//       shortest path

data class BfsResults<T>(
    val previous: Map<T, T?>,
    val distance: Map<T, Int>
)

fun <V> bfs(graph: GraphADT<V>, start: V): BfsResults<V> {
    val previous = mutableMapOf<V, V?>()
    val distance = mutableMapOf<V, Int>()
    previous[start] = null
    distance[start] = 0

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

    return BfsResults(previous, distance)
}
