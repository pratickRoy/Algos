package com.extnds.algos.random

/**
 *  References:
 *  @See <a href="https://en.wikipedia.org/wiki/Middle-square_method#Middle_Square_Weyl_Sequence_PRNG">
 *      Middle Square Weyl Sequence Generator Wikipedia</a>
 */
object MiddleSquareWeylSequenceGenerator {

    private var weylSequence = 0L
    private val increment = (1.3091206e+19).toLong()
    private var seed = 0L

    fun randomIntInRange(min : Int, max : Int) : Int {

        var random : Int
        do {
            random = ((seed() % (max - min + 1)) + min).toInt()
        } while (random < min)

        println(random)
        return random
    }

    private fun seed() : Long {

        seed *= seed
        weylSequence += increment
        seed += weylSequence
        seed = (seed.shr(32)).or(seed.shl(32))
        return seed
    }
}