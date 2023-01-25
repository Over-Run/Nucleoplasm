package org.overrun.nucleoplasm.item;

import com.google.gson.Gson;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.*;

/**
 * @author baka4n
 * @since
 * using item.yml -> abbreviation (proton neutron and translate)
 */
public class GroupDecaySettings {

    private static final  Yaml yaml = new Yaml();
    public static final GroupDecaySettings items = new GroupDecaySettings("/items.yml");
    public static final Decay decay0to20 = new Decay("/0to20decay.yml");
    private final LinkedHashMap<String, LinkedHashMap<String,LinkedHashMap<String, String>>> allItems;

    public GroupDecaySettings(String pathName) {
        InputStream resourceAsStream = GroupDecaySettings.class.getResourceAsStream(pathName);
        this.allItems = yaml.load(resourceAsStream);
    }

    public static final List<ItemStack> gas = new ArrayList<>();
    public static final List<ItemStack> liquid = new ArrayList<>();
    public static final List<ItemStack> solid = new ArrayList<>();
    public static final List<ItemStack> element = new ArrayList<>();
    public static final List<ItemStack> alkali_metal = new ArrayList<>();
    public static final List<ItemStack> alkali_earth_metal = new ArrayList<>();
    public static final List<ItemStack> transition_metal = new ArrayList<>();
    public static final List<ItemStack> other_metal = new ArrayList<>();
    public static final List<ItemStack> metalloid = new ArrayList<>();
    public static final List<ItemStack> halogen = new ArrayList<>();
    public static final List<ItemStack> noble_gas = new ArrayList<>();
    public static final List<ItemStack> lanthanide_series = new ArrayList<>();
    public static final List<ItemStack> actinide_series = new ArrayList<>();
    public static final List<ItemStack> other_non_metal = new ArrayList<>();

    //load init to groups
    @SuppressWarnings("DuplicatedCode")
    public void init() {
        for (Map.Entry<String, LinkedHashMap<String, String>> entry : this.allItems.get("items").entrySet()) {
            String abbreviation = entry.getKey();
            LinkedHashMap<String, String> value = entry.getValue();
            int proton = Integer.parseInt(value.get("proton").trim());
            String translate = value.get("translate").trim();

            for (
                int neutron = Integer.parseInt(value.get("minNeutron").trim());
                neutron <= Integer.parseInt(value.get("maxNeutron").trim());
                neutron++
            ) {
                ItemStack stack = new ItemStack(RegItem.elementera.getItem().get()).copy();
                CompoundTag tag = new CompoundTag();
                tag.putString("abbreviation", abbreviation);
                tag.putInt("proton", proton);
                tag.putInt("neutron", neutron);
                tag.putString("translate", translate);
                tag.putInt("relative_atomic_mass", proton + neutron);
                Decay decaySettings = getDecaySettings(proton);
                if (decaySettings != null) {
                    String halfLife = decaySettings.getHalfLife(abbreviation, neutron);
                    if (halfLife != null) {
                        tag.putBoolean("decay", true);
                        tag.putString("half_life", halfLife);
                        tag.putDouble("mc_half_life", decaySettings.convertMcHalfLife(halfLife));
                    }
                }
                if (tag.contains("decay")) {
                    tag.putBoolean("decay", false);
                }
                stack.setTag(tag);
                switch (proton) {
                    case 3, 11, 19, 37, 55, 87 -> alkali_metal.add(stack);
                    case 4, 12, 20, 38, 56, 88 -> alkali_earth_metal.add(stack);
                    case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                        39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
                        72, 73, 74, 75, 76, 77, 78, 79, 80,
                        104, 105, 106, 107, 108, 109, 110, 111, 112 ->
                        transition_metal.add(stack);
                    case 13, 31, 49, 50, 81, 82, 83, 113, 114, 115, 116 ->
                        other_metal.add(stack);
                    case 5, 14, 32, 33, 51, 52, 84 -> metalloid.add(stack);
                    case 6, 7, 8, 15, 16, 34 -> other_non_metal.add(stack);
                    case 9, 17, 35, 53, 85, 117 -> halogen.add(stack);
                    case 2, 10, 18, 36, 54, 86, 118 -> noble_gas.add(stack);
                    case 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71 ->
                        lanthanide_series.add(stack);
                    case 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103 ->
                        actinide_series.add(stack);
                }
            }
        }
    }

    public ItemStack getItemStack(String abbreviation, int neutron) {
        final var item = getItemString(abbreviation);
        ItemStack stack = new ItemStack(RegItem.elementera.getItem().get()).copy();
        CompoundTag tag = new CompoundTag();
        if (!item.isEmpty()) {
            int proton = Integer.parseInt(item.get("proton").trim());
            tag.putInt("proton", proton);
            tag.putInt("neutron", neutron);
            tag.putString("translate", item.get("translate").trim());
            tag.putInt("relative_atomic_mass", proton + neutron);
            Decay decaySettings = getDecaySettings(proton);
            if (decaySettings != null) {
                String halfLife = decaySettings.getHalfLife(abbreviation, neutron);
                if (halfLife != null) {
                    tag.putBoolean("decay", true);
                    tag.putString("half_life", halfLife);
                    tag.putDouble("mc_half_life", decaySettings.convertMcHalfLife(halfLife));
                }
            }
            if (tag.contains("decay")) {
                tag.putBoolean("decay", false);
            }
        }
        stack.setTag(tag);
        return stack;
    }

    public static Decay getDecaySettings(int proton) {
        if (proton <= 20) {
            return decay0to20;
        }
        return null;
    }

    public LinkedHashMap<String, String> getItemString(String abbreviation) {
        for (Map.Entry<String, LinkedHashMap<String, String>> entry : this.allItems.get("items").entrySet()) {
            String s = entry.getKey();
            if (s.equals(abbreviation)) {
                return entry.getValue();
            }
        }
        return new LinkedHashMap<>();
    }

    /**
     * @param abbreviation such as Fe
     * @param key such as proton neutron translate
     * @return
     * value -> {
     *      such as proton-> 1; you're using to Int
     *      minNeutron -> 0; you're using to Int
     *      maxNeutron -> 6; you're using to Int
     *      translate -> String -> hydrogen;
     * }
     */
    public String getItemStringToValue(String abbreviation, String key) {
        for (var entry : this.allItems.get("items").entrySet()) {
            String s = entry.getKey();
            if (s.equals(abbreviation))
                for (var e : entry.getValue().entrySet())
                    if (e.getKey().equals(key))
                        return e.getValue();
        }
        return "";
    }

    @Deprecated(since = "test", forRemoval = true)
    public static void main(String[] args) {
        System.out.println(items.getItemString("H"));
    }
}
