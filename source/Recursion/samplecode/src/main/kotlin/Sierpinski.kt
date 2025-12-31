import java.awt.Color

data class Point(var x: Double, var y: Double)

fun center(p1: Point, p2: Point, p3:Point): Point {
    return Point((p1.x + p2.x + p3.x) / 3.0, (p1.y + p2.y + p3.y) / 3.0)
}

fun drawTriangle(points: List<Point>, color: Color, t: Turtle) {
    // Move to center of triangle and draw dot
    t.up()
    val middle = center(points[0], points[1], points[2])
    t.setPosition(middle.x, middle.y)
    t.dot(color)

    // Move to corner of triangle and draw it
    t.setPosition(points[0].x, points[0].y)
    t.down()
    t.penColor(color)
    t.setPosition(points[1].x, points[1].y)
    t.setPosition(points[2].x, points[2].y)
    t.setPosition(points[0].x, points[0].y)
}

fun midpoint(p1: Point, p2: Point): Point {
    return Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0)
}

fun sierpinski(points: List<Point>, level: Int, t: Turtle) {

    val colorMap = listOf(Color.BLUE, Color.RED, Color.GREEN,
        Color.WHITE, Color.ORANGE, Color.MAGENTA)

    drawTriangle(points, colorMap[level], t)

    if (level > 0) {
        val triangle1 = listOf(
            points[0],
            midpoint(points[0], points[1]),
            midpoint(points[0], points[2])
        )

        sierpinski(triangle1, level - 1, t)

        val triangle2 = listOf(
            points[1],
            midpoint(points[0], points[1]),
            midpoint(points[1], points[2])
        )

        sierpinski(triangle2, level - 1, t)

        val triangle3 = listOf(
            points[2],
            midpoint(points[2], points[1]),
            midpoint(points[0], points[2])
        )

        sierpinski(triangle3, level - 1, t)
    }
}

fun main() {
    val myTurtle = Turtle()

    val points = listOf(
        Point(-180.0, -150.0),
        Point(0.0, 150.0),
        Point(180.0, -150.0)
    )

    sierpinski(points, 5, myTurtle)
    myTurtle.hide()
    Turtle.zoomFit()
}
