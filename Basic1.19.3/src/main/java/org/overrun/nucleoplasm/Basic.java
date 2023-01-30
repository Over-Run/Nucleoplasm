package org.overrun.nucleoplasm;

import net.minecraft.resources.ResourceLocation;
import org.overrun.nucleoplasm.api.jsons.ItemsUtils;
import org.overrun.nucleoplasm.api.jsons.Loader;

public class Basic {
    public static final String MOD_ID = "nucleoplasm";


    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    public static String toTranslationKey(String path) {
        return identifier(path).toLanguageKey();
    }

    public static final Loader loader = new Loader("/jsons/items.json", "/jsons/decay.json");
    public static void init() {
        ItemsUtils.setAllGroup(loader);
    }
}
