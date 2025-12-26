fun main() {
    val animals = mutableListOf<String>()
    println(animals)            // []

    animals.add("ibex")
    animals.add("capybara")
    animals.add("bison")
    println(animals)            // [ibex, capybara, bison]

    animals.add(1, "giraffe")
    println(animals)            // [ibex, giraffe, capybara, bison]
}