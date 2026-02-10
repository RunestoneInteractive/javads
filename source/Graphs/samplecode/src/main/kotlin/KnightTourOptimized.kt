// Returns a list with a knight's tour path, or null if none could be found.
// For keeping track of the path, we use a set instead of a list
// so that we can quickly look to see if a particular vertex is already in it.
// We are also taking advantage of the fact that if we create the set with
// mutableSetOf, Kotlin uses an implementation for sets that will let us
// iterate over it in the order that items were added.
//
fun <T> knightTourOptimized(
    graph: GraphADT<T>,
    tourVertices: MutableSet<T>,
    tourPath: MutableList<T>,
    newVertex: T,
    limit: Int
): List<T>? {

    tourPath.add(newVertex)
    tourVertices.add(newVertex)

    if (tourPath.count() == limit) {     // found a tour
        return tourPath
    }

    // Try each neighbor
//    val neighbors = graph.getNeighbors(newVertex)!!   // We know every node has a neighbor
    val neighbors = orderByAvail(graph, tourVertices, newVertex)   // We know every node has a neighbor
    for (neighbor in neighbors) {
        if (neighbor !in tourVertices) {
            val completeTour = knightTourOptimized(graph, tourVertices, tourPath, neighbor, limit)
            if (completeTour != null) { // found one!
                return completeTour
            }
        }
    }

    // If got to here, no tour found; remove current and return null
    tourPath.remove(newVertex)
    tourVertices.remove(newVertex)
    return null
}

fun main() {
    val size = 20
    val kg = buildKnightGraph(size)
    val tourVertices = mutableSetOf<Int>()
    val tourPath = mutableListOf<Int>()
    val solutionPath = knightTourOptimized(kg, tourVertices, tourPath, 0, size*size)
    println(solutionPath)

    // Print out a chessboard, so can look at locations
    for (row in size-1 downTo 0) {
        for (col in 0 ..< size) {
            print(String.format("%3d", row*size + col))
        }
        println()
    }
}