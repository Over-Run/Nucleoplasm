package org.overrun.nucleoplasm.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.api.NRegistry;

import java.util.Locale;
import java.util.function.Function;

import static org.overrun.nucleoplasm.Basic.MOD_ID;

public enum RegItem {
    elementera(ElementItem::new);

    private final ElementItem item;
    private final String regName;

    RegItem(Function<Item.Properties, ElementItem> item) {
        this.item = item.apply(new Item.Properties());
        this.regName = name().toLowerCase(Locale.ROOT);
    }

    public ElementItem getItem() {
        return item;
    }

    public String getRegistryName() {
        return regName;
    }

    public static void init(NRegistry registry) {
        for (var v : values()) {
            registry.registerItem(v.regName, v.item);
//            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, v.name()), v.item)
//            Registry.register(BuiltInRegistries.ITEM, v.id, v.item);
        }
    }
}
