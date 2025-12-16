interface StackInt<T> {

    // Returns true if there are no items on the stack;
    // false otherwise.
    fun isEmpty(): Boolean

    // Pushes given item on the top of the stack
    fun push(item: T)

    // Removes the item on top of the stack and returns it.
    // If the stack is empty, throws an exception.
    fun pop(): T

    // Returns the item on top of the stack without removing it.
    // If the stack is empty, throws an exception.
    fun peek(): T

    // Returns the number of items on the stack.
    fun size(): Int
}
