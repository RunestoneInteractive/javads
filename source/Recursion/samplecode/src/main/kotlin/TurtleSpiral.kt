fun drawSpiral(myTurtle: Turtle, lineLen: Double) {
    if (lineLen > 0) {
        myTurtle.forward(lineLen)
        myTurtle.turnRight(90.0)
        drawSpiral(myTurtle, lineLen - 5)
    }
}

fun main() {
    val habitat = World(300, 300)
    val myTurtle = Turtle(habitat)
    drawSpiral(myTurtle, 100.0)
    myTurtle.hide()
}