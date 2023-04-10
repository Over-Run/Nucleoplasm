package org.overrun.nucleoplasm_api.fabric;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm_api.Nucleoplasm_api;

public class Nucleoplasm_apiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Nucleoplasm_api.init();
    }
}