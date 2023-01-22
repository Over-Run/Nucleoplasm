package org.overrun.nucleoplasm.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.resources.ResourceLocation;
import org.overrun.nucleoplasm.Basic;
import org.overrun.nucleoplasm.item.NItemGroups;
import org.overrun.nucleoplasm.item.NbtAndGroupSettings;

import java.util.Locale;

@Environment(EnvType.CLIENT)
public class NucleoplasmClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NbtAndGroupSettings.init();
        for (NItemGroups value : NItemGroups.values()) {
            value.itemGroup = value.register(FabricItemGroup.builder(new ResourceLocation(Basic.MOD_ID, value.name().toLowerCase(Locale.ROOT))))
                .displayItems((featureFlagSet, output, bl) -> output.acceptAll(value.getStacks()))
                .build();
        }
    }
}
