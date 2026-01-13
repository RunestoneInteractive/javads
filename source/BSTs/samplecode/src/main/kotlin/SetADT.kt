interface SetADT<E> {
    // Adds the element to the set.
    fun add(element: E)

    // Returns true if the element is in the set, false otherwise.
    fun contains(element: E): Boolean

    // Removes the element from the set.
    // Returns true if the element was in the set; false otherwise.
    fun remove(element: E): Boolean

    // Returns the number of elements stored in the set
    fun size(): Int
}