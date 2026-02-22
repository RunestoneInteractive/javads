fun main() {
    val graph = AdjListGraph<String>(directed = false)
    graph.addEdge("u", "x", 1.0)
    graph.addEdge("u", "v", 2.0)
    graph.addEdge("u", "w", 5.0)
    graph.addEdge("v", "w", 3.0)
    graph.addEdge("w", "z", 5.0)
    graph.addEdge("y", "z", 1.0)
    graph.addEdge("x", "y", 1.0)
    graph.addEdge("v", "x", 2.0)
    graph.addEdge("w", "x", 3.0)
    graph.addEdge("w", "y", 1.0)

    val dijstraSolution = DijkstraSolver(graph, "u")
    println(dijstraSolution.previous)
    println(dijstraSolution.distance)

}