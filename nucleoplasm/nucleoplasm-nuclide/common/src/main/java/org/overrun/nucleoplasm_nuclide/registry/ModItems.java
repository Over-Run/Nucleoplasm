package org.overrun.nucleoplasm_nuclide.registry;

import dev.architectury.platform.Mod;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import org.overrun.nucleoplasm_nuclide.item.ElementItem;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.overrun.nucleoplasm_nuclide.Nucleoplasm_nuclide.MOD_ID;

public enum ModItems {
    hydrogen(properties -> new ElementItem(new Item.Properties(), 1)),
    helium(properties -> new ElementItem(new Item.Properties(), 2)),
    lithium(properties -> new ElementItem(new Item.Properties(), 3)),
    beryllium(properties -> new ElementItem(new Item.Properties(), 4)),
    boron(properties -> new ElementItem(new Item.Properties(), 5)),
    carbon(properties -> new ElementItem(new Item.Properties(), 6)),
    nitrogen(properties -> new ElementItem(new Item.Properties(), 7)),
    oxygen(properties -> new ElementItem(new Item.Properties(), 8)),
    fluorine(properties -> new ElementItem(new Item.Properties(), 9)),
    neon(properties -> new ElementItem(new Item.Properties(), 10)),
    sodium(properties -> new ElementItem(new Item.Properties(), 11)),
    magnesium(properties -> new ElementItem(new Item.Properties(), 12)),
    aluminium(properties -> new ElementItem(new Item.Properties(), 13)),
    silicon(properties -> new ElementItem(new Item.Properties(), 14)),
    phosphorus(properties -> new ElementItem(new Item.Properties(), 15)),
    sulfur(properties -> new ElementItem(new Item.Properties(), 16)),
    chlorine(properties -> new ElementItem(new Item.Properties(), 17)),
    argon(properties -> new ElementItem(new Item.Properties(), 18)),
    potassium(properties -> new ElementItem(new Item.Properties(), 19)),
    calcium(properties -> new ElementItem(new Item.Properties(), 20)),
    scandium(properties -> new ElementItem(new Item.Properties(), 21)),
    titanium(properties -> new ElementItem(new Item.Properties(), 22)),
    vanadium(properties -> new ElementItem(new Item.Properties(), 23)),
    chromium(properties -> new ElementItem(new Item.Properties(), 24)),
    manganese(properties -> new ElementItem(new Item.Properties(), 25)),
    iron(properties -> new ElementItem(new Item.Properties(), 26)),
    cobalt(properties -> new ElementItem(new Item.Properties(), 27)),
    nickel(properties -> new ElementItem(new Item.Properties(), 28)),
    copper(properties -> new ElementItem(new Item.Properties(), 29)),
    zinc(properties -> new ElementItem(new Item.Properties(), 30)),
    gallium(properties -> new ElementItem(new Item.Properties(), 31)),
    germanium(properties -> new ElementItem(new Item.Properties(), 32)),
    arsenic(properties -> new ElementItem(new Item.Properties(), 33)),
    selenium(properties -> new ElementItem(new Item.Properties(), 34)),
    bromine(properties -> new ElementItem(new Item.Properties(), 35)),
    krypton(properties -> new ElementItem(new Item.Properties(), 36)),
    rubidium(properties -> new ElementItem(new Item.Properties(), 37)),
    strontium(properties -> new ElementItem(new Item.Properties(), 38)),
    yttrium(properties -> new ElementItem(new Item.Properties(), 39)),
    zirconium(properties -> new ElementItem(new Item.Properties(), 40)),
    niobium(properties -> new ElementItem(new Item.Properties(), 41)),
    molybdenum(properties -> new ElementItem(new Item.Properties(), 42)),
    technetium(properties -> new ElementItem(new Item.Properties(), 43)),
    ruthenium(properties -> new ElementItem(new Item.Properties(), 44)),
    rhodium(properties -> new ElementItem(new Item.Properties(), 45)),
    palladium(properties -> new ElementItem(new Item.Properties(), 46)),
    silver(properties -> new ElementItem(new Item.Properties(), 47)),
    cadmium(properties -> new ElementItem(new Item.Properties(), 48)),
    indium(properties -> new ElementItem(new Item.Properties(), 49)),
    tin(properties -> new ElementItem(new Item.Properties(), 50)),
    antimony(properties -> new ElementItem(new Item.Properties(), 51)),
    tellurium(properties -> new ElementItem(new Item.Properties(), 52)),
    iodine(properties -> new ElementItem(new Item.Properties(), 53)),
    xenon(properties -> new ElementItem(new Item.Properties(), 54)),
    cesium(properties -> new ElementItem(new Item.Properties(), 55)),
    barium(properties -> new ElementItem(new Item.Properties(), 56)),
    lanthanum(properties -> new ElementItem(new Item.Properties(), 57)),
    cerium(properties -> new ElementItem(new Item.Properties(), 58)),
    praseodymium(properties -> new ElementItem(new Item.Properties(), 59)),
    neodymium(properties -> new ElementItem(new Item.Properties(), 60)),
    promethium(properties -> new ElementItem(new Item.Properties(), 61)),
    samarium(properties -> new ElementItem(new Item.Properties(), 62)),
    europium(properties -> new ElementItem(new Item.Properties(), 63)),
    gadolinium(properties -> new ElementItem(new Item.Properties(), 64)),
    terbium(properties -> new ElementItem(new Item.Properties(), 65)),
    dysprosium(properties -> new ElementItem(new Item.Properties(), 66)),
    holmium(properties -> new ElementItem(new Item.Properties(), 67)),
    erbium(properties -> new ElementItem(new Item.Properties(), 68)),
    thulium(properties -> new ElementItem(new Item.Properties(), 69)),
    ytterbium(properties -> new ElementItem(new Item.Properties(), 70)),
    lutetium(properties -> new ElementItem(new Item.Properties(), 71)),
    hafnium(properties -> new ElementItem(new Item.Properties(), 72)),
    tantalum(properties -> new ElementItem(new Item.Properties(), 73)),
    tungsten(properties -> new ElementItem(new Item.Properties(), 74)),
    rhenium(properties -> new ElementItem(new Item.Properties(), 75)),
    osmium(properties -> new ElementItem(new Item.Properties(), 76)),
    iridium(properties -> new ElementItem(new Item.Properties(), 77)),
    platinum(properties -> new ElementItem(new Item.Properties(), 78)),
    gold(properties -> new ElementItem(new Item.Properties(), 79)),
    mercury(properties -> new ElementItem(new Item.Properties(), 80)),
    ;
    private final String name;
    private final Supplier<ElementItem> item;
    ModItems(Function<Item.Properties, ElementItem> items) {
        name = name().toLowerCase(Locale.ROOT);
        item = () -> items.apply(new Item.Properties());
    }

    public final Supplier<ElementItem> asItem() {
        return item;
    }

    public final ElementItem get() {
        return item.get();
    }
    public static final DeferredRegister<Item> registry = DeferredRegister.create(MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<ElementItem>
            HYDROGEN, HELIUM, LITHIUM, BERYLLIUM, BORON, CARBON,
            NITROGEN, OXYGEN, FLUORINE, NEON, SODIUM, MAGNESIUM,
            ALUMINIUM, SILICON, PHOSPHORUS, SULFUR, CHLORINE,
            ARGON, POTASSIUM, CALCIUM, SCANDIUM, TITANIUM,
            VANADIUM, CHROMIUM, MANGANESE, IRON, COBALT, NICKEL,
            COPPER, ZINC, GALLIUM, GERMANIUM, ARSENIC, SELENIUM,
            BROMINE, KRYPTON, RUBIDIUM, STRONTIUM, YTTRIUM,
            ZIRCONIUM,NIOBIUM, MOLYBDENUM, TECHNETIUM, RUTHENIUM,
            RHODIUM, PALLADIUM, SILVER, CADMIUM, INDIUM, TIN,
            ANTIMONY, TELLURIUM, IODINE, XENON, CESIUM,BARIUM,
            LANTHANUM, CERIUM, PRASEODYMIUM, NEODYMIUM, PROMETHIUM,
            SAMARIUM, EUROPIUM, GADOLINIUM, TERBIUM, DYSPROSIUM,
            HOLMIUM, ERBIUM, THULIUM, YTTERBIUM, LUTETIUM, HAFNIUM,
            TANTALUM, TUNGSTEN, RHENIUM, OSMIUM, IRIDIUM, PLATINUM,
            GOLD, MERCURY;

    static {
        HYDROGEN = register(ModItems.hydrogen);//H
        HELIUM = register(ModItems.helium);//He
        LITHIUM = register(ModItems.lithium);//Li
        BERYLLIUM = register(ModItems.beryllium);//Be
        BORON = register(ModItems.boron);//B
        CARBON = register(ModItems.carbon);//C
        NITROGEN = register(ModItems.nitrogen);//N
        OXYGEN = register(ModItems.oxygen);//O
        FLUORINE = register(ModItems.fluorine);//F
        NEON = register(ModItems.neon);//Ne
        SODIUM = register(ModItems.sodium);//Na
        MAGNESIUM = register(ModItems.magnesium);//Mg
        ALUMINIUM = register(ModItems.aluminium);//Al
        SILICON = register(ModItems.silicon);//Si
        PHOSPHORUS = register(ModItems.phosphorus);//P
        SULFUR = register(ModItems.sulfur);//S
        CHLORINE = register(ModItems.chlorine);//Cl
        ARGON = register(ModItems.argon);//Ar
        POTASSIUM = register(ModItems.potassium);//K
        CALCIUM = register(ModItems.calcium);//Ca
        SCANDIUM = register(ModItems.scandium);//Sc
        TITANIUM = register(ModItems.titanium);//Ti
        VANADIUM = register(ModItems.vanadium);//V
        CHROMIUM = register(ModItems.chromium);//Cr
        MANGANESE = register(ModItems.magnesium);//Mn
        IRON = register(ModItems.iron);//Fe
        COBALT = register(ModItems.cobalt);//Co
        NICKEL = register(ModItems.nickel);//Ni
        COPPER = register(ModItems.copper);//Cu
        ZINC = register(ModItems.zinc);//Zn
        GALLIUM = register(ModItems.gallium);//Ga
        GERMANIUM = register(ModItems.germanium);//Ge
        ARSENIC = register(ModItems.arsenic);//As
        SELENIUM = register(ModItems.selenium);//Se
        BROMINE = register(ModItems.bromine);//Br
        KRYPTON = register(ModItems.krypton);//Kr
        RUBIDIUM = register(ModItems.rubidium);//Ru
        STRONTIUM = register(ModItems.strontium);
        YTTRIUM = register(ModItems.yttrium);
        ZIRCONIUM = register(ModItems.zirconium);
        NIOBIUM = register(ModItems.niobium);
        MOLYBDENUM = register(ModItems.molybdenum);
        TECHNETIUM = register(ModItems.technetium);
        RUTHENIUM = register(ModItems.ruthenium);
        RHODIUM =  register(ModItems.rhodium);
        PALLADIUM = register(ModItems.palladium);
        SILVER = register(ModItems.silver);
        CADMIUM = register(ModItems.cadmium);
        INDIUM = register(ModItems.indium);
        TIN = register(ModItems.tin);
        ANTIMONY = register(ModItems.antimony);
        TELLURIUM = register(ModItems.tellurium);
        IODINE = register(ModItems.iodine);
        XENON = register(ModItems.xenon);
        CESIUM = register(ModItems.cesium);
        BARIUM = register(ModItems.barium);
        LANTHANUM = register(ModItems.lanthanum);
        CERIUM = register(ModItems.cerium);
        PRASEODYMIUM = register(ModItems.praseodymium);
        NEODYMIUM = register(ModItems.neodymium);
        PROMETHIUM = register(ModItems.promethium);
        SAMARIUM = register(ModItems.samarium);
        EUROPIUM = register(ModItems.europium);
        GADOLINIUM = register(ModItems.gadolinium);
        TERBIUM = register(ModItems.terbium);
        DYSPROSIUM = register(ModItems.dysprosium);
        HOLMIUM = register(ModItems.holmium);
        ERBIUM = register(ModItems.erbium);
        THULIUM = register(ModItems.thulium);
        YTTERBIUM = register(ModItems.ytterbium);
        LUTETIUM = register(ModItems.lutetium);
        HAFNIUM = register(ModItems.hafnium);
        TANTALUM = register(ModItems.tantalum);
        TUNGSTEN = register(ModItems.tungsten);
        RHENIUM = register(ModItems.rhenium);
        OSMIUM = register(ModItems.osmium);
        IRIDIUM = register(ModItems.iridium);
        PLATINUM = register(ModItems.platinum);
        GOLD = register(ModItems.gold);//Au
        MERCURY = register(ModItems.mercury);//Hg
    }
    public static void init() {
        registry.register();
    }

    public static RegistrySupplier<ElementItem> register(ModItems item) {return registry.register(item.name, item.item);}
}
