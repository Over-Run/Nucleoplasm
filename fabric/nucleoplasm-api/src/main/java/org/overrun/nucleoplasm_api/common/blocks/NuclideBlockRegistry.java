package org.overrun.nucleoplasm_api.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideBlockRegistry<T extends Block> {
    private final String modid;
    public NuclideBlockRegistry() {
        modid = MODID;
    }

    public NuclideBlockRegistry(String modid) {
        this.modid = modid;
    }

    public Item add(String name, T t, boolean hasItem) {
        T register = Registry.register(Registries.BLOCK, new Identifier(modid, name), t);
        if (hasItem) {
            return Registry.register(Registries.ITEM, new Identifier(modid, name), new BlockItem(register, new Item.Settings()));
        }
        return null;
    }

}
