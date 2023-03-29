package org.overrun.nucleoplasm;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.Map;

public class RegisterAll {
    public static void registerItem(String modid, Map<String, Item> items) {
        if (!items.isEmpty()) {
            DeferredRegister<Item> ITEMS = DeferredRegister.create(modid, Registries.ITEM);
            for (var entry : items.entrySet()) {
                ITEMS.register(entry.getKey(), entry::getValue);
            }
            ITEMS.register();
        }
    }
}
