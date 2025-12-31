import java.awt.Color

fun drawTree(branchLen: Double, t: Turtle) {
    if (branchLen > 5) {
        t.forward(branchLen)
        t.turnRight(20.0)
        drawTree(branchLen - 15, t)
        t.turnLeft(40.0)
        drawTree(branchLen - 15, t)
        t.turnRight(20.0)
        t.backward(branchLen)
    }
}


fun main() {
    val habitat = World(300, 300)
    val t = Turtle(habitat)

    val darkGreen = Color(0, 128, 0)

    t.turnLeft(90.0)
    t.penUp() // do not draw a trace
    t.backward(100.0)
    t.penDown()
    t.setColor(darkGreen)
    drawTree(75.0, t)
}
