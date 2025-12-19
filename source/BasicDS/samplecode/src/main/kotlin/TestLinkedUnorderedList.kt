fun main() {
    val myList = LinkedUnorderedList<Int>()
    println(myList.toString() + " size: " + myList.size())
    myList.addFirst(31)
    myList.addFirst(77)
    myList.addFirst(17)
    myList.addFirst(93)
    myList.addFirst(26)
    myList.addFirst(54)
    println(myList.toString() + " size: " + myList.size())

    println(
        "search for 17 returns index of " +
                myList.indexOf(17)
        )
    println(
        "search for 1066 returns index of " +
                myList.indexOf(1066)
    )

    myList.remove(93)
    println("after removing 93: " + myList)

    myList.remove(54) // test removal of last item
    println("after removing 54: " + myList)

    myList.remove(1066) // remove non-existent item
    println("after removing 1066: " + myList)
}
