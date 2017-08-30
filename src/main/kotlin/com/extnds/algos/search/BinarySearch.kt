package com.extnds.algos.search

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/binary-sort">Binary Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Binary_search">Binary Sort Wikipedia</a>
 */
object BinarySearch {

    fun search(array: IntArray,
               searchTerm: Int,
               lowerIndex : Int = 0,
               higherIndex : Int = array.size - 1) : Int {

        if (lowerIndex <= higherIndex) {

            val mid = lowerIndex + (higherIndex - lowerIndex) / 2
            return when {
                array[mid] == searchTerm -> mid + 1
                searchTerm > array[mid] -> search(array, searchTerm,mid + 1, higherIndex)
                else -> search(array, searchTerm, lowerIndex, mid - 1)
            }
        }
        return -1
    }
}