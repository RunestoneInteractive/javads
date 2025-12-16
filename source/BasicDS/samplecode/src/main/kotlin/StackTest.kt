fun main() {
    val s = Stack<String>()
    println("isEmpty returns ${s.isEmpty()}")

    s.push("java")
    s.push("keyboard")
    println("Top of stack is ${s.peek()}")
    s.push("computer")
    println("Size of stack is ${s.size()}")
    println("Current stack is: $s")

    s.push("program")
    println("Current stack is: $s")

    println("Pop: ${s.pop()}")
    println("Pop: ${s.pop()}")

    println("Size of stack is ${s.size()}")
    println("Current stack is: $s")
}
