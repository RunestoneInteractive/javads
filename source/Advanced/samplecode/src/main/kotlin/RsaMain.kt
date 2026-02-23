fun main() {
    val msg = "Java and RSA"
    println(msg)
    val (e, d, n) = genKeys(5563, 8191)
    println("$e $d $n")
    val encrypted = encrypt(msg, e, n)
    println(encrypted)
    val decrypted = decrypt(encrypted, d, n)
    println(decrypted)
}
