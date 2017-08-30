package com.extnds.algos.sort

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/merge-sort">Merge Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Merge_sort">Merge Sort Wikipedia</a>
 */
object MergeSort {

    fun sort(array: IntArray,
             lowerIndex : Int = 0,
             higherIndex : Int = array.size - 1) : IntArray {

        if (lowerIndex < higherIndex) {
            val midIndex = lowerIndex + (higherIndex - lowerIndex) / 2

            sort(array, lowerIndex, midIndex)
            sort(array, midIndex + 1, higherIndex)
            merge(array, lowerIndex, midIndex, higherIndex)
        }
        return array
    }

    private fun merge(array: IntArray, lowerIndex: Int, midIndex: Int, higherIndex: Int) {

        val tempArray = IntArray(array.size)
        for (i in lowerIndex..higherIndex) {
            tempArray[i] = array[i]
        }

        var arrayIndex = lowerIndex
        var leftIndex  = lowerIndex
        var rightIndex = midIndex + 1

        while (leftIndex <= midIndex && rightIndex <= higherIndex) {

            if (tempArray[leftIndex] < tempArray[rightIndex]) {
                array[arrayIndex] = tempArray[leftIndex++]
            } else {
                array[arrayIndex] = tempArray[rightIndex++]
            }
            arrayIndex++
        }

        while (leftIndex <= midIndex) {
            array[arrayIndex++] = tempArray[leftIndex++]
        }
    }
}