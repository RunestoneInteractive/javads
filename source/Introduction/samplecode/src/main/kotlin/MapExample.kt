fun main() {
    val cityInfo = mutableMapOf<String, Int>()
    cityInfo["New York City"] = 7_888_121
    cityInfo["Tokyo"] = 13_515_271
    cityInfo["Dhaka"] = 8_906_039
    cityInfo["Luanda"] = 2_165_867

    println(cityInfo)
    println()

    for (key in cityInfo.keys) {
        println(String.format(
            "Key %s has value %,d.",
            key, cityInfo[key]
        ))
    }
}
