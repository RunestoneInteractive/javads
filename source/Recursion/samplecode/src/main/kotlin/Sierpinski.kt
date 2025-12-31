import java.awt.Color

data class Point(var x: Double, var y: Double)

fun drawTriangle(points: List<Point>, color: Color, t: Turtle) {
    t.penUp()
    t.goTo(points[0].x, points[0].y)
    t.penDown()
    t.setColor(color)
    t.beginFill()
    t.goTo(points[1].x, points[1].y)
    t.goTo(points[2].x, points[2].y)
    t.goTo(points[0].x, points[0].y)
    t.endFill()
}

fun midpoint(p1: Point, p2: Point): Point {
    return Point((p1.x + p2.x) / 2.0, (p1.y + p2.y) / 2.0)
}

fun sierpinski(points: List<Point>, level: Int, t: Turtle) {

    val colorMap = listOf(Color.BLUE, Color.RED, Color.GREEN,
        Color.WHITE, Color.YELLOW, Color.MAGENTA, Color.ORANGE)

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
    val habitat = World(400, 400)
    val myTurtle = Turtle(habitat)

    val points = listOf(
        Point(-180.0, -150.0),
        Point(0.0, 150.0),
        Point(180.0, -150.0)
    )

    sierpinski(points, 5, myTurtle)
    myTurtle.hide()
}
