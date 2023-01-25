package org.overrun.nucleoplasm.item;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Decay {
    private static final Yaml yaml = new Yaml();
    protected final LinkedHashMap<String, LinkedHashMap<Integer, LinkedHashMap<String, Object>>> allItems;

    public Decay(String pathName) {
        InputStream resourceAsStream = GroupDecaySettings.class.getResourceAsStream(pathName);
        this.allItems = yaml.load(resourceAsStream);
    }

    public LinkedHashMap<String, Object> getItemString(String abbreviation, int neutron) {
        return this.allItems.get(abbreviation).get(neutron);
    }
    public String getHalfLife(String abbreviation, int neutron) {
        return (String) getItemString(abbreviation, neutron).get("half_life");
    }

    @SuppressWarnings("unchecked")
    public LinkedHashMap<Integer, LinkedHashMap<Double, LinkedHashMap<Integer, LinkedHashMap<String, Object>>>> getRandom(String abbreviation, int neutron) {
        return (LinkedHashMap<Integer, LinkedHashMap<Double, LinkedHashMap<Integer, LinkedHashMap<String, Object>>>>)
            getItemString(abbreviation, neutron).get("random");
    }

    @SuppressWarnings("DuplicatedCode")
    public double convertMcHalfLife(String halfLife) {
        if (halfLife != null) {
            String[] es = halfLife.split("E");
            double v = Double.parseDouble(es[0].trim());
            int i = Integer.parseInt(es[1].trim());
            if (i < 0) {
                return (v + 23 + i) * 10;
            } else if (i > 0) {
                return (800+100*i + v)*10;
            } else {
                return v * 500;
            }
        }
        return -1;
    }

    public double convertMcHalfLife(String abbreviation, int neutron) {
        String halfLife = getHalfLife(abbreviation, neutron);
        if (halfLife != null) {
            String[] es = halfLife.split("E");
            double v = Double.parseDouble(es[0].trim());
            int i = Integer.parseInt(es[1].trim());
            if (i < 0) {
                return (v + 23 + i) * 10;
            } else if (i > 0) {
                return (800+100*i + v)*10;
            } else {
                return v * 500;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
