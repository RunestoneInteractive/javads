fun anagramSolution1(s1: String, s2: String): Boolean {
    var isAnagram = true

    if (s1.count() != s2.count()) {
        isAnagram = false
    } else {
        var pos1 = 0
        val s2List = s2.toMutableList() // rename
        while (pos1 < s1.count() && isAnagram) {
            var pos2 = 0
            var found = false
            while (pos2 < s2.count() && !found) {
                if (s1[pos1] == s2List[pos2]) {
                    found = true
                } else {
                    pos2 = pos2 + 1
                }
            }
            if (found) {
                s2List[pos2] = '-'
            } else {
                isAnagram = false
            }
            pos1 = pos1 + 1
        }
    }
    return isAnagram
}

fun main() {
    println(anagramSolution1("taster", "treats")) // expected: true
    println(anagramSolution1("abcd", "dcab")) // expected: true
    println(anagramSolution1("abcd", "dcda")) // expected: false
}
