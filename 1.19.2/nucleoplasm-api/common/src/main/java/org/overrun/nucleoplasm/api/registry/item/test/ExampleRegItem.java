package org.overrun.nucleoplasm.api.registry.item.test;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.api.registry.item.NRegistry;

import java.util.Locale;
import java.util.function.Function;

public enum ExampleRegItem {
    example_item(settings -> new ExampleItem(new Item.Properties()));
    private final Item item;
    private final String id;
    private RegistrySupplier<Item> supplier;
    ExampleRegItem(Function<Item.Properties, Item> items) {
        item = items.apply(new Item.Properties());
        id = name().toLowerCase(Locale.ROOT);
    }

    public static void init(NRegistry<Item> registry) {
        for (ExampleRegItem value : values()) {
            value.supplier = registry.add(value.id, value.item);
        }
        registry.register();
    }

    public RegistrySupplier<Item> supplier() {
        return supplier;
    }
}
