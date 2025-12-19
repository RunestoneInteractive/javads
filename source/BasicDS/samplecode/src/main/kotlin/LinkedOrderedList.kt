import kotlin.toString

class LinkedOrderedList<T: Comparable<T>> {

    private var head: Node<T>? = null

    // Adds (insert) a new item at the appropriate location.
    fun add(item: T) {
        var current = head
        var previous: Node<T>? = null

        while (current != null && current.data < item) {
            previous = current
            current = current.next
        }
        val itemNode = Node(item)

        if (previous == null) {
            itemNode.next = head
            head = itemNode
        } else {
            itemNode.next = current
            previous.next = itemNode
        }
    }

    // Find index of first occurrence of item in list.
    fun indexOf(item: T): Int {
        var current = head
        var location = 0
        while (current != null) {
            if (current.data == item) {
                return location
            }
            if (current.data > item) {
                return -1
            }
            current = current.next
            location++
        }
        return -1
    }

    // Searches for first occurrence of item and removes it.
    fun remove(item: T) {
        throw NotImplementedError()
    }

    // Return item at specified index.
    fun get(index: Int): T {
        throw NotImplementedError()
    }

    // Returns true if there are no items in the list;
    // false otherwise.
    fun isEmpty(): Boolean {
        throw NotImplementedError()
    }

    // Returns the number of items in the list.
    fun size(): Int {
        throw NotImplementedError()
    }

    override fun toString(): String {
        var current: Node<T>? = head
        var result = "[ "
        while (current != null) {
            result = result + current.data.toString() + " "
            current = current.next
        }
        result = result + "]"
        return result
    }

}