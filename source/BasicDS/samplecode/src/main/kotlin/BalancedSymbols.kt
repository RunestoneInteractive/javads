fun balanceCheck(symbolString: String): Boolean {
    val matchingMap = mapOf('(' to ')', '{' to '}', '[' to ']')
    val openers = matchingMap.keys
    val closers = matchingMap.values

    val symStack = Stack<Char>()

    for (symbol in symbolString) {
        if (symbol in openers) {
            symStack.push(symbol)
        } else if (symbol in closers) {
            if (symStack.isEmpty()) {
                return false
            } else {
                if (matchingMap[symStack.pop()] != symbol) {
                    return false
                }
            }
        } else {
            // not a parenthesis; skip over it
        }
    }

    return symStack.isEmpty()
}

fun main() {
    println(balanceCheck("{({([][])}())}")) // expect true
    println(balanceCheck("[{()]")) // expect false
    println(balanceCheck("[{()]]")) // expect false
}
