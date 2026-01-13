//public class BSTMap<K : Comparable<K>, V> : ComparableMapADT<K, V> {
//
//    private data class Node<K, V>(
//        var key: K,
//        var value: V,
//        var left: Node<K, V>? = null,
//        var right: Node<K, V>? = null
//    )
//
//    // Variable for the tree itself
//    private var root: Node<K, V>? = null
//
//    override fun put(key: K, value: V) {
//        root = put(key, value, root)
//    }
//
//    // Returns a pointer to the updated subtree
//    private fun put(key: K, value: V, subroot: Node<K, V>?): Node<K, V> {
//        if (subroot == null)
//            return Node(key, value)
//        else if (key < subroot.key)
//            subroot.left = put(key, value, subroot.left)
//        else if (key > subroot.key)
//            subroot.right = put(key, value, subroot.right)
//        else
//            subroot.value = value
//
//        return subroot
//    }
//
//    // Returns the value matching the provided key, or null otherwise.
//    override fun get(key: K): V? {
//        return get(key, root)
//    }
//
//    private fun get(key: K, subroot: Node<K, V>? = root): V? {
//        if (subroot == null)
//            return null
//        else if (key < subroot.key)
//            return get(key, subroot.left)
//        else if (key > subroot.key)
//            return get(key, subroot.right)
//        else
//            return subroot.value
//    }
//
//    override fun containsKey(key: K): Boolean {
//        return get(key) != null
//    }
//
//
//    override fun remove(key: K): V? {
//        root = remove(key, root)
//    }
//
//    // Returns a pointer to the updated subtree. Remove needs to return
//    // two values: the pointer itself, and the value that was removed.
//    // Handled via a data class.
//    private data class NodeAndValue<K, V>(val node: Node<K, V>?, val value: V?)
//
//    private fun remove(item: K, subroot: Node<K, V>?): NodeAndValue<K, V> {
//        // item not in subtree
//        if (subroot == null) {
//            return NodeAndValue(node=null, value=null)
//        } else if (item < subroot.key) {
//            val (updatedTree, removedValue) = remove(item, subroot.left)
//            subroot.left = updatedTree
//            return NodeAndValue(subroot, removedValue)
//        } else if (item > subroot.key) {
//            val (updatedTree, removedValue) = remove(item, subroot.right)
//            subroot.right = remove(item, subroot.right)
//            return subroot
//        } else {
//            // Local copies for null-safety
//            val left = subroot.left
//            val right = subroot.right
//
//            // If only one child, then just return a pointer to that child
//            if (left == null)
//                return right
//            else if (right == null)
//                return left
//            else {
//                val (leftMaxKey, leftMaxValue) = maxEntry(left)
//                subroot.key = leftMaxKey
//                subroot.value = leftMaxValue
//                subroot.left = remove(leftMaxKey, left)
//                return subroot
//            }
//        }
//    }
//
//    // Finds largest child key in a tree with associated value
//    private data class KeyValue<K, V>(val key: K, val value: V)
//    private fun maxEntry(subroot: Node<K, V>): KeyValue<K, V> {
//        var current: Node<K, V>? = subroot
//        var biggest = KeyValue(subroot.key, subroot.value)
//
//        while (current != null) {
//            biggest = KeyValue(subroot.key, subroot.value)
//            current = current.right
//        }
//
//        return biggest
//    }
//}
//
//fun main() {
//    val myset = BSTSet<Int>()
//    myset.insert(7)
//    myset.insert(5)
//    myset.insert(11)
//    myset.insert(6)
//    myset.insert(8)
//    myset.insert(3)
//    myset.insert(1)
//    println(myset.contains(8))
//    println(myset.contains(18))
//    myset.displayTree()
//    myset.displayInorder()
//    myset.delete(11)
//    myset.delete(5)
//    myset.delete(7)
//    myset.displayInorder()
//}
//
//
//
//
//
//
//
//
//
//
////    fun displayInorder() {
////        _displayInorder(root)
////        println()
////    }
////
////    fun displayTree() {
////        _displayTree(root, 0)
////    }
////
////    private fun _displayTree(current: Node<T>?, spaces: Int) {
////        if (current == null) {
////            return
////        }
////
////        _displayTree(current.right, spaces + 4)
////        println(" ".repeat(spaces) + "-> " + current.key)
////        _displayTree(current.left, spaces + 4)
////    }
////
////    private fun _displayInorder(subroot: Node<T>?) {
////        if (subroot != null) {
////            _displayInorder(subroot.left)
////            print(" " + subroot.key)
////            _displayInorder(subroot.right)
////        }
////    }
////
