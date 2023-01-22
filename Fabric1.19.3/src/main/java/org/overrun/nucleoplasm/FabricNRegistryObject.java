package org.overrun.nucleoplasm;

import org.overrun.nucleoplasm.api.NRegistryObject;

/**
 * the fabric NRegistryObject
 *
 * @author squid233
 * @since 1.0.0
 */
public final class FabricNRegistryObject<T> extends NRegistryObject<T> {
    private final T entry;

    public FabricNRegistryObject(String name, T entry) {
        super(name);
        this.entry = entry;
    }

    @Override
    public T get() {
        return entry;
    }
}
