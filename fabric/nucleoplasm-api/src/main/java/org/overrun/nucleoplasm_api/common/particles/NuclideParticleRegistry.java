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

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideParticleRegistry<T extends DefaultParticleType> {
    private final String modid;
    public NuclideParticleRegistry() {
        modid = MODID;
    }
    public NuclideParticleRegistry(String modid) {
        this.modid = modid;
    }

    public T add(String name, T t) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(modid, name), t);
    }
    public void client(ParticleFactoryRegistry registry, T t) {
        registry.register(t, Factory::new);
    }
}
