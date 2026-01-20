fun main() {
    val g = DirectedUnweightedGraph<Int>()
    for (i in 0..5) {
        g.addVertex(i)
    }
    g.addEdge(0, 1)
    g.addEdge(0, 5)
    g.addEdge(1, 2)
    g.addEdge(2, 3)
    g.addEdge(3, 4)
    g.addEdge(3, 5)
    g.addEdge(4, 0)
    g.addEdge(5, 4)
    g.addEdge(5, 2)

    for (key in g.getVertices()) {
        println("$key connected to: ${g.getNeighbors(key)}")
    }
}
