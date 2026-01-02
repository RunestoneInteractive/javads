interface MapADT<K, V> {
    // Adds the key/value pair to the map.
    // If the key is already in the map, it replaces the old value with the new one.
    fun put(key: K, value: V)

    // Returns the value matching the provided key, or null otherwise.
    fun get(key: K): V?

    // Removes the key from the map.
    // Returns the matching value stored in the map, or null otherwise.
    fun remove(key: K): V?

    // Returns true if the key is in the map, false otherwise.
    fun containsKey(key: K): Boolean

    // Returns the number of key/value pairs stored in the map
    fun size(): Int
}