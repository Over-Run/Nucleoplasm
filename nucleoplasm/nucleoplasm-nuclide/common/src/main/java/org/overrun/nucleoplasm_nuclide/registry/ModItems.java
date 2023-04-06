package org.overrun.nucleoplasm_nuclide.registry;

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
    public static final RegistrySupplier<ElementItem> HYDROGEN =
            registry.register(ModItems.hydrogen.name, ModItems.hydrogen.item);
    public static final RegistrySupplier<ElementItem> HELIUM =
            registry.register(ModItems.helium.name, ModItems.helium.item);
    public static final RegistrySupplier<ElementItem> LITHIUM =
            registry.register(ModItems.lithium.name, ModItems.lithium.item);
    public static final RegistrySupplier<ElementItem> BERYLLIUM =
            registry.register(ModItems.beryllium.name, ModItems.beryllium.item);
    public static final RegistrySupplier<ElementItem> BORON =
            registry.register(ModItems.boron.name, ModItems.boron.item);
    public static final RegistrySupplier<ElementItem> CARBON =
            registry.register(ModItems.carbon.name, ModItems.carbon.item);
    public static final RegistrySupplier<ElementItem> NITROGEN =
            registry.register(ModItems.nitrogen.name, ModItems.nitrogen.item);
    public static final RegistrySupplier<ElementItem> OXYGEN =
            registry.register(ModItems.oxygen.name, ModItems.oxygen.item);
    public static final RegistrySupplier<ElementItem> FLUORINE =
            registry.register(ModItems.fluorine.name, ModItems.fluorine.item);
    public static final RegistrySupplier<ElementItem> NEON =
            registry.register(ModItems.neon.name, ModItems.neon.item);
    public static final RegistrySupplier<ElementItem> SODIUM =
            registry.register(ModItems.sodium.name, ModItems.sodium.item);
    public static final RegistrySupplier<ElementItem> MAGNESIUM =
            registry.register(ModItems.magnesium.name, ModItems.magnesium.item);
    public static final RegistrySupplier<ElementItem> ALUMINIUM =
            registry.register(ModItems.aluminium.name, ModItems.aluminium.item);
    public static final RegistrySupplier<ElementItem> SILICON =
            registry.register(ModItems.silicon.name, ModItems.silicon.item);
    public static final RegistrySupplier<ElementItem> PHOSPHORUS =
            registry.register(ModItems.phosphorus.name, ModItems.phosphorus.item);
    public static final RegistrySupplier<ElementItem> SULFUR =
            registry.register(ModItems.sulfur.name, ModItems.sulfur.item);
    public static final RegistrySupplier<ElementItem> CHLORINE =
            registry.register(ModItems.chlorine.name, ModItems.chlorine.item);
    public static final RegistrySupplier<ElementItem> ARGON =
            registry.register(ModItems.argon.name, ModItems.argon.item);
    public static final RegistrySupplier<ElementItem> POTASSIUM =
            registry.register(ModItems.potassium.name, ModItems.potassium.item);
    public static final RegistrySupplier<ElementItem> CALCIUM =
            registry.register(ModItems.calcium.name, ModItems.calcium.item);
    public static final RegistrySupplier<ElementItem> SCANDIUM =
            registry.register(ModItems.scandium.name, ModItems.scandium.item);
    public static final RegistrySupplier<ElementItem> TITANIUM =
            registry.register(ModItems.titanium.name, ModItems.titanium.item);
    public static final RegistrySupplier<ElementItem> VANADIUM =
            registry.register(ModItems.vanadium.name, ModItems.vanadium.item);
    public static final RegistrySupplier<ElementItem> CHROMIUM =
            registry.register(ModItems.chromium.name, ModItems.chromium.item);
    public static final RegistrySupplier<ElementItem> MANGANESE =
            registry.register(ModItems.magnesium.name, ModItems.magnesium.item);
    public static final RegistrySupplier<ElementItem> IRON =
            registry.register(ModItems.iron.name, ModItems.iron.item);
    public static final RegistrySupplier<ElementItem> COBALT =
            registry.register(ModItems.cobalt.name, ModItems.cobalt.item);
    public static final RegistrySupplier<ElementItem> NICKEL =
            registry.register(ModItems.nickel.name, ModItems.nickel.item);
    public static final RegistrySupplier<ElementItem> COPPER =
            registry.register(ModItems.copper.name, ModItems.copper.item);
    public static final RegistrySupplier<ElementItem> ZINC =
            registry.register(ModItems.zinc.name, ModItems.zinc.item);
    public static final RegistrySupplier<ElementItem> GALLIUM =
            registry.register(ModItems.gallium.name, ModItems.gallium.item);
    public static final RegistrySupplier<ElementItem> GERMANIUM =
            registry.register(ModItems.germanium.name, ModItems.germanium.item);
    public static final RegistrySupplier<ElementItem> ARSENIC =
            registry.register(ModItems.arsenic.name, ModItems.arsenic.item);
    public static final RegistrySupplier<ElementItem> SELENIUM =
            registry.register(ModItems.selenium.name, ModItems.selenium.item);
    public static final RegistrySupplier<ElementItem> BROMINE =
            registry.register(ModItems.bromine.name, ModItems.bromine.item);
    public static final RegistrySupplier<ElementItem> KRYPTON =
            registry.register(ModItems.krypton.name, ModItems.krypton.item);
    public static final RegistrySupplier<ElementItem> RUBIDIUM =
            registry.register(ModItems.rubidium.name, ModItems.rubidium.item);
    public static final RegistrySupplier<ElementItem> STRONTIUM =
            registry.register(ModItems.strontium.name, ModItems.strontium.item);
    public static final RegistrySupplier<ElementItem> YTTRIUM =
            registry.register(ModItems.yttrium.name, ModItems.yttrium.item);
    public static final RegistrySupplier<ElementItem> ZIRCONIUM =
            registry.register(ModItems.zirconium.name, ModItems.zirconium.item);
    public static final RegistrySupplier<ElementItem> NIOBIUM =
            registry.register(ModItems.niobium.name, ModItems.niobium.item);
    public static final RegistrySupplier<ElementItem> MOLYBDENUM =
            registry.register(ModItems.molybdenum.name, ModItems.molybdenum.item);
    public static final RegistrySupplier<ElementItem> TECHNETIUM =
            registry.register(ModItems.technetium.name, ModItems.technetium.item);
    public static final RegistrySupplier<ElementItem> RUTHENIUM =
            registry.register(ModItems.ruthenium.name, ModItems.ruthenium.item);
    public static final RegistrySupplier<ElementItem> RHODIUM =
            registry.register(ModItems.rhodium.name, ModItems.rhodium.item);
    public static final RegistrySupplier<ElementItem> PALLADIUM =
            registry.register(ModItems.palladium.name, ModItems.palladium.item);
    public static final RegistrySupplier<ElementItem> SILVER =
            registry.register(ModItems.silver.name, ModItems.silver.item);
    public static final RegistrySupplier<ElementItem> CADMIUM =
            registry.register(ModItems.cadmium.name, ModItems.cadmium.item);
    public static final RegistrySupplier<ElementItem> INDIUM =
            registry.register(ModItems.indium.name, ModItems.indium.item);
    public static final RegistrySupplier<ElementItem> TIN =
            registry.register(ModItems.tin.name, ModItems.tin.item);
    public static final RegistrySupplier<ElementItem> ANTIMONY =
            registry.register(ModItems.antimony.name, ModItems.antimony.item);
    public static final RegistrySupplier<ElementItem> TELLURIUM =
            registry.register(ModItems.tellurium.name, ModItems.tellurium.item);
    public static final RegistrySupplier<ElementItem> IODINE =
            registry.register(ModItems.iodine.name, ModItems.iodine.item);
    public static final RegistrySupplier<ElementItem> XENON =
            registry.register(ModItems.xenon.name, ModItems.xenon.item);
    public static final RegistrySupplier<ElementItem> CESIUM =
            registry.register(ModItems.cesium.name, ModItems.cesium.item);
    public static final RegistrySupplier<ElementItem> BARIUM =
            registry.register(ModItems.barium.name, ModItems.barium.item);
    public static final RegistrySupplier<ElementItem> LANTHANUM =
            registry.register(ModItems.lanthanum.name, ModItems.lanthanum.item);
    public static final RegistrySupplier<ElementItem> CERIUM =
            registry.register(ModItems.cerium.name, ModItems.cerium.item);
    public static final RegistrySupplier<ElementItem> PRASEODYMIUM =
            registry.register(ModItems.praseodymium.name, ModItems.praseodymium.item);
    public static final RegistrySupplier<ElementItem> NEODYMIUM =
            registry.register(ModItems.neodymium.name, ModItems.neodymium.item);
    public static final RegistrySupplier<ElementItem> PROMETHIUM =
            registry.register(ModItems.promethium.name, ModItems.promethium.item);
    public static final RegistrySupplier<ElementItem> SAMARIUM =
            registry.register(ModItems.samarium.name, ModItems.samarium.item);
    public static final RegistrySupplier<ElementItem> EUROPIUM =
            registry.register(ModItems.europium.name, ModItems.europium.item);
    public static final RegistrySupplier<ElementItem> GADOLINIUM =
            registry.register(ModItems.gadolinium.name, ModItems.gadolinium.item);
    public static final RegistrySupplier<ElementItem> TERBIUM = registry.register(ModItems.terbium.name, ModItems.terbium.item);
    public static final RegistrySupplier<ElementItem> DYSPROSIUM = registry.register(ModItems.dysprosium.name, ModItems.dysprosium.item);
    public static final RegistrySupplier<ElementItem> HOLMIUM = registry.register(ModItems.holmium.name, ModItems.holmium.item);
    public static final RegistrySupplier<ElementItem> ERBIUM = registry.register(ModItems.erbium.name, ModItems.erbium.item);
    public static final RegistrySupplier<ElementItem> THULIUM = registry.register(ModItems.thulium.name, ModItems.thulium.item);
    public static final RegistrySupplier<ElementItem> YTTERBIUM = registry.register(ModItems.ytterbium.name, ModItems.ytterbium.item);
    public static final RegistrySupplier<ElementItem> LUTETIUM = registry.register(ModItems.lutetium.name, ModItems.lutetium.item);
    public static final RegistrySupplier<ElementItem> HAFNIUM = registry.register(ModItems.hafnium.name, ModItems.hafnium.item);
    public static final RegistrySupplier<ElementItem> TANTALUM = registry.register(ModItems.tantalum.name, ModItems.tantalum.item);
    public static final RegistrySupplier<ElementItem> TUNGSTEN = registry.register(ModItems.tungsten.name, ModItems.tungsten.item);
    public static final RegistrySupplier<ElementItem> RHENIUM = registry.register(ModItems.rhenium.name, ModItems.rhenium.item);
    public static final RegistrySupplier<ElementItem> OSMIUM = registry.register(ModItems.osmium.name, ModItems.osmium.item);
    public static final RegistrySupplier<ElementItem> IRIDIUM = registry.register(ModItems.iridium.name, ModItems.iridium.item);
    public static final RegistrySupplier<ElementItem> PLATINUM = registry.register(ModItems.platinum.name, ModItems.platinum.item);
    public static final RegistrySupplier<ElementItem> GOLD = registry.register(ModItems.gold.name, ModItems.gold.item);
    public static final RegistrySupplier<ElementItem> MERCURY = registry.register(ModItems.mercury.name, ModItems.mercury.item);
    public static void init() {
        registry.register();
    }
}
