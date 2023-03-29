package org.overrun.nucleoplasm;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class RegisterAll {
    public static final Map<String, Item> ITEMS = new HashMap<>();
    static {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation("nucleoplasm", "a"), new Item(new Item.Properties()));
    }
    @ExpectPlatform
    public static void registerItem(Map<String, Item> items) {}//注册物品
}
