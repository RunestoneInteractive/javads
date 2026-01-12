fun evaluate(parseTree: BinaryTree<String>): Double {
    val leftChild = parseTree.leftChild
    val rightChild = parseTree.rightChild

    if (leftChild != null && rightChild != null) {
        val operator = parseTree.key
        val leftOperand = evaluate(leftChild)
        val rightOperand = evaluate(rightChild)
        return apply(operator, leftOperand, rightOperand)
    } else {
        return parseTree.key.toDouble()
    }
}

fun apply(
    operator: String, leftOperand: Double, rightOperand: Double
): Double {

    val result: Double

    if (operator == "+") {
        result = leftOperand + rightOperand
    } else if (operator == "-") {
        result = leftOperand - rightOperand
    } else if (operator == "*") {
        result = leftOperand * rightOperand
    } else {
        result = leftOperand / rightOperand
    }
    return result
}

fun main() {
    val parseTree = buildParseTree("( 3 + ( 4 * 5 ) )")
    println(evaluate(parseTree))
}
