package org.overrun.nucleoplasm.api.group;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.overrun.nucleoplasm.item.RegItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum RegElementStackGroup {
    H_0("hydrogen", 1, false, null),
    H_1("hydrogen", 1, false, null),
    He_1("helium", 2, false, null),
    He_2("helium", 2, false, null),
    Li_3("lithium", 3, false, null),
    Li_4("lithium", 3, false, null),
    Be_5("beryllium", 4, false, null),
    B_5("boron", 5, false, null),
    B_6("boron", 5, false, null),
    C_6("carbon", 6, false, null),
    C_7("carbon", 6, false, null),
    Li_2("lithium", 3, true, "3.790925E-22",
        new RandomSettings(He_2, 1)
    ),
    Be_2("beryllium", 4, true, "5E-21",
        new RandomSettings(He_2, 1)
    ),
    Be_3("beryllium", 4, true, "4.598208E6",
        new RandomSettings(Li_4, 1)
    ),
    Be_4("beryllium", 4, true, "8.2E-17",
        new RandomSettings(He_2, 1)
    ),
    Be_6("beryllium", 4, true, "4.765067136E13",
        new RandomSettings(B_5, 1)
    ),
    B_4("boron", 5, true, "8E-19",
        new RandomSettings(Be_4, 1)
    ),
    C_2("carbon", 6, true, "3.5E-21",
        new RandomSettings(Be_6, 1)
    ),
    C_8("carbon", 6, true, "1.798733952E11",
        new RandomSettings(N_7, 1)
    ),
    C_9("carbon", 6, true, "2.499E0",
        new RandomSettings(N_8, 1)
    ),
    C_10("carbon", 6, true, "7.47E-1",
        //100000
        new RandomSettings(97900, N_8, 1),
        new RandomSettings(2100,N_9, 1)
    ),
    C_11("carbon", 6, true, "1.936E-1",
        new RandomSettings(71590, N_10, 1),
        new RandomSettings(28410, N_9, 1)
    ),
    C_12("carbon", 6, true, "9.2E-2",
        new RandomSettings(68500, N_11, 1),
        new RandomSettings(31500, N_10, 1)
    ),
    C_13("carbon", 6, true, "4.63E-2",
        new RandomSettings(47000, N_11, 1),
        new RandomSettings(46000, N_12, 1),
        new RandomSettings(7000, N_10, 1)
    ),
    C_14("carbon", 6, true, "1.63E-2",
        new RandomSettings(72000, N_12, 1),
        new RandomSettings(28000, N_13, 1)
    ),
    C_15("carbon", 6, true, "3E-8",
        new RandomSettings(C_14, 1)
    ),
    C_16("carbon", 6, true, "6.1E-3",
        new RandomSettings(N_15, 1)
    ),
    B_10("boron", 5, true, "9.93E-3",
        new RandomSettings(93600, C_8, 1),
        new RandomSettings(6000, C_9, 1),
        new RandomSettings(400, C_7, 1)
    ),
    B_9("boron", 5, true, "1.25E-2",
        new RandomSettings(93960, C_8, 1),
        new RandomSettings(6040, C_7, 1)
    ),
    Be_8("beryllium", 4, true, "2.146E-2",
        new RandomSettings(99480, B_6, 1),
        new RandomSettings(520, B_5, 1)
    ),
    Be_9("beryllium", 4, true, "2.7E-21",
        new RandomSettings(Be_8, 1)
    ),
    Li_5("lithium", 3, true, "8.399E2",
        new RandomSettings(Be_4, 1)
    ),
    C_3("carbon", 6, true, "1.265E-1",
        new RandomSettings(60000, B_4, 1),

        new RandomSettings(231000, Be_4, 1),
        new RandomSettings(17000, Li_2, 1)
    ),
    C_4("carbon", 6, true, "1.929E1",
        //100000
        new RandomSettings(B_5, 1)
    ),
    C_5("carbon", 6, true, "1.2218E3",
        new RandomSettings(99790, B_6, 1)
    ),
    B_2("boron", 5, true, "5.7E-22",
        new RandomSettings(Be_2, 1)
    ),
    B_3("boron", 5, true, "7.7E-1",
        new RandomSettings(He_2, 2)
    ),

    B_7("boron", 5, true, "2.02E-2",
        new RandomSettings(98400, C_6, 1),
        new RandomSettings(1600, Be_4, 1)
    ),
    B_8("boron", 5, true, "1.733E-2",
        new RandomSettings(99720, C_7, 1),
        new RandomSettings(280, C_6, 1)
    ),

    B_11("boron", 5, true, "4.56237715071385E-21",
        new RandomSettings(B_10, 1)
    ),
    B_12("boron", 5, true, "5.08E-3",
        new RandomSettings(63000, C_10, 1),
        new RandomSettings(22100, C_11, 1),
        new RandomSettings(11000, C_9, 1),
        new RandomSettings(3500, C_8, 1),
        new RandomSettings(400, C_7, 1)
    ),
    B_13("boron", 5, true, "2.6E-8",
        new RandomSettings(B_12, 1)
    ),
    B_14("boron", 5, true, "2.92E-3",
        new RandomSettings(C_13, 1)
    ),
    Be_7("beryllium", 4, true, "1.376E1",
        new RandomSettings(97100, B_6, 1),
        new RandomSettings(2900, Li_4, 1)
    ),
    Be_10("beryllium", 4, true, "4.35E-3",
        new RandomSettings(81000, B_8, 1),
        new RandomSettings(14000, B_9, 1),
        new RandomSettings(5000, B_7, 1)
    ),
    Be_11("beryllium", 4, true, "8E-22",
        new RandomSettings(Be_10, 1)
    ),
    Be_12("beryllium", 4, true, "5.7E-22",
        new RandomSettings(Be_10, 1)
    ),
    Li_1("lithium", 3, true, "9.1E-23",
        new RandomSettings(He_1, 1)
    ),
    H_2("hydrogen", 1, true, "3.887789875E8",
        new RandomSettings(He_1, 1)
    ),
    He_3("helium", 2, true, "7.04070547949669E-22",
        new RandomSettings(He_2, 1)
    ),
    He_4("helium", 2, true, "8.067E-1",
        new RandomSettings(99720, Li_3/*为Li_3*/, 1),
        new RandomSettings(280, new StackSettings(He_3, 1), new StackSettings(H_1, 1))
    ),
    He_5("helium", 2, true, "3E-21",
        new RandomSettings(He_4, 1)
    ),
    Li_6("lithium", 3, false, "1.783E2",
        new RandomSettings(50800, Be_4, 1),
        new RandomSettings(49200, Be_5, 1)
    ),
    Li_7("lithium", 3, false, "2E-21",
        new RandomSettings(Li_6, 1)
    ),
    Li_8("lithium", 3, false, "8.75E-3",
        new RandomSettings(84900, Be_6, 1),
        new RandomSettings(8070, Be_7, 1),
        new RandomSettings(4100, Be_5, 1),
        new RandomSettings(1900, Be_4, 1),
        new RandomSettings(1000, new StackSettings(He_5, 1), new StackSettings(He_2, 1)),
        new RandomSettings(14, new StackSettings(Li_5,1), new StackSettings(H_2, 1)),
        new RandomSettings(13, new StackSettings(Li_6, 1), new StackSettings(H_1, 1))
    ),
    Li_9("lithium", 3, false, "1E-8",
        new RandomSettings(Li_8, 1)
    ),
    He_6("helium", 2, true, "1.191E2",
        new RandomSettings(83100, Li_5, 1),
        new RandomSettings(16000, Li_4, 1),
        new RandomSettings(900, new StackSettings(He_3, 1), new StackSettings(H_2, 1))
    ),
    He_7("helium", 2, true, "7E-21",
        new RandomSettings(He_6, 1)
    ),
    He_8("helium", 2, true, "1.5E-21",
        new RandomSettings(He_6, 1)
    ),
    H_3("hydrogen", 1, true, "1.39E-22",
        new RandomSettings(H_2, 1)
    ),
    H_4("hydrogen", 1, true, "8.6E-23",
        new RandomSettings(H_2, 1)
    ),
    H_5("hydrogen", 1, true, "2.9E-22",
        new RandomSettings(50000, H_2, 1),
        new RandomSettings(50000, H_1, 1)
    ),
    H_6("hydrogen", 1, true, "1E-20",
        new RandomSettings(H_2, 1)
    ),
    ;

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
    private final ItemStack stack;
    public final String abbreviation;
    public final int neutron;
    public final RandomSettings[] randomSettings;

    RegElementStackGroup(String translate, int proton, boolean decay, String half_life, RandomSettings... randomSettings) {
        abbreviation = name().split("_")[0];
        neutron = Integer.parseInt(name().split("_")[1]);
        int relative_atomic_mass = proton + neutron;

        stack = new ItemStack(RegItem.elementera.getItem().get());
        CompoundTag tag = new CompoundTag();
        tag.putString("abbreviation", abbreviation);
        tag.putString("translate", translate);
        tag.putInt("proton", proton);
        tag.putInt("neutron", neutron);
        tag.putInt("relative_atomic_mass", relative_atomic_mass);
        tag.putBoolean("decay", decay);
       if (decay) {
           tag.putString("half_life", half_life);
           tag.putDouble("mc_half_life", get(half_life));
       }
        stack.setTag(tag);
       this.randomSettings = randomSettings;
    }

    public ItemStack getStack() {
        return stack;
    }

    public double get(String half_life) {
        String[] es = half_life.split("E");
        double v = Double.parseDouble(es[0].trim());
        int i = Integer.parseInt(es[1].trim());
        if (i < 0) {
            return  (v + 23 + i) * 10;
        } else if (i > 0) {
            return (800+100*i + v)*10;
        } else {
            return v * 500;
        }
    }

    public static void init() {
        for (RegElementStackGroup value : RegElementStackGroup.values()) {
            setGroupSwitch(value.stack);
        }
    }

    public static void setGroupSwitch(ItemStack stack) {
        assert stack.getTag() != null;
        int proton = stack.getTag().getInt("proton");
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

    /**
     * 记录触发概率和列表
     */
    public static final class RandomSettings {
        private final int random;
        private final ListSettings record1;

        /**
         * @param random  随机数
         * @param record1
         */
        public RandomSettings(int random, ListSettings record1) {
            this.random = random;
            this.record1 = record1;
        }

        public RandomSettings(int random, StackSettings... stackSettings) {
            this.random = random;
            this.record1 = new ListSettings(stackSettings);
        }
        public RandomSettings(StackSettings... stackSettings) {
            this.random = 100000;
            this.record1 = new ListSettings(stackSettings);
        }

        /**
         * 变量只有一种情况的时候
         * @param record1
         */
        public RandomSettings(ListSettings record1) {
            this.random = 100000;
            this.record1 = record1;
        }

        public RandomSettings(RegElementStackGroup group, int count) {
            this.random = 100000;
            this.record1 = new ListSettings(group, count);
        }
        public RandomSettings(int random,RegElementStackGroup group, int count) {
            this.random = random;
            this.record1 = new ListSettings(group, count);
        }

        public int random() {
            return random;
        }
        public ListSettings record1() {
            return record1;
        }
    }

    public static final class ListSettings {
        private final StackSettings[] record2s;

        public ListSettings(StackSettings... record2s) {
            this.record2s = record2s;
        }

        /**
         * 只有一个产物的时候
         * @param group items
         * @param count count
         */
        public ListSettings(RegElementStackGroup group, int count) {
            this.record2s = new StackSettings[] {
                new StackSettings(group, count)
            };
        }

        public NonNullList<ItemStack> getItemStacks() {
            NonNullList<ItemStack> stacks = NonNullList.create();
            for (StackSettings record2 : record2s) {
                stacks.add(record2.getItemStack());
            }
            return stacks;
        }
    }

    public static final class StackSettings {
        private final RegElementStackGroup group;
        private final int count;

        public StackSettings(RegElementStackGroup group, int count) {
            this.group = group;
            this.count = count;
        }

        public ItemStack getItemStack() {
            final ItemStack copy = group.stack.copy();
            copy.setCount(count);
            return copy;
        }

    }
}
