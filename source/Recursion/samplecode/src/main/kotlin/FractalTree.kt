fun drawTree(branchLen: Double, t: Turtle) {
    if (branchLen > 5) {
        t.forward(branchLen)
        t.right(20.0)
        drawTree(branchLen - 15, t)
        t.left(40.0)
        drawTree(branchLen - 15, t)
        t.right(20.0)
        t.backward(branchLen)
    }
}


fun main() {
    val t = Turtle()

    t.left(90.0)
    t.up() // do not draw a trace
    t.backward(100.0)
    t.down()
    t.penColor("green")
    drawTree(75.0, t)
    Turtle.zoomFit()
}
