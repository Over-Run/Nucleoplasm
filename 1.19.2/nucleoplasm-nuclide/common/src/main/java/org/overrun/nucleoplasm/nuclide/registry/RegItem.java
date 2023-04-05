package org.overrun.nucleoplasm.nuclide.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.nuclide.NucleoplasmNuclide;
import org.overrun.nucleoplasm.nuclide.core.item.ElementItem;

import java.util.Locale;
import java.util.function.Function;

import static org.overrun.nucleoplasm.nuclide.NucleoplasmNuclide.MOD_ID;

public enum RegItem {
    example_item(settings -> new ElementItem(new Item.Properties()));
    public final ElementItem item;
    public final String name;
    public RegistrySupplier<Item> supplier;
    RegItem(Function<Item.Properties, ElementItem> item) {
        this.item = item.apply(new Item.Properties());
        this.name = name().toLowerCase(Locale.ROOT);
    }
//    public static final NRegistry nRegistry = NucleoplasmApiExpectPlatform.register(NucleoplasmNuclide.MOD_ID);
    public static void init(DeferredRegister<Item> itemRegistry) {

    }
}
