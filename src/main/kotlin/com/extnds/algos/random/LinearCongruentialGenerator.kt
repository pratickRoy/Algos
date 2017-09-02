package com.extnds.algos.random

/**
 *  References:
 *  @See <a href="https://en.wikipedia.org/wiki/Linear_congruential_generator">
 *      Linear Congruential Generator Wikipedia</a>
 */
object LinearCongruentialGenerator {

    private val multiplier = 25214903917
    private val increment = 11
    private val modulus = Math.pow(2.0, 48.0) - 1
    private var seed = System.currentTimeMillis()

    fun randomIntInRange(min : Int, max : Int) : Int {

        var random : Int
        do {
            random = ((seed() % (max - min + 1)) + min).toInt()
        } while (random < min)

        return random
    }

    private fun seed() : Long {

        seed = (((multiplier * seed) + increment) % modulus).toLong()
        return seed
    }
}