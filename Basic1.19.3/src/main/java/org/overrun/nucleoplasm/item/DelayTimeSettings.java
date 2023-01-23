package org.overrun.nucleoplasm.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public enum DelayTimeSettings {
    H0(false, 1.00782503223, null),
    H1(false, 2.01410177812, null),
    H2(true, 3.01604927791, "3.887789875E8", "He1_1,1"),
    H3(true, 4.026431864, "1.39E-22", "H2_1,1"),
    H4(true, 5.035311489, "8.6E-23", "H2_1,1"),
    H5(true, 6.044955433, "2.9E-22", "H2_1,0.5", "H1_1,0.5"),
    H6(true, 7.052749, "1E-20", "H2_1,1"),
    He1(false, 3.0160293191, null),
    He2(false, 4.00260325415, null),
    He3(true, 5.01222, "7.04070547949669E-22", "He2_1,1"),
    He4(true, 6.0188891, "8.067E-1", "Li3_1,0.99", "He2_1:H1_1,0.01"),
    He5(true, 7.028021, "3E-21", "Li3_1,1"),
    He6(true, 8.033922, "1.191E2", "Li5_1,0.831", "Li4_1,0.16", "He3_1:H2_1,0.009"),
    He7(true, 9.04395, "7E-21", "He6_1,1"),
    He8(true, 10.0524, "1.5E-21", "He6_1,1"),
    Li1(true, 4.02719, "9.1E-23", "He1_1,1"),
    Li2(true, 5.01254, "3.790925E-22", "He2_1,1"),
    Li3(false, 6.015122795, null),
    Li4(false, 7.01600455, null),
    Li5(true, 8.02248736, "8.399E2", "Be4_1,1"),
    Li6(true, 9.0267895, "1.783E2", "Be4_1,0.508", "Be5_1,0.492"),
    Li7(true, 10.035481, "2E-21", "Li6_1,1"),
    Li8(true, 11.043798, "8.75E-3", "Be6_1,0.849", "Be7_1,0.0807", "Be5_1,0.041", "Be4_1,0.019", "He5_1:He2_1,0.01", "Li5_1:H2_1,0.00014", "Li6_1:H1_1,0.00013"),
    Li9(true, 12.05378, "1E-8", "Li8_1,1"),
    ;
    private final boolean delay;
    private final double relative_atomic_mass;
    private final String half_life;
    private final double mc_half_life;
    private final String[] delay_out;

    public static final Map<String, Map<String, NonNullList<ItemStack>>> map = new HashMap<>();

    public static void init() {
        for (DelayTimeSettings value : values()) {
            Map<String, NonNullList<ItemStack>> listMap = map.containsKey(value.name()) ? map.get(value.name()) : new HashMap<>();
            for (String s : value.delay_out) {
                String[] split = s.split(",");
                String ran = split[1];
                String s1 = split[0];
                String[] split1;
                if (s1.contains(":")) {
                    split1 = s1.split(":");
                } else {
                    split1 = new String[] {s1};
                }
                NonNullList<ItemStack> stacks = NonNullList.create();
                for (String s2 : split1) {
                    String[] s3 = s2.split("_");
                    int count = Integer.parseInt(s3[1].trim());
                    ItemStack stack = NbtAndGroupSettings.get(s3[0].trim());
                    if (!stack.equals(ItemStack.EMPTY)) {
                        stack.setCount(count);
                    }
                    stacks.add(stack);
                }
                listMap.put(ran, stacks);
                map.put(value.name(), listMap);
            }
        }
    }
    DelayTimeSettings(boolean delay, double relative_atomic_mass,
                      String eNumber/*E的计数法*/, String... delay_out) {
        this.delay = delay;
        this.relative_atomic_mass = relative_atomic_mass;
        this.half_life = eNumber;
        if (delay) {
            String[] es = eNumber.split("E", 2);
            int replace = Integer.parseInt(es[1]);
            if (replace < 0) {
                mc_half_life = Double.parseDouble(es[0])*10+(23 + replace)*10;
            } else if (replace == 0) {
                mc_half_life = Double.parseDouble(es[0]) * 500;
            } else {
                mc_half_life = Double.parseDouble(es[0])*10+(8 + replace)*1000;
            }
        } else {
            mc_half_life = -1;
        }
        this.delay_out = delay_out;
    }

    public boolean isDelay() {
        return delay;
    }

    public double getRelative_atomic_mass() {
        return relative_atomic_mass;
    }

    public double getMc_half_life() {
        return mc_half_life;
    }

    public String[] getDelay_out() {
        return delay_out;
    }

    public String getHalf_life() {
        return half_life;
    }

}
