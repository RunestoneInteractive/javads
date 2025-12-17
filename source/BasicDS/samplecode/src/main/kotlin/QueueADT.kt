interface QueueADT<T> {
    // Returns true if there are no items in the queue;
    // false otherwise.
    fun isEmpty(): Boolean

    // Add an item to the tail of the queue
    fun enqueue(item: T)

    // Remove the item at the head of the queue and return it.
    fun dequeue(): T

    // Return the item at the head of the queue, but do not remove it.
    // If the queue is empty, throws an exception.
    fun peek(): T

    // Returns the number of items in the queue.
    fun size(): Int
}