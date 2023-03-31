package org.overrun.nucleoplasm_api.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideEnchantRegistry<T extends Enchantment> extends NuclideBase {

    public NuclideEnchantRegistry(NuclideBase base) {
        super(base.getModid());
    }
    public NuclideEnchantRegistry() {
        super();
    }
    public NuclideEnchantRegistry(String modid) {
         super(modid);
    }
    public T add(String name, T t) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(getModid(), name), t);
    }
}
