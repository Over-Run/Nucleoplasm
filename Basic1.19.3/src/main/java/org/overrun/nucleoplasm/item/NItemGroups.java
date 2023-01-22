package org.overrun.nucleoplasm.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.overrun.nucleoplasm.Basic;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public enum NItemGroups {
    gas(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 1);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.gas/*后面再填充*/),
    liquid(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 35);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.liquid),
    solid(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 3);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.solid),
    element(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 1);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.element),
    alkali_metal(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 3);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.alkali_metal),
    alkali_earth_metal(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 4);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.alkali_earth_metal),
    transition_metal(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 21);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.transition_metal),
    other_metal(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 13);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.other_metal),
    metalloid(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 5);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.metalloid),
    other_non_metallic(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 6);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.other_non_metallic),
    halogen(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 9);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.halogen),
    noble_gas(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 2);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.noble_gas),
    lanthanide_series(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 57);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.lanthanide_series),
    actinide_series(() -> {
        ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putInt("proton", 89);
        itemStack.setTag(tag);
        return itemStack;
    }, NbtAndGroupSettings.actinide_series),
    ;

    private final Component title;
    private final Supplier<ItemStack> icon;
    private final List<ItemStack> stacks;
    public CreativeModeTab itemGroup;

    NItemGroups(Supplier<ItemStack> icon, List<ItemStack> stacks) {
        this.title = Component.translatable("itemGroup." + Basic.MOD_ID + "." + name().toLowerCase(Locale.ROOT));
        this.icon = icon;
        this.stacks = stacks;
    }

    public CreativeModeTab.Builder register(CreativeModeTab.Builder builder) {
        return builder.title(getTitle())
            .icon(getIcon());
    }

    public Component getTitle() {
        return title;
    }

    public Supplier<ItemStack> getIcon() {
        return icon;
    }

    public List<ItemStack> getStacks() {
        return stacks;
    }
}
