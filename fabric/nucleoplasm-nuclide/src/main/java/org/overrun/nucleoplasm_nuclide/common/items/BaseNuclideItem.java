package org.overrun.nucleoplasm_nuclide.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

/**
 * @since 基本实现注册
 */
public class BaseNuclideItem extends Item {


    public BaseNuclideItem(Settings settings, int max_nuclear_mass_number) {
        super(settings);
    }


    @Override
    public ItemStack getDefaultStack() {
        ItemStack defaultStack = super.getDefaultStack();
        NbtCompound nbt = defaultStack.getNbt() != null ? defaultStack.getNbt() : new NbtCompound();
        String[] split = super.getTranslationKey().split("\\.");
        nbt.putInt("proton", proton(split[split.length - 1]));
        defaultStack.setNbt(nbt);
        return defaultStack;
    }
    public int proton(String name) {
        return switch (name) {
            case "hydrogen" -> 1;
            case "helium" -> 2;
            case "lithium" -> 3;
            default -> 0;
        };
    }
}
