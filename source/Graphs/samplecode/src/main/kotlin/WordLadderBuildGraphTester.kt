fun main() {
    val graph = buildGraph("src/main/resources/words.txt")
    println(graph.getNeighbors("base"))
}