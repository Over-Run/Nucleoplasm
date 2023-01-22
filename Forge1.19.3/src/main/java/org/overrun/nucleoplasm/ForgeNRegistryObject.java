package org.overrun.nucleoplasm;

import org.overrun.nucleoplasm.api.NRegistryObject;

import java.util.function.Supplier;

/**
 * the forge NRegistryObject
 *
 * @author squid233
 * @since 1.0.0
 */
public final class ForgeNRegistryObject<T> extends NRegistryObject<T> {
    private final Supplier<T> supplier;

    public ForgeNRegistryObject(String name, Supplier<T> supplier) {
        super(name);
        this.supplier = supplier;
    }

    @Override
    public T get() {
        return supplier.get();
    }
}
