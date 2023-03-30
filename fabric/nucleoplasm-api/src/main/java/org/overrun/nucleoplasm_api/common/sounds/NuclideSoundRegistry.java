package org.overrun.nucleoplasm_api.common.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class NuclideSoundRegistry {
    private final String modid;
    public NuclideSoundRegistry() {
        this.modid = MODID;
    }
    public NuclideSoundRegistry(String modid) {
        this.modid = modid;
    }

    public SoundEvent add(String name) {
        var id = new Identifier(modid, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

}
