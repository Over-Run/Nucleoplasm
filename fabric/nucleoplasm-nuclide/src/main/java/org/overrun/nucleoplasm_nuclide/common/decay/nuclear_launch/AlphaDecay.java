package org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch;

import net.minecraft.item.ItemStack;
import org.overrun.nucleoplasm_nuclide.common.decay.DecayImpl;
import org.overrun.nucleoplasm_nuclide.common.items.BaseNuclideItem;

public class AlphaDecay<T extends BaseNuclideItem> extends DecayImpl<T> {
    public AlphaDecay(ItemStack... stacks) {
        super(stacks);
    }
}
