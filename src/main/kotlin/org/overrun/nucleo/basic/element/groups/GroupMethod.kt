package org.overrun.nucleo.basic.element.groups

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

/**
 * Gets an item stack, with proton, neutron, decay and decay level put in nbt.
 */
fun addGroup(group: ItemGroup, stack: ItemStack?) {
    ItemGroupEvents.modifyEntriesEvent(group)
        .register(ModifyEntries { content ->
            content.add(stack)
        })
}
