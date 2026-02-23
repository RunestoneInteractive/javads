fun encrypt(message: String): String {
    var result = ""
    for (letter in message) {
        val originalUnicode = letter.code                 // a=97, b=98, etc
        val originalIndex = originalUnicode - 'a'.code    // a=0, b=1, etc
        val encryptedIndex = (originalIndex + 13) % 26
        val encryptedUnicode = encryptedIndex + 'a'.code
        result = result + encryptedUnicode.toChar()
    }
    return result
}

fun main() {
    val test = "helloworld"
    val encrypted = encrypt(test)
    println(encrypted)
}
