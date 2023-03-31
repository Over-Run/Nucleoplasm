package org.overrun.nucleoplasm_api.utils;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideBase {
    private final String modid;
    public NuclideBase() {
        this.modid = MODID;
    }
    public NuclideBase(String modid) {
        this.modid = modid;
    }

    public String getModid() {
        return modid;
    }
}
