interface PriorityQueueADT<E: Comparable<E>> {
    // Two constructors should be implemented:
    // PriorityQueueADT()
    //     creates an empty priority queue
    //
    // PriorityQueueADT(List<E> initialList)
    //     creates a priority queue initialized with items
    //     present in initialList

    // Other methods:

    // Adds the element to the priority queue.
    fun insert(element: E)

    // Returns item with minimum value, leaving item in the priority queue.
    // Returns null if empty.
    fun peek(): E?

    // Deletes the item with minimum value, removing it from the priority queue.
    // Returns the value deleted, or null if the priority queue was empty.
    fun delete(): E?

    // Returns true if priority queue is empty, false otherwise
    fun isEmpty(): Boolean

    // Returns the number of items in the heap.
    fun size(): Int
}