package org.overrun.nucleoplasm.api.fabric;

import org.overrun.nucleoplasm.api.NucleoplasmApi;
import net.fabricmc.api.ModInitializer;

public class NucleoplasmApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NucleoplasmApi.init();
    }
}
