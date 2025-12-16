class Printer(
    var pageRate: Int // pages per minute
) {
    var currentTask: Task? = null
    var timeRemaining = 0

    fun tick() {
        if (currentTask != null) {
            timeRemaining = timeRemaining - 1
            if (timeRemaining <= 0) {
                currentTask = null
            }
        }
    }

    fun busy(): Boolean {
        return currentTask != null
    }

    fun startNext(newTask: Task) {
        currentTask = newTask
        timeRemaining = newTask.pages * 60 / pageRate
    }
}