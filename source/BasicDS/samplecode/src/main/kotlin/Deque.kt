class Deque<T> {

    /*
     * The tail of the deque is at the beginning
     * of the ArrayList; the head is the last item
     */
    private val items = mutableListOf<T>()

    /*
     * Returns true if there are no items in the deque;
    * false otherwise.
    */
    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    /*
    * Add an item to the head of the deque
    */
    fun addHead(item: T) {
        items.add(item)
    }

    /*
     * Add an item to the tail of the deque
     */
    fun addTail(item: T) {
        items.add(0, item)
    }

    /*
     * Remove the item at the head of the deque and return it.
     * If the deque is empty, throws an exception.
     */
    fun removeHead(): T {
        if (this.isEmpty()) {
            throw NoSuchElementException("Deque is empty.")
        }
        return this.items.removeAt(this.size() - 1)
    }

    /*
     * Remove the item at the tail of the deque and return it.
     * If the deque is empty, throws an exception.
     */
    fun removeTail(): T {
        if (this.isEmpty()) {
            throw NoSuchElementException("Deque is empty.")
        }
        return items.removeFirst()
    }

    /*
     * Return the item at the head of the deque, but do not remove it.
     * If the deque is empty, throws an exception.
     */
    fun peekHead(): T {
        if (this.isEmpty()) {
            throw NoSuchElementException("Deque is empty.")
        }
        return items[items.count() - 1]
    }

    /*
     * Return the item at the tail of the deque, but do not remove it.
     * If the deque is empty, throws an exception.
     */
    fun peekTail(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Deque is empty.")
        }
        return items[0]
    }

    /*
     * Returns the number of items in the deque.
     */
    fun size(): Int {
        return items.count()
    }

    /*
     * Convert to string as an array from tail to head
     */
    override fun toString(): String {
        return "tail ${items.toString()} head"
    }
}