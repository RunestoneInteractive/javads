import kotlin.math.max
import kotlin.math.min

class AVLTreeMap<K : Comparable<K>, V> : ComparableMapADT<K, V>, Iterable<K> {

    var root: AVLTreeNode? = null
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
            this.root = AVLTreeNode(key, value)
        }
        this.nodeCount += 1
    }

    private fun put(key: K, value: V, currentNode: AVLTreeNode) {
        if (key < currentNode.key) {
            if (currentNode.leftChild != null) {
                put(key, value, currentNode.leftChild!!)
            } else {
                currentNode.leftChild = AVLTreeNode(key, value, currentNode)
                updateBalance(currentNode.leftChild!!)
            }
        } else {
            if (currentNode.rightChild != null) {
                put(key, value, currentNode.rightChild!!)
            } else {
                currentNode.rightChild = AVLTreeNode(key, value, currentNode)
                updateBalance(currentNode.rightChild!!)
            }
        }
    }

    private fun updateBalance(node: AVLTreeNode) {
        if (node.balanceFactor > 1 || node.balanceFactor < -1) {
            rebalance(node)
        } else {
            // Local copy for null safety
            val nodeParent = node.parent
            if (nodeParent != null) {
                if (node.isLeftChild()) {
                    nodeParent.balanceFactor += 1
                } else if (node.isRightChild()) {
                    nodeParent.balanceFactor -= 1
                }

                if (nodeParent.balanceFactor != 0) {
                    updateBalance(nodeParent)
                }
            }
        }
    }

    private fun rotateLeft(rotationRoot: AVLTreeNode) {
        // We are choosing to rotate left, so the right child
        // of rotationRoot cannot be null.
        val newRoot = rotationRoot.rightChild!!
        rotationRoot.rightChild = newRoot.leftChild

        if (newRoot.leftChild != null) {
            newRoot.leftChild!!.parent = rotationRoot
        }
        newRoot.parent = rotationRoot.parent
        if (rotationRoot.parent == null) {  // is root of tree
            root = newRoot
        } else {
            if (rotationRoot.isLeftChild()) {
                rotationRoot.parent!!.leftChild = newRoot
            } else {
                rotationRoot.parent!!.rightChild = newRoot
            }
        }
        newRoot.leftChild = rotationRoot
        rotationRoot.parent = newRoot
        rotationRoot.balanceFactor = rotationRoot.balanceFactor + 1 -
                min(newRoot.balanceFactor, 0)
        newRoot.balanceFactor = newRoot.balanceFactor + 1 +
                max(rotationRoot.balanceFactor, 0)
    }

    private fun rotateRight(rotationRoot: AVLTreeNode) {
        // We are choosing to rotate right, so the left child
        // of rotationRoot cannot be null.
        val newRoot = rotationRoot.leftChild!!
        rotationRoot.leftChild = newRoot.rightChild
        if (newRoot.rightChild != null) {
            newRoot.rightChild!!.parent = rotationRoot
        }
        newRoot.parent = rotationRoot.parent
        if (rotationRoot.parent == null) {  // is root of tree
            root = newRoot
        } else {
            if (rotationRoot.isRightChild()) {
                rotationRoot.parent!!.rightChild = newRoot
            } else {
                rotationRoot.parent!!.leftChild = newRoot
            }
        }
        newRoot.rightChild = rotationRoot
        rotationRoot.parent = newRoot
        rotationRoot.balanceFactor = rotationRoot.balanceFactor - 1 + max(newRoot.balanceFactor, 0)
        newRoot.balanceFactor = newRoot.balanceFactor - 1 + min(rotationRoot.balanceFactor, 0)
    }

    private fun rebalance(node: AVLTreeNode) {
        if (node.balanceFactor < 0) {
            // Negative balance factor means right subtree is bigger than left,
            // so there must be a right subtree
            val rightChild = node.rightChild!!
            if (rightChild.balanceFactor > 0) {
                rotateRight(rightChild)
                rotateLeft(node)
            } else {
                rotateLeft(node)
            }
        } else if (node.balanceFactor > 0) {
            // Positive balance factor means right subtree is bigger than left,
            // so there must be a left subtree
            val leftChild = node.leftChild!!
            if (leftChild.balanceFactor < 0) {
                rotateLeft(leftChild)
                rotateRight(node)
            } else {
                rotateRight(node)
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

    fun get(key: K, currentNode: AVLTreeNode?): AVLTreeNode? {
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

    /*
     * Return nested list representation of tree
     */
    override fun toString(): String {
        return stringify(this.root)
    }

    fun stringify(node: AVLTreeNode?): String {
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

    override fun remove(key: K): V? {
        throw NotImplementedError()
    }

    override fun keyList(fromKey: K, toKey: K): List<K> {
        throw NotImplementedError("Not yet implemented")
    }

    inner class AVLTreeNode(
        var key: K,
        var value: V,
        var parent: AVLTreeNode? = null,
        var leftChild: AVLTreeNode? = null,
        var rightChild: AVLTreeNode? = null,
        var balanceFactor: Int = 0
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

        fun replaceValue(key: K, value: V, left: AVLTreeNode?, right: AVLTreeNode?) {
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
                    "parent: " + parent + " balance: " + balanceFactor
        }

        fun findSuccessor(): AVLTreeNode? {
            var successor: AVLTreeNode? = null

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

        fun findMin(): AVLTreeNode {
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