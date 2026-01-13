//class TreeNode<K, V>(
//    var key: K,
//    var value: V,
//    var leftChild: TreeNode<K, V>?,
//    var rightChild: TreeNode<K, V>?,
//    var parent: TreeNode<K, V>?
//) {
//
//    constructor(key: K, value: V) :
//            this(key, value, null, null, null)
//
//    constructor(key: K, value: V, parent: TreeNode<K, V>?) :
//            this(key, value, null, null, parent)
//
//    // Is this node a left child of a parent?
//    fun isLeftChild(): Boolean {
//        val parent = parent  // Local copy of parent for null safety
//        return parent != null && parent.leftChild === this
//    }
//
//    // Is this node a right child of a parent?
//    fun isRightChild(): Boolean {
//        val parent = parent
//        return parent != null && parent.rightChild === this
//    }
//
//    // Is this the root node? (The root node has no parent)
//    fun isRoot(): Boolean {
//        return parent == null
//    }
//
//    // Is this a leaf node? (Leaf nodes have no children)
//    fun isLeaf(): Boolean {
//        return (leftChild == null && rightChild == null)
//    }
//
//    // Does this node have any children?
//    fun hasAnyChild(): Boolean {
//        return leftChild != null || rightChild != null
//    }
//
//    // Does this node have both left and right children?
//    fun hasChildren(): Boolean {
//        return leftChild != null && rightChild != null
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
////            val keyStr: String? = if (key == null) "null" else key.toString()
////            val valStr: String? = if (value == null) "null" else value.toString()
//        return "key: " + key + " value: " + value + "\n  " +
//                " left: " + leftChild + " right: " + rightChild +
//                "parent: " + parent
//    }
//
//    fun findSuccessor(): TreeNode<K, V>? {
//        var successor: TreeNode<K, V>? = null
//        // Local copies for null safety
//        val _rightChild = rightChild
//        val _parent = parent
//        if (_rightChild != null) {
//            successor = _rightChild.findMinimumChild()
//        } else {
//            if (_parent != null) {
//                if (isLeftChild()) {
//                    successor = parent
//                } else {
//                    _parent.rightChild = null
//                    successor = _parent.findSuccessor()
//                    _parent.rightChild = this
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
//    fun spliceOut() {
//        if (this.isLeaf()) {
//            if (this.isLeftChild()) {
//                this.parent!!.leftChild = null
//            } else {
//                this.parent!!.rightChild = null
//            }
//        } else if (this.hasAnyChild()) {
//            if (this.leftChild != null) {
//                if (this.isLeftChild()) {
//                    this.parent!!.leftChild = this.leftChild
//                } else {
//                    this.parent!!.rightChild = this.leftChild
//                }
//                this.leftChild!!.parent = this.parent
//            } else {
//                if (this.isLeftChild()) {
//                    this.parent!!.leftChild = this.rightChild
//                } else {
//                    this.parent!!.rightChild = this.rightChild
//                }
//                this.rightChild!!.parent = this.parent
//            }
//        }
//    }
//}
//
//
//
//class BSTMap<K : Comparable<K>, V>: ComparableMapADT<K, V> {
//
//    var root: TreeNode<K, V>? = null
//    var nodeCount = 0
//
//    override fun size(): Int {
//        return nodeCount
//    }
//
//    override fun put(key: K, value: V) {
//        if (this.root != null) {
//            put(key, value, this.root)
//        } else {
//            this.root = TreeNode(key, value)
//        }
//        this.nodeCount = this.nodeCount + 1
//    }
//
//    fun put(key: K?, value: V?, currentNode: TreeNode) {
//        if (key!!.compareTo(currentNode.key) < 1) {
//            if (currentNode.leftChild != null) {
//                put(key, value, currentNode.leftChild)
//            } else {
//                currentNode.leftChild = BinarySearchTree.TreeNode(
//                    key, value,
//                    currentNode
//                )
//            }
//        } else {
//            if (currentNode.rightChild != null) {
//                put(key, value, currentNode.rightChild)
//            } else {
//                currentNode.rightChild = BinarySearchTree.TreeNode(
//                    key, value,
//                    currentNode
//                )
//            }
//        }
//    }
//
//    fun get(key: K?): V? {
//        if (this.root != null) {
//            val result: TreeNode? = get(key, this.root)
//            if (result != null) {
//                return result.value
//            }
//        }
//        return null
//    }
//
//    fun get(key: K?, currentNode: TreeNode?): TreeNode? {
//        if (currentNode == null) {
//            return null
//        }
//        if (key!!.compareTo(currentNode.key) == 0) {
//            return currentNode
//        } else if (key.compareTo(currentNode.key) < 0) {
//            return get(key, currentNode.leftChild)
//        } else {
//            return get(key, currentNode.rightChild)
//        }
//    }
//
//    fun containsKey(key: K?): Boolean {
//        val result: TreeNode? = get(key, this.root)
//        return (result != null)
//    }
//
//    fun removeKey(key: K?): TreeNode? {
//        if (size > 1) {
//            val nodeToRemove: TreeNode? = get(key, root)
//            if (nodeToRemove != null) {
//                removeNode(nodeToRemove)
//                size = size - 1
//                return nodeToRemove
//            } else {
//                throw NoSuchElementException(
//                    key.toString() + " not in tree."
//                )
//            }
//        } else if (size == 1 && root.key == key) {
//            root = null
//            size = size - 1
//            return null
//        } else {
//            throw NoSuchElementException(
//                key.toString() + " not in tree."
//            )
//        }
//    }
//
//    fun adjustParent(nodeToRemove: TreeNode, childOfRemoved: TreeNode) {
//        if (nodeToRemove.isLeftChild()) {
//            childOfRemoved.parent = nodeToRemove.parent
//            nodeToRemove.parent.leftChild = childOfRemoved
//        } else if (nodeToRemove.isRightChild()) {
//            childOfRemoved.parent = nodeToRemove.parent
//            nodeToRemove.parent.rightChild = childOfRemoved
//        } else {
//            nodeToRemove.replaceValue(
//                childOfRemoved.key,
//                childOfRemoved.value,
//                childOfRemoved.leftChild,
//                childOfRemoved.rightChild
//            )
//        }
//    }
//
//    fun removeNode(currentNode: TreeNode) {
//        // case 1: the current node is a leaf node
//        if (currentNode.isLeaf()) {
//            if (currentNode === currentNode.parent.leftChild) {
//                currentNode.parent.leftChild = null
//            } else {
//                currentNode.parent.rightChild = null
//            }
//        } else if (currentNode.hasChildren()) { // case 3: two chilren
//            val successor: TreeNode = currentNode.findSuccessor()
//            successor.spliceOut()
//            currentNode.key = successor.key
//            currentNode.value = successor.value
//        } else { // case 2: one child only
//            if (currentNode.leftChild != null) {
//                adjustParent(currentNode, currentNode.leftChild)
//            } else {
//                adjustParent(currentNode, currentNode.rightChild)
//            }
//        }
//    }
//
//    /*
//     * Return nested list representation of tree
//     */
//    override fun toString(): String {
//        return stringify(this.root)
//    }
//
//    fun stringify(node: TreeNode?): String {
//        var result = ""
//        if (node != null) {
//            if (node.isLeaf()) {
//                result = " [" + node.key + "]"
//            } else {
//                result = " [" + node.key + stringify(node.leftChild) +
//                        stringify(node.rightChild) + "]"
//            }
//        } else {
//            result = " []"
//        }
//        return result
//    }
//
//
//    internal inner class TreeIterator : MutableIterator<TreeNode?> {
//        var iteratorNode: TreeNode? = null
//
//        init {
//            if (root.leftChild == null) {
//                iteratorNode = root
//            } else {
//                iteratorNode = root.findMinimumChild()
//            }
//        }
//
//        override fun hasNext(): Boolean {
//            return iteratorNode != null
//        }
//
//        override fun next(): TreeNode? {
//            var result: TreeNode? = null
//            if (iteratorNode != null) {
//                result = iteratorNode
//                iteratorNode = iteratorNode.findSuccessor()
//            }
//            return result
//        }
//    }
//    override fun iterator(): MutableIterator<TreeNode?> {
//        return BinarySearchTree.TreeIterator()
//    }
//
//
//}