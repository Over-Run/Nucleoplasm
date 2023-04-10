package org.overrun.nucleoplasm_interstellar.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.overrun.nucleoplasm_interstellar.Nucleoplasm_interstellar;

@Mod(Nucleoplasm_interstellar.MOD_ID)
public class Nucleoplasm_interstellarForge {
    public Nucleoplasm_interstellarForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Nucleoplasm_interstellar.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Nucleoplasm_interstellar.init();
    }
}