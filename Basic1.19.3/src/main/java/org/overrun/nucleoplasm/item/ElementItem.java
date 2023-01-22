package org.overrun.nucleoplasm.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overrun.nucleoplasm.Basic;

import java.util.List;

import static net.minecraft.network.chat.Component.nullToEmpty;
import static net.minecraft.network.chat.Component.translatable;

//核素 元素

/**
 * @author baka4n
 */
public class ElementItem extends Item {
    public ElementItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    @Override
    @NotNull
    public Component getName(@NotNull ItemStack stack) {
        CompoundTag tag = stack.hasTag() ? stack.getTag() : new CompoundTag();
        assert tag != null;
        stack.setHoverName(
            translatable(
                "item." +
                    Basic.toTranslationKey(tag.getString("translate")) +
                    (tag.getInt("proton") + (tag.getInt("neutron")))
            ).setStyle(Style.EMPTY.withFont(Basic.identifier("uniform")).withColor(0xFFFFFF))
        );
        return super.getName(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        CompoundTag tag = stack.hasTag() ? stack.getTag() : new CompoundTag();
        assert tag != null;
        if (!tag.isEmpty()) {
            list.add(translatable("item.nucleoplasm.cf"));
            list.add(nullToEmpty(String.format("%02d", (tag.getInt("proton") + tag.getInt("neutron")))));
            list.add(nullToEmpty("    %s    ".formatted(tag.getString("abbreviation"))));
            list.add(nullToEmpty(String.format("%02d", tag.getInt("proton"))));
            list.add(nullToEmpty(""));
            list.add(nullToEmpty("decay: " + tag.getBoolean("decay")));
            list.add(translatable("item.nucleoplasm.ram"));//relative_atomic_mass:
            list.add(nullToEmpty(String.valueOf(tag.getDouble("relative_atomic_mass"))));
            list.add(translatable("item.nucleoplasm.mc.half.life")
                .append(nullToEmpty(String
                    .valueOf(tag
                        .getDouble("mc_half_life"))))
            );
        }
        super.appendHoverText(stack, level, list, flag);
    }
}
