package org.overrun.nucleo.basic.element.remake;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleo.basic.element.item.ElementItem;

import java.util.Locale;
import java.util.function.Function;

import static org.overrun.nucleo.Nucleoplasm.NAMESPACE;

public enum RegItem {
    /*考古老项目ElementEra*/
    elementera(ElementItem::new);

    private final Identifier id;
    private final ElementItem item;

    RegItem(Function<FabricItemSettings, ElementItem> item) {
        this.id = new Identifier(NAMESPACE, name().toLowerCase(Locale.ROOT));
        this.item = item.apply(new FabricItemSettings());
    }

    public Identifier getId() {
        return id;
    }

    public ElementItem getItem() {
        return item;
    }

    public static void init() {
        for (var v : values()) {
            Registry.register(Registries.ITEM, v.id, v.item);
        }
    }
}
