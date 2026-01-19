data class Animal(val priority: Int, val name: String): Comparable<Animal> {

    override fun compareTo(other: Animal): Int {
        return this.priority - other.priority
    }
}

fun main() {
    val myPq = BinaryHeapPriorityQueue<Animal>()
    myPq.insert(Animal(5, "emu"))
    myPq.insert(Animal(7, "elephant"))
    myPq.insert(Animal(3, "gazelle"))
    myPq.insert(Animal(11, "giraffe"))
    println("Min value: " + myPq.peek())

    println("Deleting items: ")
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
}