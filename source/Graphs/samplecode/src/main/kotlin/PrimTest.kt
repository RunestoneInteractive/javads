fun main() {
    val graph = AdjListGraph<String>(directed=false)
    graph.addEdge("A", "B", 2.0)
    graph.addEdge("A", "C", 3.0)
    graph.addEdge("B", "C", 1.0)
    graph.addEdge("B", "D", 1.0)
    graph.addEdge("B", "E", 4.0)
    graph.addEdge("D", "E", 1.0)
    graph.addEdge("C", "F", 5.0)
    graph.addEdge("F", "G", 1.0)
    val primSolution = PrimSolver(graph, "A")
    println(primSolution.mst)

}
