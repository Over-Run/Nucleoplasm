package org.overrun.nucleoplasm;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm.item.RegItem;

public final class Nucleoplasm implements ModInitializer {
    @Override
    public void onInitialize() {
        RegItem.init(new FabricNRegistry());
    }
}
