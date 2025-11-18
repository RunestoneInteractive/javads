fun anagramSolution4(s1: String, s2: String): Boolean {
    val count1 = MutableList(26, {0}) // initialized to all zeros
    val count2 = MutableList(26, {0})

    for (ch in s1) {
        val index = ch - 'a'
        count1[index] = count1[index] + 1
    }

    for (ch in s2) {
        val index = ch - 'a'
        count2[index] = count2[index] + 1
    }

    for (j in 0..<26) {
        if (count1[j] != count2[j]) {
            return false
        }
    }

    return true
}

fun main() {
    println(anagramSolution4("taster", "treats")) // expected: true
    println(anagramSolution4("abcd", "dcab")) // expected: true
    println(anagramSolution4("abcd", "dcda")) // expected: false
}
