fun preorder(tree: BinaryTree<String>?) {
    if (tree != null) {
        println(tree.key)
        preorder(tree.leftChild)
        preorder(tree.rightChild)
    }
}

fun postorder(tree: BinaryTree<String>?) {
    if (tree != null) {
        postorder(tree.leftChild)
        postorder(tree.rightChild)
        println(tree.key)
    }
}

fun inorder(tree: BinaryTree<String>?) {
    if (tree != null) {
        inorder(tree.leftChild)
        println(tree.key)
        inorder(tree.rightChild)
    }
}

fun expressionToString(tree: BinaryTree<String>?): String {
    var result = ""
    if (tree != null) {
        result += "(" + expressionToString(tree.leftChild)
        result += tree.key
        result += expressionToString(tree.rightChild) + ")"
    }
    return result
}

fun main() {
    val parseTree = buildParseTree("( 3 + ( 4 * 5 ) )")
    preorder(parseTree)
    parseTree.preorder()
    println("---")
    postorder(parseTree)
    println("---")
    inorder(parseTree)
    println(expressionToString(parseTree))
}

