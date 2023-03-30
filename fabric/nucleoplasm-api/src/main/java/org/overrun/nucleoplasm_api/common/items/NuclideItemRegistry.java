package org.overrun.nucleoplasm_api.common.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.common.Nucleoplasm_api;
import org.overrun.nucleoplasm_api.common.blocks.NuclideBlockRegistry;

public class NuclideItemRegistry<T extends Item> {
    private final String modid;
    public NuclideItemRegistry() {
        modid = Nucleoplasm_api.MODID;
    }
    public NuclideItemRegistry(String modid) {
        this.modid = modid;
    }
    public T add(String name, T t)  {
        return Registry.register(Registries.ITEM, new Identifier(modid, name), t);
    }
}
