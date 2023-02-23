package org.overrun.nucleoplasm.api.elements.elements;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public record ElementRandom(
    @SerializedName("ran") double ran,
    @SerializedName("items") ArrayList<ElementDecayOutStack> items
) {
}
