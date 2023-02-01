package org.overrun.nucleoplasm.item;

import com.google.gson.internal.LinkedTreeMap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.overrun.nucleoplasm.Basic;
import org.overrun.nucleoplasm.api.jsons.ItemsUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.minecraft.network.chat.Component.empty;
import static net.minecraft.network.chat.Component.translatable;
import static org.overrun.nucleoplasm.Basic.loader;
import static org.overrun.nucleoplasm.api.jsons.ItemsUtils.*;

//核素 元素

/**
 * @author baka4n
 */
public class ElementItem extends Item {
    public ElementItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slot, boolean selected) {
        if (entity instanceof Player) {
            if (stack.hasTag()) {
                assert stack.getTag() != null;
                CompoundTag tag = stack.getTag().copy();
                if (!tag.contains("create_tick")) {
                    tag.putLong("create_tick", entity.level.getGameTime());
                    stack.setTag(tag);
                } else  {
                    int createTick = Math.toIntExact(entity.level.getGameTime() - tag.getLong("create_tick"));
                    if (createTick >= tag.getDouble("mc_half_life")) {
                        ((Player) entity).getInventory().setItem(slot, ItemStack.EMPTY);
                        int neutron = tag.getInt("neutron");
                        String abbreviation = tag.getString("abbreviation");
                        Object decayNeutronSettings = getDecayNeutronSettings(loader.get(1), abbreviation, neutron);
                        Object random = decayNeutronSettings != null ? get(decayNeutronSettings).get("random") : null;
                        double d = 0;
                        double v = new Random().nextDouble(0.0000000000, 1.0000000000);
                        if (random != null) {
                            for (var entry : get(random).entrySet()) {
//                                int parseInt = Integer.parseInt((String) entry.getKey());
                                for (var e : get(entry.getValue()).entrySet()) {
                                    double ran = Double.parseDouble((String) e.getKey());
                                    if (v >= d && v <= ran) {
                                        for (var mapEntry : get(e.getValue()).entrySet()) {
//                                            Object value = mapEntry.getValue();
                                            var map = get(mapEntry.getValue());
                                            String abbreviation1 = (String) map.get("abbreviation");
                                            int neutron1 = Integer.parseInt((String) map.get("neutron"));
                                            int count = Integer.parseInt((String) map.get("count"));
                                            LinkedTreeMap<?, ?> map1 = get(get(loader.get(1)).get("items"));
                                            int proton = (int) map1.get(abbreviation1);
                                            String translate = (String) map1.get("translate");
                                            Object decayNeutronSettings1 = getDecayNeutronSettings(loader.get(1), abbreviation, neutron);
                                            String halfLife = decayNeutronSettings1 != null ? (String) get(decayNeutronSettings1).get("half_life") : null;
                                            if (halfLife != null) {
                                                ItemStack itemStack = getItemStack(RegItem.elementera,abbreviation1, translate, halfLife, proton, neutron1);
                                                itemStack.setCount(count);
                                                ((Player) entity).drop(itemStack, false);
                                            }
                                        }
                                    }

                                }
                            }
                        }
//                        Decay decaySettings = GroupDecaySettings.getDecaySettings(proton);
//                        if (decaySettings != null) {
//                            ((Player) entity).getInventory().setItem(slot, ItemStack.EMPTY);
//                            var random = decaySettings.getRandom(abbreviation, neutron);
//                            double d = 0;
//                            double v = new Random().nextDouble(0, 100);
//                            for (var entry : random.entrySet()) {
//                                for (var e : entry.getValue().entrySet()) {
//                                    double aDouble = e.getKey() * 100;
//                                    if (v - d <= aDouble && v - d >= 0) {
//                                        for (var mapEntry : e.getValue().entrySet()) {
//                                            var sol = mapEntry.getValue();
//                                            String abbreviation1 = (String) sol.get("abbreviation");
//                                            int neutron1 = (int) sol.get("neutron");
//                                            int count = (int) sol.get("count");
//                                            ItemStack copy = GroupDecaySettings.items.getItemStack(abbreviation1, neutron1).copy();
//                                            copy.setCount(count);
//                                            ((Player) entity).drop(copy, true);
//
//                                        }
//                                        break;
//                                    }
//                                    d += aDouble;
//
//                                }
//                            }
//                        }
                    }


                }

            }
        }

//        CompoundTag compoundTag = stack.hasTag() ? stack.getTag() : null;
//        if (compoundTag != null) {
//            if (compoundTag.contains("create_tick")) {//创建的游戏时间
//                compoundTag.putLong("create_tick", entity.level.getGameTime());
//                stack.setTag(compoundTag);
//            }
//        }
//        if (entity instanceof Player player) {
//            CompoundTag tag = player.inventoryMenu.getSlot(slot).getItem().getTag();
//            if (tag != null) {
//
//                if ((level.getGameTime() - tag.getLong("create_tick")) >= tag.getDouble("mc_half_life")) {
//
//                    String key = tag.getString("abbreviation") + tag.getInt("neutron");
////                    player.inventoryMenu.getSlot(slot).remove(player.inventoryMenu.getSlot(slot).getItem().getCount());
//                    Map<String, NonNullList<ItemStack>> listMap = map.get(key);
//                    int i = 0;
//                    double v = new Random().nextDouble(0, 1);
//                    double t = 0;
//                    for (String s : listMap.keySet()) {
//                        System.out.println("c");
//                        double ran = Double.parseDouble(s.trim());
//                        t = ran;
//                        if ((i == 0 && v <= ran) || (v <= ran && v >= t) ) {
//                            listMap.get(s).forEach(stack1 -> player.drop(stack1, true));
//                            System.out.println("d");
//                        }
//                        i++;
//                    }
//                }
////                if ((level.getGameTime() - tag.getLong("create_tick")) >= tag.getDouble("mc_half_life")) {
////                    for (DecayTimeSettings value : DecayTimeSettings.values()) {
////                        double d = 1;
////                        if (value.name().equals(tag.getString("abbreviation")+tag.getInt("neutron"))) {
////                            for (String s : value.getDecay_out()) {
////                                String[] split = s.split(",");
////                                double ran = Double.parseDouble(split[1].trim());
////                                double v = new Random().nextDouble(0,1);
////                                double t = d;
////                                d = d - v;
////                                inventoryMenu.getSlot(slot).remove(inventoryMenu.getSlot(slot).getItem().getCount());
////                                if (ran > d && ran <= t) {
////                                    String[] split1 = split[0].split(":");
////                                    for (String s1 : split1) {
////                                        String[] PANAC = s1.split("_");
////                                        int proton = Integer.parseInt(PANAC[0].trim());
////                                        int neutron = Integer.parseInt(PANAC[1].trim());
////
////                                        int count = 1;
////                                        if (PANAC.length == 3) count = Integer.parseInt(PANAC[2].trim());
////                                        ItemStack itemStack = NbtAndGroupSettings.get(proton, neutron);
////                                        itemStack.setCount(count);
////                                        player.drop(itemStack, true);
////                                    }
////                                }
////
////                            }
////                        }
////                    }
////                }
//            }
//
//        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    @Override
    @NotNull
    public Component getName(@NotNull ItemStack stack) {
        CompoundTag tag = stack.hasTag() ? stack.getTag() : new CompoundTag();
        assert tag != null;
        stack.setHoverName(
            translatable(
                "item." +
                    Basic.toTranslationKey(tag.getString("translate")) +
                    (tag.getInt("proton") + (tag.getInt("neutron")))
            ).setStyle(Style.EMPTY.withFont(Basic.identifier("uniform")).withColor(0xFFFFFF))
        );
        return super.getName(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        CompoundTag tag = stack.hasTag() ? stack.getTag() : new CompoundTag();
        assert tag != null;
        if (!tag.isEmpty()) {
            list.add(translatable("item.nucleoplasm.cf"));
            list.add(
                empty()
                    .append(
                        "%03d"
                            .formatted(tag.getInt("proton") + tag.getInt("neutron"))
                    )
            );

            list.add(empty().append("      %s      ".formatted(tag.getString("abbreviation"))));
            list.add(empty().append(String.format("%03d", tag.getInt("proton"))));
//            list.add(nullToEmpty(String.format("%03d", tag.getInt("proton"))));
            list.add(empty());
            list.add(empty().append("decay: ").append(String.valueOf(tag.getBoolean("decay"))));
            list.add(translatable("item.nucleoplasm.ram"));//relative_atomic_mass:
            list.add(empty().append(String.valueOf(tag.getDouble("relative_atomic_mass"))));
//            list.add(nullToEmpty(String.valueOf(tag.getDouble("relative_atomic_mass"))));
            if (tag.contains("half_life")) {
                list.add(
                    translatable("item.nucleoplasm.half.life")
                        .append(tag.getString("half_life"))
                );
                list.add(
                    empty()
                        .append("MC ")
                        .append(translatable("item.nucleoplasm.half.life"))
                        .append(String.valueOf(tag.getDouble("mc_half_life")))
                );
            }
            list.add(empty().append(String.valueOf(tag.getLong("create_tick"))));

        }
        super.appendHoverText(stack, level, list, flag);
    }
}
