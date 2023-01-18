package org.overrun.nucleoplasm;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm.item.RegItem;

public class Nucleoplasm implements ModInitializer {
    @Override
    public void onInitialize() {
        RegItem.init(new FabricNRegistry());
    }
}
