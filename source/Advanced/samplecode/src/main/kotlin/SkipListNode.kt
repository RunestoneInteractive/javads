data class SkipListNode<K: Comparable<K>, V>(
    val key: K,
    val value: V,
    val next: SkipListNode<K, V>? = null,
    val down: SkipListNode<K, V>? = null
)
