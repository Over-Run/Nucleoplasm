package org.overrun.nucleoplasm_nuclide.common.decay;

import java.util.Locale;

public class DecaySettings {
    public enum Settings {
        ;
        final String lower_name;
        Settings() {
            lower_name = name().toLowerCase(Locale.ROOT);
        }

        public String lower_name() {
            return lower_name;
        }
    }
}
