package org.overrun.nucleoplasm.fabric;

import dev.architectury.registry.registries.DeferredRegister;
import org.overrun.nucleoplasm.NucleoplasmApi;
import net.fabricmc.api.ModInitializer;

public class NucleoplasmApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NucleoplasmApi.init();

    }
}