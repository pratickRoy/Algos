package com.extnds.algos.sort

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/selection-sort">Selection Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort Wikipedia</a>
 */
object SelectionSort {

    fun sort(array: IntArray) : IntArray {

        for (i in 0 until array.size - 1) {

            for (j in i + 1 until array.size) {

                if (array[i] > array[j]) {

                    val temp = array[j]
                    array[j] = array[i]
                    array[i] = temp
                }
            }
        }
        return array
    }
}