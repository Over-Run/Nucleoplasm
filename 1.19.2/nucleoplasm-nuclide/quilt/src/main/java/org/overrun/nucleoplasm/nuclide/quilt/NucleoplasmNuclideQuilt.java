package org.overrun.nucleoplasm.nuclide.quilt;

import org.overrun.nucleoplasm.nuclide.fabriclike.NucleoplasmNuclideFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class NucleoplasmNuclideQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        NucleoplasmNuclideFabricLike.init();
    }
}