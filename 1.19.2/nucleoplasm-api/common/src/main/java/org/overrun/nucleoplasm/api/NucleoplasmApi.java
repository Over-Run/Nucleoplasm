package org.overrun.nucleoplasm.api;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registries;

import java.util.function.Supplier;

public class NucleoplasmApi {
    public static final String MOD_ID = "nucleoplasm_api";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));
    // Registering a new creative tab
    
    public static void init() {
        System.out.println(NucleoplasmApiExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
