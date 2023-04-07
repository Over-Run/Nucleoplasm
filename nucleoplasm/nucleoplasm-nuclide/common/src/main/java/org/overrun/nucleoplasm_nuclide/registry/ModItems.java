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
    thallium(properties -> new ElementItem(new Item.Properties(), 81)),
    lead(properties -> new ElementItem(new Item.Properties(), 82)),
    bismuth(properties -> new ElementItem(new Item.Properties(), 83)),
    polonium(properties -> new ElementItem(new Item.Properties(), 84)),
    astatine(properties -> new ElementItem(new Item.Properties(), 85)),
    radon(properties -> new ElementItem(new Item.Properties(), 86)),
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
             H,                                                                                                                         He,
            Li, Be,                                                                                                  B,  C,  N,  O,  F, Ne,
            Na, Mg,                                                                                                 Al, Si,  P,  S, Cl, Ar,
             K, Ca, Sc,                                                         Ti,  V, Cr, Mn, Fe, Co, Ni, Cu, Zn, Ga, Ge, As, Se, Br, Kr,
            Rb, Sr,  Y,                                                         Zr, Nb, Mo, Tc, Ru, Rh, Pd, Ag, Cd, In, Sn, Sb, Te,  I, Xe,
            Cs, Ba, La, Ce, Pr, Nd, Pm, Sm, Eu, Gd, Tb, Dy, Ho, Er, Tm, Yb, Lu, Hf, Ta,  W, Re, Os, Ir, Pt, Au, Hg, Tl, Pb, Bi, Po, At, Rn;

    static {
        H = register(ModItems.hydrogen);//H
        He = register(ModItems.helium);//He
        Li = register(ModItems.lithium);//Li
        Be = register(ModItems.beryllium);//Be
        B = register(ModItems.boron);//B
        C = register(ModItems.carbon);//C
        N = register(ModItems.nitrogen);//N
        O = register(ModItems.oxygen);//O
        F = register(ModItems.fluorine);//F
        Ne = register(ModItems.neon);//Ne
        Na = register(ModItems.sodium);//Na
        Mg = register(ModItems.magnesium);//Mg
        Al = register(ModItems.aluminium);//Al
        Si = register(ModItems.silicon);//Si
        P = register(ModItems.phosphorus);//P
        S = register(ModItems.sulfur);//S
        Cl = register(ModItems.chlorine);//Cl
        Ar = register(ModItems.argon);//Ar
        K = register(ModItems.potassium);//K
        Ca = register(ModItems.calcium);//Ca
        Sc = register(ModItems.scandium);//Sc
        Ti = register(ModItems.titanium);//Ti
        V = register(ModItems.vanadium);//V
        Cr = register(ModItems.chromium);//Cr
        Mn = register(ModItems.magnesium);//Mn
        Fe = register(ModItems.iron);//Fe
        Co = register(ModItems.cobalt);//Co
        Ni = register(ModItems.nickel);//Ni
        Cu = register(ModItems.copper);//Cu
        Zn = register(ModItems.zinc);//Zn
        Ga = register(ModItems.gallium);//Ga
        Ge = register(ModItems.germanium);//Ge
        As = register(ModItems.arsenic);//As
        Se = register(ModItems.selenium);//Se
        Br = register(ModItems.bromine);//Br
        Kr = register(ModItems.krypton);//Kr
        Rb = register(ModItems.rubidium);//Ru
        Sr = register(ModItems.strontium);
        Y = register(ModItems.yttrium);
        Zr = register(ModItems.zirconium);
        Nb = register(ModItems.niobium);
        Mo = register(ModItems.molybdenum);
        Tc = register(ModItems.technetium);
        Ru = register(ModItems.ruthenium);
        Rh =  register(ModItems.rhodium);
        Pd = register(ModItems.palladium);
        Ag = register(ModItems.silver);
        Cd = register(ModItems.cadmium);
        In = register(ModItems.indium);
        Sn = register(ModItems.tin);
        Sb = register(ModItems.antimony);
        Te = register(ModItems.tellurium);
        I = register(ModItems.iodine);
        Xe = register(ModItems.xenon);
        Cs = register(ModItems.cesium);
        Ba = register(ModItems.barium);
        La = register(ModItems.lanthanum);
        Ce = register(ModItems.cerium);
        Pr = register(ModItems.praseodymium);
        Nd = register(ModItems.neodymium);
        Pm = register(ModItems.promethium);
        Sm = register(ModItems.samarium);
        Eu = register(ModItems.europium);
        Gd = register(ModItems.gadolinium);
        Tb = register(ModItems.terbium);
        Dy = register(ModItems.dysprosium);
        Ho = register(ModItems.holmium);
        Er = register(ModItems.erbium);
        Tm = register(ModItems.thulium);
        Yb = register(ModItems.ytterbium);
        Lu = register(ModItems.lutetium);
        Hf = register(ModItems.hafnium);
        Ta = register(ModItems.tantalum);
        W = register(ModItems.tungsten);
        Re = register(ModItems.rhenium);
        Os = register(ModItems.osmium);
        Ir = register(ModItems.iridium);
        Pt = register(ModItems.platinum);
        Au = register(ModItems.gold);//Au
        Hg = register(ModItems.mercury);//Hg
        Tl = register(ModItems.thallium);
        Pb = register(ModItems.lead);
        Bi = register(ModItems.bismuth);
        Po = register(ModItems.polonium);
        At = register(ModItems.astatine);
        Rn = register(ModItems.radon);
    }
    public static void init() {
        registry.register();
    }

    public static RegistrySupplier<ElementItem> register(ModItems item) {return registry.register(item.name, item.item);}
}
