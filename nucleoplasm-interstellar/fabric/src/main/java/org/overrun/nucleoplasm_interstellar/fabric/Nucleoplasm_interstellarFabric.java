package org.overrun.nucleoplasm_interstellar.fabric;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm_interstellar.Nucleoplasm_interstellar;

public class Nucleoplasm_interstellarFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Nucleoplasm_interstellar.init();
    }
}