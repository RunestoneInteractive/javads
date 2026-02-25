data class Pixel(var red: Int, var green: Int, var blue: Int)

class Octree {
    var root: OTNode? = null
    var numLeaves = 0
    var maxLevel = 5
    var allLeaves: MutableList<OTNode> = mutableListOf()

    fun insert(r: Int, g: Int, b: Int) {
        if (this.root == null) {
            this.root = OTNode(outer = this)
        }
        this.root!!.insert(r, g, b, 0, this)
    }

    fun find(r: Int, g: Int, b: Int): Pixel? {
        if (this.root != null) {
            return this.root!!.find(r, g, b, 0)
        } else {
            return null
        }
    }

    fun reduce(maxCubes: Int) {
        System.err.printf(
            "Reducing %d to %d%n",
            this.allLeaves.size, maxCubes
        )
        while (this.allLeaves.size > maxCubes) {
            val smallest = this.findMinCube()
            smallest!!.parent!!.merge()
            this.allLeaves.add(smallest.parent)
            this.numLeaves += 1
        }
    }

    fun findMinCube(): OTNode? {
        var minCount = Int.Companion.MAX_VALUE
        var maxLevel = 0
        var minCube: OTNode? = null

        for (node in allLeaves) {
            if (node.count <= minCount && node.level >= maxLevel) {
                minCube = node
                minCount = node.count
                maxLevel = node.level
            }
        }
        return minCube
    }
}