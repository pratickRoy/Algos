package com.extnds.algos.sort

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/bubble-sort">Bubble Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort Wikipedia</a>
 */
object BubbleSort {

    fun sort(array: IntArray) : IntArray {

        for (i in 0 until array.size - 1) {

            for (j in 0 until array.size - i - 1) {

                if (array[j] > array[j + 1]) {

                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
        return array
    }
}