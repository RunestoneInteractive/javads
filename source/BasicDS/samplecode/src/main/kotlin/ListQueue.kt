class ListQueue<T> : QueueADT<T> {

    /*
     * The tail of the queue is at the beginning
     * of the list; the head is the last item
     */
    private val items = mutableListOf<T>()

    /*
     * Returns true if there are no items in the queue;
     * false otherwise.
     */
    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    /*
    * Add an item to the tail of the queue
    */
    override fun enqueue(item: T) {
        items.add(0, item)
    }

    /*
     * Remove the item at the head of the queue and return it.
     * If the queue is empty, throws an exception.
     */
    override fun dequeue(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty.")
        }
        return items.removeLast()
    }

    /*
     * Return the item at the head of the queue, but do not remove it.
     * If the queue is empty, throws an exception.
     */
    override fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty.")
        }
        return items[items.count() - 1]
    }

    /*
     * Returns the number of items in the queue.
     */
    override fun size(): Int {
        return items.count()
    }

    /*
     * Convert to string as an array from tail to head
     */
    override fun toString(): String {
        return items.toString()
    }
}