// T is the type of the id used for each node.
interface GraphADT<T> {
    // Returns true if vertex added,
    // false if not (because it was already there)
    fun addVertex(id: T): Boolean

    // Adds edge if not previously present;
    // replaces weight with new one if edge already there.
    // A default weight of 0 is placed if the function
    // is called without specifying a weight.
    fun addEdge(begin: T, end: T, weight: Double = 0.0)

    // Returns true if vertex is present, false if not
    fun hasVertex(id: T): Boolean

    // Returns true if edge is present, false if not
    fun hasEdge(begin: T, end: T): Boolean

    // Returns a set of all vertex keys in the graph
    fun getVertices(): Set<T>

    // Returns a set of all neighbors to a vertex.
    // Returns null if the vertex is not in the graph.
    fun getNeighbors(id: T): Set<T>?

    // Returns the weight associated with an edge.
    // Returns null if the edge is not in the graph.
    fun getWeight(begin: T, end: T): Double?
}