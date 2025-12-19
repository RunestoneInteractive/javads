fun main() {
    val myList = LinkedOrderedList<Int>()

    myList.add(505)
    myList.add(217)
    myList.add(1066)
    println("After adding 505, 217, and 1066: $myList")
    println("Is 505 in the list? Location = " + myList.indexOf(505))
    println("Is 300 in the list? Location = " + myList.indexOf(300))
}
