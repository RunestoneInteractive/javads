import kotlin.random.Random

fun performSimulation(numSeconds: Int, pagesPerMinute: Int) {

    val labPrinter = Printer(pagesPerMinute)
    val printQueue = ListQueue<Task>()
    val waitingTimes = mutableListOf<Int>()

    for (currentSecond in 0..<numSeconds) {

        if (newPrintTask()) {
            val task = Task(currentSecond)
            printQueue.enqueue(task)
        }

        if ((!labPrinter.busy()) && (!printQueue.isEmpty())) {
            val nextTask = printQueue.dequeue()
            waitingTimes.add(nextTask.waitTime(currentSecond))
            labPrinter.startNext(nextTask)
        }

        labPrinter.tick()
    }

    val averageWait = waitingTimes.average()

    println(
        String.format(
            "Average wait %6.2f secs. %d tasks remaining.",
            averageWait, printQueue.size()
        )
    )
}

fun newPrintTask(): Boolean {
    val num = Random.nextInt(180) + 1
    return (num == 180)
}

fun main() {
    for (i in 0..9) {
        performSimulation(3600, 5)
    }
}
