package org.overrun.nucleoplasm;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RegisterAll {
    private final String modid;
    private final Map<String, Supplier<Item>> items = new HashMap<>();
    private final Map<String, Supplier<Block>> blocks = new HashMap<>();
    public RegisterAll(String modid) {
        this.modid = modid;
    }
    public <T> void invokeT(Map<String, T> map) {
        if (!map.isEmpty()) {
            for (var entry : map.entrySet()) {
                String name = entry.getKey();
                T t = entry.getValue();
                if (t instanceof Item item) {
                    items.put(name, () -> item);
                } else if (t instanceof Block block) {
                    blocks.put(name, () -> block);
                }
            }
        }
    }
    public void register() {
        final DeferredRegister<Block> blockRegistry = DeferredRegister.create(modid, Registries.BLOCK);
        final DeferredRegister<Item> itemRegistry = DeferredRegister.create(modid, Registries.ITEM);
        blocks.forEach(blockRegistry::register);
        items.forEach(itemRegistry::register);
        blockRegistry.register();
        itemRegistry.register();
    }
}
