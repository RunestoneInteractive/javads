interface DequeADT<T> {
    // Returns true if there are no items in the deque;
    // false otherwise.
    fun isEmpty(): Boolean

    // Add an item to the head of the deque
    fun addHead(item: T)

    // Add an item to the tail of the deque
    fun addTail(item: T)

    // Remove the item at the head of the deque and return it.
    // If the deque is empty, throws an exception.
    fun removeHead(): T

    // Remove the item at the tail of the deque and return it.
    // If the deque is empty, throws an exception.
    fun removeTail(): T

    // Return the item at the head of the deque, but do not remove it.
    // If the deque is empty, throws an exception.
    fun peekHead(): T

    // Return the item at the tail of the deque, but do not remove it.
    // If the deque is empty, throws an exception.
    fun peekTail(): T

    // Returns the number of items in the deque.
    fun size(): Int
}