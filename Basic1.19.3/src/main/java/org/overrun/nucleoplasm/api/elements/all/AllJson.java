package org.overrun.nucleoplasm.api.elements.all;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record AllJson(@SerializedName("elements") List<Name> elements) {

}
