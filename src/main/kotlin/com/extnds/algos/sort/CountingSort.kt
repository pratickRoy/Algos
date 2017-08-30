package com.extnds.algos.sort

/**
 *  References:
 *  @See <a href="http://www.geeksforgeeks.org/counting-sort">Counting Sort GeeksForGeeks</a>
 *  @See <a href="https://en.wikipedia.org/wiki/Counting_sort">Counting Sort Wikipedia</a>
 */
object CountingSort {

    fun sort(array: IntArray,
             byDigit: Boolean = false,
             placeValue : Int = if (byDigit) -1 else 1) : IntArray {

        if (placeValue % 10 != 0 && placeValue != 1) {
            throw IllegalArgumentException("Place value must be 10^i where i is a whole number")
        }
        if (array.isEmpty()) {
            return array
        }

        val min = if(byDigit) 0 else array.min()!!
        val range = if(byDigit) 10 else array.max()!! + 1 - min
        val countArray = IntArray(range)
        val sortedArray = IntArray(array.size)

        for (i in array) {

            var index = ((i - min) / placeValue)
            if(byDigit) {
                index %= 10
            }
            countArray[index]++
        }

        for (i in 1 until range) {
            countArray[i] += countArray[i-1]
        }

        for (i in array.reversed()) {

            var index = ((i - min) / placeValue)
            if(byDigit) {
                index %= 10
            }
            sortedArray[--countArray[index]] = i
        }

        for (i in array.indices) {
            array[i] = sortedArray[i]
        }

        return array
    }

}