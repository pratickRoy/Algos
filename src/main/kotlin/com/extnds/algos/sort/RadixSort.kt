package com.extnds.algos.sort

/**
 *  References:
 *  @See <array href="http://www.geeksforgeeks.org/radix-sort">Radix Sort GeeksForGeeks</array>
 *  @See <array href="https://en.wikipedia.org/wiki/Radix_sort">Radix Sort Wikipedia</array>
 */
object RadixSort {

    fun sort(array: IntArray) : IntArray {

        if(array.isEmpty()) {
            return array
        }

        var positiveArray = ArrayList<Int>()
        var negativeArray = ArrayList<Int>()
        for (i in array) {
            if(i >= 0) {
                positiveArray.add(i)
            } else {
                negativeArray.add(i * -1)
            }
        }

        positiveArray = radixSort(positiveArray)
        negativeArray = radixSort(negativeArray)

        var arrayIndex = 0
        for (i in negativeArray.size -1 downTo  0) {
            array[arrayIndex++] = -negativeArray[i]
        }
        for (i in positiveArray) {
            array[arrayIndex++] = i
        }
        return array
    }

    private fun radixSort(arrayList: ArrayList<Int>) : ArrayList<Int> {

        if(arrayList.isEmpty()) {
            return arrayList
        }

        val array = arrayList.toIntArray()
        val max = array.max() ?: array[0]

        var placeValue = 1
        while (max / placeValue > 0) {
            CountingSort.sort(array, true, placeValue)
            placeValue *= 10
        }
        return array.toCollection(ArrayList())
    }
}