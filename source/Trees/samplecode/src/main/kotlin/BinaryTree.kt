class BinaryTree<T>(var key: T) {
    var leftChild: BinaryTree<T>? = null
    var rightChild: BinaryTree<T>? = null

    fun insertLeft(newNode: T): BinaryTree<T> {
        if (leftChild == null) {
            val newChild = BinaryTree(newNode)
            leftChild = newChild
            return newChild
        } else {
            val newChild = BinaryTree(newNode)
            newChild.leftChild = leftChild
            leftChild = newChild
            return newChild
        }
    }

    fun insertRight(newNode: T): BinaryTree<T> {
        if (rightChild == null) {
            val newChild = BinaryTree(newNode)
            rightChild = newChild
            return newChild
        } else {
            val newChild = BinaryTree(newNode)
            newChild.rightChild = rightChild
            rightChild = newChild
            return newChild
        }
    }
}