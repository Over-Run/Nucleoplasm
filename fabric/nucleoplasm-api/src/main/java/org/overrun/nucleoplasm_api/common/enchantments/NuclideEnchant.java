package org.overrun.nucleoplasm_api.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideEnchant<T extends Enchantment> {
    private final String modid;
    public NuclideEnchant(String name) {
        modid = MODID;
    }
    public T add(String name, T t) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(modid, name), t);
    }
}
