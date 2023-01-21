package org.overrun.nucleoplasm;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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
    public <T extends Item> void registerItem(String name, T item) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation("nucleoplasm", name), item);
    }
}
