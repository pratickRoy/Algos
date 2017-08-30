package com.extnds.algos.search

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/linear-sort">Linear Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Linear_sort">Linear Sort Wikipedia</a>
 */
object LinearSearch {

    fun search(array: IntArray, searchTerm: Int) : Int {

        return (0 until array.size)
            .firstOrNull { searchTerm == array[it] }
            ?.let { it + 1 }
            ?: -1
    }
}