import kotlin.random.Random

fun main() {
    val random = Random(98765)
    val skip = SkipListMap<Int, String>()
    val entries = (0..<20).sortedBy { random.nextInt(2000) }
    for (num in entries) {
        skip.put(num, "s$num")
    }
    println(skip)

    for (num in entries) {
        println("$num ${skip.get(num)}")
    }
}