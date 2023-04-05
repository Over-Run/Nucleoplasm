package org.overrun.nucleoplasm.nuclide;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.nuclide.core.item.ElementItem;
import org.overrun.nucleoplasm.nuclide.registry.RegItem;

import java.util.Arrays;

public class NucleoplasmNuclide {
    public static final String MOD_ID = "nucleoplasm_nuclide";
    public static final DeferredRegister<Item> itemRegister = DeferredRegister.create(MOD_ID ,Registry.ITEM_REGISTRY);
    public static void init() {
//        RegItem.init(itemRegister);
        Arrays.stream(RegItem.values()).forEach(regItem -> {
            final RegistrySupplier<ElementItem> register = itemRegister.register(new ResourceLocation(MOD_ID, regItem.name), () -> regItem.item);
        });
        itemRegister.register();
    }
}
