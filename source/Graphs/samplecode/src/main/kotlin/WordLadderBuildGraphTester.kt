fun main() {
    val graph = buildGraph("words.txt")
    println(graph.getNeighbors("base"))
}