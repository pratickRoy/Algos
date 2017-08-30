package com.extnds.algos.search

import org.junit.Test
import kotlin.test.assertEquals

class SearchTest {

    private val TEST_ARRAY = intArrayOf(54, 26, 93, 17, 77, 31, 44, 55, 20).sortedArray()

    private val SEARCH_TERM1 = 17
    private val EXPECTED_TERM1 = 1

    private val SEARCH_TERM2 = 171
    private val EXPECTED_TERM2 = -1

    private val SEARCH_TERM3 = 55
    private val EXPECTED_TERM3 = 7

    @Test
    fun binarySearchTest() {

        assertEquals(EXPECTED_TERM1, BinarySearch.search(TEST_ARRAY, SEARCH_TERM1))
        assertEquals(EXPECTED_TERM2, BinarySearch.search(TEST_ARRAY, SEARCH_TERM2))
        assertEquals(EXPECTED_TERM3, BinarySearch.search(TEST_ARRAY, SEARCH_TERM3))
    }

    @Test
    fun linearSearchTest() {

        assertEquals(EXPECTED_TERM1, LinearSearch.search(TEST_ARRAY, SEARCH_TERM1))
        assertEquals(EXPECTED_TERM2, LinearSearch.search(TEST_ARRAY, SEARCH_TERM2))
        assertEquals(EXPECTED_TERM3, LinearSearch.search(TEST_ARRAY, SEARCH_TERM3))
    }
}