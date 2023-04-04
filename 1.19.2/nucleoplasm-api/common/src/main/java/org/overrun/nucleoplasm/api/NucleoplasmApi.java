package org.overrun.nucleoplasm.api;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.overrun.nucleoplasm.api.registry.item.NRegistry;
import org.overrun.nucleoplasm.api.registry.item.test.ExampleRegItem;

import java.util.function.Supplier;

public class NucleoplasmApi {
    public static final String MOD_ID = "nucleoplasm_api";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));
    // Registering a new creative tab
    public static final CreativeModeTab EXAMPLE_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "example_tab"), () ->
            new ItemStack(ExampleRegItem.example_item.supplier().get()));

    public static final NRegistry<Item> items = new NRegistry<>(Registry.ITEM_REGISTRY);
    
    public static void init() {
        ExampleRegItem.init(items);
        
        System.out.println(NucleoplasmApiExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
