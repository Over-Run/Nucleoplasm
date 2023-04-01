package org.overrun.nucleoplasm_api.common.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ItemInventoryTick {
    Event<ItemInventoryTick> EVENT = EventFactory.createArrayBacked(ItemInventoryTick.class, listeners -> ((stack, world, entity, slot, selected) -> {
        for (ItemInventoryTick tick : listeners) {
            tick.inventoryTick(stack, world, entity, slot, selected);
        }
    }));
    void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected);
}
