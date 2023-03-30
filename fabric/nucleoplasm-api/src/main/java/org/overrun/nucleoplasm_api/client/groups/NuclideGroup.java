package org.overrun.nucleoplasm_api.client.groups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideGroup {
    private final ItemGroup item_group;
    public NuclideGroup(String name, Item t) {
        item_group = FabricItemGroup
                .builder(new Identifier(MODID, name))
                .icon(() -> new ItemStack(t))
                .build();
    }
    public void add(@NotNull ItemStack... stacks) {
        ItemGroupEvents.modifyEntriesEvent(item_group).register(content -> {
            content.addAll(List.of(stacks));
        });
    }
    public void add(Item... ts) {
        ItemGroupEvents.modifyEntriesEvent(item_group).register(content -> {
            for (Item t : ts) {
                content.add(new ItemStack(t));
            }
        });
    }
}
