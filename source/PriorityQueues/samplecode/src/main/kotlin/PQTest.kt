fun main() {
    val myPq = BinaryHeapPriorityQueue<Int>()
    myPq.insert(5)
    myPq.insert(7)
    myPq.insert(3)
    myPq.insert(11)
    println("Min value: " + myPq.peek())
    println(myPq)

    println("Deleting items: ")
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())

    println("-------")
    // Testing list constructor
    val myPq2 = BinaryHeapPriorityQueue<Int>(listOf(18, 9, 1, 3, 6, 4, 12))
    println("Min value: " + myPq2.peek())
    println(myPq2)

    println("Deleting items: ")
    println(myPq2.delete())
    println(myPq2.delete())
    println(myPq2.delete())
    println(myPq2.delete())

}
