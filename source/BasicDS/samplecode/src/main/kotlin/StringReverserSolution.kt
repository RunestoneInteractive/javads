fun reverseStringSolution(str: String): String {
    // your code here; returns a String
    val stack = Stack<Char>()
    for (c in str) {
        stack.push(c)
    }
    var result = ""
    while (!stack.isEmpty()) {
        result += stack.pop()
    }
    return result
}
