fun main() {
    val myPq = BinaryHeapPriorityQueue<Int>()
    myPq.insert(5)
    myPq.insert(7)
    myPq.insert(3)
    myPq.insert(11)
    println("Min value: " + myPq.peek())

    println("Deleting items: ")
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
}