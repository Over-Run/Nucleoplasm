package org.overrun.nucleoplasm_api.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterAll {
    public final Map<String,Item> itemsMap = new ConcurrentHashMap<>();

    public RegisterAll() {
    }
    public <T> void invokeT(Map<String, T> tMap) {
        tMap.forEach(this::invokeT);
    }
    public <T> void invokeT(String name, T t) {
        if (t instanceof Item item) {
            itemsMap.put(name, item);
        }
    }
}
