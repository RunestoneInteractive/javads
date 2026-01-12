fun main() {
    val parseTree = buildParseTree("( 3 + ( 4 * 5 ) )")
    println(postorderEvaluate(parseTree))
}
