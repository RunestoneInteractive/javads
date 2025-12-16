import kotlin.random.Random

class Task(var timeStamp: Int) {
    var pages = Random.nextInt(20) + 1

    fun waitTime(currentTime: Int): Int {
        return currentTime - timeStamp
    }
}