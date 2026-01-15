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

    for (key in tree) {
        println(key + " -> " + tree.get(key))
    }

    println("-----------------------------")
    println(tree.remove("France"))  // "Paris"
    println(tree)

    println(tree.remove("Zimbabwe"))  // "Harare"
    for (key in tree) {
        println(key + " -> " + tree.get(key))
    }

}
