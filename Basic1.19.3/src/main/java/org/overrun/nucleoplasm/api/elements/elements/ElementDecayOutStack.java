package org.overrun.nucleoplasm.api.elements.elements;

import com.google.gson.annotations.SerializedName;

public record ElementDecayOutStack(
    @SerializedName("abbreviation") String abbreviation,
    @SerializedName("neutron") int neutron,
    @SerializedName("count") int count
) {
}
