package org.overrun.nucleoplasm_nuclide.common.items;

import net.minecraft.item.Item;

public class ElementItem extends Item {
    private final int proton;
    public ElementItem(Settings settings, int proton) {
        super(settings);
        this.proton = proton;

    }
}
