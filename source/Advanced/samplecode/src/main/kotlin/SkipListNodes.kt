data class HeaderNode<K: Comparable<K>, V>(
    var next: DataNode<K, V>? = null,
    val down: HeaderNode<K, V>? = null
)

data class DataNode<K: Comparable<K>, V>(
    val key: K,
    val value: V,
    val headerNode: HeaderNode<K, V> = HeaderNode()
)
