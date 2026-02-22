class PrimSolver<V>(val graph: GraphADT<V>, val start: V) {
    val mst = AdjListGraph<V>(directed = false)

    init {
        prim(start)
    }

    data class PqItem<V>(val vertex: V, val distance: Double) :
        Comparable<PqItem<V>> {

        override fun compareTo(other: PqItem<V>): Int {
            return (this.distance - other.distance).toInt()
        }
    }

    private fun prim(start: V) {
        val distance = mutableMapOf<V, Double>()
        val previous = mutableMapOf<V, V?>()

        // Initialize distances to all vertices
        for (vertex in graph.getVertices()) {
            distance[vertex] = Double.MAX_VALUE
        }
        distance[start] = 0.0
        previous[start] = null

        // Insert into priority queue
        val pqItems = mutableListOf<PqItem<V>>()
        for (vertex in graph.getVertices()) {
            pqItems.add(PqItem(vertex, distance[vertex]!!))
        }
        val pq = BinaryHeapPriorityQueue(pqItems)

        while (!pq.isEmpty()) {
            val (curV, curDist) = pq.delete()!!
            for (nbrV in graph.getNeighbors(curV)!!) {
                val newDist = graph.getWeight(curV, nbrV)!!
                if (nbrV !in previous && newDist < distance[nbrV]!!) {
                    val oldDist = distance[nbrV]!!
                    distance[nbrV] = newDist
                    previous[nbrV] = curV

                    // update priority
                    pq.removeElement(PqItem(nbrV, oldDist))
                    pq.insert(PqItem(nbrV, newDist))
                }
            }
        }

        for (vertex in previous.keys) {
            if (previous[vertex] != null) {
                mst.addEdge(vertex, previous[vertex]!!, distance[vertex]!!)
            }
        }
    }
}
