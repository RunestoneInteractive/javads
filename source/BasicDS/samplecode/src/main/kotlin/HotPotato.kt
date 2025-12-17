fun hotPotato(nameList: List<String>, num: Int): String {
    val simQueue = ListQueue<String>()

    for (name in nameList) {
        simQueue.enqueue(name)
    }

    while (simQueue.size() > 1) {
        // pass the potato: move person at head to tail
        for (pass in 0..< num) {
            simQueue.enqueue(simQueue.dequeue())
        }

        val removed = simQueue.dequeue() // remove person at head
        println("$removed is out of the game.")
    }
    return simQueue.dequeue()
}

fun main() {
    val people = listOf<String>(
        "Bill", "David", "Susan", "Jane",
        "Kent", "Brad"
    )
    val lastPerson = hotPotato(people, 7)
    println("Last person is $lastPerson.")
}
