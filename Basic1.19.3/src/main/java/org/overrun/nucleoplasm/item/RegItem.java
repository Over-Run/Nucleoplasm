package org.overrun.nucleoplasm.item;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

import static net.minecraft.world.item.Items.registerItem;
import static org.overrun.nucleoplasm.Basic.mod_id;

public enum RegItem {
    elementera(ElementItem::new);
    private final ElementItem item;
    private final Identifier id;

    RegItem(Function<ElementItem.Settings, ElementItem> item) {

        this.item = item.apply(new ElementItem.Settings());
        this.id = new Identifier(mod_id, name());
    }

    public static void init() {
        for (var v : values()) {
            registerItem(v.id, v.item);
        }
    }

    public static class Identifier extends ResourceLocation {
        public Identifier(String key, String path) {
            super(key, path);
        }
    }
}
