package com.extnds.algos.search

import com.extnds.algos.random.LinearCongruentialGenerator
import com.extnds.algos.random.MiddleSquareWeylSequenceGenerator
import org.junit.Test
import kotlin.test.assertTrue

class RandomTest {

    private val TEST_RANGE_1 = kotlin.Pair(-2000, -1000)
    private val TEST_RANGE_2 = kotlin.Pair(-1000,  1000)
    private val TEST_RANGE_3 = kotlin.Pair( 1000,  2000)

    @Test
    fun linearCongruentialGeneratorTest() {

        for (i in 0..100) {
            assertTrue(liesInRange(TEST_RANGE_1, {a,b -> LinearCongruentialGenerator.randomIntInRange(a, b)}))
            assertTrue(liesInRange(TEST_RANGE_2, {a,b -> LinearCongruentialGenerator.randomIntInRange(a, b)}))
            assertTrue(liesInRange(TEST_RANGE_3, {a,b -> LinearCongruentialGenerator.randomIntInRange(a, b)}))
        }

    }

    @Test
    fun middleSquareWeylSequenceGeneratorTest() {

        for (i in 0..100) {
            assertTrue(liesInRange(TEST_RANGE_1, {a,b -> MiddleSquareWeylSequenceGenerator.randomIntInRange(a, b)}))
            assertTrue(liesInRange(TEST_RANGE_2, {a,b -> MiddleSquareWeylSequenceGenerator.randomIntInRange(a, b)}))
            assertTrue(liesInRange(TEST_RANGE_3, {a,b -> MiddleSquareWeylSequenceGenerator.randomIntInRange(a, b)}))
        }

    }

    private fun liesInRange(range: Pair<Int, Int>, generatorBody : (Int, Int) -> Int) : Boolean {

        return generatorBody(range.first, range.second) in range.first..range.second
    }
}