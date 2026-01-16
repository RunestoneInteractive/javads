fun main() {
    val tree = AVLTreeMap<String, String>()

    tree.put("Albania", "Tirana")
    println(tree)

    tree.put("Bolivia", "La Paz")
    println(tree)

    tree.put("Germany", "Berlin")
    println(tree)

    tree.put("Lesotho", "Maseru")
    println(tree)

    tree.put("Madagascar", "Antananarivo")
    println(tree)

    tree.put("South Korea", "Seoul")
    println(tree)
}