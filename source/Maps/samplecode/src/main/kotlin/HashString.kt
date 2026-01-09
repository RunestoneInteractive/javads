fun hashString(str: String, tableSize: Int): Int {
    var sum = 0
    for (ch in str) {
        sum = sum + ch.code
    }
    return sum % tableSize
}
