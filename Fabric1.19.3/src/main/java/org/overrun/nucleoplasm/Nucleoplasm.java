package org.overrun.nucleoplasm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.resources.ResourceLocation;
import org.overrun.nucleoplasm.item.GroupDecaySettings;
import org.overrun.nucleoplasm.item.NItemGroups;
import org.overrun.nucleoplasm.item.RegItem;

import java.util.Locale;

public final class Nucleoplasm implements ModInitializer {
    @Override
    public void onInitialize() {
        RegItem.init(new FabricNRegistry());
        GroupDecaySettings.items.init();
//        NbtAndGroupSettings.init();
        for (NItemGroups value : NItemGroups.values()) {
            value.itemGroup = value.register(FabricItemGroup.builder(new ResourceLocation(Basic.MOD_ID, value.name().toLowerCase(Locale.ROOT))))
                .displayItems((featureFlagSet, output, bl) -> output.acceptAll(value.getStacks()))
                .build();
        }
    }
}
