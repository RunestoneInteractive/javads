//fun main() {
//    val graph = AdjacencyListGraph<String>(directed=false)
//    graph.addEdge("A", "u", 1.0)
//    graph.addEdge("x", "u", 1.0)
//
//    graph.addEdge("u", "v", 2.0)
//    graph.addEdge("v", "u", 2.0)
//
//    graph.addEdge("u", "w", 5.0)
//    graph.addEdge("w", "u", 5.0)
//
//    graph.addEdge("v", "w", 3.0)
//    graph.addEdge("w", "v", 3.0)
//
//    graph.addEdge("w", "z", 5.0)
//    graph.addEdge("z", "w", 5.0)
//
//    graph.addEdge("y", "z", 1.0)
//    graph.addEdge("z", "y", 1.0)
//
//    graph.addEdge("x", "y", 1.0)
//    graph.addEdge("y", "x", 1.0)
//
//    graph.addEdge("v", "x", 2.0)
//    graph.addEdge("x", "v", 2.0)
//
//    graph.addEdge("w", "x", 3.0)
//    graph.addEdge("x", "w", 3.0)
//
//    graph.addEdge("w", "y", 1.0)
//    graph.addEdge("y", "w", 1.0)
//
//    val primSolution = PrimSolver(graph, "u")
//    println(primSolution.mst)
//
//}
