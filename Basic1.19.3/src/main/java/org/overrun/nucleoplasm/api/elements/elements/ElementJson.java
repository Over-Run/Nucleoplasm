package org.overrun.nucleoplasm.api.elements.elements;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public record ElementJson(
    @SerializedName("proton") int proton,
    @SerializedName("translate") String translate,
    @SerializedName("list") ArrayList<ElementNeutronSetting> list
    ) {
}
