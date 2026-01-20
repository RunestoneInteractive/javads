class AdjacencyListGraph<T>: GraphADT<T> {

    // T represents the id, or key, for each vertex.
    // Each vertex maps to a set of vertices.
    // Each set is an "adjacency set" of neighbors.
    var neighbors = mutableMapOf<T, MutableMap<T, Double>>()

    // Returns true if vertex added, false if not (because it was already there)
    override fun addVertex(id: T): Boolean {
        if (id !in neighbors) {
            neighbors[id] = mutableMapOf()
            return true
        } else {
            return false
        }
    }

    // Adds edge if not previously present;
    // replaces weight with new one if edge already there.
    // A default weight of 0 is placed if the function
    // is called without specifying a weight; this is handled
    // via the interface.
    override fun addEdge(begin: T, end: T, weight: Double) {
        // Make sure vertices are in the graph. (addVertex will
        // just return false if already there.)
        addVertex(begin)
        addVertex(end)

        // Local copy for null safety.
        // We just verified vertex is there, so not null.
        val beginNeighbors = neighbors[begin]!!

        // Add or replace the edge.
        beginNeighbors[end] = weight
    }

    // Returns true if vertex is present, false if not
    override fun containsVertex(id: T): Boolean {
        return id in neighbors
    }

    // Returns true if edge is present, false if not
    override fun containsEdge(begin: T, end: T): Boolean {
        val beginNeighbors = neighbors[begin]
        return beginNeighbors != null && end in beginNeighbors
    }

    // Returns a set of all vertex keys in the graph
    override fun getVertices(): Set<T> {
        return neighbors.keys
    }

    // Returns a set of all neighbors to a vertex.
    // Returns null if the vertex is not in the graph.
    override fun getNeighbors(id: T): Set<T>? {
        return neighbors[id]?.keys
    }

    // Returns a map of all neighbors to a vertex,
    // and the weights of the edges.
    // Returns null if the vertex is not in the graph.
    override fun getNeighborsAndWeights(id: T): Map<T, Double>? {
        return neighbors[id]
    }
}