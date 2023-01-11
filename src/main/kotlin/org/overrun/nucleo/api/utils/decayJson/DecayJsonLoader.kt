package org.overrun.nucleo.api.utils.decayJson

import com.google.gson.annotations.SerializedName

data class DecayJson(
    @SerializedName("decay") val decay: Array<Decay>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DecayJson

        if (!decay.contentEquals(other.decay)) return false

        return true
    }

    override fun hashCode(): Int {
        return decay.contentHashCode()
    }
}

data class Decay(
    @SerializedName("proton") val proton: Int,
    @SerializedName("out") val out : Array<Out>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Decay

        if (proton != other.proton) return false
        if (!out.contentEquals(other.out)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = proton
        result = 31 * result + out.contentHashCode()
        return result
    }
}

data class Out(
    @SerializedName("neutron") val neutron: Int,
    @SerializedName("out") val out: Array<OutOut>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Out

        if (neutron != other.neutron) return false
        if (!out.contentEquals(other.out)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = neutron
        result = 31 * result + out.contentHashCode()
        return result
    }
}

data class OutOut(
    @SerializedName("nbt") val nbt: Array<Nbt>,
    @SerializedName("random") val random: Double
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OutOut

        if (!nbt.contentEquals(other.nbt)) return false
        if (random != other.random) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nbt.contentHashCode()
        result = 31 * result + random.hashCode()
        return result
    }
}

data class Nbt(
    @SerializedName("proton") val proton: Int,
    @SerializedName("neutron") val neutron: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("decay") val decay: Boolean,
)