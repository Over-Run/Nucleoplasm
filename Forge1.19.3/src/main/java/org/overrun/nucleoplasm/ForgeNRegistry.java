package org.overrun.nucleoplasm;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import org.overrun.nucleoplasm.api.NRegistry;
import org.overrun.nucleoplasm.api.NRegistryObject;

import java.util.function.Supplier;

/**
 * forge NRegistry
 *
 * @author squid233
 * @since 1.0.0
 */
public final class ForgeNRegistry implements NRegistry {
    private final DeferredRegister<Item> itemRegistry;

    public ForgeNRegistry(DeferredRegister<Item> itemRegistry) {
        this.itemRegistry = itemRegistry;
    }

    @Override
    public <T extends Item> NRegistryObject<T> registerItem(String name, Supplier<T> item) {
        return new ForgeNRegistryObject<>(name, itemRegistry.register(name, item));
    }
}
