fun main() {
    val wordList = mutableListOf("cat", "dog", "rabbit")
    val letterList = mutableListOf<Char>()
    for (word in wordList) {
        for (letter in word) {
            letterList.add(letter)
        }
    }
    println(letterList)
}
