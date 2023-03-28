package org.overrun.nucleoplasm.api.jsons;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Loader {

    private static final Gson gson = new Gson();
    private final Map<Integer, Object> jsonMap = new HashMap<>();
    public Loader(String... names) {
        for (var name : names) {
            try(InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(this.getClass().getResourceAsStream(name)), StandardCharsets.UTF_8)) {
                Object o = gson.fromJson(reader, Object.class);
                jsonMap.put(jsonMap.size() + 1, o);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                    ItemsUtils.get(o2).forEach((o1, o21) -> {
                        ItemsUtils.get(o21).forEach((o3, o22) -> {
                            System.out.println(o3);
                            System.out.println(o22);
                        });
                    });
                });
            }

        }
    }


}
