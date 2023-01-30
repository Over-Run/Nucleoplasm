package org.overrun.nucleoplasm.api.jsons;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.overrun.nucleoplasm.item.RegItem;

import java.io.*;
import java.net.URL;
import java.util.*;

import static org.overrun.nucleoplasm.api.jsons.ItemsUtils.setAllGroup;

public class Loader {

    private static final Gson gson = new Gson();
    private final Map<Integer, Object> jsonMap = new HashMap<>();
    public Loader(String... names) {
        for (var name : names) {
            Object o = gson.fromJson(new InputStreamReader(this.getClass().getResourceAsStream(name)), Object.class);
            jsonMap.put(jsonMap.size() + 1, o);
        }
    }
    public Object get(int i) {
        return jsonMap.get(i);
    }



    @Deprecated(since = "testJsonLoder")
    public static void main(String[] args) {
        Loader loader = new Loader("/jsons/items.json", "/jsons/decay.json");
        for (var entry : ItemsUtils.get(loader.get(2)).entrySet()) {
            String abbreviation = (String) entry.getKey();
            for (var e : ItemsUtils.get(entry.getValue()).entrySet()) {
                int neutron = Integer.parseInt((String) e.getKey());
                LinkedTreeMap<?, ?> map = ItemsUtils.get(e.getValue());
                ItemsUtils.get(map.get("random")).forEach((o, o2) -> {
                    System.out.println(o);
                    System.out.println(o2);
                });
            }

        }
    }


}
