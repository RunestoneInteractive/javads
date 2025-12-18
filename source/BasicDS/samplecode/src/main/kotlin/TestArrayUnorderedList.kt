fun main() {
    val myList = ArrayUnorderedList<Int>()
    println(myList.toString() + " size: " + myList.size())
    myList.add(31)
    myList.add(77)
    myList.add(17)
    myList.add(93)
    myList.add(26)
    myList.add(54)
    println(myList.toString() + " size: " + myList.size())

    println("First value, should be 31: ${myList.get(0)}")
    println("Second value, should be 77: ${myList.get(1)}")

    myList.add(2, 19)
    println(myList.toString() + " size: " + myList.size())

    myList.set(2, 28)
    println(myList.toString() + " size: " + myList.size())
}
