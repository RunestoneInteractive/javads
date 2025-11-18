fun foo(tom: Int): Long {
    var fred = 0L
    for (nancy in 1..tom) {
        var joanne = nancy
        fred = fred + joanne
    }
    return fred
}

fun main() {
    println(foo(10))
}
