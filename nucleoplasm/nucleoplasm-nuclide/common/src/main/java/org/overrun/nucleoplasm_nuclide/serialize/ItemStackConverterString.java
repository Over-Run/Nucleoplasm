package org.overrun.nucleoplasm_nuclide.serialize;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.Set;

public class ItemStackConverterString {
    public static String stackToString(ItemStack stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(BuiltInRegistries.ITEM.getKey(stack.getItem()));
        CompoundTag tag = stack.getTag();
        if (tag != null) {
            sb.append("{");
            Set<String> allKeys = tag.getAllKeys();
            for (String key : allKeys) {
                sb.append(key).append(": ").append(tag.get(key));
            }
            sb.append("}");
        }
        return sb.toString();
    }

}
