package org.overrun.nucleoplasm;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.util.Map;

public class NucleoplasmApi {
    public static final String MOD_ID = "nucleoplasm";

    public static void init() {
        RegisterAll.registerItem(RegisterAll.ITEMS);
    }

}