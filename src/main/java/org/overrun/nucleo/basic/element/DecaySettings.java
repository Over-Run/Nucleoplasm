package org.overrun.nucleo.basic.element;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.overrun.nucleo.basic.element.item.ElementItem;

import java.util.*;
import java.util.stream.Collectors;

//import static org.overrun.nucleo.basic.element.RegItem.*;

/**
 * @author baka4n
 * {@code 准备将衰变基本内容写入json当中}
 */
public class DecaySettings {
//    public static final Map<Integer, Delay> neutroniumMap = decay(0, 5, 1);//中子逸散
//    public static final Map<Integer, Delay> boronMap = decay(5, 11, 8);
//    public static final Map<Integer, Delay> carbonMap = decay(6, 12, 9);
//    public static final Map<Integer, Delay> nitrogenMap = decay(7, 13, 9);
//    public static final Map<Integer, Delay> oxygenMap = decay(8, 14, 11);
//    public static final Map<Integer, Delay> fluorineMap = decay(9, 15, 11);
//    public static final Map<Integer, Delay> neonMap = decay(10, 16, 13);
//    public static final Map<Integer, Delay> natriumMap = decay(11, 17, 13);
//    public static final Map<Integer, Delay> magnesiumMap = decay(12, 18, 15);
//    public static final Map<Integer, Delay> aluminumMap = decay(13, 19, 15);
//    public static final Map<Integer, Delay> siliconMap = decay(14, 20, 19);
//    public static final Map<Integer, Delay> phosphorusMap = decay(15, 21, 19);
//    public static final Map<Integer, Delay> sulfurMap = decay(16, 22, 21);
//    public static final Map<Integer, Delay> chlorineMap = decay(17, 27, 21);
//    public static final Map<Integer, Delay> argonMap = decay(18, 28, 25);
//    public static final Map<Integer, Delay> kaliumMap = decay(19, 29, 23);
//    public static final Map<Integer, Delay> calciumMap = decay(20, 30, 29);
//    public static final Map<Integer, Delay> scandiumMap = decay(21, 30, 28);
//    public static final Map<Integer, Delay> titaniumMap = decay(22, 31, 29);
//    public static final Map<Integer, Delay> vanadiumMap = decay(23, 32, 29);
//    public static final Map<Integer, Delay> chromaMap = decay(24, 33, 31);
//    public static final Map<Integer, Delay> manganeseMap = decay(25, 34, 31);
//    public static final Map<Integer, Delay> ironMap = decay(26, 36, 35);
//    public static final Map<Integer, Delay> cobaltMap = decay(27, 37, 34);
//    public static final Map<Integer, Delay> nickelMap = decay(28, 40, 39);
//    public static final Map<Integer, Delay> copperMap = decay(29, 41, 39);
//
//    public static List<ItemStack> delayStack(Item item, boolean delay, int protonNumber, int neutronNumber) {
//        List<ItemStack> stacks = new ArrayList<>();
//        ItemStack stack = new ItemStack(item);
//        NbtCompound nbt = new NbtCompound();
//        nbt.putInt("timer", 0);
//        nbt.putBoolean("delay", delay);
//        nbt.putInt("protonNumber", protonNumber);
//        nbt.putInt("neutronNumber", neutronNumber);
//        nbt.putString("uuid", UUID.randomUUID().toString());
//        stack.setNbt(nbt);
//        stacks.add(stack);
//        return stacks;
//    }
//
//
//    @SafeVarargs
//    public static List<ItemStack> delayStack(List<ItemStack>... itemStacks) {
//        return Arrays.stream(itemStacks).flatMap(Collection::stream).collect(Collectors.toList());
//    }
//
//    public static List<ItemStack> delayStack(ItemStack... stacks) {
//        return Arrays.stream(stacks).toList();
//    }
//
//    public static Map<Integer, List<ItemStack>> getDelayItemStack(Item item, boolean delay, int protonNumber, int neutronNumber, int minNeutron) {
//        final Map<Integer, List<ItemStack>> stackMap = new HashMap<>();
//        for (int i = neutronNumber; i >= minNeutron; i--) {
//            List<ItemStack> stacks = delayStack(item, delay, protonNumber, i - protonNumber - 1);
//            stackMap.put(i, stacks);
//            String[] split = item.getTranslationKey().toLowerCase().split("\\.");
//            stacksMap.put(split[split.length - 1] + (protonNumber + i), stacks);
//        }
//        return stackMap;
//    }
//    public static final Map<String, List<ItemStack>> stacksMap = new HashMap<>();
//    public static final Map<Integer, List<ItemStack>> berylliumStack = new HashMap<>();
//    public static final Map<Integer, Delay> berylliumMap = decay(4,10,7);
//    public static void initBe() {
//        berylliumMap.put(6, level(5));
//        berylliumMap.put(4, new Delay(berylliumMap.get(7).randomB, berylliumMap.get(7).randomB + 1000));
//        berylliumMap.put(3, level(2));
//        berylliumMap.putAll(decay(4, 2,1));
//        berylliumStack.put(2, delayStack(helium.getItem(), false, 2, 2));
//        berylliumStack.put(3, delayStack(lithium.getItem(), false, 3, 4));
//        berylliumStack.put(4, delayStack(helium.getItem(), false, 2, 2));
//        berylliumStack.put(6, delayStack(boron.getItem(), false, 5, 5));
//        berylliumStack.put(7, delayStack(boron.getItem(), false, 5, 6));
//        berylliumStack.put(8, delayStack(boron.getItem(), true, 5, 7));
//    }
//
//    public static final Map<Integer, List<ItemStack>> lithiumStack = new HashMap<>();
//    public static final Map<Integer, Delay> lithiumMap = decay(3, 9, 5);
//    private static void initLi() {
//        lithiumMap.putAll(decay(lithiumMap.get(5).randomB, 2, 0));
//        lithiumStack.put(0, delayStack(helium.getItem(), true , 2, 0));
//        lithiumStack.put(1, delayStack(helium.getItem(), false , 2, 1));
//        lithiumStack.put(2, delayStack(helium.getItem(), false , 2, 2));
//        lithiumStack.put(5, delayStack(beryllium.getItem(), true , 4, 4));
//        lithiumStack.put(6, delayStack(beryllium.getItem(), true , 4, 4));
//        lithiumStack.put(7, delayStack(lithium.getItem(), true , 3, 6));
//        lithiumStack.put(8, delayStack(beryllium.getItem(), true , 4, 6));
//        lithiumStack.put(9, delayStack(lithium.getItem(), true , 3, 8));
//    }
//    public static final Map<Integer, List<ItemStack>> heliumItemStack = new HashMap<>();
//    public static final Map<Integer, Delay> heliumMap = decay(2, 8, 4);
//    private static void initHe() {
//        heliumMap.putAll(decay(2, 0, 0));
//        heliumItemStack.put(0, delayStack(hydrogen.getItem(),false, 1, 1));
//        heliumItemStack.put(3, delayStack(helium.getItem(), false, 2, 2));
//        heliumItemStack.put(4, delayStack(delayStack(helium.getItem(), false, 2, 2), delayStack(hydrogen.getItem(), false, 1, 1)));
//        heliumItemStack.put(5, delayStack(helium.getItem(), true, 2, 4));
//        heliumItemStack.put(6, delayStack(delayStack(helium.getItem(), true, 2, 3), delayStack(hydrogen.getItem(), true, 1, 2)));
//        heliumItemStack.put(7, delayStack(helium.getItem(), true, 2, 6));
//        heliumItemStack.put(8, delayStack(helium.getItem(), true, 2, 6));
//    }
//    public static final Map<Integer, List<ItemStack>> hydrogenItemStack = new HashMap<>();
//    public static final Map<Integer, Delay> hydrogenMap = decay(1, 6, 3);
//    private static void initH() {
//        hydrogenMap.put(2, level(4));
//        stacksMap.put("helium3", delayStack(helium.getItem(), false, 2, 1));
//        hydrogenItemStack.put(2, stacksMap.get("helium3"));
//        hydrogenItemStack.putAll(getDelayItemStack(hydrogen.getItem(), true, 1, 6, 3));
//
//    }
//
//    public static void init() {
//        initH();
//        initHe();
//        initLi();
//        initBe();
//
//
//        boronMap.putAll(decay(5,4,2));
//        carbonMap.put(8, level(4));
//        carbonMap.putAll(decay(6, 5, 2));
//        nitrogenMap.putAll(decay(7, 6, 3));
//        oxygenMap.putAll(decay(8, 7, 4));
//        fluorineMap.putAll(decay(9, 9, 5));
//        neonMap.putAll(decay(10, 9, 6));
//        natriumMap.put(11, level(3));
//        natriumMap.putAll(decay(11, 10, 7));
//        magnesiumMap.putAll(decay(12, 11, 8));
//        aluminumMap.put(13, nuclear_isomer_Level(5, 13));
//        aluminumMap.putAll(decay(13, 12, 9));
//        siliconMap.put(18, level(4));
//        siliconMap.putAll(decay(14, 17,  17));
//        siliconMap.putAll(decay(14, 13,  10));
//        phosphorusMap.put(18, level(2));
//        phosphorusMap.put(17, level(2));
//        phosphorusMap.putAll(decay(15, 15, 11));
//        sulfurMap.put(19, level(2));
//        sulfurMap.putAll(decay(16, 15, 13));
//        chlorineMap.put(19, level(5));
//        chlorineMap.putAll(decay(17, 17, 14));
//        argonMap.put(24, level(4));
//        argonMap.putAll(decay(18, 23, 23));
//        argonMap.put(21, level(4));
//        argonMap.put(19, level(2));
//        argonMap.putAll(decay(18, 17, 15));
//        kaliumMap.put(21, level(6));
//        kaliumMap.putAll(decay(19, 19, 16));
//        calciumMap.put(28, level(6));
//        calciumMap.put(27, level(1));
//        calciumMap.put(25, level(3));
//        calciumMap.put(21, level(5));
//        calciumMap.putAll(decay(20, 19, 17));
//        scandiumMap.put(27, level(1));
//        scandiumMap.put(26, level(1));
//        scandiumMap.put(25, nuclear_isomer_Level(2, 25));
//        scandiumMap.put(23, level(1));
//        scandiumMap.putAll(decay(21, 22, 19));
//        titaniumMap.putAll(decay(22, 23, 23));
//        titaniumMap.put(22, level(4));
//        titaniumMap.putAll(decay(22, 21, 19));
//        vanadiumMap.put(27, level(6));
//        vanadiumMap.put(26, level(3));
//        vanadiumMap.put(25, level(2));
//        vanadiumMap.putAll(decay(23, 24, 21));
//        chromaMap.put(27, level(2));
//        chromaMap.put(26, new Delay(50000, 5000000));
//        chromaMap.putAll(decay(24, 25, 21));
//        manganeseMap.put(29, level(3));
//        manganeseMap.put(28, level(5));
//        manganeseMap.put(27, nuclear_isomer_Level(1, 27));
//        manganeseMap.putAll(decay(25,26, 23));
//        ironMap.put(34, level(5));
//        ironMap.put(33, level(2));
//        ironMap.put(29, level(3));
//        ironMap.put(28, new Delay(40000, 5000000));
//        ironMap.putAll(decay(26, 27, 23));
//        cobaltMap.put(33, nuclear_isomer_Level(3, 33));
//        cobaltMap.put(31, nuclear_isomer_Level(2, 31));
//        cobaltMap.put(30, level(3));
//        cobaltMap.put(29, level(2));
//        nickelMap.put(38, level(1));
//        nickelMap.putAll(decay(28, 37, 37));
//        nickelMap.put(35, level(4));
//        nickelMap.put(31, level(5));
//        nickelMap.put(30, level(3));
//        nickelMap.put(29, level(1));
//        nickelMap.put(28, level(1));
//        nickelMap.putAll(decay(28, 27, 25));
//        copperMap.put(38, level(1));
//        copperMap.putAll(decay(29, 37, 37));
//        copperMap.putAll(decay(29, 35, 35));
//        copperMap.putAll(decay(29, 33, 26));
//    }
//
//    public static Delay level(int i) {
//        return switch (i) {
//            case 1 -> new Delay(1000, 100000);
//            case 2 -> new Delay(10000, 1000000);
//            case 3 -> new Delay(100000, 10000000);
//            case 4 -> new Delay(1000000, 100000000);
//            case 5 -> new Delay(10000000, 1000000000);
//            case 6 -> new Delay(100000000, Integer.MAX_VALUE);
//            default -> null;
//        };
//    }
//
//    public static Delay nuclear_isomer_Level(int i, int meu) {
//        return switch (i) {
//            case 1 -> new Delay(meu - 1, 100000);
//            case 2 -> new Delay(meu - 1, 1000000);
//            case 3 -> new Delay(meu - 1, 10000000);
//            case 4 -> new Delay(meu - 1, 100000000);
//            case 5 -> new Delay(meu - 1, 1000000000);
//            case 6 -> new Delay(meu - 1, Integer.MAX_VALUE);
//            default -> null;
//        };
//    }
//
//    public static Map<Integer, Delay> decay(int valA, int maxMeu, int minNeu) {
//        final Map<Integer, Delay> map = new HashMap<>();
//        int a = 100 / valA*valA;
//        int b;
//        for (int i = maxMeu; i >= minNeu; i--) {
//            b = Delay.random.nextInt(7,15) * 10 + a;
//            map.put(i, new Delay(a,b));
//            a = b;
//        }
//        return map;
//    }
//
//    /**
//     * @author baka4n
//     * {@code 记录随机时序}
//     */
//    public static class Delay {
//        protected final int randomA;
//        protected final int randomB;
//        private static final Random random = new Random();
//        public Delay(int randomA, int randomB) {
//            this.randomA = randomA;
//            this.randomB = randomB;
//        }
//
//        public int getDecay() {
//            return random.nextInt(randomA, randomB);
//        }
//
//        /**
//         * 尚未使用,暂时弃用
//         * 光速震荡理论，根据相对论提出(以接近光速运动（或者处在高引力场中）的事物的时间，在相对静止系的观测者眼中会变慢)
//         * The time of things moving at a speed close to the speed of light (or in a high gravitational field) will slow down in the eyes of observers in a relatively static system
//         * {@code 衰变抑制等级(科幻类目前人类还未能做到)}
//         * @param level 抑制剂等级
//         * @return 返回衰变时数
//         */
//        @Deprecated
//        public int suppression_getDecay(int level) {
//            return random.nextInt(randomA * (100 + new Suppression(level).decay())/100, randomB * (100 + new Suppression(level).decay())/100);
//        }
//    }
//
//    public static class Suppression {
//        protected int a;
//        protected int b;
//
//        public Suppression(int level) {
//            switch (level) {
//                case 1 -> {
//                    this.a = 81;
//                    this.b = 100;
//                }
//                case 2 -> {
//                    this.a = 67;
//                    this.b = 80;
//                }
//                case 3 -> {
//                    this.a = 49;
//                    this.b = 66;
//                }
//                case 4 -> {
//                    this.a = 35;
//                    this.b = 48;
//                }
//                case 5 -> {
//                    this.a = 21;
//                    this.b = 34;
//                }
//                case 6 -> {
//                    this.a = 2;
//                    this.b = 20;
//                }
//
//            }
//        }
//
//        public int decay() {
//            return Delay.random.nextInt(this.a, this.b);
//        }
//
//    }



}
