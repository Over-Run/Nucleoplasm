package org.overrun.nucleo.basic.element.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.overrun.nucleo.Nucleoplasm;
import org.overrun.nucleo.basic.element.remake.RegItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementGroup {
    public static final ItemGroup group = FabricItemGroup.builder(new Identifier(Nucleoplasm.NAMESPACE, "element"))
        .icon(() -> {
            //h
            ItemStack stack = new ItemStack(RegItem.elementera.getItem());
            NbtCompound nbt = new NbtCompound();
            nbt.putInt("proton", 1);
            stack.setNbt(nbt);
            return stack;
        })
        .build();
    //金属元素
    public static final ItemGroup metallic_elements = FabricItemGroup.builder(new Identifier(Nucleoplasm.NAMESPACE, "metallic_elements"))
        .icon(() -> {
            //li
            ItemStack stack = new ItemStack(RegItem.elementera.getItem());
            NbtCompound nbt = new NbtCompound();
            nbt.putInt("proton", 3);
            stack.setNbt(nbt);
            return stack;
        })
        .build();
    public static final ItemGroup non_metallic_elements = FabricItemGroup.builder(new Identifier(Nucleoplasm.NAMESPACE, "non_metallic_elements"))
        .icon(() -> {
            //be
            ItemStack stack = new ItemStack(RegItem.elementera.getItem());
            NbtCompound nbt = new NbtCompound();
            nbt.putInt("proton", 4);
            stack.setNbt(nbt);
            return stack;
        })
        .build();

    public static void initGroup() {
        ItemGroupEvents
            .modifyEntriesEvent(group)
            .register(content -> {
                content.addAll(
                    get(
                        1,
                        6,
                        0,
                        getDelay(1, 6, 2),
                        getLevel(getInts(2,3,4,5,6), getInts(4, 0,0,0,0))
                    )
                );
                content.addAll(get(
                    2,
                    8,
                    0,
                    getDelays(getDelay(2, 0, 0), getDelay(2, 8, 3)),
                    getLevel(getInts(0, 3,4,5,6,7,8), getInts(0,0,0,0,0,0,0))
                ));

            });
        ItemGroupEvents.modifyEntriesEvent(metallic_elements)
            .register(content -> {
                content.addAll(get(
                    3,
                    10,
                    0,
                    getDelays(getDelay(3, 2, 0), getDelay(3, 10, 5)),
                    getLevel(getInts(0,1,2,5,6,7,8,9,10), getInts(0,0,0,0,0,0,0,0,0))
                ));
            });
        ItemGroupEvents.modifyEntriesEvent(non_metallic_elements)
            .register(content -> {
                content.addAll(get(
                    4,
                    10,
                    1,
                    getDelays(getDelay(4, 10, 6), getDelay(4, 4, 1)),
                    getLevel(getInts(1,2,3,4,6,7,8,9,10), getInts(0,0,2,0,5,0,0,0,0))
                ));
            });
    }

    public static int[] getInts(int... i) {
        return i;
    }

    public static Map<Integer, Integer> getLevel(int[] keys, int[] values) {
        final Map<Integer, Integer> IIM = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            IIM.put(keys[i], values[i]);
        }
        return IIM;
    }

    public static Map<Integer, Boolean> getDelay(int... i) {
        final Map<Integer, Boolean> IBM = new HashMap<>();
        for (var ii : i) IBM.put(ii, true);
        return IBM;
    }
    @SafeVarargs
    public static Map<Integer, Boolean> getDelays(@NotNull Map<Integer, Boolean>... getDelay) {
        final Map<Integer, Boolean> IBM = new HashMap<>();
        for (var t : getDelay) {
            IBM.putAll(t);
        }
        return IBM;
    }

    public static List<ItemStack> get(int p, int max, int min, Map<Integer, Boolean> delay, Map<Integer, Integer> level) {
        final List<ItemStack> list = new ArrayList<>();
        for (int i = max; i >= min; i--) {
            ItemStack stack = new ItemStack(RegItem.elementera.getItem());
            NbtCompound nbt = new NbtCompound();
            nbt.putInt("proton", p);
            nbt.putInt("neutron", i);
            nbt.putBoolean("delay", delay.getOrDefault(i, false));
            nbt.putInt("delay_level", level.getOrDefault(i, 0));
            stack.setNbt(nbt);
            list.add(stack);
        }
        return list;
    }

    @SafeVarargs
    public static List<ItemStack> getAll(List<ItemStack>... lists) {
        final List<ItemStack> list = new ArrayList<>();
        for (var t : lists) {
            list.addAll(t);
        }
        return list;
    }

}
