package org.overrun.nucleoplasm_api.common.particles;

import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

public class NuclideParticleRegistry<T extends DefaultParticleType> extends NuclideBase {


    public NuclideParticleRegistry(NuclideBase base) {
        super(base.getModid());
    }
    public NuclideParticleRegistry() {
        super();
    }
    public NuclideParticleRegistry(String modid) {
        super(modid);
    }

    public T add(String name, T t) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(getModid(), name), t);
    }
}
