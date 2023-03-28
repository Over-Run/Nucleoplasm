package org.overrun.nucleoplasm.api.elements;

import org.overrun.nucleoplasm.Basic;
import org.overrun.nucleoplasm.api.elements.all.AllJson;
import org.overrun.nucleoplasm.api.elements.all.Name;
import org.overrun.nucleoplasm.api.elements.elements.ElementJson;
import org.overrun.nucleoplasm.api.resources.Build;

import java.io.InputStreamReader;
import java.util.Map;

import static org.overrun.nucleoplasm.Basic.loadJson;
import static org.overrun.nucleoplasm.api.resources.Build.items;

public class AllSelect {
    @Deprecated(since = "All_Json_Test")
    public static void main(String[] args) {

        AllJson allJson = loadJson(items.copyFindName("all"), "json", AllJson.class);
        if (allJson != null) {
            for (Name name : allJson.elements()) {
                ElementJson json = loadJson(items.copyFindName(name.name()), "json", ElementJson.class);

                System.out.println(json);
            }
        }

    }
}
