package com.extnds.algos.sort

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/heap-sort">Heap Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Heap_sort">Heap Sort Wikipedia</a>
 */
object HeapSort {

    fun sort(array : IntArray) : IntArray {
        for (i in array.size / 2 - 1 downTo 0)
            heapify(array, array.size, i)

        for (i in array.indices.reversed()) {
            val temp = array[0]
            array[0] = array[i]
            array[i] = temp
            heapify(array, i, 0)
        }
        return array
    }

    private fun heapify(array : IntArray, heapSize : Int, index: Int) {

        var maxIndex = index
        val leftIndex  = 2 * index + 1
        val rightIndex = 2 * index + 2

        if (leftIndex < heapSize && array[maxIndex] < array[leftIndex]) {
            maxIndex = leftIndex
        }
        if (rightIndex < heapSize && array[maxIndex] < array[rightIndex]) {
            maxIndex = rightIndex
        }

        if (maxIndex != index) {
            val temp = array[index]
            array[index] = array[maxIndex]
            array[maxIndex] = temp
            heapify(array, heapSize, maxIndex)
        }
    }
}