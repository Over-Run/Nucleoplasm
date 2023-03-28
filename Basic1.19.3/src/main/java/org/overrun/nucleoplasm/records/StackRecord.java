package org.overrun.nucleoplasm.records;

import java.util.List;
import java.util.Map;

public record StackRecord(Map<String, List<Record>> records) {
    public record Record(int proton, int neutron,
                         String translate, String abbreviation,
                         boolean decay, double relative_atomic_mass,
                         String half_life, double mc_half_life) {
    }
}//用于记录itemStack

