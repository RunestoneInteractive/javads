fun drawSpiral(myTurtle: Turtle, lineLen: Double) {
    if (lineLen > 0) {
        myTurtle.forward(lineLen)
        myTurtle.right(90.0)
        drawSpiral(myTurtle, lineLen - 5)
    }
}

fun main() {
    val myTurtle = Turtle()
    drawSpiral(myTurtle, 100.0)
    myTurtle.hide()
    Turtle.zoomFit()
}