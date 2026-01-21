fun main() {
    val graph = buildGraph("words.txt")

    val startWord = "fool"
    val endWord = "sage"

    val (previous, distance) = bfs(graph, startWord)

    // Traverse backwards from end word
    var current: String? = endWord
    while (current != null) {
        println(current)
        current = previous[current]
    }
}