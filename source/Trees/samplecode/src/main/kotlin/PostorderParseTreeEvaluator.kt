fun postorderEvaluate(tree: BinaryTree<String>?): Double? {
    var leftValue: Double? = null
    var rightValue: Double? = null
    val result: Double
    if (tree != null) {
        leftValue = postorderEvaluate(tree.leftChild)
        rightValue = postorderEvaluate(tree.rightChild)
        if (leftValue != null && rightValue != null) {
            val operator: String = tree.key
            if (operator == "+") {
                result = leftValue + rightValue
            } else if (operator == "-") {
                result = leftValue - rightValue
            } else if (operator == "*") {
                result = leftValue * rightValue
            } else {
                result = leftValue / rightValue
            }
            return result
        }
        return tree.key.toDouble()
    } else {
        return null
    }
}
