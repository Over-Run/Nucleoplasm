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
    rhodium(properties -> new ElementItem(new Item.Properties(), 44)),
    palladium(properties -> new ElementItem(new Item.Properties(), 45)),
    silver(properties -> new ElementItem(new Item.Properties(), 46)),
    cadmium(properties -> new ElementItem(new Item.Properties(), 47)),
    indium(properties -> new ElementItem(new Item.Properties(), 48)),
    tin(properties -> new ElementItem(new Item.Properties(), 49)),
    antimony(properties -> new ElementItem(new Item.Properties(), 50)),
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
    public static final RegistrySupplier<ElementItem> SELENIUM = registry.register(ModItems.selenium.name, ModItems.selenium.item);
    public static final RegistrySupplier<ElementItem> BROMINE = registry.register(ModItems.bromine.name, ModItems.bromine.item);
    public static final RegistrySupplier<ElementItem> KRYPTON = registry.register(ModItems.krypton.name, ModItems.krypton.item);
    public static final RegistrySupplier<ElementItem> RUBIDIUM = registry.register(ModItems.rubidium.name, ModItems.rubidium.item);
    public static final RegistrySupplier<ElementItem> STRONTIUM = registry.register(ModItems.strontium.name, ModItems.strontium.item);
    public static final RegistrySupplier<ElementItem> YTTRIUM = registry.register(ModItems.yttrium.name, ModItems.yttrium.item);
    public static final RegistrySupplier<ElementItem> ZIRCONIUM = registry.register(ModItems.zirconium.name, ModItems.zirconium.item);
    public static final RegistrySupplier<ElementItem> NIOBIUM = registry.register(ModItems.niobium.name, ModItems.niobium.item);
    public static final RegistrySupplier<ElementItem> MOLYBDENUM = registry.register(ModItems.molybdenum.name, ModItems.molybdenum.item);
    public static final RegistrySupplier<ElementItem> TECHNETIUM = registry.register(ModItems.technetium.name, ModItems.technetium.item);
    public static void init() {
        registry.register();
    }
}
