fun infixToPostfix(infixExpr: String): String {
    val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val digits = "0123456789"
    val precedence = mapOf(
        "*" to 3,
        "/" to 3,
        "+" to 2,
        "-" to 2,
        "(" to 1
    )

    val opStack = ListStack<String>()
    val postfixList = mutableListOf<String>()

    val tokenList = infixExpr.split(" ")

    for (token in tokenList) {
        if (token in letters || token in digits) {
            postfixList.add(token)
        } else if (token == "(") {
            opStack.push(token)
        } else if (token == ")") {
            // pop everything down to the matching open paren
            var topToken = opStack.pop()
            while (topToken != "(") {
                postfixList.add(topToken)
                topToken = opStack.pop()
            }
        } else if (token in precedence) {
            // pop higher-precedence operations
            while (!opStack.isEmpty() &&
                (precedence.getValue(opStack.peek())
                        >= precedence.getValue(token))
            ) {
                postfixList.add(opStack.pop())
            }
            // then push this operator
            opStack.push(token)
        }
    }

    // If any operators remain, add them to the postfix expression
    while (!opStack.isEmpty()) {
        postfixList.add(opStack.pop())
    }

    var result = ""
    for (s in postfixList) {
        result = result + s + " "
    }
    return result
}

fun main() {
    var expr = "A * B + C * D"
    println(expr + " --> " + infixToPostfix(expr))

    expr = "( A + B ) * C - ( D - E ) * ( F + G )"
    println(expr + " --> " + infixToPostfix(expr))
}
