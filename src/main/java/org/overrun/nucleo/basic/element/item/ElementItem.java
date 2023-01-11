//package org.overrun.nucleo.basic.element.item;
//
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.client.item.TooltipContext;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Wearable;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.text.Style;
//import net.minecraft.text.Text;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.*;
//import java.util.concurrent.ThreadPoolExecutor;
//
//import static org.overrun.nucleo.basic.element.DecaySettings.*;
//
///**
// * @author baka4n
// * @since 基础元素注册,后期用于单独元素分离保持一定稳定性的容器
// */
//public class ElementItem extends Item implements Wearable {
//    protected final int protonNumber;
//    protected final int minNeutronNumber;
//    protected Item decayItem;
//    protected Map<Integer, List<ItemStack>> delayItemStack;
//    protected final int max;
//    protected Map<String, Integer> timerMap = new HashMap<>();
//    protected Map<String, NbtCompound> nbtMap = new HashMap<>();
////    protected final Map<Integer, Delay> delayTimes;//获取不同中子数段的衰变段
//
//    @SuppressWarnings("unused")
//    public ElementItem setDecayItem(Item item) {
//        this.decayItem = item;
//        return this;
//    }
//
//    public int getProtonNumber() {
//        return protonNumber;
//    }
//
//    public int getMinNeutronNumber() {
//        return minNeutronNumber;
//    }
//
//    public Item getDecayItem() {
//        return decayItem;
//    }
//
//    public Map<Integer, List<ItemStack>> getDelayItemStack() {
//        return delayItemStack;
//    }
//
//    public int getMax() {
//        return max;
//    }
//
//    public Map<String, Integer> getTimerMap() {
//        return timerMap;
//    }
//
//    public Map<String, NbtCompound> getNbtMap() {
//        return nbtMap;
//    }
//
//    public Map<Integer, Delay> getDelayTimes() {
//        return delayTimes;
//    }
//
//    //用于构建气态化学式
//    public ElementItem(Settings settings, int protonNumber, int maxNeutronNumber, int minNeutronNumber, Map<Integer, Delay> delayTimes) {
//        super(settings);
//        this.protonNumber = Math.max(protonNumber, 0);
//        this.minNeutronNumber = Math.max(minNeutronNumber, 0);
//        this.max = maxNeutronNumber;
//        this.delayTimes = delayTimes;
//
//    }
//
//    public ElementItem(Settings settings, int protonNumber, int maxNeutronNumber, int minNeutronNumber, Map<Integer, Delay> delayTimes, Map<Integer, List<ItemStack>> delayItemStack) {
//        super(settings);
//        this.protonNumber = Math.max(protonNumber, 0);
//        this.minNeutronNumber = Math.max(minNeutronNumber, 0);
//        this.max = maxNeutronNumber;
//        this.delayTimes = delayTimes;
//        this.delayItemStack = delayItemStack;
//    }
//
//    @Override
//    public boolean hasGlint(ItemStack stack) {
//       return false;
//    }
//
//    @Override
//    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
//        if (stack.getNbt() != null) {
//            tooltip.add(Text.translatable("proton.Number"));
//            tooltip.add(Text.of(String.valueOf(stack.getNbt().getInt("protonNumber"))));
//            tooltip.add(Text.translatable("neutron.Number"));
//            tooltip.add(Text.of(String.valueOf(stack.getNbt().getInt("neutronNumber"))));
//            tooltip.add(Text.of(String.valueOf(stack.getNbt().getString("uuid"))));
//        }
//
//        super.appendTooltip(stack, world, tooltip, context);
//    }
//    /**
//     * {@code Decay会随着每次tick而改变，随时都有可能衰变}
//     * @author baka4n
//     * @param stack 物品堆
//     * @param world 所在维度
//     * @param entity the entity holding the item; usually a player
//     * @param slot 所在格子
//     * @param selected whether the item is in the selected hot-bar slot
//     */
//    @Override
//    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//        if (stack.getNbt() != null) {
//            int timer;
//            NbtCompound nbt;
//            if (!nbtMap.containsKey(stack.getNbt().getString("uuid"))) {
//                nbtMap.put(stack.getNbt().getString("uuid"), stack.getNbt());
//            }
//            nbt = nbtMap.get(stack.getNbt().getString("uuid"));
//
//            if (!timerMap.containsKey(nbt.getString("uuid"))) {
//                timerMap.put(nbt.getString("uuid"), nbt.getInt("timer"));
//                timer = timerMap.get(nbt.getString("uuid"));
//            } else {
//                timer = timerMap.get(nbt.getString("uuid"));
//            }
//            if (nbt.getBoolean("delay")) {
//                timer++;
//                timerMap.put(nbt.getString("uuid"), timer);
//                nbt.putInt("timer", timer);
//                if (timer % 3000 == 0) {
//                    stack.setNbt(nbt);
//                }
//                if (nbt.getInt("neutronNumber") == minNeutronNumber) {
//                    if (delayTimes.containsKey(nbt.getInt("neutronNumber"))) {
//                        stack = new ItemStack(decayItem);
//                    } else {
//                        nbt.putBoolean("delay", false);
//                    }
//                }
//                if (delayTimes.get(nbt.getInt("neutronNumber")) != null && timer >= delayTimes.get(nbt.getInt("neutronNumber")).getDecay()) {
//
//                    var int_ = nbt.getInt("neutronNumber") - 1;
//                    if (nbt.getInt("neutronNumber") < minNeutronNumber) {
//                        int_ = minNeutronNumber;
//                    }
//                    nbt.putInt("neutronNumber", int_);
//                    timer = 0;
//                    timerMap.put(nbt.getString("uuid"), timer);
//                    stack.setNbt(nbt);
//                    stack.setCustomName(getText(stack, 0xFFFFFF));
//                }
//            }
//        } else {
//            NbtCompound nbt = new NbtCompound();
//            nbt.putInt("timer", 0);
//            nbt.putBoolean("delay", true);
//            nbt.putInt("protonNumber", protonNumber);
//            nbt.putInt("neutronNumber", max);
//            nbt.putString("uuid", UUID.randomUUID().toString());
//            stack.setNbt(nbt);
//        }
//        super.inventoryTick(stack, world, entity, slot, selected);
//    }
//
//
//
//    @Override
//    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
//        return false;
//    }
//
//    public Text getText(ItemStack stack, Integer rgba) {
//        var key1 = super.getTranslationKey();
//        NbtCompound nbt = stack.getNbt();
//        var key2 = nbt != null ?  nbt.getInt("protonNumber") + nbt.getInt("neutronNumber") : "";
//        if (rgba == null) {
//            return Text.translatable(key1 + key2);
//        } else {
//            return Text.translatable(key1 + key2).setStyle(Style.EMPTY.withColor(rgba));
//        }
//
//    }
//
//    @Override
//    public Text getName(ItemStack stack) {
//        stack.setCustomName(getText(stack, 0xFFFFFF));
//        return super.getName(stack);
//    }
//}
