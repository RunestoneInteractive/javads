class ArrayUnorderedList<T> : UnorderedListADT<T> {

    // Create an initial array, of size 1
    @Suppress("UNCHECKED_CAST")
    private var array = arrayOfNulls<Any>(1) as Array<T?>

    // Keeps track of the number of locations in the
    // array that have been used
    private var usedCount = 0

    // Add a new item to the end of the list.
    override fun add(item: T) {
        add(usedCount, item)
    }

    // Add a new item at the specified index.
    override fun add(index: Int, item: T) {
        // Make sure that index is for an allowed location
        if (index !in 0.. usedCount) {
            throw Exception("Index out of range")
        }

        // If entire array is used, double its capacity
        if (usedCount == array.count()) {
            array = array.copyOf(array.count()*2)
        }

        // Move values out of the way
        for (i in usedCount downTo index+1) {
            array[i] = array[i-1]
        }
        array[index] = item
        usedCount++
    }

    // Return item at specified index.
    override fun get(index: Int): T {
        if (index in 0..< usedCount) {
            return requireNotNull(array[index])
        } else {
            throw Exception("Index out of range")
        }
    }

    // Find index of first occurrence of item in list.
    override fun indexOf(item: T): Int {
        throw NotImplementedError()
    }

    // Returns true if there are no items in the deque;
    // false otherwise.
    override fun isEmpty(): Boolean {
        throw NotImplementedError()
    }

    // Removes item at specified index. Items at higher
    // index values are shifted down to fill the gap.
    override fun removeAt(index: Int) {
        throw NotImplementedError()
    }

    // Returns the number of items in the list.
    override fun size(): Int {
        return usedCount
    }

    override fun toString(): String {
        var result = "[ "
        for (i in 0 ..< usedCount) {
            result = result + array[i].toString() + " "
        }
        result = result + "]"
        return result
    }
}