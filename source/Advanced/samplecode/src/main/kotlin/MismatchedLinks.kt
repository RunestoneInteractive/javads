fun mismatchedLinks(pattern: String): Map<Int, Int> {
    val augPattern = "0$pattern"
    val links = mutableMapOf<Int, Int>()
    links[1] = 0
    for (k in 2 ..< augPattern.count()) {
        var s = links[k - 1]!!
        while (s >= 1 && augPattern[s] != augPattern[k - 1]) {
            if (augPattern[s] != augPattern[k - 1]) {
                s = links[s]!!
            }
        }
        links[k] = s + 1
    }
    return links
}

fun main() {
    val result = mismatchedLinks("ACATA")
    println(result)
}