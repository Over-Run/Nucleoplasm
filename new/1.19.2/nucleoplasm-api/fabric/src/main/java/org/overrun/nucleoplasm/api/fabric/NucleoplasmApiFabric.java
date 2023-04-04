package org.overrun.nucleoplasm.api.fabric;

import org.overrun.nucleoplasm.api.fabriclike.NucleoplasmApiFabricLike;
import net.fabricmc.api.ModInitializer;

public class NucleoplasmApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NucleoplasmApiFabricLike.init();
    }
}
