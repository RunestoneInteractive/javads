//override fun toString(): String {
//    var result = ""
//    var row = head
//    while (row != null) {
//        var node = row.next
//        while (node != null) {
//            result += " ${System.identityHashCode(node.headerNode)} ${node.key} ${node.value} ${System.identityHashCode(node.headerNode.down)} -- "
//            node = node.headerNode.next
//        }
//        result += "\n"
//        row = row.down
//    }
//    return result
//}
