fun main() {
    val g = AdjacencyListGraph<Int>()
    for (i in 0..5) {
        g.addVertex(i)
    }
    g.addEdge(0, 1, 5.0)
    g.addEdge(0, 5, 2.0)
    g.addEdge(1, 2, 4.0)
    g.addEdge(2, 3, 9.0)
    g.addEdge(3, 4, 7.0)
    g.addEdge(3, 5, 3.0)
    g.addEdge(4, 0, 1.0)
    g.addEdge(5, 4, 8.0)
    g.addEdge(5, 2, 1.0)

    for (key in g.getVertices()) {
        println("$key connected to: ${g.getNeighborsAndWeights(key)}")
    }
}
