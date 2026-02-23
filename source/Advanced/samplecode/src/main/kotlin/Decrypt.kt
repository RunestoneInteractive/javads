fun decrypt(message: String, key: Int): String {
    var result = ""
    for (letter in message) {
        val encryptedUnicode = letter.code                 // a=97, b=98, etc
        val encryptedIndex = encryptedUnicode - 'a'.code    // a=0, b=1, etc
        val originalIndex = (encryptedIndex + 26 - key) % 26
        val originalUnicode = originalIndex + 'a'.code
        result = result + originalUnicode.toChar()
    }
    return result
}
