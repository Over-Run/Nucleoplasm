package org.overrun.nucleoplasm.api;

import java.util.function.Supplier;

/**
 * the registry object wrapper
 *
 * @author squid233
 * @since 1.0.0
 */
public abstract class NRegistryObject<T> implements Supplier<T> {
    private final String name;

    public NRegistryObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract T get();
}
