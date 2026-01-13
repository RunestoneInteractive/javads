class BSTMap<K : Comparable<K>, V> : ComparableMapADT<K, V>, Iterable<TreeNode<K, V>> {

    var root: TreeNode<K, V>? = null
    var nodeCount = 0

    override fun size(): Int {
        return nodeCount
    }

    override fun put(key: K, value: V) {
        // Local copy for null safety
        val root = this.root
        if (root != null) {
            put(key, value, root)
        } else {
            this.root = TreeNode(key, value)
        }
        this.nodeCount += 1
    }

    private fun put(key: K, value: V, currentNode: TreeNode<K, V>) {
        // Local copies for null safety
        val currentLeftChild = currentNode.leftChild
        val currentRightChild = currentNode.rightChild

        if (key < currentNode.key) {
            if (currentLeftChild != null) {
                put(key, value, currentLeftChild)
            } else {
                currentNode.leftChild = TreeNode(key, value, currentNode)
            }
        } else {
            if (currentRightChild != null) {
                put(key, value, currentRightChild)
            } else {
                currentNode.rightChild = TreeNode(key, value, currentNode)
            }
        }
    }

    override fun get(key: K): V? {
        if (this.root != null) {
            val result = get(key, this.root)
            if (result != null) {
                return result.value
            }
        }
        return null
    }

    fun get(key: K, currentNode: TreeNode<K, V>?): TreeNode<K, V>? {
        if (currentNode == null) {
            return null
        }
        if (key == currentNode.key) {
            return currentNode
        } else if (key < currentNode.key) {
            return get(key, currentNode.leftChild)
        } else {
            return get(key, currentNode.rightChild)
        }
    }

    override fun containsKey(key: K): Boolean {
        val result = get(key, this.root)
        return (result != null)
    }

    override fun remove(key: K): V? {
        val nodeToRemove = get(key, root)

        if (nodeToRemove == null) {
            // Didn't find key; this handles empty tree case too
            return null
        } else if (nodeCount == 1) {
            // Node to remove must be root
            root = null
            nodeCount -= 1
            return nodeToRemove.value
        } else {
            // Node to remove must be some other node
            removeNode(nodeToRemove)
            nodeCount -= 1
            return nodeToRemove.value
        }
    }

    private fun removeNode(currentNode: TreeNode<K, V>) {
        // Local copies for null safety
        val currentParent = currentNode.parent
        val currentLeft = currentNode.leftChild
        val currentRight = currentNode.rightChild

        // removeNode should only be legitimately be used called
        // for a node which has a parent (i.e., not the root)
        checkNotNull(currentParent)

        if (currentNode.isLeaf()) {
            // case 1: the current node is a leaf node (no children)
            if (currentNode == currentParent.leftChild) {
                currentParent.leftChild = null
            } else {
                currentParent.rightChild = null
            }
        } else if (currentLeft != null) {
            // case 2a: one child only (left)
            adjustParent(currentNode, currentLeft)
        } else if (currentRight != null) {
            // case 2b: one child only (right)
            adjustParent(currentNode, currentRight)
        } else {
            // case 3: two children
            val successor = currentNode.findSuccessor()
            // Since two children, there must be a successor
            checkNotNull(successor)
            successor.spliceOut()
            currentNode.key = successor.key
            currentNode.value = successor.value
        }
    }

    fun adjustParent(nodeToRemove: TreeNode<K, V>, childOfRemoved: TreeNode<K, V>) {
        // Local copies for null safety
        val nodeToRemoveParent = nodeToRemove.parent

        // Only legitimate to call this function if the parent exists
        checkNotNull(nodeToRemoveParent)

        if (nodeToRemove.isLeftChild()) {
            childOfRemoved.parent = nodeToRemove.parent
            nodeToRemoveParent.leftChild = childOfRemoved
        } else if (nodeToRemove.isRightChild()) {
            childOfRemoved.parent = nodeToRemove.parent
            nodeToRemoveParent.rightChild = childOfRemoved
        } else {
            nodeToRemove.replaceValue(
                childOfRemoved.key, childOfRemoved.value,
                childOfRemoved.leftChild, childOfRemoved.rightChild
            )
        }
    }


    // Return nested list representation of tree
    override fun toString(): String {
        return stringify(this.root)
    }

    fun stringify(node: TreeNode<K, V>?): String {
        var result = ""
        if (node != null) {
            if (node.isLeaf()) {
                result = " [" + node.key + "]"
            } else {
                result = " [" + node.key + stringify(node.leftChild) + stringify(node.rightChild) + "]"
            }
        } else {
            result = " []"
        }
        return result
    }


    private inner class TreeIterator: Iterator<TreeNode<K, V>> {
        var iteratorNode: TreeNode<K,V>? = null

        init {
            // Local copies for null safety
            val root = this@BSTMap.root

            if (root == null) {
                iteratorNode = null
            } else if (root.leftChild == null) {
                iteratorNode = root
            } else {
                iteratorNode = root.findMinimumChild()
            }
        }

        override fun hasNext(): Boolean {
            return iteratorNode != null
        }

        override fun next(): TreeNode<K, V> {
            // Copy for null safety
            val currentIteratorNode = iteratorNode

            if (currentIteratorNode == null) {
                throw NoSuchElementException()
            } else {
                val result = currentIteratorNode
                iteratorNode = currentIteratorNode.findSuccessor()
                return result
            }
        }
    }

    override fun iterator(): Iterator<TreeNode<K, V>> {
        return TreeIterator()
    }

    override fun keyList(fromKey: K, toKey: K): List<K> {
        throw NotImplementedError("Not yet implemented")
    }

}