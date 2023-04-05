package org.overrun.nucleoplasm.nuclide.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.overrun.nucleoplasm.api.NucleoplasmApi;
import org.overrun.nucleoplasm.nuclide.NucleoplasmNuclide;

@Mod(NucleoplasmNuclide.MOD_ID)
public class NucleoplasmApiForge {
    public NucleoplasmApiForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(NucleoplasmNuclide.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        NucleoplasmNuclide.init();
    }
}
