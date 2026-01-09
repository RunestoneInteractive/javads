class HashTableMap<K, V> : MapADT<K, V> {

    // Each Entry contains a key and a value
    data class Entry<K, V>(val key: K, var value: V)

    // slots is a list consisting of Entry objects
    val size = 11
    var slots: MutableList<Entry<K, V>?> = MutableList(size) { null }

    override fun toString(): String {
        return slots.toString()
    }

    // Assumes that a slot will eventually be found.
    override fun put(key: K, value: V) {
        var hashSlot = key.hashCode() % slots.count()
        var currentEntry = slots[hashSlot]

        while (currentEntry != null && (currentEntry.key != key)) {
            hashSlot = rehash(hashSlot, slots.count())
            currentEntry = slots[hashSlot]
        }

        if (currentEntry == null) {
            slots[hashSlot] = Entry(key, value)
        } else {
            currentEntry.value = value
        }
    }


    private fun rehash(oldHash: Int, size: Int): Int {
        return (oldHash + 1) % size
    }

    override fun get(key: K): V? {
        val startSlot = key.hashCode() % slots.count()
        var position = startSlot
        var currentEntry = slots[position]

        while (currentEntry != null) {
            if (currentEntry.key == key) {
                return currentEntry.value
            } else {
                position = rehash(position, slots.count())
                currentEntry = slots[position]
                if (position == startSlot) {
                    return null
                }
            }
        }

        return null
    }

    // Returns the number of key/value pairs stored in the map
    override fun size(): Int {
        return slots.count()
    }

    // Removes the key from the map.
    // Returns the matching value stored in the map, or null otherwise.
    // Not implemented yet: see exercises below.
    override fun remove(key: K): V? {
        throw NotImplementedError()
    }

    // Returns true if the key is in the map, false otherwise.
    // Not implemented yet: see exercises below.
    override fun containsKey(key: K): Boolean {
        throw NotImplementedError()
    }
}
