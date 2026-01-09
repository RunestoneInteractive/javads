class ListSet<E>: SetADT<E> {
    private val list = mutableListOf<E>()

    // Adds the element to the set.
    override fun add(element: E) {
        for (item in list) {
            if (item == element) {
                return   // already there
            }
        }
        // Element must not have been found
        list.add(element)
    }

    // Returns true if the element is in the set, false otherwise.
    override fun contains(element: E): Boolean {
        for (item in list) {
            if (item == element) {
                return true  // found it
            }
        }
        // Element must not have been found
        return false
    }

    // Removes the element from the set.
    // Returns true if the element was in the set; false otherwise.
    override fun remove(element: E): Boolean {
        for (index in 0 ..< list.count()) {
            if (list[index] == element) {
                list.removeAt(index)
                return true
            }
        }
        // Element must not have been found
        return false
    }

    // Returns the number of elements stored in the set
    override fun size(): Int {
        return list.count()
    }

    override fun toString(): String {
        return list.toString()
    }
}

fun main() {
    val set = ListSet<String>()
    set.add("emu")
    set.add("elephant")
    set.add("emu")
    set.add("dolphin")
    println(set)
    println(set.contains("emu"))    // true
    println(set.contains("horse"))  // false
}