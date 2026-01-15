class BSTMap<K : Comparable<K>, V> : ComparableMapADT<K, V>, Iterable<K> {

    var root: TreeNode? = null
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

    private fun put(key: K, value: V, currentNode: TreeNode) {
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

    fun get(key: K, currentNode: TreeNode?): TreeNode? {
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
            val valueRemoved = nodeToRemove.value
            removeNode(nodeToRemove)
            nodeCount -= 1
            return valueRemoved
        }
    }

    private fun removeNode(currentNode: TreeNode) {
        // Local copies for null safety
        val currentParent = currentNode.parent
        val currentLeft = currentNode.leftChild
        val currentRight = currentNode.rightChild

        if (currentNode.isLeaf()) {
            // case 1: the current node is a leaf node (no children)

            // removeNode is never called if there is only a single node
            // in the tree, so this node cannot both be a leaf
            // and have no parent
            checkNotNull(currentParent)

            if (currentNode == currentParent.leftChild) {
                currentParent.leftChild = null
            } else {
                currentParent.rightChild = null
            }
        } else if (currentLeft != null && currentRight == null) {
            // case 2a: one child only (left)
            adjustParent(currentNode, currentLeft)
        } else if (currentRight != null && currentLeft == null) {
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

    fun adjustParent(nodeToRemove: TreeNode, childOfRemoved: TreeNode) {
        // Local copies for null safety
        val nodeToRemoveParent = nodeToRemove.parent

        if (nodeToRemove.isLeftChild()) {
            checkNotNull(nodeToRemoveParent)
            childOfRemoved.parent = nodeToRemove.parent
            nodeToRemoveParent.leftChild = childOfRemoved
        } else if (nodeToRemove.isRightChild()) {
            checkNotNull(nodeToRemoveParent)
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

    fun stringify(node: TreeNode?): String {
        var result = ""
        if (node != null) {
            if (node.isLeaf()) {
                result = " [" + node.key + "]"
            } else {
                result = " [" + node.key + stringify(node.leftChild) +
                        stringify(node.rightChild) + "]"
            }
        } else {
            result = " []"
        }
        return result
    }

    override fun iterator(): Iterator<K> {
        val root = this.root
        if (root == null) {
            return iterator()
        } else {
            return root.iterator()
        }
    }

    override fun keyList(fromKey: K, toKey: K): List<K> {
        throw NotImplementedError("Not yet implemented")
    }

    inner class TreeNode(
        var key: K,
        var value: V,
        var parent: TreeNode? = null,
        var leftChild: TreeNode? = null,
        var rightChild: TreeNode? = null
    ) : Iterable<K> {

        // Is this node a left child of a parent?
        fun isLeftChild(): Boolean {
            val parent = parent  // Local copy of parent for null safety
            return parent != null && parent.leftChild == this
        }

        // Is this node a right child of a parent?
        fun isRightChild(): Boolean {
            val parent = parent   // Local copy of parent for null safety
            return parent != null && parent.rightChild == this
        }

        // Is this a leaf node? (Leaf nodes have no children)
        fun isLeaf(): Boolean {
            return (leftChild == null && rightChild == null)
        }

        fun replaceValue(key: K, value: V, left: TreeNode?, right: TreeNode?) {
            this.key = key
            this.value = value
            this.leftChild = left
            this.rightChild = right
            this.leftChild?.parent = this
            this.rightChild?.parent = this
        }

        override fun toString(): String {
            return ""
            return "key: " + key + " value: " + value + "\n  " +
                    " left: " + leftChild + " right: " + rightChild +
                    "parent: " + parent
        }

        fun findSuccessor(): TreeNode? {
            var successor: TreeNode? = null

            // Local copies for null safety
            val rightChild = this.rightChild
            val parent = this.parent

            if (rightChild != null) {
                successor = rightChild.findMin()
            } else {
                if (parent != null) {
                    if (isLeftChild()) {
                        successor = parent
                    } else {
                        parent.rightChild = null
                        successor = parent.findSuccessor()
                        parent.rightChild = this
                    }
                }
            }
            return successor
        }

        fun findMin(): TreeNode {
            var current = this
            while (current.leftChild != null) {
                current = current.leftChild!!
            }
            return current
        }

        // This function self-removes a node.
        fun spliceOut() {

            // Local copies for null safety
            val parent = this.parent
            val leftChild = this.leftChild
            val rightChild = this.rightChild

            // spliceOut should only be legitimately be used called
            // for a node which has a parent
            checkNotNull(parent)

            if (leftChild != null && rightChild != null) {
                // Two children
                throw IllegalStateException(
                    "spliceOut should never be called on a node with two children"
                )
            } else if (leftChild != null) {
                // One child, which is left
                if (this.isLeftChild()) {
                    parent.leftChild = this.leftChild
                } else {
                    parent.rightChild = this.leftChild
                }
                leftChild.parent = parent
            } else if (rightChild != null) {
                // One child, which is right
                if (this.isLeftChild()) {
                    parent.leftChild = this.rightChild
                } else {
                    parent.rightChild = this.rightChild
                }
                rightChild.parent = this.parent
            } else {
                // No children
                if (this.isLeftChild()) {
                    parent.leftChild = null
                } else {
                    parent.rightChild = null
                }
            }
        }

        override fun iterator(): Iterator<K> {
            // Local copies for null safety
            val leftChild = this.leftChild
            val rightChild = this.rightChild

            return iterator {
                if (leftChild != null) {
                    for (elem in leftChild) {
                        yield(elem)
                    }
                }
                yield(key)
                if (rightChild != null) {
                    for (elem in rightChild) {
                        yield(elem)
                    }
                }
            }
        }

    }
}