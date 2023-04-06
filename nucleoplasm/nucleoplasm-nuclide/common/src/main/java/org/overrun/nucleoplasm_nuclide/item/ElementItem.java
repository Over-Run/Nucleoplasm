package org.overrun.nucleoplasm_nuclide.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.network.chat.Component.empty;

public class ElementItem extends Item {
    private final int proton;
    public ElementItem(Properties properties) {
        super(properties);
        proton = 0;
    }

    public ElementItem(Properties properties, int proton) {
        super(properties);
        this.proton = proton;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        list.add(
                empty()
                        .append(Component.translatable("nucleoplasm.proton"))
                        .append(Component.nullToEmpty(String.valueOf(": %d".formatted(proton))))
        );
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }
}
