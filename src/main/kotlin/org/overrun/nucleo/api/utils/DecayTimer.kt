package org.overrun.nucleo.api.utils

import kotlin.random.Random
import kotlin.random.nextULong

class DecayTimer(var randomA: Int, var randomB: Int) {

    fun getDecayTime() : Int {
        return Random.nextInt(randomA, randomB)
    }
}

