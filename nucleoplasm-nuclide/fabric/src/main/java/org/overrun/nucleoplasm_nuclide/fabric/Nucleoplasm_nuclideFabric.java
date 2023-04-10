package org.overrun.nucleoplasm_nuclide.fabric;

import org.overrun.nucleoplasm_nuclide.Nucleoplasm_nuclide;
import net.fabricmc.api.ModInitializer;

public class Nucleoplasm_nuclideFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Nucleoplasm_nuclide.init();
    }
}