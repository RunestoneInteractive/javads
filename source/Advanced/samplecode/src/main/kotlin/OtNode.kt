class OTNode(
    val parent: OTNode? = null,
    val level: Int = 0,
    val outer: Octree? = null
) {
    var red = 0
    var green = 0
    var blue = 0
    var count = 0
    val children: MutableList<OTNode?> = MutableList(8) { null }

    fun insert(r: Int, g: Int, b: Int, level: Int, outer: Octree) {
        if (level < this.outer!!.maxLevel) {
            val index = computeIndex(r, g, b, level)
            if (this.children[index] == null) {
                this.children[index] = OTNode(this, level + 1, outer)
            }
            this.children[index]!!.insert(r, g, b, level + 1, outer)
        } else {
            if (this.count == 0) {
                this.outer.numLeaves = this.outer.numLeaves + 1
                this.outer.allLeaves.add(this)
            }
            this.red += r
            this.green += g
            this.blue += b
            this.count += 1
        }
    }

    fun computeIndex(r: Int, g: Int, b: Int, level: Int): Int {
        val nShift = 8 - level
        val rBits = (r shr (nShift - 2)) and 0x04
        val gBits = (g shr (nShift - 1)) and 0x02
        val bBits = (b shr nShift) and 0x01
        return rBits or gBits or bBits
    }


    fun find(r: Int, g: Int, b: Int, level: Int): Pixel {
        if (level < this.outer!!.maxLevel) {
            val index = computeIndex(r, g, b, level)
            if (this.children[index] != null) {
                return this.children[index]!!.find(r, g, b, level + 1)
            } else if (this.count > 0) {
                return Pixel(
                    this.red / this.count,
                    this.green / this.count, this.blue / this.count
                )
            } else {
                throw Exception("No leaf node to represent RGB($r, $g, $b)")
            }
        } else {
            return Pixel(
                this.red / this.count,
                this.green / this.count, this.blue / this.count
            )
        }
    }


    fun merge() {
        for (child in this.children) {
            if (child != null) {
                if (child.count > 0) {
                    val removed = this.outer!!.allLeaves.remove(child)
                    this.outer.numLeaves -= 1
                } else {
                    println("Recursively merging non-leaf")
                    child.merge()
                }

                this.count += child.count
                this.red += child.red
                this.green += child.green
                this.blue += child.blue
            }
        }

        for (i in 0 ..< 8) {
            this.children[i] = null
        }
    }
}
