package org.overrun.nucleoplasm_nuclide.common.decay;

import net.minecraft.util.collection.DefaultedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

public class DecaySettings {
    public enum Settings {
        hydrogen();
        final String lower_name;
        Settings() {
            lower_name = name().toLowerCase(Locale.ROOT);

        }

        public String lower_name() {
            return lower_name;
        }
    }

}
