class UndirectedUnweightedGraph<T> {

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

        // Local copies for null safety. We just verified they are there,
        // so not null.
        val beginNeighbors = neighbors[begin]!!
        val endNeighbors = neighbors[end]!!

        // Check if already present. Graph is undirected,
        // so checking one direction is sufficient
        if (end in beginNeighbors) {
            return false
        }

        // Add the edge.
        beginNeighbors.add(end)
        endNeighbors.add(begin)
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


}