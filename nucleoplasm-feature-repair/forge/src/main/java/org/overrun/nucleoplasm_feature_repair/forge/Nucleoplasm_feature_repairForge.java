package org.overrun.nucleoplasm_feature_repair.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.overrun.nucleoplasm_feature_repair.Nucleoplasm_feature_repair;

@Mod(Nucleoplasm_feature_repair.MOD_ID)
public class Nucleoplasm_feature_repairForge {
    public Nucleoplasm_feature_repairForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Nucleoplasm_feature_repair.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Nucleoplasm_feature_repair.init();
    }
}