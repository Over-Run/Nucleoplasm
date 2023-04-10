package org.overrun.nucleoplasm_feature_repair.fabric;

import net.fabricmc.api.ModInitializer;
import org.overrun.nucleoplasm_feature_repair.Nucleoplasm_feature_repair;

public class Nucleoplasm_feature_repairFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Nucleoplasm_feature_repair.init();
    }
}