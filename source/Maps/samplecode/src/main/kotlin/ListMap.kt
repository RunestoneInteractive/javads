class ListMap<K, V>: MapADT<K, V> {
    data class Entry<K,V>(val key: K, var value: V)

    private val list = mutableListOf<Entry<K, V>>()

    // Adds the key/value pair to the map.
    // If the key is already in the map, it replaces the old value with the new one.
    override fun put(key: K, value: V) {
        // Look for key in list
        for (entry in list) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }
        // Key must not have been found
        list.add(Entry(key, value))
    }

    // Returns the value matching the provided key, or null otherwise.
    override fun get(key: K): V? {
        for (entry in list) {
            if (entry.key == key) {
                return entry.value
            }
        }
        // Key must not have been found
        return null
    }

    // Removes the key from the map.
    // Returns the matching value stored in the map, or null otherwise.
    override fun remove(key: K): V? {
        for (index in 0 ..< list.count()) {
            if (list[index].key == key) {
                val value = list[index].value
                list.removeAt(index)
                return value
            }
        }
        // Key must not have been found
        return null
    }

    // Returns true if the key is in the map, false otherwise.
    override fun containsKey(key: K): Boolean {
        for (entry in list) {
            if (entry.key == key) {
                return true
            }
        }
        // Key must not have been found
        return false
    }

    // Returns the number of key/value pairs stored in the map
    override fun size(): Int {
        return list.count()
    }

    override fun toString(): String {
        return list.toString()
    }
}

fun main() {
    val map = ListMap<Int, String>()

    map.put(61820, "Champaign IL")
    map.put(48658, "Stanidsh MI")
    map.put(18222, "Drums PA")
    map.put(75394, "Dallas TX")
    map.put(83344, "Murtaugh ID")
    map.put(32157, "Lake Como FL")
    map.put(25101, "Cumberland MD")
    map.put(74457, "Proctor OK")
    map.put(24002, "Roanoke VA")
    map.put(46957, "Matthews IN")
    println(map)
    println()

    // Access and modify elements in the table
    println("key 32157, value " + map.get(32157)) // Lake Como
    println("key 61820, value " + map.get(61820)) // Champaign
    println("key 95135, value " + map.get(95135)) // null

    map.put(48658, "Standish MI") // correct a misspelling
    println("key 48658, value " + map.get(48658)) // Standish
}
