fun simpleMatcher(pattern: String, text: String): Int {
    var i = 0
    var j = 0
    var result = -1

    while (i < text.count() && j < pattern.count()) {
        if (text[i] == pattern[j]) {
            j++
        } else {
            j = 0
        }
        i++
    }
    if (j == pattern.count()) {
        println("Hit end of pattern")
        result = i - j
    } else if (i == text.count()) {
        println("Hit end of text")
        result = -1
    }
    return result
}
