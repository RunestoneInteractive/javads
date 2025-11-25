fun timeRemove(len: Int, removeFirst: Boolean): Double {
    val N_TRIALS = 25
    val N_IGNORE = 20 // let system stabilize
    var totalTime = 0

    val list = MutableList<Int>(len, { 0 })

    for (trial in 0 ..< N_TRIALS) {
        val start = list.count()
        for (i in start downTo len) {
            list.add(i)
        }
        System.gc()

        // long startTime = System.nanoTime();
        for (count in 0 ..< 1000) {
            if (removeFirst) {
                list.remove(0)
            } else {
                list.remove(list.count() - 1)
            }
        }

        if (trial >= N_IGNORE) {
            // totalTime = totalTime + (System.nanoTime() - startTime);
        }
    }
    return (totalTime / (N_TRIALS - N_IGNORE)) / 1.0E9
}

fun main() {
    println("2,000,000 items")
    printf("Remove first time: %.7f sec%n", timeRemove(2_000_000, true))
    printf("Remove last time: %.7f sec%n", timeRemove(2_000_000, false))
    println()

    println("1,000,000 items")
    printf("Remove first time: %.7f sec%n", timeRemove(1_000_000, true))
    printf("Remove last time: %.7f sec%n", timeRemove(1_000_000, false))
    println()

    println("100,000 items")
    printf("Remove first time: %.7f sec%n", timeRemove(100_000, true))
    printf("Remove last time: %.7f sec%n", timeRemove(100_000, false))
    println()
}
