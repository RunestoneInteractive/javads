class BinaryHeapPriorityQueue<E : Comparable<E>>() : PriorityQueueADT<E> {

    var heap = mutableListOf<E>()

    constructor(nonHeap: List<E>): this() {

        if (nonHeap.count() != 0) {
            heap = nonHeap.toMutableList()  // copies list

            var currIndex = heap.count() / 2 - 1
            while (currIndex >= 0) {
                percolateDown(currIndex)
                currIndex -= 1
            }
        }
    }

    private fun swapItemsAt(index1: Int, index2: Int) {
        val temporary = heap[index1]
        heap[index1] = heap[index2]
        heap[index2] = temporary
    }

    private fun percolateUp(index: Int) {
        var index = index
        while (index > 0) {
            val parentIndex = (index - 1) / 2
            if (heap[index] < heap[parentIndex]) {
                swapItemsAt(index, parentIndex)
            }
            index = parentIndex
        }
    }

    override fun insert(element: E) {
        heap.add(element)
        percolateUp(heap.count() - 1)
    }

    private fun percolateDown(index: Int) {
        var index = index
        while (2 * index + 1 < heap.count()) {
            val smallerChild = getSmallerChild(index)
            if (heap[index] > heap[smallerChild]) {
                swapItemsAt(index, smallerChild)
            } else {
                break
            }
            index = smallerChild
        }
    }

    private fun getSmallerChild(index: Int): Int {
        if (2 * index + 2 > heap.count() - 1) {
            return 2 * index + 1
        }
        if (heap[2 * index + 1] < heap[2 * index + 2]) {
            return 2 * index + 1
        }
        return 2 * index + 2
    }

    override fun delete(): E? {
        if (heap.count() == 0) {
            return null
        }

        val result = heap.get(0)
        swapItemsAt(0, heap.count() - 1)
        heap.removeLast()
        percolateDown(0)
        return result
    }

    override fun peek(): E? {
        if (heap.count() == 0) {
            return null
        } else {
            return heap[0]
        }
    }

    override fun isEmpty(): Boolean {
        return heap.count()==0
    }

    override fun size(): Int {
        return heap.count()
    }

    override fun toString(): String {
        return heap.toString()
    }

}