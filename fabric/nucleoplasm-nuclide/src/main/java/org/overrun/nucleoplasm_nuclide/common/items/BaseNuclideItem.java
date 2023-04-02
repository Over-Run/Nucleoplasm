package org.overrun.nucleoplasm_nuclide.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

/**
 * @since 基本实现注册
 */
public class BaseNuclideItem extends Item {


    public BaseNuclideItem(Settings settings, int max_nuclear_mass_number) {
        super(settings);
    }


    @Override
    public ItemStack getDefaultStack() {
        ItemStack defaultStack = super.getDefaultStack();
        NbtCompound nbt = defaultStack.getNbt() != null ? defaultStack.getNbt() : new NbtCompound();
        String[] split = super.getTranslationKey().split("\\.");
        nbt.putInt("proton", proton(split[split.length - 1]));
        defaultStack.setNbt(nbt);
        return defaultStack;
    }
    public int proton(String name) {
        return switch (name) {
            case "hydrogen"         ->        1;
            case "helium"           ->        2;
            case "lithium"          ->        3;
            case "beryllium"        ->        4;
            case "boron"            ->        5;
            case "carbon"           ->        6;
            case  "nitrogen"        ->        7;
            case "oxygen"           ->        8;
            case "fluorine"         ->        9;
            case "neon"             ->       10;
            case "sodium"           ->       11;
            case "magnesium"        ->       12;
            case "aluminium"        ->       13;
            case "silicon"          ->       14;
            case "phosphorus"       ->       15;
            case "sulfur"           ->       16;
            case "chlorine"         ->       17;
            case "argon"            ->       18;
            case "potassium"        ->       19;
            case "calcium"          ->       20;
            case "scandium"         ->       21;
            case "titanium"         ->       22;
            case "vanadium"         ->       23;
            case "chromium"         ->       24;
            case "manganese"        ->       25;
            case "iron"             ->       26;
            case "cobalt"           ->       27;
            case "nickel"           ->       28;
            case "copper"           ->       29;
            case "zinc"             ->       30;
            case "gallium"          ->       31;
            case "germanium"        ->       32;
            case "arsenic"          ->       33;
            case "selenium"         ->       34;
            case "bromine"          ->       35;
            case "krypton"          ->       36;
            case "rubidium"         ->       37;
            case "strontium"        ->       38;
            case "yttrium"          ->       39;
            case "zirconium"        ->       40;
            case "niobium"          ->       41;
            case "molybdenum"       ->       42;
            case "technetium"       ->       43;
            case "ruthenium"        ->       44;
            case "rhodium"          ->       45;
            case "palladium"        ->       46;
            case "silver"           ->       47;
            case "cadmium"          ->       48;
            case "indium"           ->       49;
            case "tin"              ->       50;
            case "antimony"         ->       51;
            case "tellurium"        ->       52;
            case "iodine"           ->       53;
            case "xenon"            ->       54;
            case "cesium"           ->       55;
            case "barium"           ->       56;
            case "lanthanum"        ->       57;
            case "cerium"           ->       58;
            case "praseodymium"     ->       59;
            case "neodymium"        ->       60;
            case "promethium"       ->       61;
            case "samarium"         ->       62;
            case "europium"         ->       63;
            case "gadolinium"       ->       64;
            case "terbium"          ->       65;
            case "dysprosium"       ->       66;
            case "holmium"          ->       67;
            case "erbium"           ->       68;
            case "thulium"          ->       69;
            case "ytterbium"        ->       70;
            case "lutetium"         ->       71;
            case "hafnium"          ->       72;
            case "tantalum"         ->       73;
            case "tungsten"         ->       74;
            case "rhenium"          ->       75;
            case "osmium"           ->       76;
            case "iridium"          ->       77;
            case "platinum"         ->       78;
            case "gold"             ->       79;
            case "mercury"          ->       80;
            case "thallium"         ->       81;
            case "lead"             ->       82;
            case "bismuth"          ->       83;
            case "polonium"         ->       84;
            case "astatine"         ->       85;
            case "radon"            ->       86;
            case "francium"         ->       87;
            case "radium"           ->       88;
            case "actinium"         ->       89;
            case "thorium"          ->       90;
            case "protactinium"     ->       91;
            case "uranium"          ->       92;
            case "neptunium"        ->       93;
            case "plutonium"        ->       94;
            case "amenicium"        ->       95;
            case "curium"           ->       96;
            case "berkelium"        ->       97;
            case "californium"      ->       98;
            case "einsteinium"      ->       99;
            case "fermium"          ->      100;
            case "mendelevium"      ->      101;
            case "nobelium"         ->      102;
            case "lawrencium"       ->      103;
            case "rutherfordium"    ->      104;
            case "dubnium"          ->      105;
            case "seadorgium"       ->      106;
            case "bohrium"          ->      107;
            case "hassium"          ->      108;
            case "meitnerium"       ->      109;
            case "darmstadtium"     ->      110;
            case "roentgenium"      ->      111;
            case "copernicium"      ->      112;
            case "nihonium"         ->      113;
            case "flerovium"        ->      114;
            case "moscovium"        ->      115;
            case "livermorium"      ->      116;
            case "tennessine"       ->      117;
            case "oganesson"        ->      118;
            default                 ->        0;
        };
    }
}
