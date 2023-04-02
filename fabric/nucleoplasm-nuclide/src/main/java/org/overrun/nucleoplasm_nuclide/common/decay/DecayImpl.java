package org.overrun.nucleoplasm_nuclide.common.decay;

import org.overrun.nucleoplasm_nuclide.common.decay.beta.DoubleJustBetaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.beta.DoubleNegativeBetaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.beta.JustBetaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.beta.NegativeBetaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.beta.electron.DoubleElectronCaptureDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.beta.electron.ElectronCaptureDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.conversion_with_atomic_nuclei.GammaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.conversion_with_atomic_nuclei.InternalConversionDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.conversion_with_atomic_nuclei.NuclearIsosteroidDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.SpontaneousFissionDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.neutron.DoubleDoubleNeutronEmissionDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.neutron.DoubleNeutronEmissionDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.neutron.NeutronEmissionDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.AlphaDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.ClusterDecay;
import org.overrun.nucleoplasm_nuclide.common.decay.nuclear_launch.proton.ProtonEmissionDecay;
import org.overrun.nucleoplasm_nuclide.common.items.BaseNuclideItem;

public class DecayImpl<T extends BaseNuclideItem> {
    public DecayImpl() {}
    public static <T extends BaseNuclideItem> DecayImpl<T> get(String decayType) {
        return switch (decayType) {
            case "β−"               -> new NegativeBetaDecay<>();
            case "2β−", "β−β−"      -> new DoubleNegativeBetaDecay<>();
            case "β+"               -> new JustBetaDecay<>();
            case "β+β+", "2β+"      -> new DoubleJustBetaDecay<>();
            case "μ"                -> new MiuDecay<>();
            case "α"                -> new AlphaDecay<>();
            case "n"                -> new NeutronEmissionDecay<>();
            case "2n"               -> new DoubleNeutronEmissionDecay<>();
            case "4n"               -> new DoubleDoubleNeutronEmissionDecay<>();
            case "p"                -> new ProtonEmissionDecay<>();
            case "SF"               -> new SpontaneousFissionDecay<>();
            case "ε", "EC"          -> new ElectronCaptureDecay<>();
            case "εε", "DEC"        -> new DoubleElectronCaptureDecay<>();
            case "CD"               -> new ClusterDecay<>();
            case "γ"                -> new GammaDecay<>();
            case "IT"               -> new NuclearIsosteroidDecay<>();
            case "IC"               -> new InternalConversionDecay<>();
            default                 -> new NullDecay<>();
        };
    }

}
