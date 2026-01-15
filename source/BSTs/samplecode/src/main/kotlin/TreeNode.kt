//class TreeNode<K, V>(
//    var key: K,
//    var value: V,
//    var leftChild: TreeNode<K, V>?,
//    var rightChild: TreeNode<K, V>?,
//    var parent: TreeNode<K, V>?
//) {
//
//    constructor(key: K, value: V) : this(key, value, null, null, null)
//
//    constructor(key: K, value: V, parent: TreeNode<K, V>?) : this(key, value, null, null, parent)
//
//    // Is this node a left child of a parent?
//    fun isLeftChild(): Boolean {
//        val parent = parent  // Local copy of parent for null safety
//        return parent != null && parent.leftChild == this
//    }
//
//    // Is this node a right child of a parent?
//    fun isRightChild(): Boolean {
//        val parent = parent   // Local copy of parent for null safety
//        return parent != null && parent.rightChild == this
//    }
//
//    // Is this a leaf node? (Leaf nodes have no children)
//    fun isLeaf(): Boolean {
//        return (leftChild == null && rightChild == null)
//    }
//
//    fun replaceValue(key: K, value: V, left: TreeNode<K, V>?, right: TreeNode<K, V>?) {
//        this.key = key
//        this.value = value
//        this.leftChild = left
//        this.rightChild = right
//        this.leftChild?.parent = this
//        this.rightChild?.parent = this
//    }
//
//    override fun toString(): String {
//        return "key: " + key + " value: " + value + "\n  " + " left: " + leftChild + " right: " + rightChild + "parent: " + parent
//    }
//
//    fun findSuccessor(): TreeNode<K, V>? {
//        var successor: TreeNode<K, V>? = null
//
//        // Local copies for null safety
//        val rightChild = this.rightChild
//        val parent = this.parent
//
//        if (rightChild != null) {
//            successor = rightChild.findMinimumChild()
//        } else {
//            if (parent != null) {
//                if (isLeftChild()) {
//                    successor = parent
//                } else {
//                    parent.rightChild = null
//                    successor = parent.findSuccessor()
//                    parent.rightChild = this
//                }
//            }
//        }
//        return successor
//    }
//
//    fun findMinimumChild(): TreeNode<K, V> {
//        var current = this
//        while (current.leftChild != null) {
//            current = current.leftChild!!
//        }
//        return current
//    }
//
//    // This function self-removes a node. It connects
//    fun spliceOut() {
//
//        // Local copies for null safety
//        val parent = this.parent
//        val leftChild = this.leftChild
//        val rightChild = this.rightChild
//
//        // spliceOut should only be legitimately be used called
//        // for a node which has a parent
//        checkNotNull(parent)
//
//        if (leftChild != null && rightChild != null) {
//            // Two children
//            throw IllegalStateException(
//                "spliceOut should never be called on a node with two children"
//            )
//        } else if (leftChild != null) {
//            // One child, which is left
//            if (this.isLeftChild()) {
//                parent.leftChild = this.leftChild
//            } else {
//                parent.rightChild = this.leftChild
//            }
//            leftChild.parent = parent
//        } else if (rightChild != null) {
//            // One child, which is right
//            if (this.isLeftChild()) {
//                parent.leftChild = this.rightChild
//            } else {
//                parent.rightChild = this.rightChild
//            }
//            rightChild.parent = this.parent
//        } else {
//            // No children
//            if (this.isLeftChild()) {
//                parent.leftChild = null
//            } else {
//                parent.rightChild = null
//            }
//        }
//    }
//}
//
