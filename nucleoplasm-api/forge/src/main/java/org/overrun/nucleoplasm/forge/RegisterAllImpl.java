package org.overrun.nucleoplasm.forge;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

import static org.overrun.nucleoplasm.NucleoplasmApi.MOD_ID;

public class RegisterAllImpl {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static void registerItem(Map<String, Item> items) {
        for (var entry : items.entrySet()) {
            ITEMS.register(entry.getKey(), entry::getValue);
        }
    }
}
