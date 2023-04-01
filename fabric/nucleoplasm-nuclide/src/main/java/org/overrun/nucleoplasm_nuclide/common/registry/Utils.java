package org.overrun.nucleoplasm_nuclide.common.registry;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import org.overrun.nucleoplasm_api.common.blocks.NuclideBlockRegistry;
import org.overrun.nucleoplasm_api.common.enchantments.NuclideEnchantRegistry;
import org.overrun.nucleoplasm_api.common.items.NuclideItemRegistry;
import org.overrun.nucleoplasm_nuclide.common.items.BaseNuclideItem;

public class Utils {
    public static final NuclideItemRegistry<BaseNuclideItem> ITEM_NUCLIDE_ITEM_REGISTRY = new NuclideItemRegistry<>();
    public static final NuclideBlockRegistry<Block> BLOCK_NUCLIDE_BLOCK_REGISTRY = new NuclideBlockRegistry<>();
    public static final NuclideEnchantRegistry<Enchantment> ENCHANTMENT_NUCLIDE_BLOCK_REGISTRY = new NuclideEnchantRegistry<>();
}
