package org.overrun.nucleoplasm.api.elements.elements;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public record ElementNeutronSetting(
    @SerializedName("neutron") int neutron,
    @SerializedName("decay") boolean decay,
    @SerializedName("half_life") String half_life,
    @SerializedName("random") ArrayList<ElementRandom> random
) {
}
