fun main() {
    val aTree = BinaryTree("a")

    println(aTree.key) // "a"
    println(aTree.leftChild) // null

    aTree.insertLeft("b")
    println(aTree.leftChild) // reference to BinaryTree
    println(aTree.leftChild!!.key) // "b"

    aTree.insertRight("c")
    println(aTree.rightChild) // reference to BinaryTree
    println(aTree.rightChild!!.key) // "c"

    aTree.rightChild!!.key = "d"
    println(aTree.rightChild!!.key) // "d"
}
