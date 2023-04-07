package org.overrun.nucleoplasm_nuclide.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overrun.nucleoplasm_nuclide.decay.DecayUtils;

import java.util.List;

import static net.minecraft.network.chat.Component.empty;
import static net.minecraft.network.chat.Component.nullToEmpty;

public class ElementItem extends Item {
    public final int proton;
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
    public @NotNull ItemStack getDefaultInstance() {
        ItemStack defaultInstance = super.getDefaultInstance();
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("neutron", DecayUtils.mass_number.get(proton) - proton);
        nbt.putInt("quantity_electricity", DecayUtils.mass_number.get(proton));//电子量
        defaultInstance.setTag(nbt);
        return defaultInstance;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        CompoundTag tag = itemStack.getTag();
        if (tag != null) {
            list.add(
                    empty()
                            .append(Component.translatable("nucleoplasm.proton"))
                            .append(Component.nullToEmpty(": %d".formatted(proton)))
            );
            list.add(
                    empty()
                            .append(Component.translatable("nucleoplasm.neutron"))
                            .append(Component.nullToEmpty(": %d".formatted(tag.getInt("neutron"))))
            );
            list.add(
                    empty()
                            .append(Component.translatable("nucleoplasm.quantity.electricity"))
                            .append(Component.nullToEmpty(": %d".formatted(tag.getInt("quantity_electricity"))))
            );
        }
        super.appendHoverText(itemStack, level, list, tooltipFlag);
    }
}
