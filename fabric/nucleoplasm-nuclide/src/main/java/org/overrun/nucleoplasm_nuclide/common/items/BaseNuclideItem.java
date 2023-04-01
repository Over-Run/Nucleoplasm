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
            case "hydrogen"     -> 1;
            case "helium"       -> 2;
            case "lithium"      -> 3;
            case "beryllium"    -> 4;
            case "boron"        -> 5;
            case "carbon"       -> 6;
            case  "nitrogen"    -> 7;
            case "oxygen"       -> 8;
            case "fluorine"     -> 9;
            case "neon"         -> 10;
            case "sodium"       -> 11;
            case "magnesium"    -> 12;
            case "aluminium"    -> 13;
            case "silicon"      -> 14;
            case "phosphorus"   -> 15;
            case "sulfur"       -> 16;
            case "chlorine"     -> 17;
            case "argon"        -> 18;
            case "potassium"    -> 19;
            case "calcium"      -> 20;
            case "scandium"     -> 21;
            case "titanium"     -> 22;
            case "vanadium"     -> 23;
            case "chromium"     -> 24;
            case "manganese"    -> 25;
            default -> 0;
        };
    }
}
