package org.overrun.nucleoplasm.api.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.overrun.nucleoplasm.api.NucleoplasmApi;

@Mod(NucleoplasmApi.MOD_ID)
public class NucleoplasmApiForge {
    public NucleoplasmApiForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(NucleoplasmApi.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        NucleoplasmApi.init();
    }
}
