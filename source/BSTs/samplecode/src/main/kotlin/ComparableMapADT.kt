// Subinterface of MapADT that adds Comparable capability.
interface ComparableMapADT<K: Comparable<K>, V>: MapADT<K, V> {

    // Return a list of all keys from fromKey to toKey, inclusive.
    fun keyList(fromKey: K, toKey: K): List<K>
}