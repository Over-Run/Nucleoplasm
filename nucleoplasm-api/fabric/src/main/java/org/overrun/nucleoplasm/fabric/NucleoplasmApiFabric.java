package org.overrun.nucleoplasm.fabric;

import org.overrun.nucleoplasm.NucleoplasmApi;
import net.fabricmc.api.ModInitializer;

public class NucleoplasmApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NucleoplasmApi.init();
    }
}