package org.overrun.nucleoplasm.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.Basic;
import org.overrun.nucleoplasm.api.NRegistry;
import org.overrun.nucleoplasm.api.NRegistryObject;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.overrun.nucleoplasm.Basic.MOD_ID;

public enum RegItem {
    elementera(ElementItem::new);

    private NRegistryObject<Item> registryObject;
    private final Supplier<Item> item;
    private final String regName;

    RegItem(Function<Item.Properties, ElementItem> item) {
        this.item = () -> item.apply(new Item.Properties());
        this.regName = name().toLowerCase(Locale.ROOT);
    }

    public NRegistryObject<Item> getItem() {
        return registryObject;
    }

    public String getRegistryName() {
        return regName;
    }

    public static void init(NRegistry registry) {
        for (var v : values()) {
            v.registryObject = registry.registerItem(v.regName, v.item);
//            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, v.name()), v.item)
//            Registry.register(BuiltInRegistries.ITEM, v.id, v.item);
        }
    }
}
