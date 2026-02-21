import java.io.File

fun buildGraph(fileName: String): GraphADT<String> {
    val wordGraph = AdjListGraph<String>(directed=false)
    val buckets = mutableMapOf<String, MutableSet<String>>()

    val lines = File(fileName).readLines()

    for (line in lines) {
        val word = line.trim()
        for (i in 0..<word.length) {
            val bucket = word.substring(0, i) + "_" +
                    word.substring(i + 1)
            if (!buckets.containsKey(bucket)) {
                buckets[bucket] = mutableSetOf()
            }
            buckets[bucket]!!.add(word)
        }
    }

    for (similarWords in buckets.values) {
        for (word1 in similarWords) {
            for (word2 in similarWords.minus(word1)) {
                wordGraph.addEdge(word1, word2)
            }
        }
    }
    return wordGraph
}
