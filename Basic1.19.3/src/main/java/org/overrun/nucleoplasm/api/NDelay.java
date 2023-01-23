package org.overrun.nucleoplasm.api;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.Random;

import static org.overrun.nucleoplasm.item.DelayTimeSettings.map;

public class NDelay {
    public static void tickEvent(Player player, int slot) {
        ItemStack item = player.getInventory().getItem(slot).copy();
        CompoundTag tag = item.hasTag() ? item.getTag() : null;
        if (!item.isEmpty()) {
            if (tag != null) {
                if (tag.getBoolean("delay")) {
                    if (tag.contains("create_tick")) {//创建的游戏时间
                        tag.putLong("create_tick", player.level.getGameTime());
                        item.setTag(tag);
                    }
                }
            }
            player.getInventory().setItem(slot, item);
        }
    }
    public static void tickPlayer2(Player player, int slot) {
        ItemStack item = player.getInventory().getItem(slot).copy();
        if (!item.isEmpty()) {
            CompoundTag tag = item.getTag();
            if (tag != null) {
                if (tag.getBoolean("delay")) {
                    System.out.println(player.level.getGameTime());
                    if (tag.contains("create_tick")) {
                        if ((double)(player.level.getGameTime() - tag.getLong("create_tick")) >= tag.getDouble("mc_half_life")) {
                            String key = tag.getString("abbreviation") + tag.getInt("neutron");
                            player.getInventory().setItem(slot, item);
                            Map<String, NonNullList<ItemStack>> listMap = map.get(key);
                            int i = 0;
                            double v = new Random().nextDouble(0, 1);
                            double t;
                            for (String s : listMap.keySet()) {
                                double ran = Double.parseDouble(s.trim());
                                t = ran;
                                if ((i == 0 && v <= ran) || (v <= ran && v >= t) ) {
                                    listMap.get(s).forEach(stack1 -> {
                                        player.drop(stack1, true);
                                        System.out.println("e");
                                    });
                                }
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }
}
