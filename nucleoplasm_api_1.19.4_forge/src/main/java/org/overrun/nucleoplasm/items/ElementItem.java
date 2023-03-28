package org.overrun.nucleoplasm.items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ElementItem extends Item {
    private final int proton;
    private final Map<Integer, String> decay;//neutron, and decay using such as 1.0E10
    public ElementItem(Properties properties, int proton, Map<Integer, String> decay) {
        super(properties);
        this.proton = proton;
        this.decay = decay;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        CompoundTag tag = pStack.getTag();
        if (!tag.contains("createTime")) {
            tag.putLong("createTime", pLevel.getGameTime());
            pStack.setTag(tag);
        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
