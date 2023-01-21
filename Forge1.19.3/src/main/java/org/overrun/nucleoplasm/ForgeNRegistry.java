package org.overrun.nucleoplasm;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.*;
import org.overrun.nucleoplasm.api.NRegistry;

/**
 * forge NRegistry
 *
 * @author squid233
 * @since 1.0.0
 */
public final class ForgeNRegistry implements NRegistry {
    private final RegisterEvent event;

    public ForgeNRegistry(RegisterEvent event) {
        this.event = event;
    }

    @Override
    public <T extends Item> void registerItem(String name, T item) {
//        itemRegistry.register(name, () -> item);
        event.register(ForgeRegistries.Keys.ITEMS, h -> {
            h.register(new ResourceLocation("nucleoplasm", name), item);
        });
    }
}
