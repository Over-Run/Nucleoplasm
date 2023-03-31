package org.overrun.nucleoplasm_nuclide.common.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import org.overrun.nucleoplasm_api.common.blocks.NuclideBlockRegistry;
import org.overrun.nucleoplasm_api.common.items.NuclideItemRegistry;

public class Utils {
    public static final NuclideItemRegistry<Item> ITEM_NUCLIDE_ITEM_REGISTRY = new NuclideItemRegistry<>();
    public static final NuclideBlockRegistry<Block> BLOCK_NUCLIDE_BLOCK_REGISTRY = new NuclideBlockRegistry<>();
}
