fun main() {
    println("Test 1: directed graph")
    val g1 = AdjListGraph<Int>(directed=true)
    for (i in 0..5) {
        g1.addVertex(i)
    }
    g1.addEdge(0, 1, 5.0)
    g1.addEdge(0, 5, 2.0)
    g1.addEdge(1, 2, 4.0)
    g1.addEdge(2, 3, 9.0)
    g1.addEdge(3, 4, 7.0)
    g1.addEdge(3, 5, 3.0)
    g1.addEdge(4, 0, 1.0)
    g1.addEdge(5, 4, 8.0)
    g1.addEdge(5, 2, 1.0)
    println(g1)

    println("Test 2: undirected graph")
    val g2 = AdjListGraph<Int>(directed=false)
    for (i in 0..5) {
        g2.addVertex(i)
    }
    g2.addEdge(0, 1, 5.0)
    g2.addEdge(0, 5, 2.0)
    g2.addEdge(1, 2, 4.0)
    g2.addEdge(2, 3, 9.0)
    g2.addEdge(3, 4, 7.0)
    g2.addEdge(3, 5, 3.0)
    g2.addEdge(4, 0, 1.0)
    g2.addEdge(5, 4, 8.0)
    g2.addEdge(5, 2, 1.0)
    println(g2)
}
