package org.overrun.nucleoplasm.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

//核素 元素
public class ElementItem extends Item {
    public ElementItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
    }
    //模仿fabric的常用格式
    public static class Settings extends Properties {

    }
}
