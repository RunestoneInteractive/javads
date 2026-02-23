import java.math.BigInteger

data class Keys(val encryptKey: Long, val decryptKey: Long, val n: Long)
fun genKeys(p: Long, q: Long): Keys {
    val n = p * q
    val m = (p - 1) * (q - 1)
    var encryptKey = (Math.random() * n).toLong()
    while (gcdLong(m, encryptKey) != 1L) {
        encryptKey = (Math.random() * n).toLong()
    }
    var (decryptKey, a, b) = extGcdLong(m, encryptKey)

    if (b < 0L) {
        decryptKey = m + b
    } else {
        decryptKey = b
    }
    return Keys(encryptKey, decryptKey, n)
}

fun encrypt(
    msg: String, encryptKey: Long,
    n: Long
): List<Long> {
    val bigN = BigInteger(n.toString())
    val chunkSize = bigN.bitLength() / 8

    val allChunks = strToChunks(msg, chunkSize)
    return allChunks.map {chunk -> modExpLong(chunk, encryptKey, n)}
}

fun decrypt(
    cipherChunks: List<Long>, decryptKey: Long,
    n: Long
): String {
    val bigN = BigInteger(n.toString())
    val chunkSize = bigN.bitLength() / 8

    val plainChunks = cipherChunks.map { chunk -> modExpLong(chunk, decryptKey, n) }
    return chunksToStr(plainChunks, chunkSize)
}