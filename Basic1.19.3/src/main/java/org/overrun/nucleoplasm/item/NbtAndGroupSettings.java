package org.overrun.nucleoplasm.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * 记录各项物品的item和组
 */
public enum NbtAndGroupSettings {
    H(1, 0, 6,
        "hydrogen", "ia", "氢"),
    He(2, 1, 8,
        "helium", "zero", "氦"),
    Li(3, 1, 9,
        "lithium", "ia", "锂"),
    Be(4, 2, 12,
        "beryllium", "iia", "铍"),
    B(5, 2, 16,
        "boron", "iiia", "硼"),
    C(6, 2, 16,
        "carbon", "iva", "碳"),
    N(7, 3, 17,
        "nitrogen", "va", "氮"),
    O(8, 4, 26,
        "oxygen", "via", "氧"),
    F(9, 4, 22,
        "fluorine", "viia", "氟"),
    Ne(10, 5, 24,
        "neon", "zero", "氖"),
    Na(11, 6, 28,
        "natrium", "ia", "钠"),
    Mg(12, 7, 29,
        "magnesium", "iia", "镁"),
    Al(13, 8, 30,
        "aluminum", "iiia", "铝"),
    Si(14, 8, 31,
        "silicon", "iva", "硅"),
    P(15, 9, 32,
        "phosphorus", "va", "磷"),
    S(16, 10, 33,
        "sulfur", "via", "硫"),
    Cl(17, 11, 35,
        "chlorine", "viia", "氯"),
    Ar(18, 11, 36,
        "argon", "zero", "氩"),
    K(19, 12, 40,
        "kalium", "ia", "钾"),
    Ca(20, 13, 41,
        "calcium", "iia", "钙"),
    Sc(21, 14, 42,
        "scandium", "iiib", "钪"),
    Ti(22, 15, 43,
        "titanium", "ivb", "钛"),
    V(23, 16, 44,
        "vanadium", "vb", "钒"),
    Cr(24, 17, 46,
        "chroma", "vib", "铬"),
    Mn(25, 18, 48,
        "manganese", "viib", "锰"),
    Fe(26, 19, 50,
        "ferrum", "viii", "铁"),
    Co(27, 20, 51,
        "cobalt", "viii", "钴"),
    Ni(28, 20, 54,
        "nickel", "viii", "镍"),
    Cu(29, 23, 55,
        "copper", "ib", "铜"),
    Zn(30, 24, 56,
        "zinc", "iib", "锌"),
    Ga(31, 25, 57,
        "gallium", "iiia", "镓"),
    Ge(32, 26, 58,
        "gallium", "iva", "锗"),
    As(33, 27, 58,
        "arsenic", "va", "砷"),
    Se(34, 30, 61,
        "selenium", "via", "硒"),
    Br(35, 31, 63,
        "bromine", "viia", "溴"),
    Kr(36, 32, 65,
        "krypton", "zero", "氪"),
    Rb(37, 34, 67,
        "rubidium", "ia", "铷"),
    Sr(38, 35, 69,
        "strontium", "iia", "锶"),
    Y(39, 36, 70,
        "yttrium", "iiib", "钇"),
    Zr(40, 37, 73,
        "zirconium", "ivb", "锆"),
    Nb(41, 38, 75,
        "niobium", "vb", "铌"),
    Mo(42, 39, 77,
        "molybdenum", "vib", "钼"),
    Tc(43, 40, 79,
        "technetium", "viib", "锝"),
    Ru(44, 41, 81,
        "ruthenium", "viii", "钌"),
    Rh(45, 43, 83,
        "rhodium", "viii", "铑"),
    Pd(46, 44, 85,
        "palladium", "viii", "钯"),
    Ag(47, 45, 86,
        "argentum", "ib", "银"),
    Cd(48, 46, 87,
        "cadmium", "iib", "镉"),
    In(49, 47, 88,
        "indium", "iiia", "铟"),
    Sn(50, 49, 90,
        "stannum", "iva", "锡"),
    Sb(51, 51, 91,
        "stibium", "va", "锑"),
    Te(52, 52, 93,
        "tellurium", "via", "碲"),
    I(53, 53, 94,
        "iodine", "viia", "碘"),
    Xe(54, 54, 96,
        "xenon", "zero", "氙"),
    Cs(55, 56, 97,
        "caesium", "ia", "铯"),
    Ba(56, 57, 98,
        "barium", "iia", "钡"),
    La(57, 59, 100,
        "lanthanum", "iiib", "镧"),
    Ce(58, 61, 101,
        "cerium", "iiib", "铈"),
    Pr(59, 62, 102,
        "praseodymium", "iiib", "镨"),
    Nd(60, 64, 103,
        "neodymium", "iiib", "钕"),
    Pm(61, 65, 104,
        "promethium", "iiib", "钷"),
    Sm(62, 66, 106,
        "samarium", "iiib", "钐"),
    Eu(63, 67, 107,
        "europium", "iiib", "铕"),
    Gd(64, 69, 108,
        "gadolinium", "iiib", "钆"),
    Tb(65, 70, 109,
        "terbium", "iiib", "铽"),
    Dy(66, 72, 110,
        "dysprosium", "iiib", "镝"),
    Ho(67, 73, 111,
        "holmium", "iiib", "钬"),
    Er(68, 74, 112,
        "erbium", "iiib", "铒"),
    Tm(69, 75, 113,
        "thulium", "iiib", "铥"),
    Yb(70, 78, 115,
        "ytterbium", "iiib", "镱"),
    Lu(71, 79, 117,
        "lutetium", "iiib", "镥"),
    Hf(72, 81, 118,
        "hafnium", "ivb", "铪"),
    Ta(73, 82, 121,
        "tantalum", "vb", "钽"),
    W(74, 83, 123,
        "tungsten", "vib", "钨"),
    Re(75, 84, 124,
        "rhenium", "viib", "铼"),
    Os(76, 85, 127,
        "osmium", "viii", "锇"),
    Ir(77, 86, 128,
        "iridium", "viii", "铱"),
    Pt(78, 87, 130,
        "platinum", "viii", "铂"),
    Au(79, 89, 131,
        "aurum", "ib", "金"),
    Hg(80, 90, 136,
        "mercury", "iib", "汞"),
    Tl(81, 95, 137,
        "thallium", "iiia", "铊"),
    Pb(82, 96, 138,
        "plumbum", "iva", "铅"),
    Bi(83, 101, 141,
        "bismuth", "va", "铋"),
    Po(84, 102, 143,
        "polonium", "via", "钋"),
    At(85, 106, 144,
        "astatine", "viia", "砹"),
    Rn(86, 107, 145,
        "radon", "zero", "氡"),
    Fr(87, 110, 146,
        "francium", "ia", "钫"),
    Ra(88, 113, 147,
        "radium", "iia", "镭"),
    Ac(89, 116, 148,
        "actinium", "iiib", "锕"),
    Th(90, 118, 149,
        "thorium", "iiib", "钍"),
    Pa(91, 120, 150,
        "protactinium", "iiib", "镤"),
    U(92, 123, 151,
        "uranium", "iiib", "铀"),
    Np(93, 126, 152,
        "neptunium", "iiib", "镎"),
    Pu(94, 127, 153,
        "plutonium", "iiib", "钚"),
    Am(95, 128, 154,
        "americium", "iiib", "镅"),
    Cm(96, 135, 156,
        "curium", "iiib", "锔"),
    Bk(97, 136, 157,
        "berkelium", "iiib", "锫"),
    Cf(98, 139, 158,
        "californium", "iiib", "锎"),
    Es(99, 140, 159,
        "einsteinium", "iiib", "锿"),
    Fm(100, 141, 160,
        "fermium", "iiib", "镄"),
    Md(101, 143, 161,
        "mendelevium", "iiib", "钔"),
    No(102, 146, 162,
        "nobelium", "iiib", "锘"),
    Lr(103, 148, 163,
        "lawrencium", "iiib", "铹"),
    Rf(104, 149, 164,
        "rutherfordium", "ivb", "𬬻"),
    Db(105, 150, 165,
        "dubnium", "vb", "𬭊"),
    Sg(106, 152, 167,
        "seaborgium", "vib", "𬭳"),
    Bh(107, 153, 171,
        "bohrium", "vib", "𬭛"),
    Hs(108, 155, 172,
        "hassium", "viii", "𬭶"),
    Mt(109, 156, 173,
        "meitnerium", "viii", "鿏"),
    Ds(110, 157, 174,
        "darmstadtium", "viii", "𫟼"),
    Rg(111, 161, 175,
        "roentgenium", "ib", "𬬭"),
    Cn(112, 164, 176,
        "copernicium", "iib", "鿔"),
    Nh(113, 165, 177,
        "nihonium", "iiia", "鿭"),
    Fl(114, 170, 177,
        "flerovium", "iva", "𫓧"),
    Mc(115, 172, 177,
        "moscovium", "va", "镆"),
    Lv(116, 173, 177,
        "livermorium", "via", "𫟷"),
    Ts(117, 175, 177,
        "tennessine", "viia", "鿬"),
    Og(118, 176, 177,
        "oganesson", "zero", "鿫")
    ;//name = abbreviated_name

    private final int proton, minNeutron,maxNeutron;
    private final String translate, main_group, chinese_name;

    NbtAndGroupSettings(int proton, int minNeutron, int maxNeutron,
                        String translate, String main_group,
                        String chinese_name) {
        //其他国家都会显示abbreviated_name，中文会显示chinese_name
        this.proton = proton;
        this.maxNeutron = maxNeutron;
        this.minNeutron = minNeutron;
        this.translate = translate;
        this.main_group = main_group;
        this.chinese_name = chinese_name;
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
    public static ItemStack get(String str) {
        for (ItemStack itemStack : element) {
            CompoundTag tag = itemStack.getTag();
            assert tag != null;
            if (str.equals(tag.getString("abbreviation") + tag.getInt("neutron"))) {
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }
    public static void init() {
        for (NbtAndGroupSettings value : values()) {
            for (int neutron = value.minNeutron; neutron <= value.maxNeutron; neutron++) {
                ItemStack itemStack = new ItemStack(RegItem.elementera.getItem().get());
                CompoundTag tag = new CompoundTag();
                tag.putInt("proton", value.proton);
                tag.putInt("neutron", neutron);
                tag.putString("translate", value.translate);
                tag.putString("abbreviation", value.name());
                for (DelayTimeSettings decayTime : DelayTimeSettings.values()) {
                    if (decayTime.name().equals(value.name()+neutron)) {
                        tag.putBoolean("delay", decayTime.isDelay());
                        tag.putDouble("relative_atomic_mass", decayTime.getRelative_atomic_mass());
                        if (decayTime.isDelay()) {
                            tag.putString("half_life", decayTime.getHalf_life());
                            tag.putDouble("mc_half_life", decayTime.getMc_half_life());
                        }
                        break;
                    }
                }
                itemStack.setTag(tag);
                switch (value.proton) {
                    case 3, 11, 19, 37, 55, 87 -> alkali_metal.add(itemStack);
                    case 4, 12, 20, 38, 56, 88 -> alkali_earth_metal.add(itemStack);
                    case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                        39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
                        72, 73, 74, 75, 76, 77, 78, 79, 80,
                        104, 105, 106, 107, 108, 109, 110, 111, 112 ->
                        transition_metal.add(itemStack);
                    case 13, 31, 49, 50, 81, 82, 83, 113, 114, 115, 116 -> other_metal.add(itemStack);
                    case 5, 14, 32, 33, 51, 52, 84 -> metalloid.add(itemStack);
                    case 6, 7, 8, 15, 16, 34 -> other_non_metal.add(itemStack);
                    case 9, 17, 35, 53, 85, 117 -> halogen.add(itemStack);
                    case 2, 10, 18, 36, 54, 86, 118 -> noble_gas.add(itemStack);
                    case 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71 ->
                        lanthanide_series.add(itemStack);
                    case 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103 ->
                        actinide_series.add(itemStack);
                }
                /*
            6,7,8,15,16,34 -> addGroup(other_non_metallic, stack)//其他非金属
            9,17,35,53,85,117 -> addGroup(halogen, stack)//卤素
            2, 10, 18, 36, 54, 86, 118 -> addGroup(noble_gas, stack)//惰性气体
            in 57..71 -> addGroup(lanthanide_series, stack)//镧系
            in 89..103 -> addGroup(actinide_series, stack)//锕系
            else -> {}
                 */

                switch (value.proton) {
                    case 35,53,80 -> liquid.add(itemStack);
                    case 1,2, 7,8,9,10,17,18,36,54,86 -> gas.add(itemStack);
                    default -> solid.add(itemStack);
                }
                element.add(itemStack);
            }

        }
    }
}
