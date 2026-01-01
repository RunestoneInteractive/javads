// Kick it all off
fun <T: Comparable<T>> mergeSort(list: MutableList<T>) {

    // copies list; just a brief way to make a list of the right size,
    // don't care about contents
    val tempList = list.toMutableList()
    mergeSort(list, tempList, 0, list.count())
}

// Recursive function that outlines the procedure.
// "start" is the beginning of the range (inclusive)
// "stop" is the end of the range (exclusive)
fun <T: Comparable<T>> mergeSort(list: MutableList<T>,
                                 tempList: MutableList<T>,
                                 start: Int, stop: Int) {
    displayStatus("Sorting", list, start, stop)
    if (stop - start > 1) {
        val center = (start + stop)/2
        mergeSort(list, tempList, start, center)
        mergeSort(list, tempList, center, stop)
        merge(list, tempList, start, center, stop)
        displayStatus("Merged into", list, start, stop)
    }
}

// Workhorse: Merge together two sorted runs of integers.
// First range is leftStart (inclusive) through rightStart (exclusive)
// Second range is rightStart (inclusive) through rightStop (exclusive)
fun <T: Comparable<T>> merge(list: MutableList<T>,
                             tempList: MutableList<T>,
                             leftStart: Int,
                             rightStart: Int,
                             rightStop: Int) {
    val leftStop = rightStart
    var cur = leftStart    // Current location in tempList
    var left = leftStart
    var right = rightStart

    // Start merging until one of the halves is exhausted
    while (left < leftStop && right < rightStop) {
        if (list[left] <= list[right]) {
            tempList[cur] = list[left]
            left = left + 1
        } else {
            tempList[cur] = list[right]
            right = right + 1
        }

        cur = cur + 1
    }

    // If above loop exits, either left half or right half is
    // done. Finish copying other half that's not done.

    // Copy rest of first half
    while (left < leftStop) {
        tempList[cur] = list[left]
        cur = cur + 1
        left = left + 1
    }

    // Copy rest of second half
    while (right < rightStop) {
        tempList[cur] = list[right]
        cur = cur + 1
        right = right + 1
    }

    // Copy temp list over original
    for (i in leftStart ..< rightStop)
        list[i] = tempList[i]
}

// Code to display current status of algorithm
// Most of the complexity below is just to indent the right amount.
fun <T> displayStatus(status: String, list: MutableList<T>, left: Int, right: Int) {
    print(String.format("%${list.count()+1-(right-left)}s",""))
    println("$status ${list.slice(left..< right)}")
}

fun main() {
    val testList = mutableListOf(54, 26, 93, 17, 77, 31, 44, 55, 20)
    println("Start point:  $testList")
    mergeSort(testList)
    println("Final result: $testList")
}