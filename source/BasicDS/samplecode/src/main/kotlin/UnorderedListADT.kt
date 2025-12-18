interface UnorderedListADT<T> {

    // Add (insert )a new item to the end of the list.
    fun add(item: T)

    // Add (insert) a new item at the specified index.
    fun add(index: Int, item: T)

    // Set the value of an item at the specified index.
    fun set(index: Int, item: T)

    // Return item at specified index.
    fun get(index: Int): T

    // Find index of first occurrence of item in list.
    fun indexOf(item: T): Int

    // Returns true if there are no items in the deque;
    // false otherwise.
    fun isEmpty(): Boolean

    // Removes item at specified index. Items at higher
    // index values are shifted down to fill the gap.
    fun removeAt(index: Int)

    // Returns the number of items in the list.
    fun size(): Int
}