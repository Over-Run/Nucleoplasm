package org.overrun.nucleoplasm_nuclide.common.decay;

import org.overrun.nucleoplasm_nuclide.common.items.BaseNuclideItem;

public class DecayImpl<T extends BaseNuclideItem> {
    public DecayImpl() {}
    public static <T extends BaseNuclideItem> DecayImpl<T> get(String decayType) {
        return switch (decayType) {
            case "β−" -> new NegativeBetaDecay();
            case "β+" -> new JustBetaDecay();
            default -> new NullDecay();
        };
    }

}
