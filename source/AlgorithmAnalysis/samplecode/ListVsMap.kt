import kotlin.random.Random
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun main() {
    println("size      list       map")

    for (size in 10_000 ..< 1_000_001 step 20_000) {
        val list = mutableListOf<Int>()
        for (key in 0 ..< size) {
            list.add(key)
        }
        System.gc()
        var generator = Random(12345) // seeded random numbers
        val elapsedListTime = measureTime {
            for (i in 0 ..< 1000) {
                val lookFor = generator.nextInt(size)
                list.contains(lookFor)
            }
        }

        val map = mutableMapOf<Int, Int>()
        for (key in 0 ..< size) {
            map[key] = key // key and value are the same
        }
        System.gc()
        generator = Random(12345) // seeded random numbers
        val elapsedMapTime = measureTime {
            for (i in 0 ..< 1000) {
                val lookFor = generator.nextInt(size)
                map.containsKey(lookFor)
            }
        }

        println(
                String.format(
                        "%8d %9.7f %9.7f",
                        size,
                        elapsedListTime.toDouble(DurationUnit.SECONDS),
                        elapsedMapTime.toDouble(DurationUnit.SECONDS)
                )
        )
    }
}
