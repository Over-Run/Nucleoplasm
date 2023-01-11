package org.overrun.nucleo.api.utils

object LevelDecay {
    fun tick(level : Int) : DecayTimer? {
        when(level) {
            1 -> return DecayTimer(1000, 100000)
            2 -> return DecayTimer(10000, 1000000)
            3 -> return DecayTimer(100000, 10000000)
            4 -> return DecayTimer(1000000, 100000000)
            5 -> return DecayTimer(10000000, 1000000000)
            6 -> return DecayTimer(100000000, Int.MAX_VALUE)
            else -> return null
        }
    }
}