/*
 * Show the operation, its result (if any), and the resulting deque
 */
fun display(operation: String, result: String, d: ListDeque<Int>) {
    println(String.format(
        "%-17s | %-7s | %s", operation, result, d))
}

fun main() {
    val d = ListDeque<Int>()
    display("d.isEmpty()", d.isEmpty().toString(), d)

    d.addTail(4)
    display("d.addTail(4)", "", d)

    d.addTail(505)
    display("d.addTail(505)", "", d)

    d.addHead(1066)
    display("d.addHead(1066)", "", d)

    d.addHead(4711)
    display("d.addHead(4711)", "", d)

    display("d.size", d.size().toString(), d)

    display("d.isEmpty()", d.isEmpty().toString(), d)

    d.addTail(217)
    display("d.addTail(217)", "", d)

    var value: Int = d.removeTail()
    display("d.removeTail()", value.toString(), d)

    value = d.removeHead()
    display("d.removeHead()", value.toString(), d)
}
