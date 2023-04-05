package org.overrun.nucleoplasm.nuclide.fabric;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm.nuclide.fabriclike.NucleoplasmNuclideFabricLike;

public class NucleoplasmNuclideFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        NucleoplasmNuclideFabricLike.init();
    }
}
