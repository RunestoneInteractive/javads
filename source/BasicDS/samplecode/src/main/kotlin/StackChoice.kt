import kotlin.random.Random

fun main() {
    val myStack: StackADT<Int>

    if (Random.nextInt(1) == 1) {
        myStack = ListStack<Int>()
    } else {
        myStack = AltListStack<Int>()
    }

    for (i in 1..20) {
        myStack.push(i)
    }
    for (i in 1..20) {
        println(myStack.pop())
    }
}
