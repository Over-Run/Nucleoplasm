package org.overrun.nucleoplasm.api.jsons;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Basic json element map loader
 * @author baka4n
 */
public class GsonLoader {
    public Object o, back_json;
    private final Object original_json;
    /**
     * default load json on resources
     * @param resourceFileName resource
     */
    public GsonLoader(String resourceFileName){
        original_json = new Gson()
            .fromJson(
                new InputStreamReader(
                    Objects
                        .requireNonNull(
                            GsonLoader.class
                                .getResourceAsStream(resourceFileName)
                        )
                ), Object.class
            );
        o = original_json;
    }


    public GsonLoader toOriginal() {
        back_json = o;
        o = original_json;
        return this;
    }
    public GsonLoader toBack() {
        Object t = o;
        o = back_json;
        back_json = t;
        return this;
    }

    public String[] getKeys() {
        List<String> list = new ArrayList<>();
        if (o instanceof LinkedTreeMap<?,?> map) {
            map.forEach((o1, o2) -> {
                if (o1 instanceof String s) {
                    list.add(s);
                }
            });
        }
        return list.toArray(new String[0]);
    }

    /**
     *  get value if they is {@link LinkedTreeMap}
     * @param key String
     * @return value
     */
    public GsonLoader get(String key) {
        if (o instanceof LinkedTreeMap<?,?> map) {
            back_json = o;
            o = map.get(key);
        }
        return this;
    }
}
