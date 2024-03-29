package org.overrun.nucleoplasm_api.common.potion;

import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

public class NuclidePotionRegistry<T extends Potion> extends NuclideBase {
    public NuclidePotionRegistry(NuclideBase nuclideBase) {
        super(nuclideBase.getModid());
    }
    public NuclidePotionRegistry() {
        super();
    }
    public NuclidePotionRegistry(String modid) {
        super(modid);
    }

    public T add(String name, T t) {
        return Registry.register(Registries.POTION, new Identifier(getModid(), name), t);
    }
}
