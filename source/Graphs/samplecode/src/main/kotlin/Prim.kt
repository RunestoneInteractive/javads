//class PrimSolver<V>(val graph: GraphADT<V>, val start: V) {
//    //    private val previous = mutableMapOf<V, V?>()
//    private val distance = mutableMapOf<V, Double>()
//
//    val mst = AdjacencyListGraph<V>(directed = false)
//
//    init {
//        prim(start)
//    }
//
//    data class PqItem<V>(val vertex: V, val distance: Double) :
//        Comparable<PqItem<V>> {
//
//        override fun compareTo(other: PqItem<V>): Int {
//            return (this.distance - other.distance).toInt()
//        }
//    }
//
//    private fun prim(start: V) {
//        // Initialize distances to all vertices
//        for (vertex in graph.getVertices()) {
//            distance[vertex] = Double.MAX_VALUE
//        }
//        distance[start] = 0.0
////        previous[start] = null
//
//        // Insert into priority queue
//        val pqItems = mutableListOf<PqItem<V>>()
//        for (vertex in graph.getVertices()) {
//            pqItems.add(PqItem(vertex, distance[vertex]!!))
//        }
//        val pq = BinaryHeapPriorityQueue(pqItems)
//
//        while (pq.size() > 0) {
//            val (curVertex, curDistance) = pq.delete()!!
//            val neighborsAndDistances =
//                graph.getNeighborsAndWeights(curVertex)!!
//            for ((neighborVertex, neighborDistance) in neighborsAndDistances) {
//                val newDistance = neighborDistance
//                if ((neighborVertex !in mst.getVertices()) &&
//                    (newDistance < distance[neighborVertex]!!)
//                ) {
//                    mst.addEdge(curVertex, neighborVertex, neighborDistance)
//                    mst.addEdge(neighborVertex, curVertex, neighborDistance)
//                    val oldDistance = distance[neighborVertex]!!
//                    distance[neighborVertex] = newDistance
////                    previous[neighborVertex] = curVertex
//
//                    // update priority
//                    pq.removeElement(PqItem(neighborVertex, oldDistance))
//                    pq.insert(PqItem(neighborVertex, newDistance))
//                }
//            }
//        }
//    }
//}
