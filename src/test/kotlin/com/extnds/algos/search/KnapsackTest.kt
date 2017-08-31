package com.extnds.algos.search

import com.extnds.algos.optimization.Knapsack
import com.extnds.algos.optimization.Knapsack.Item
import org.junit.Test
import kotlin.test.assertEquals

class KnapsackTest {

    private val ITEMS = arrayListOf(Item(120, 30),
        Item(60, 10),
        Item(100, 20))

    private val KNAPSACK_SPACE = 50
    private val FRACTIONAL_KNAPSACK_VALUE = 240.0
    private val ZERO_ONE_KNAPSACK_VALUE = 220

    @Test
    fun fractionalKnapsackTest() {

        assertEquals(FRACTIONAL_KNAPSACK_VALUE,
            Knapsack(ITEMS, KNAPSACK_SPACE).fractionalKnapsack())
    }

    @Test
    fun zeroOneKnapsackTest() {

        assertEquals(ZERO_ONE_KNAPSACK_VALUE,
                Knapsack(ITEMS, KNAPSACK_SPACE).zeroOneKnapsack())
    }

    @Test
    fun tabulatedZeroOneKnapsackTest() {

        assertEquals(ZERO_ONE_KNAPSACK_VALUE,
                Knapsack(ITEMS, KNAPSACK_SPACE).tabulatedZeroOneKnapsack())
    }

    @Test
    fun memoizedZeroOneKnapsackTest() {

        assertEquals(ZERO_ONE_KNAPSACK_VALUE,
                Knapsack(ITEMS, KNAPSACK_SPACE).memoizedZeroOneKnapsack())
    }
}