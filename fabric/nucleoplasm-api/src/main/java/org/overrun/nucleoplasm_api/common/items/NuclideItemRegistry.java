package org.overrun.nucleoplasm_api.common.items;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

public class NuclideItemRegistry<T extends Item> extends NuclideBase {

    public NuclideItemRegistry(NuclideBase base) {
        super(base.getModid());
    }
    public NuclideItemRegistry() {
        super();
    }
    public NuclideItemRegistry(String modid) {
        super(modid);
    }
    public T add(String name, T t)  {
        return Registry.register(Registries.ITEM, new Identifier(getModid(), name), t);
    }
}
