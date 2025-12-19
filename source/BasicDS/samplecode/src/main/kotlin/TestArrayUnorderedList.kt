fun main() {
    val myList = ArrayUnorderedList<Int>()
    println(myList.toString() + " size: " + myList.size())
    myList.addLast(31)
    myList.addLast(77)
    myList.addLast(17)
    myList.addLast(93)
    myList.addLast(26)
    myList.addLast(54)
    println(myList.toString() + " size: " + myList.size())

    println("First value, should be 31: ${myList.get(0)}")
    println("Second value, should be 77: ${myList.get(1)}")

    myList.add(2, 19)
    println(myList.toString() + " size: " + myList.size())

    myList.set(2, 28)
    println(myList.toString() + " size: " + myList.size())
}
