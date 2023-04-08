package org.overrun.nucleoplasm_nuclide.decay;

import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

import static org.overrun.nucleoplasm_nuclide.registry.ModItems.*;

public class DecayUtils {
    public static final Map<Integer, Integer> mass_number = new HashMap<>();
    static {
        putArrayStep(1,2, 7,2);
        putArrayStep(3,4, 12,3);
        putArrayAdd(5,6,21);
        putArrayStep(7,8,24,1);
        putArrayStep(9,10,31,2);
        putArrayStep(11, 13, 37, 2);
        putArrayStep(14, 16, 44, 1);
        putArrayStep(17, 18, 51, 1);
        putArrayStep(19, 20, 56, 1);
        putArrayStep(21, 25, 61, 2);
        putArrayStep(26, 27, 75, 1);
        putArrayAdd(28, 29, 82);
        putArrayStep(30, 31, 85, 1);
        putArrayStep(32, 33, 90, 1);
        putArrayStep(34, 36, 95, 2);
        putArrayStep(37, 38, 103, 3);
        putArrayStep(39, 45, 109, 2);
        putArrayStep(46, 47, 129, 2);
        mass_number.put(48, 134);
        putArrayStep(49, 51, 137, 1);
        putArrayAdd(52, 53, 144);
        mass_number.put(54, 148);
        putArrayStep(55, 60, 152, 1);
        mass_number.put(61, 163);
        putArrayStep(62, 66, 166, 1);
        putArrayAdd(67, 68, 177);
        putArrayStep(69, 70, 181, 3);
        putArrayStep(71, 72, 188, 1);
        putArrayStep(73, 74, 194, 2);
        putArrayStep(75, 76, 199, 3);
        putArrayStep(77, 78, 205, 2);
        putArrayStep(79, 80, 210, 5);
        putArrayStep(81, 82, 217, 2);
        putArrayStep(83, 84, 224, 2);
        putArray(85, 86, 229);
        putArrayAdd(87, 88, 233);
        putArrayStep(89, 90, 236, 1);
        putArrayStep(91, 92, 239, 3);
        putArrayStep(93, 94, 244, 2);
        putArrayStep(95, 96, 248, 3);
        putArrayStep(97, 98, 253, 2);
        putArrayStep(99, 100, 257, 1);
        putArrayStep(101, 102, 260, 1);
        putArrayAdd(103, 104, 266);
        putArrayAdd(105, 106, 270);
        putArray(107, 108, 278);
        putArray(109, 110, 282);
        putArray(111, 112, 286);
        putArray(113, 115, 290);
        putArray(116, 118, 294);
    }
    public static void putArrayStep/*跳级递增*/(int key, int key2, int vaule, int step) {int v = vaule;for (int i = key;i <= key2; i++) {mass_number.put(i, v);v+=step+1;}}
    public static void putArrayAdd/*递增*/(int key, int key2, int value) {putArrayStep(key, key2, value, 0);}
    public static void putArray/*等同*/(int key, int key2, int value) {for (int i = key;i <= key2; i++) mass_number.put(i, value);}
    public static ItemStack getStack(int proton) {
        return new ItemStack(
                switch (proton) {
                    case 1  -> H.get();
                    case 2  -> He.get();
                    case 3  -> Li.get();
                    case 4  -> Be.get();
                    case 5  -> B.get();
                    case 6  -> C.get();
                    case 7  -> N.get();
                    case 8  -> O.get();
                    case 9  -> F.get();
                    case 10 -> Ne.get();
                    case 12 -> Na.get();
                    case 13 -> Mg.get();
                    case 14 -> Al.get();
                    case 15 -> Si.get();
                    case 16 -> P.get();
                    case 17 -> S.get();
                    case 18 -> Cl.get();
                    case 19 -> Ar.get();
                    case 20 -> K.get();
                    case 21 -> Ca.get();
                    case 22 -> Sc.get();
                    case 23 -> V.get();
                    case 24 -> Cr.get();
                    case 25 -> Mn.get();
                    case 26 -> Fe.get();
                    case 27 -> Co.get();
                    case 28 -> Ni.get();
                    case 29 -> Cu.get();
                    case 30 -> Zn.get();
                    case 31 -> Ga.get();
                    case 32 -> Ge.get();
                    case 33 -> As.get();
                    case 34 -> Se.get();
                    case 35 -> Br.get();
                    case 36 -> Kr.get();
                    case 37 -> Rb.get();
                    case 38 -> Sr.get();
                    case 39 -> Y.get();
                    case 40 -> Zr.get();
                    case 41 -> Nb.get();
                    case 42 -> Mo.get();
                    case 43 -> Tc.get();
                    case 44 -> Ru.get();
                    case 45 -> Rh.get();
                    case 46 -> Pd.get();
                    case 47 -> Ag.get();
                    case 48 -> Cd.get();
                    case 49 -> In.get();
                    case 50 -> Sn.get();
                    case 51 -> Sb.get();
                    case 52 -> Te.get();
                    case 53 -> I.get();
                    case 54 -> Xe.get();
                    case 55 -> Cs.get();
                    case 56 -> Ba.get();
                    case 57 -> La.get();
                    case 58 -> Ce.get();
                    case 59 -> Pr.get();
                    case 60 -> Nd.get();
                    case 61 -> Pm.get();
                    case 62 -> Sm.get();
                    case 63 -> Eu.get();
                    case 64 -> Gd.get();
                    case 65 -> Tb.get();
                    case 66 -> Dy.get();
                    case 67 -> Ho.get();
                    case 68 -> Er.get();
                    case 69 -> Tm.get();
                    case 70 -> Yb.get();
                    case 71 -> Lu.get();
                    case 72 -> Hf.get();
                    case 73 -> Ta.get();
                    case 74 -> W.get();
                    case 75 -> Re.get();
                    case 76 -> Os.get();
                    case 77 -> Ir.get();
                    case 78 -> Pt.get();
                    case 79 -> Au.get();
                    case 80 -> Hg.get();
                    case 81 -> Tl.get();
                    case 82 -> Pb.get();
                    case 83 -> Bi.get();
                    case 84 -> Po.get();
                    case 85 -> At.get();
                    case 86 -> Rn.get();
                    case 87 -> Fr.get();
                    case 88 -> Ra.get();
                    case 89 -> Ac.get();
                    case 90 -> Th.get();
                    case 91 -> Pa.get();
                    case 92 -> U.get();
                    case 93 -> Np.get();
                    case 94 -> Pu.get();
                    case 95 -> Am.get();
                    case 96 -> Cm.get();
                    case 97 -> Bk.get();
                    case 98 -> Cf.get();
                    case 99 -> Es.get();
                    case 100-> Fm.get();
                    case 101-> Md.get();
                    case 102-> No.get();
                    case 103-> Lr.get();
                    case 104-> Rf.get();
                    case 105-> Db.get();
                    case 106-> Sg.get();
                    case 107-> Bh.get();
                    case 108-> Hs.get();
                    case 109-> Mt.get();
                    case 110-> Ds.get();
                    case 111-> Rg.get();
                    case 112-> Cn.get();
                    case 113-> Nh.get();
                    case 114-> Fl.get();
                    case 115-> Mc.get();
                    case 116-> Lv.get();
                    case 117-> Ts.get();
                    case 118-> Og.get();
                    default -> elementItem.get();
                }
        );
    }
}
