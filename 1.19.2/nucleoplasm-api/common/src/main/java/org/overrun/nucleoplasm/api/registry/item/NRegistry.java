package org.overrun.nucleoplasm.api.registry.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.overrun.nucleoplasm.api.NucleoplasmApi;

public class NRegistry<T> {
    private final DeferredRegister<T> register;
    public NRegistry(String modid,ResourceKey<Registry<T>> key) {
        register = DeferredRegister.create(modid, key);
    }
    public NRegistry(ResourceKey<Registry<T>> key) {
        register = DeferredRegister.create(NucleoplasmApi.MOD_ID, key);
    }

    public RegistrySupplier<T> add(String name, T t) {
        return register.register(name, () -> t);
    }
    public void register() {
        register.register();
    }
}
