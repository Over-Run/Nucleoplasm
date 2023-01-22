package org.overrun.nucleoplasm.api;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

/**
 * the registry interface
 *
 * @author squid233
 * @since 1.0.0
 */
public interface NRegistry {
    <T extends Item> NRegistryObject<T> registerItem(String name, Supplier<T> item);
}
