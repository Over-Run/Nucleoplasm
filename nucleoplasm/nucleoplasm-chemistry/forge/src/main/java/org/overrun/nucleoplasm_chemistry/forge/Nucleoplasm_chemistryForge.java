package org.overrun.nucleoplasm_chemistry.forge;

import dev.architectury.platform.forge.EventBuses;
import org.overrun.nucleoplasm_chemistry.Nucleoplasm_chemistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Nucleoplasm_nuclide.MOD_ID)
public class Nucleoplasm_chemistryForge {
    public Nucleoplasm_nuclideForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Nucleoplasm_chemistry.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Nucleoplasm_chemistry.init();
    }
}