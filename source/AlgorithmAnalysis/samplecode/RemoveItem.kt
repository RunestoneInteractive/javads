import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration
import kotlin.time.measureTime


fun timeRemove(len: Int, removeFirst: Boolean): Duration {
    val N_TRIALS = 25
    val N_IGNORE = 20 // let system stabilize
    var totalTime = 10.milliseconds

    for (trial in 0 ..< N_TRIALS) {
        val list = MutableList<Int>(len, { it })
        System.gc()

        val timeTaken = measureTime {
            for (count in 0 ..< 1000) {
                if (removeFirst) {
                    list.removeAt(0)
                } else {
                    list.removeAt(list.count() - 1)
                }
            }
        }

        if (trial >= N_IGNORE) {
            totalTime = totalTime + timeTaken
        }
    }
    return (totalTime / (N_TRIALS - N_IGNORE))
}

fun main() {
    for (itemCount in listOf(400_000, 200_000, 100_000)) {
        println("$itemCount items")
        println("Remove first time:  ${timeRemove(itemCount, true)}")
        println("Remove last time:   ${timeRemove(itemCount, false)}")
        println()
    }
}
