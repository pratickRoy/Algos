package com.extnds.algos.search

import com.extnds.algos.sort.*
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SortTest {

    private val TEST_ARRAY_1 = intArrayOf(54, 26, 93, 17, 77, 31, 26, 44, 55, 20, 55)
    private val SORTED_TEST_ARRAY_1 = TEST_ARRAY_1.sortedArray()

    private val TEST_ARRAY_2 = intArrayOf(54, 26, -93, -17, 77, 31, 44, -55, 20, 0)
    private val SORTED_TEST_ARRAY_2 = TEST_ARRAY_2.sortedArray()

    private val TEST_ARRAY_3 = intArrayOf()
    private val SORTED_TEST_ARRAY_3 = TEST_ARRAY_3.sortedArray()

    @Test
    fun bubbleSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, BubbleSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, BubbleSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, BubbleSort.sort(TEST_ARRAY_3))
    }

    @Test
    fun countingSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, CountingSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, CountingSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, CountingSort.sort(TEST_ARRAY_3))
    }

    @Test
    fun heapSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, HeapSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, HeapSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, HeapSort.sort(TEST_ARRAY_3))
    }

    @Test
    fun mergeSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, MergeSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, MergeSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, MergeSort.sort(TEST_ARRAY_3))
    }

    @Test
    fun quickSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, QuickSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, QuickSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, QuickSort.sort(TEST_ARRAY_3))
    }

    @Test
    fun radixSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, RadixSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, RadixSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, RadixSort.sort(TEST_ARRAY_3))
    }


    @Test
    fun selectionSortTest() {

        assertArrayEquals(SORTED_TEST_ARRAY_1, SelectionSort.sort(TEST_ARRAY_1))
        assertArrayEquals(SORTED_TEST_ARRAY_2, SelectionSort.sort(TEST_ARRAY_2))
        assertArrayEquals(SORTED_TEST_ARRAY_3, SelectionSort.sort(TEST_ARRAY_3))
    }
}