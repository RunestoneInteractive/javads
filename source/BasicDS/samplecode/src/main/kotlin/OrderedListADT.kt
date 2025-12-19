interface OrderedListADT<T: Comparable<T>> {

    // Adds (insert) a new item at the appropriate location.
    fun add(item: T)

    // Searches for first occurrence of item and removes it.
    fun remove(item: T)

    // Find index of first occurrence of item in list.
    fun indexOf(item: T): Int

    // Return item at specified index.
    fun get(index: Int): T

    // Returns true if there are no items in the list;
    // false otherwise.
    fun isEmpty(): Boolean

    // Returns the number of items in the list.
    fun size(): Int
}