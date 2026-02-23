fun strToChunks(msg: String, chunkSize: Int): List<Long> {
    val msgBytes = msg.toByteArray()

    val numChunks = (msgBytes.size + chunkSize - 1) / chunkSize
    val chunkList = mutableListOf<Long>()

    var n = 0
    var hex = ""
    for (i in 0 ..< msgBytes.count()) {
        hex += String.format("%02x", msgBytes[i])
        if (i % chunkSize == chunkSize - 1) {
            chunkList.add(hex.toLong(16))
            n++
            hex = ""
        }
    }
    if (hex != "") {
        hex = hex + "00".repeat(chunkSize - hex.length / 2)
        chunkList.add(hex.toLong(16))
    }
    return chunkList
}

fun chunksToStr(chunkList: List<Long>, chunkSize: Int): String {
    val byteArr = ByteArray(chunkList.size * chunkSize)
    var n = 0
    for (chunk in chunkList) {
        for (i in 0..<chunkSize) {
            byteArr[n + (chunkSize - i - 1)] = ((chunk shr (i * 8)) and 0xffL).toByte()
        }
        n += chunkSize
    }
    return String(byteArr)
}