package org.overrun.nucleoplasm.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public enum DecayTimeSettings {
    H0(false, 1.00782503223, null),
    H1(false, 2.01410177812, null),
    H2(true, 3.01604927791, "3.887789875E8",
        1.0, new IIRecord( "He",1,1)),//"He", 1, 1, 1
    H3(true, 4.026431864, "1.39E-22",
        1.0, new IIRecord("H",2, 1)),
    H4(true, 5.035311489, "8.6E-23",
        1.0, new IIRecord("H", 2, 1)),
    H5(true, 6.044955433, "2.9E-22",
        0.51,
        new IIRecord("H", 2, 1),
        0.49,
        new IIRecord("H", 1,1)),
    H6(true, 7.052749, "1E-20",
        1.0, new IIRecord("H", 2, 2)),
    He1(false, 3.0160293191, null),
    He2(false, 4.00260325415, null),
    He3(true, 5.01222, "7.04070547949669E-22",
        1.0, new IIRecord("He", 2, 1)),//"He2_1,1"
    He4(true, 6.0188891, "8.067E-1",
        0.99, new IIRecord("Li", 3,1),
        0.01,
        new IIRecord("He", 2, 1),
        new IIRecord("H", 1, 1)),//, "Li3_1,0.99", "He2_1:H1_1,0.01"
    He5(true, 7.028021, "3E-21",
        1.0, new IIRecord("Li", 3, 1) ),//"Li3_1,1"
    He6(true, 8.033922, "1.191E2",
        0.831, new IIRecord("Li", 5, 1),
        0.16, new IIRecord("Li", 4, 1),
        0.009,
        new IIRecord("He", 3, 1),
        new IIRecord("H", 2,1)),//"Li5_1,0.831", "Li4_1,0.16", "He3_1:H2_1,0.009"
    He7(true, 9.04395, "7E-21",
        1.0, new IIRecord("He", 6, 1)),//"He6_1,1"
    He8(true, 10.0524, "1.5E-21",
        1.0,new IIRecord("He", 6, 1)),
    Li1(true, 4.02719, "9.1E-23",
        1.0, new IIRecord("He", 1, 1)),//"He1_1,1"
    Li2(true, 5.01254, "3.790925E-22",
        1.0,new IIRecord("He", 2, 1)),//"He2_1,1"
    Li3(false, 6.015122795, null),
    Li4(false, 7.01600455, null),
    Li5(true, 8.02248736, "8.399E2",
        1.0, new IIRecord("Be", 4, 1)),//"Be4_1,1"
    Li6(true, 9.0267895, "1.783E2",
        0.508, new IIRecord("Be", 4, 1),
        0.492, new IIRecord("Be", 5, 1) /*"Be5_1,0.492"*/),
    Li7(true, 10.035481, "2E-21",
        1.0, new IIRecord("Li", 6, 1)),//"Li6_1,1"
    Li8(true, 11.043798, "8.75E-3",
        0.849, new IIRecord("Be", 6, 1),
        0.807, new IIRecord("Be", 7,1),
        0.041, new IIRecord("Be", 5, 1),
        0.019, new IIRecord("Be", 4, 1) ,
        0.01,
        new IIRecord("He", 5, 1),
        new IIRecord("He", 2, 1),
        0.00014,
        new IIRecord("Li", 5, 1),
        new IIRecord("H", 2, 1),
        0.00013,
        new IIRecord("Li", 6, 1),
        new IIRecord("H", 1, 1)),
    Li9(true, 12.05378, "1E-8",
        1.0, new IIRecord("Li", 8, 1)),
    ;
    private final boolean decay;
    private final double relative_atomic_mass;
    private final String half_life;
    private final double mc_half_life;
    private final Object[] decay_out;

    public static final  Map<String, Map<Double, List<IIRecord>>> abbreviationRanMap = new HashMap<>();
    DecayTimeSettings(boolean decay, double relative_atomic_mass,
                      String eNumber/*E的计数法*/, Object... decay_out) {
        this.decay = decay;
        this.relative_atomic_mass = relative_atomic_mass;
        this.half_life = eNumber;
        if (decay) {
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
        List<Object> list = new ArrayList<>(List.of(decay_out));
        list.add("TheEnd");
        this.decay_out = list.toArray(new Object[0]);
    }

    public static void init() {
        for (DecayTimeSettings value : values()) {
            double key = -1;
            List<IIRecord> records = new ArrayList<>();
            Map<Double, List<IIRecord>> abbreviationListRecordMap = new HashMap<>();
            for (Object o : value.decay_out) {
                if (o instanceof Double ran) {
                    if (key != -1) {
                        abbreviationListRecordMap.put(key, records);
                        records = new ArrayList<>();//新的list
                    }
                    key = ran;
                } else if (o instanceof IIRecord r) {
                    records.add(r);
                }
            }
            abbreviationRanMap.put(value.name(), abbreviationListRecordMap);
        }
    }

    public record IIRecord(String abbreviation,int neutron, int count) { }

    public boolean hasDecay() {
        return decay;
    }

    public double getRelative_atomic_mass() {
        return relative_atomic_mass;
    }

    public double getMc_half_life() {
        return mc_half_life;
    }

    public Object[] getDecay_out() {
        return decay_out;
    }

    public String getHalf_life() {
        return half_life;
    }

}
