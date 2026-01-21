// V is the type of the id used for each node.
interface GraphADT<V> {
    // Returns true if vertex added,
    // false if not (because it was already there)
    fun addVertex(id: V): Boolean

    // Adds edge if not previously present;
    // replaces weight with new one if edge already there.
    // A default weight of 0 is placed if the function
    // is called without specifying a weight.
    fun addEdge(begin: V, end: V, weight: Double = 0.0)

    // Returns true if vertex is present, false if not
    fun containsVertex(id: V): Boolean

    // Returns true if edge is present, false if not
    fun containsEdge(begin: V, end: V): Boolean

    // Returns a set of all vertex keys in the graph
    fun getVertices(): Set<V>

    // Returns a set of all neighbors to a vertex.
    // Returns null if the vertex is not in the graph.
    fun getNeighbors(id: V): Set<V>?

    // Returns a map of all neighbors to a vertex,
    // and the weights of the edges.
    // Returns null if the vertex is not in the graph.
    fun getNeighborsAndWeights(id: V): Map<V, Double>?
}