package org.overrun.nucleoplasm_api.utils;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static org.overrun.nucleoplasm_api.Nucleoplasm_api.allModid;

public class ModSettings {
    public static class ModItems {
        public static final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, allModid);
        public static final RegistryObject<Item> test_item = register("test_item", new Item(new Item.Properties()));
        public static void register(IEventBus bus) {
            items.register(bus);
        }
        public static RegistryObject<Item> register(String name, Item item) {
            return items.register(name, () -> item);
        }
    }
    public static void register(IEventBus bus) {
        ModItems.register(bus);
    }

}
