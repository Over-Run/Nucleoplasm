package org.overrun.nucleoplasm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.overrun.nucleoplasm.api.elements.all.AllJson;
import org.overrun.nucleoplasm.api.elements.all.Name;
import org.overrun.nucleoplasm.api.elements.elements.ElementDecayOutStack;
import org.overrun.nucleoplasm.api.elements.elements.ElementJson;
import org.overrun.nucleoplasm.api.elements.elements.ElementNeutronSetting;
import org.overrun.nucleoplasm.api.elements.elements.ElementRandom;
import org.overrun.nucleoplasm.api.group.RegElementStackGroup;
import org.overrun.nucleoplasm.api.jsons.ItemsUtils;
import org.overrun.nucleoplasm.api.jsons.Loader;
import org.overrun.nucleoplasm.api.resources.Build;
import org.overrun.nucleoplasm.item.RegItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.overrun.nucleoplasm.api.resources.Build.items;

public class Basic {
    public static final String MOD_ID = "nucleoplasm";

    public static final Gson gson = new Gson();

    public static ResourceLocation identifier(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static String toTranslationKey(String path) {
        return identifier(path).toLanguageKey();
    }

    public static final Loader loader = new Loader("/jsons/items.json", "/jsons/decay.json");
    public static final Map<String, ElementJson> itemsMap = new HashMap<>();

    public static ElementJson getItemsMapJson(String name) {
        return itemsMap.get(name);
    }

    public static void init() {
        RegElementStackGroup.init();
//        ItemsUtils.setAllGroup(loader);
//        AllJson allJson = loadJson(items.copyFindName("all"), "json", AllJson.class);
//        for (var name : allJson.elements()) {
//            ElementJson json = loadJson(items.copyFindName(name.name()), "json", ElementJson.class);
//            if (json != null) {
//                itemsMap.put(name.name(), json);
//            }
//        }
//        for (var items : itemsMap.entrySet()) {
//            ElementJson elementJson = items.getValue();
//            setGroup(elementJson, RegItem.elementera.getItem().get());
//        }
//        ItemsUtils.setAllGroup(loader);
    }

    public static void setGroup(@NotNull ElementJson elementJson, Item item) {

        for (ElementNeutronSetting neutronSetting : elementJson.list()) {
            ItemStack stack = new ItemStack(item);
            CompoundTag tag = new CompoundTag();
            tag.putInt("proton", elementJson.proton());
            tag.putString("translate", elementJson.translate());
            tag.putInt("neutron", neutronSetting.neutron());
            tag.putBoolean("decay", neutronSetting.decay());
            if (neutronSetting.decay()) {
                String s = neutronSetting.half_life();
                for (ElementRandom random : neutronSetting.random()) {
                    double ran = random.ran();
                    for (ElementDecayOutStack outStack : random.items()) {
                        String abbreviation = outStack.abbreviation();
                        int neutron1 = outStack.neutron();
                        int count = outStack.count();
                    }
                }
            }
        }
    }

    public static <T> T loadJson(String name, Class<T> t) {
        InputStream resourceAsStream = Basic.class.getResourceAsStream(name);
        if (resourceAsStream != null) {
            try (InputStreamReader reader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8)) {
                return gson.fromJson(reader, t);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T> T loadJson(Build name, String suffix, Class<T> c) {
        return loadJson(name.build(suffix), c);
        /*
        InputStream resourceAsStream = Basic.class.getResourceAsStream(name.build(suffix));
        if (resourceAsStream != null) {
            try (InputStreamReader reader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8)) {
                return gson.fromJson(reader, c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;*/
    }

}
