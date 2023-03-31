package org.overrun.nucleoplasm_api.common.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.impl.client.particle.ParticleFactoryRegistryImpl;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.client.particle.FireworksSparkParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.FlameParticle.Factory;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.overrun.nucleoplasm_api.utils.NuclideBase;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

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
    public void client(ParticleFactoryRegistry registry, T t) {
        registry.register(t, Factory::new);
    }
}
