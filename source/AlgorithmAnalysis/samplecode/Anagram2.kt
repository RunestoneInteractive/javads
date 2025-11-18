fun anagramSolution2(s1: String, s2: String): Boolean {
    val s1List = s1.toMutableList()
    val s2List = s2.toMutableList()

    s1List.sort()
    s2List.sort()

    var pos = 0
    var matches = true

    while (pos < s1.count() && matches) {
        if (s1List[pos] == s2List[pos]) {
            pos = pos + 1
        } else {
            matches = false
        }
    }
    return matches
}

fun main() {
    println(anagramSolution2("taster", "treats")) // expected: true
    println(anagramSolution2("abcd", "dcab")) // expected: true
    println(anagramSolution2("abcd", "dcda")) // expected: false
}
