fun main() {
    val tree = BSTMap<String, String>()

    tree.put("France", "Paris")
    tree.put("Japan", "Tokyo")
    tree.put("Albania", "Tirana")
    tree.put("Madagascar", "Antananarivo")
    tree.put("Zimbabwe", "Harare")
    tree.put("South Korea", "Seoul")

    println(tree)

    println(tree.get("Japan")) // "Tokyo"
    println(tree.get("Brazil")) // null

    for (node in tree) {
        println(node.key + " -> " + node.value)
    }

    println("-----------------------------")

    println(tree.remove("Zimbabwe"))  // "Harare"
    for (node in tree) {
        println(node.key + " -> " + node.value)
    }

}
