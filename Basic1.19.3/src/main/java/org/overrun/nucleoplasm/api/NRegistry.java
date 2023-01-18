package org.overrun.nucleoplasm.api;

import net.minecraft.world.item.Item;

/**
 * the registry interface
 *
 * @author squid233
 * @since 1.0.0
 */
public interface NRegistry {
    <T extends Item> T registerItem(String name, T item);
}
