import java.awt.Color
import java.io.File

class Maze(mazeFileName: String) {

    val START = 'S'
    val OBSTACLE = '+'
    val TRIED = '.'
    val DEAD_END = '-'
    val PART_OF_PATH = 'O'

    var habitat: World
    var t: Turtle

    var rowsInMaze = 0
    var columnsInMaze = 0
    var startRow = 0
    var startColumn = 0

    val mazeList = mutableListOf<MutableList<Char>>()

    var xTranslate = 0.0
    var yTranslate = 0.0

    init {
        var row = 0
        val lines = File(mazeFileName).readLines()
        for (line in lines) {
            val sCol = line.indexOf(START)
            if (sCol >= 0) {
                startRow = row
                startColumn = sCol
            }
            this.mazeList.add(line.toMutableList())
            row = row + 1
        }
        this.rowsInMaze = this.mazeList.count()
        this.columnsInMaze = this.mazeList[0].count()
        this.xTranslate = -this.columnsInMaze / 2.0
        this.yTranslate = this.rowsInMaze / 2.0
        this.habitat = World(
            600, 600, Color.WHITE,
            -(this.columnsInMaze - 1) / 2.0 - 0.5,
            -(this.rowsInMaze - 1) / 2.0 - 0.5,
            (this.columnsInMaze - 1) / 2.0 + 0.5,
            (this.rowsInMaze - 1) / 2.0 + 0.5
        )
        this.t = Turtle(habitat)
        t.hide()
    }


    fun drawMaze() {
        t.setDelay(0.0)
        this.habitat.setUpdating(false)
        for (y in 0..<this.rowsInMaze) {
            for (x in 0..<this.columnsInMaze) {
                if (this.mazeList[y][x] == OBSTACLE) {
                    this.drawCenteredBox(
                        x + this.xTranslate,
                        -y + this.yTranslate, Color(184, 134, 11)
                    )
                }
                t.setColor(Color.BLACK)
            }
        }
        this.habitat.setUpdating(true)
        t.setDelay(0.04)
    }

    fun drawCenteredBox(x: Double, y: Double, color: Color?) {
        t.penUp()
        t.setColor(Color.BLACK)
        t.setFillColor(color)
        t.beginFill()
        t.goTo(x + 1, y)
        t.setHeading(90.0)
        t.penDown()
        for (i in 0..3) {
            t.forward(1.0)
            t.turnRight(90.0)
        }
        t.endFill()
    }

    fun updatePosition(row: Int, col: Int, value: Char?) {
        moveTurtle(col.toDouble(), row.toDouble())
        if (value != null) {
            mazeList[row][col] = value

            var color: Color? = null
            if (value == PART_OF_PATH) {
                color = Color(0, 192, 0) //bright green
            } else if (value == OBSTACLE) {
                color = Color.RED
            } else if (value == TRIED) {
                color = Color.BLACK
            } else if (value == DEAD_END) {
                color = Color.RED
            }

            if (color != null) {
                dropBreadCrumb(color)
            }
        }
    }

    fun moveTurtle(x: Double, y: Double) {
        t.penUp()
        t.show()
        t.setHeading(t.towards(x + this.xTranslate, -y + this.yTranslate))
        t.goTo(x + xTranslate + 0.5, -y + this.yTranslate - 0.5)
    }

    fun dropBreadCrumb(color: Color?) {
        val saveColor = t.getColor()
        t.setColor(color)
        t.drawDot(0.25)
        t.setColor(saveColor)
    }

    fun isExit(row: Int, col: Int): Boolean {
        return (row == 0 ||
                row == rowsInMaze - 1 ||
                col == 0 ||
                col == columnsInMaze - 1
                )
    }

    fun searchFrom(startRow: Int, startColumn: Int): Boolean {
        /*
         * try each of the four directions from this point until we find
         * a way out.
         */
        updatePosition(startRow, startColumn, null)

        /*
         *  Base case return values:
         *  1. We have run into an obstacle; return false
         */
        val value = getItem(startRow, startColumn)
        if (value == OBSTACLE) {
            return false
        }

        /* 2. We have found a square that has already been explored */
        if (value == TRIED || value == DEAD_END) {
            return false
        }

        /* 3. We have found an outside edge not occupied by an obstacle */
        if (isExit(startRow, startColumn)) {
            updatePosition(startRow, startColumn, PART_OF_PATH)
            return true
        }

        updatePosition(startRow, startColumn, TRIED)

        /*
         * Otherwise, use logical short circuiting to try each direction
         * in turn (if needed)
         */
        val found = (searchFrom(startRow - 1, startColumn)
                || searchFrom(startRow + 1, startColumn)
                || searchFrom(startRow, startColumn - 1)
                || searchFrom(startRow, startColumn + 1)
                )

        if (found) {
            updatePosition(startRow, startColumn, PART_OF_PATH)
        } else {
            updatePosition(startRow, startColumn, DEAD_END)
        }
        return found
    }

    fun getItem(row: Int, col: Int): Char {
        return mazeList[row][col]
    }
}

fun main() {
    val myMaze = Maze("maze2.txt")
    myMaze.drawMaze()
    myMaze.updatePosition(myMaze.startRow, myMaze.startColumn, null)
    myMaze.searchFrom(myMaze.startRow, myMaze.startColumn)
    myMaze.t.setHeading(90.0)
}
