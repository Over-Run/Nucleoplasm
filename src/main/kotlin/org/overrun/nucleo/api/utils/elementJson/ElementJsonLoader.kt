package org.overrun.nucleo.api.utils.elementJson

import com.google.gson.annotations.SerializedName

data class Nucleoplasm(
    @SerializedName("proton") val proton: Int,
    @SerializedName("maxNeutron") val maxNeutron: Int,
    @SerializedName("minNeutron") val minNeutron: Int,
    @SerializedName("decay_level") val decayLevel: Map<String, Array<DecayLevel>>
)

data class DecayLevel(
    @SerializedName("maxNeutron") val maxNeutron: Int,
    @SerializedName("minNeutron") val minNeutron: Int
)

data class ElementJson(
    @SerializedName("reference_URL") val referenceURL: String,
    @SerializedName("nucleoplasm") val nucleoplasm: Array<Nucleoplasm>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ElementJson

        if (referenceURL != other.referenceURL) return false
        if (!nucleoplasm.contentEquals(other.nucleoplasm)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = referenceURL.hashCode()
        result = 31 * result + nucleoplasm.contentHashCode()
        return result
    }
}
