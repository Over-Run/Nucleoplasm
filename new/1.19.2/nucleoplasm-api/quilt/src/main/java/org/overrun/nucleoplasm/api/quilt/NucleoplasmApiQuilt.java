package org.overrun.nucleoplasm.api.quilt;

import org.overrun.nucleoplasm.api.NucleoplasmApi;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class NucleoplasmApiQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        NucleoplasmApi.init();
    }
}
