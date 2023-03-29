package org.overrun.nucleoplasm_api.utils;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

public class RegisterAll {
    public final Map<String,Item> itemsMap = new ConcurrentHashMap<>();
    public RegisterAll() {}
    public <T> void invokeT(Map<String, T> tMap) {
        tMap.forEach(this::invokeT);
    }
    public <T> void invokeT(String name, T t) {
        if (t instanceof Item item) {
            itemsMap.put(name, item);
        }
    }
}
