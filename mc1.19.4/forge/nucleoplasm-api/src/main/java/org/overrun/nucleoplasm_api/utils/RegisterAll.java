package org.overrun.nucleoplasm_api.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterAll {
    public final Map<String,Item> itemsMap = new ConcurrentHashMap<>();
    public final Map<String, Block> blocksMap = new ConcurrentHashMap<>();

    public RegisterAll() {
    }
    public <T> void invokeT(Map<String, T> tMap) {
        for (Map.Entry<String, T> entry : tMap.entrySet()) invokeT(entry.getKey(), entry.getValue());
    }
    public <T> void invokeT(String name, T t) {
        if (t instanceof Item item) {
            itemsMap.put(name, item);
        } else if (t instanceof Block block) {
            blocksMap.put(name, block);
        }
    }
}
