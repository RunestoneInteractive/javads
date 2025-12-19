class LinkedUnorderedList<T> : UnorderedListADT<T> {

    private var head: Node<T>? = null

    // Add a new first item to the beginning of the list
    override fun addFirst(item: T) {
        val temp = Node<T>(item)
        temp.next = head
        head = temp
    }

    // Returns the number of items in the list.
    override fun size(): Int {
        var current = head
        var count = 0
        while (current != null) {
            count = count + 1
            current = current.next
        }
        return count
    }

    // Find index of first occurrence of item in list.
    // Returns -1 if not found.
    override fun indexOf(item: T): Int {
        var current = head
        var location = 0
        while (current != null) {
            if (current.data == item) {
                return location
            }
            current = current.next
            location++
        }
        return -1
    }

    // Removes item from list.
    override fun remove(item: T) {
        var current = head
        var previous: Node<T>? = null

        while (current != null && (current.data != item)) {
            previous = current
            current = current.next
        }
        if (current != null) {
            if (previous == null) {
                head = current.next
            } else {
                previous.next = current.next
            }
        }
    }

    // Returns true if there are no items in the list;
    // false otherwise.
    override fun isEmpty(): Boolean {
        return head != null
    }


    // Add a new item at the specified index.
    override fun add(index: Int, item: T) {
        throw NotImplementedError()
    }

    // Add a new item to the end of the list.
    override fun addLast(item: T) {
        throw NotImplementedError()
    }

    // Set the value of an item at the specified index.
    override fun set(index: Int, item: T) {
        throw NotImplementedError()
    }

    // Return item at specified index.
    override fun get(index: Int): T {
        throw NotImplementedError()
    }

    // Removes item at specified index. Items at higher
    // index values are shifted down to fill the gap.
    override fun removeAt(index: Int) {
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