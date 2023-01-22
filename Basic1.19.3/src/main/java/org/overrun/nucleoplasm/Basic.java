package org.overrun.nucleoplasm;

import net.minecraft.resources.ResourceLocation;

public class Basic {
    public static final String MOD_ID = "nucleoplasm";

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static String toTranslationKey(String path) {
        return identifier(path).toLanguageKey();
    }
}
