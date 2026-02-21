fun main() {
    val pancake = AdjListGraph<String>(directed=true)
    pancake.addEdge("3/4 cup milk", "1 cup mix")
    pancake.addEdge("pour 1/4 cup", "turn when bubbly")
    pancake.addEdge("heat syrup", "eat")
    pancake.addEdge("heat griddle", "pour 1/4 cup")
    pancake.addEdge("1 egg", "1 cup mix")
    pancake.addEdge("1 Tbsp oil", "1 cup mix")
    pancake.addEdge("1 cup mix", "pour 1/4 cup")
    pancake.addEdge("1 cup mix", "heat syrup")
    pancake.addEdge("turn when bubbly", "eat")
    val dfsSolution = DfsSolver(pancake)

    val sortList = pancake
        .getVertices()
        .sortedByDescending { vertex -> dfsSolution.closingTime[vertex] }

    for (v in sortList) {
        println("$v (${dfsSolution.closingTime[v]})")
    }
}
