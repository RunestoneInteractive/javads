fun parenCheck(symbolString: String): Boolean {
    val symStack = Stack<Char>()

    for (symbol in symbolString) {
        if (symbol == '(') {
            symStack.push(symbol)
        } else if (symbol == ')') {
            if (symStack.isEmpty()) {
                return false
            } else {
                symStack.pop()
            }
        } else {
            // not a parenthesis; skip over it
        }
    }

    return symStack.isEmpty()
}

fun main() {
    println(parenCheck("((()))")) // expected true
    println(parenCheck("((()()))")) // expected true
    println(parenCheck("(()")) // expected false
    println(parenCheck(")(")) // expected false
}
