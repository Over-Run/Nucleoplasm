package org.overrun.nucleoplasm.fabric;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.Map;

import static org.overrun.nucleoplasm.NucleoplasmApi.MOD_ID;

public class RegisterAllImpl {
    public static void registerItem(Map<String, Item> items) {
        for (var entry : items.entrySet()) {
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, entry.getKey()), entry.getValue());
        }
    }
}
