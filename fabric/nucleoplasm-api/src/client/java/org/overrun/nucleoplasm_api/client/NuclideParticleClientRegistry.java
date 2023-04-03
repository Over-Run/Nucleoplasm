package org.overrun.nucleoplasm_api.client;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle.Factory;
import net.minecraft.particle.DefaultParticleType;

public class NuclideParticleClientRegistry<T extends DefaultParticleType> {
    public void registryClient(ParticleFactoryRegistry registry, T t) {
        registry.register(t, Factory::new);
    }
}
