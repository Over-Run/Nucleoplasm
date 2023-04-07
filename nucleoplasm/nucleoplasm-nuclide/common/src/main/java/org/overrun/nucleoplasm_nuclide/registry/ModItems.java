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
    element(properties -> new ElementItem(new Item.Properties(), -1)),
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
    francium(properties -> new ElementItem(new Item.Properties(), 87)),
    radium(properties -> new ElementItem(new Item.Properties(), 88)),
    actinium(properties -> new ElementItem(new Item.Properties(), 89)),
    thorium(properties -> new ElementItem(new Item.Properties(), 90)),
    protactinium(properties -> new ElementItem(new Item.Properties(), 91)),
    uranium(properties -> new ElementItem(new Item.Properties(), 92)),
    neptunium(properties -> new ElementItem(new Item.Properties(), 93)),
    plutonium(properties -> new ElementItem(new Item.Properties(), 94)),
    americium(properties -> new ElementItem(new Item.Properties(), 95)),
    curium(properties -> new ElementItem(new Item.Properties(), 96)),
    berkelium(properties -> new ElementItem(new Item.Properties(), 97)),
    californium(properties -> new ElementItem(new Item.Properties(), 98)),
    einsteinium(properties -> new ElementItem(new Item.Properties(), 99)),
    mendelevium(properties -> new ElementItem(new Item.Properties(), 100)),
    fermium(properties -> new ElementItem(new Item.Properties(), 101)),
    nobelium(properties -> new ElementItem(new Item.Properties(), 102)),
    lawrencium(properties -> new ElementItem(new Item.Properties(), 103)),
    rutherfordium(properties -> new ElementItem(new Item.Properties(), 104)),
    dubnium(properties -> new ElementItem(new Item.Properties(), 105)),
    seaborgium(properties -> new ElementItem(new Item.Properties(), 106)),
    bohrium(properties -> new ElementItem(new Item.Properties(), 107)),
    hassium(properties -> new ElementItem(new Item.Properties(), 108)),
    meitnerium(properties -> new ElementItem(new Item.Properties(), 109)),
    darmstadtium(properties -> new ElementItem(new Item.Properties(), 110)),
    roentgenium(properties -> new ElementItem(new Item.Properties(), 111)),
    copernicium(properties -> new ElementItem(new Item.Properties(), 112)),
    nihonium(properties -> new ElementItem(new Item.Properties(), 113)),
    flerovium(properties -> new ElementItem(new Item.Properties(), 114)),
    moscovium(properties -> new ElementItem(new Item.Properties(), 115)),
    livermorium(properties -> new ElementItem(new Item.Properties(), 116)),
    tennessine(properties -> new ElementItem(new Item.Properties(), 117)),
    oganesson(properties -> new ElementItem(new Item.Properties(), 118)),
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
    public static final RegistrySupplier<ElementItem> elementItem = register(element);
    public static final RegistrySupplier<ElementItem>
          //1A                                                                                                                          0
       /*1*/ H,/*2A*/                                                                                             /*3A  4A  5A  6A  7A*/He,
       /*2*/Li, Be,                                                                                                  B,  C,  N,  O,  F, Ne,
       /*3*/Na, Mg,/*3B*/                                                      /*4B  5B 6B  7B   8   8   8  1B  2B*/Al, Si,  P,  S, Cl, Ar,
       /*4*/ K, Ca, Sc,                                                         Ti,  V, Cr, Mn, Fe, Co, Ni, Cu, Zn, Ga, Ge, As, Se, Br, Kr,
       /*5*/Rb, Sr,  Y,                                                         Zr, Nb, Mo, Tc, Ru, Rh, Pd, Ag, Cd, In, Sn, Sb, Te,  I, Xe,
       /*6*/Cs, Ba, La, Ce, Pr, Nd, Pm, Sm, Eu, Gd, Tb, Dy, Ho, Er, Tm, Yb, Lu, Hf, Ta,  W, Re, Os, Ir, Pt, Au, Hg, Tl, Pb, Bi, Po, At, Rn,
       /*7*/Fr, Ra, Ac, Th, Pa,  U, Np, Pu, Am, Cm, Bk, Cf, Es, Fm, Md, No, Lr, Rf, Db, Sg, Bh, Hs, Mt, Ds, Rg, Cn, Nh, Fl, Mc, Lv, Ts, Og;

    static {
        H = register(hydrogen);
        He = register(helium);
        Li = register(lithium);
        Be = register(beryllium);
        B = register(boron);
        C = register(carbon);
        N = register(nitrogen);
        O = register(oxygen);
        F = register(fluorine);
        Ne = register(neon);
        Na = register(sodium);
        Mg = register(magnesium);
        Al = register(aluminium);
        Si = register(silicon);
        P = register(phosphorus);
        S = register(sulfur);
        Cl = register(chlorine);
        Ar = register(argon);
        K = register(potassium);
        Ca = register(calcium);
        Sc = register(scandium);
        Ti = register(titanium);
        V = register(vanadium);
        Cr = register(chromium);
        Mn = register(magnesium);
        Fe = register(iron);
        Co = register(cobalt);
        Ni = register(nickel);
        Cu = register(copper);
        Zn = register(zinc);
        Ga = register(gallium);
        Ge = register(germanium);
        As = register(arsenic);
        Se = register(selenium);
        Br = register(bromine);
        Kr = register(krypton);
        Rb = register(rubidium);
        Sr = register(strontium);
        Y = register(yttrium);
        Zr = register(zirconium);
        Nb = register(niobium);
        Mo = register(molybdenum);
        Tc = register(technetium);
        Ru = register(ruthenium);
        Rh =  register(rhodium);
        Pd = register(palladium);
        Ag = register(silver);
        Cd = register(cadmium);
        In = register(indium);
        Sn = register(tin);
        Sb = register(antimony);
        Te = register(tellurium);
        I = register(iodine);
        Xe = register(xenon);
        Cs = register(cesium);
        Ba = register(barium);
        La = register(lanthanum);
        Ce = register(cerium);
        Pr = register(praseodymium);
        Nd = register(neodymium);
        Pm = register(promethium);
        Sm = register(samarium);
        Eu = register(europium);
        Gd = register(gadolinium);
        Tb = register(terbium);
        Dy = register(dysprosium);
        Ho = register(holmium);
        Er = register(erbium);
        Tm = register(thulium);
        Yb = register(ytterbium);
        Lu = register(lutetium);
        Hf = register(hafnium);
        Ta = register(tantalum);
        W = register(tungsten);
        Re = register(rhenium);
        Os = register(osmium);
        Ir = register(iridium);
        Pt = register(platinum);
        Au = register(gold);
        Hg = register(mercury);
        Tl = register(thallium);
        Pb = register(lead);
        Bi = register(bismuth);
        Po = register(polonium);
        At = register(astatine);
        Rn = register(radon);
        Fr = register(francium);
        Ra = register(radium);
        Ac = register(actinium);
        Th = register(thorium);
        Pa = register(protactinium);
        U = register(uranium);
        Np = register(neptunium);
        Pu = register(plutonium);
        Am = register(americium);
        Cm = register(curium);
        Bk = register(berkelium);
        Cf = register(californium);
        Es = register(einsteinium);
        Fm = register(fermium);
        Md = register(mendelevium);
        No = register(nobelium);
        Lr = register(lawrencium);
        Rf = register(rutherfordium);
        Db = register(dubnium);
        Sg = register(seaborgium);
        Bh = register(bohrium);
        Hs = register(hassium);
        Mt = register(meitnerium);
        Ds = register(darmstadtium);
        Rg = register(roentgenium);
        Cn = register(copernicium);
        Nh = register(nihonium);
        Fl = register(flerovium);
        Mc = register(moscovium);
        Lv = register(livermorium);
        Ts = register(tennessine);
        Og = register(oganesson);

    }
    public static void init() {
        registry.register();
    }

    public static RegistrySupplier<ElementItem> register(ModItems item) {return registry.register(item.name, item.item);}
}
