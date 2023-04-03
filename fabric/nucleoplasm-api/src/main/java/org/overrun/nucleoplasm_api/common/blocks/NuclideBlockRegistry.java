package org.overrun.nucleoplasm_api.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

public class NuclideBlockRegistry<T extends Block> extends NuclideBase {

    public NuclideBlockRegistry(NuclideBase base) {
        super(base.getModid());
    }
    public NuclideBlockRegistry() {
        super();
    }

    public NuclideBlockRegistry(String modid) {
        super(modid);
    }

    public Item add(String name, T t, boolean hasItem) {
        T register = Registry.register(Registries.BLOCK, new Identifier(getModid(), name), t);
        if (hasItem) {
            return Registry.register(Registries.ITEM, new Identifier(getModid(), name), new BlockItem(register, new Item.Settings()));
        }
        return null;
    }

}
