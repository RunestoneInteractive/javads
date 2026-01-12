// Given a fully-parenthesized expression, return its parse tree.
fun buildParseTree(expr: String): BinaryTree<String> {
    val tokenList = expr.split(" ")
    val parentStack = ListStack<BinaryTree<String>>()
    val exprTree = BinaryTree("")

    parentStack.push(exprTree)

    var currentTree: BinaryTree<String> = exprTree

    for (token in tokenList) {
        if (token == "(") {
            val newLeftChild = currentTree.insertLeft("")
            parentStack.push(currentTree)
            currentTree = newLeftChild
        } else if (token in "+-*/") {
            currentTree.key = token
            val newRightChild = currentTree.insertRight("")
            parentStack.push(currentTree)
            currentTree = newRightChild
        } else if (token.toIntOrNull() != null) {
            currentTree.key = token
            val parent = parentStack.pop()
            currentTree = parent
        } else if (token == ")") {
            currentTree = parentStack.pop()
        } else {
            throw IllegalArgumentException(
                "Unknown token $token"
            )
        }
    }
    return exprTree
}
