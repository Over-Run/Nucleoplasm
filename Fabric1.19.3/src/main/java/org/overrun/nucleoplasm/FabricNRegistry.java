package org.overrun.nucleoplasm;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm.api.NRegistry;

/**
 * fabric NRegistry
 *
 * @author squid233
 * @since 1.0.0
 */
public final class FabricNRegistry implements NRegistry {
    @Override
    public <T extends Item> T registerItem(String name, T item) {
        return Registry.register(BuiltInRegistries.ITEM, name, item);
    }
}
