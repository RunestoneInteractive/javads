fun postfixEval(postfixExpr: String): Int? {
    val digits = "0123456789"
    val operandStack = ListStack<Int>()

    val tokenList = postfixExpr.split(" ")

    for (token in tokenList) {
        if (token in digits) {
            operandStack.push(token.toInt())
        } else {
            val operand2 = operandStack.pop()
            val operand1 = operandStack.pop()
            val result = doMath(token, operand1, operand2)
            operandStack.push(result)
        }
    }
    return operandStack.pop()
}

fun doMath(operator: String, operand1: Int, operand2: Int): Int {
    return when (operator) {
        "*"  -> operand1 * operand2
        "/"  -> operand1 / operand2
        "+"  -> operand1 + operand2
        else -> operand1 - operand2
    }
}

fun main() {
    println(postfixEval("7 8 + 3 2 + /"))
}
