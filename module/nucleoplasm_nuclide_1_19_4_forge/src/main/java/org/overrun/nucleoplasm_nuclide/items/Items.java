package org.overrun.nucleoplasm_nuclide.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static org.overrun.nucleoplasm_nuclide.Nucleoplasm_nuclide.MODID;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    static {
        ITEMS.register("h", () -> new Item(new Item.Properties()));
    }
}
