package org.overrun.nucleoplasm_api.forge;

import dev.architectury.platform.forge.EventBuses;
import org.overrun.nucleoplasm_api.Nucleoplasm_api;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Nucleoplasm_api.MOD_ID)
public class Nucleoplasm_apiForge {
    public Nucleoplasm_apiForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Nucleoplasm_api.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Nucleoplasm_api.init();
    }
}