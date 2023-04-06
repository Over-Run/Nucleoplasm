package org.overrun.nucleoplasm_nuclide.forge;

import dev.architectury.platform.forge.EventBuses;
import org.overrun.nucleoplasm_nuclide.Nucleoplasm_nuclide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Nucleoplasm_nuclide.MOD_ID)
public class Nucleoplasm_nuclideForge {
    public Nucleoplasm_nuclideForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Nucleoplasm_nuclide.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Nucleoplasm_nuclide.init();
    }
}