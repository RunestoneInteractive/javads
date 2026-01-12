class BinaryTree<T>(var key: T) {
    var leftChild: BinaryTree<T>? = null
    var rightChild: BinaryTree<T>? = null

    fun insertLeft(newNode: T) {
        if (leftChild == null) {
            leftChild = BinaryTree(newNode)
        } else {
            val newChild = BinaryTree(newNode)
            newChild.leftChild = leftChild
            leftChild = newChild
        }
    }

    fun insertRight(newNode: T) {
        if (rightChild == null) {
            rightChild = BinaryTree(newNode)
        } else {
            val newChild = BinaryTree(newNode)
            newChild.rightChild = rightChild
            rightChild = newChild
        }
    }
}