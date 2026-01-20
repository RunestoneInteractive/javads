class DirectedUnweightedGraph<T> {

    // T represents the id, or key, for each vertex.
    // Each vertex maps to a set of vertices.
    // Each set is an "adjacency set" of neighbors.
    var neighbors = mutableMapOf<T, MutableSet<T>>()

    // Returns true if vertex added, false if not (because it was already there)
    fun addVertex(key: T): Boolean {
        if (key !in neighbors) {
            neighbors[key] = mutableSetOf<T>()
            return true
        } else {
            return false
        }
    }

    // Returns true if edge added. Returns, false if not
    // because it was already there.
    fun addEdge(begin: T, end: T): Boolean {
        // Make sure vertices are in the graph. The addVertex will
        // just return false if already there.
        addVertex(begin)
        addVertex(end)

        // Local copy for null safety.
        // We just verified vertex is there, so not null.
        val beginNeighbors = neighbors[begin]!!

        // Check if already present.
        if (end in beginNeighbors) {
            return false
        }

        // Add the edge.
        beginNeighbors.add(end)
        return true
    }

    // Returns true if vertex is present, false if not
    fun containsVertex(key: T): Boolean {
        return key in neighbors
    }

    // Returns true if edge is present, false if not
    fun containsEdge(begin: T, end: T): Boolean {
        val beginNeighbors = neighbors[begin]
        return beginNeighbors != null && end in beginNeighbors
    }

    // Returns a set of all vertex keys in the graph
    fun getVertices(): Set<T> {
        return neighbors.keys
    }

    // Returns a set of all neighbors to a vertex.
    // Returns null if the vertex is not in the graph.
    fun getNeighbors(key: T): Set<T>? {
        return neighbors[key]
    }


}