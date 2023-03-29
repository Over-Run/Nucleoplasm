package org.overrun.nucleoplasm;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class NucleoplasmApi {
    public static final Map<String, Item> ITEMS = new HashMap<>();
    public static  final Map<String, Block> BLOCKS = new HashMap<>();
    public static final String MOD_ID = "nucleoplasm_api";

    public static void init() {
        RegisterAll.registerItem(MOD_ID, ITEMS);
    }

}