fun main() {
    val q = ListQueue<Int>()
    println("isEmpty returns ${q.isEmpty()}")

    q.enqueue(4)
    q.enqueue(27)
    println("Queue is now: $q")

    q.enqueue(1066)
    println("After another enqueue, size is ${q.size()}")
    println("isEmpty now returns ${q.isEmpty()}")

    q.enqueue(4711)

    println("After another enqueue, queue is $q")

    var head = q.dequeue()
    println("Dequeue - head was: $head")
    head = q.dequeue()
    println("Dequeue again - head was: $head")

    println("Queue is now: $q")
    println("Size is now: ${q.size()}")
}
