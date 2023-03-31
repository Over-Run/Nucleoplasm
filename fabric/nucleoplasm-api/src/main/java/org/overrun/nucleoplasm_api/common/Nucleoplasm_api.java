package org.overrun.nucleoplasm_api.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import org.overrun.nucleoplasm_api.client.groups.NuclideGroup;
import org.overrun.nucleoplasm_api.common.blocks.NuclideBlockRegistry;
import org.overrun.nucleoplasm_api.common.items.NuclideItemRegistry;

public class Nucleoplasm_api implements ModInitializer {
    public static final String MODID = "nucleoplasm";
    public static final String THIS_MODID = "nucleoplasm_api";

    public static final NuclideBlockRegistry<Block> blocks = new NuclideBlockRegistry<>();
    public static final NuclideItemRegistry<Item> items = new NuclideItemRegistry<>();
    public static NuclideGroup group;
    @Override
    public void onInitialize() {
    }
}
