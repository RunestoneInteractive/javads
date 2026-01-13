// Subinterface of SetADT that adds Comparable capability.
interface ComparableSetADT<E: Comparable<E>>: SetADT<E> {

    // Return a list of all keys from fromKey to toKey, inclusive.
    fun keyList(fromElement: E, toElement: E): List<E>
}