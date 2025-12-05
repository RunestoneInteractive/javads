class Stack<T> {

    /*
     * Create a new stack. The top of the stack is at the end
     * of the ArrayList.
     */
    private val items = mutableListOf<T>()

    /*
     * Returns true if there are no items on the stack;
     * false otherwise.
     */
    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    /*
     * Pushes given item on the top of the stack
     */
    fun push(item: T) {
        items.add(item)
    }

    /*
     * Removes the item on top of the stack and returns it.
     * If the stack is empty, throws an exception.
     */
    fun pop(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack is empty.")
        }
        return items.removeLast()
    }

    /*
     * Returns the item on top of the stack without removing it.
     * If the stack is empty, throws an exception.
     */
    fun peek(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack is empty.")
        }
        return items.get(items.count() - 1)
    }

    /*
     * Returns the number of items on the stack.
     */
    fun size(): Int {
        return items.count()
    }

    /*
     * Convert to string as an array from bottom to top
     */
    override fun toString(): String {
        return items.toString()
    }
}
