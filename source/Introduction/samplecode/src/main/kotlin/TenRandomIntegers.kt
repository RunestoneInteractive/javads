import kotlin.random.Random

fun main() {
    for (i in 0..9) {
        val randomInt = Random.nextInt(100)
        println(randomInt)
    }
}
