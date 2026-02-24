import kotlin.random.Random

class SkipListMap<K: Comparable<K>, V> {
    private var head: HeaderNode<K, V>? = null

    fun get(key: K): V? {
        var current = this.head
        while (current != null) {
            val next = current.next
            if (next == null) {
                current = current.down
            } else {
                val testKey = next.key
                if (key == testKey) {
                    return next.value
                } else if (key < testKey) {
                    current = current.down
                } else {
                    current = next.headerNode
                }
            }
        }
        return null
    }

    fun put(key: K, value: V) {
        if (head == null) {
            var temp = DataNode(key, value)
            head = HeaderNode(next=temp, down=null)
            var top = temp.headerNode
            while (Random.nextBoolean()) {
                temp = DataNode(key, value, HeaderNode(down=top))
                head = HeaderNode(next=temp, down=head)
                top = temp.headerNode
            }
        } else {
            val tower = ListStack<HeaderNode<K, V>>()
            var current = head
            while (current != null) {
                val next = current.next
                if (next == null) {
                    tower.push(current)
                    current = current.down
                } else if (next.key > key) {
                        tower.push(current)
                        current = current.down
                } else {
                    current = next.headerNode
                }
            }

            val lowestLevel = tower.pop()
            var temp = DataNode(key, value, HeaderNode(next=lowestLevel.next))
            lowestLevel.next = temp
            var top = temp.headerNode

            while (Random.nextBoolean()) {
                if (tower.isEmpty()) {
                    temp = DataNode(key, value, HeaderNode(down=top))
                    head = HeaderNode(next=temp, down=head)
                    top = temp.headerNode
                } else {
                    val nextLevel = tower.pop()
                    temp = DataNode(key, value, HeaderNode(down=top, next=nextLevel.next))
                    nextLevel.next = temp
                    top = temp.headerNode
                }
            }
        }
    }
}