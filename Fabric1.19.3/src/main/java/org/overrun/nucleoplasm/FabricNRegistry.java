package org.overrun.nucleoplasm;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.api.NRegistry;
import org.overrun.nucleoplasm.api.NRegistryObject;

import java.util.function.Supplier;

/**
 * fabric NRegistry
 *
 * @author squid233
 * @since 1.0.0
 */
public final class FabricNRegistry implements NRegistry {
    @Override
    public <T extends Item> NRegistryObject<T> registerItem(String name, Supplier<T> item) {
        return new FabricNRegistryObject<>(name, Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Basic.MOD_ID, name), item.get()));
    }
}
