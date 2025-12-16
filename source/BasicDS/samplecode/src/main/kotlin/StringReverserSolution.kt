fun reverseStringSolution(str: String): String {
    // your code here; returns a String
    val stack = ListStack<Char>()
    for (c in str) {
        stack.push(c)
    }
    var result = ""
    while (!stack.isEmpty()) {
        result += stack.pop()
    }
    return result
}
