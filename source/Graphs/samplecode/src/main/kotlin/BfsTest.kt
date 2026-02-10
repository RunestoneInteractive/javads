fun main() {
    val graph = buildGraph("words.txt")

    val startWord = "fool"
    val endWord = "sage"

    val bfsSolution = BfsSolver(graph, startWord)

    // Traverse backwards from end word
    var current: String? = endWord
    while (current != null) {
        println(current)
        current = bfsSolution.previous[current]
    }
}