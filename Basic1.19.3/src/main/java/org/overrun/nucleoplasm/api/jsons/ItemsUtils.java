package org.overrun.nucleoplasm.api.jsons;

import com.google.gson.internal.LinkedTreeMap;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.overrun.nucleoplasm.item.RegItem;

import java.util.ArrayList;
import java.util.List;

public class ItemsUtils {
    public static LinkedTreeMap<?,?> get(Object o) {
        if (o instanceof LinkedTreeMap<?,?> treeMap) {
            return treeMap;
        }
        return new LinkedTreeMap<>();
    }

    public static ItemStack getItemStack(RegItem item,String abbreviation, String translate, String halfLife,
                                         int proton, int neutron) {
        ItemStack stack = new ItemStack(item.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putString("abbreviation", abbreviation);
        tag.putString("translate", translate);
        tag.putInt("proton", proton);
        tag.putInt("neutron", neutron);
        tag.putInt("relative_atomic_mass", proton + neutron);
        if (halfLife != null) {
            tag.putBoolean("decay", true);
            tag.putString("half_life", halfLife);
            tag.putDouble("mc_half_life", convertMcHalfLife(halfLife));
        } else {
            tag.putBoolean("decay", false);
        }

        stack.setTag(tag);
        return stack;
    }

    public static double convertMcHalfLife(String halfLife) {
        if (halfLife != null) {
            String[] es = halfLife.split("E");
            double v = Double.parseDouble(es[0].trim());
            int i = Integer.parseInt(es[1].trim());
            if (i < 0) {
                return (v + 23 + i) * 10;
            } else if (i > 0) {
                return (800+100*i + v)*10;
            } else {
                return v * 500;
            }
        }
        return -1;
    }

    public static NonNullList<ItemStack> getAll(Loader loader) {
        NonNullList<ItemStack> itemStacks = NonNullList.create();
        for (final var entry : get(get(loader.get(1)).get("items")).entrySet()) {
            String abbreviation = (String) entry.getKey();
            final var map = get(entry.getValue());
            int proton = (int) map.get("proton");
            String translate = (String) map.get("translate");
            for (int neutron = (int) map.get("minNeutron"); neutron <= (int) map.get("maxNeutron"); neutron++) {
                Object decayNeutronSettings = getDecayNeutronSettings(loader.get(1), abbreviation, neutron);
                String halfLife = decayNeutronSettings != null ? (String) get(decayNeutronSettings).get("half_life") : null;
                ItemStack itemStack = getItemStack(RegItem.elementera,abbreviation, translate, halfLife, proton, neutron);
                itemStacks.add(itemStack);
            }
        }
        return itemStacks;
    }

    public static Object getDecayNeutron(Object o, String abbreviation) {
        LinkedTreeMap<?, ?> map = get(o);
        if (map.containsKey(abbreviation)) {
            return map.get(abbreviation);
        }
        return null;
    }

    public static String of(Object o) {
        return String.valueOf(o);
    }

    public static Object getDecaySettings(Object o, int neutron) {
        LinkedTreeMap<?, ?> map = get(o);
        if (map.containsKey(of(neutron))) {
            return map.get(of(neutron));
        }
        return null;
    }
    public static Object getDecayNeutronSettings(Object o, String abbreviation, int neutron) {
        return getDecaySettings(getDecayNeutron(o, abbreviation), neutron);
    }

    public static void setAllGroup(Loader loader) {
        for (final var entry : get(get(loader.get(1)).get("items")).entrySet()) {
            String abbreviation = (String) entry.getKey();
            final var map = get(entry.getValue());
            int proton = Integer.parseInt((String) map.get("proton"));
            String translate = (String) map.get("translate");
            for (int neutron = (int) map.get("minNeutron"); neutron <= (int) map.get("maxNeutron"); neutron++) {
                Object decayNeutronSettings = getDecayNeutronSettings(loader.get(1), abbreviation, neutron);
                String halfLife = decayNeutronSettings != null ? (String) get(decayNeutronSettings).get("half_life") : null;
                ItemStack itemStack = getItemStack(RegItem.elementera,abbreviation, translate, halfLife, proton, neutron);
                setGroupSwitch(itemStack, proton);
            }
        }
    }

    public static final List<ItemStack> gas = new ArrayList<>();
    public static final List<ItemStack> liquid = new ArrayList<>();
    public static final List<ItemStack> solid = new ArrayList<>();
    public static final List<ItemStack> element = new ArrayList<>();
    public static final List<ItemStack> alkali_metal = new ArrayList<>();
    public static final List<ItemStack> alkali_earth_metal = new ArrayList<>();
    public static final List<ItemStack> transition_metal = new ArrayList<>();
    public static final List<ItemStack> other_metal = new ArrayList<>();
    public static final List<ItemStack> metalloid = new ArrayList<>();
    public static final List<ItemStack> halogen = new ArrayList<>();
    public static final List<ItemStack> noble_gas = new ArrayList<>();
    public static final List<ItemStack> lanthanide_series = new ArrayList<>();
    public static final List<ItemStack> actinide_series = new ArrayList<>();
    public static final List<ItemStack> other_non_metal = new ArrayList<>();

    public static void setGroupSwitch(ItemStack stack, int proton) {
        switch (proton) {
            case 3, 11, 19, 37, 55, 87 -> alkali_metal.add(stack);
            case 4, 12, 20, 38, 56, 88 -> alkali_earth_metal.add(stack);
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
                72, 73, 74, 75, 76, 77, 78, 79, 80,
                104, 105, 106, 107, 108, 109, 110, 111, 112 ->
                transition_metal.add(stack);
            case 13, 31, 49, 50, 81, 82, 83, 113, 114, 115, 116 ->
                other_metal.add(stack);
            case 5, 14, 32, 33, 51, 52, 84 -> metalloid.add(stack);
            case 6, 7, 8, 15, 16, 34 -> other_non_metal.add(stack);
            case 9, 17, 35, 53, 85, 117 -> halogen.add(stack);
            case 2, 10, 18, 36, 54, 86, 118 -> noble_gas.add(stack);
            case 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71 ->
                lanthanide_series.add(stack);
            case 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103 ->
                actinide_series.add(stack);
        }
    }

    public static void main(String[] args) {

    }
}
