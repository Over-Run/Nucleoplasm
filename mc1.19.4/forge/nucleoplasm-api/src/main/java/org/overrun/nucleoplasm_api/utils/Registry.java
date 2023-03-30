package org.overrun.nucleoplasm_api.utils;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class Registry<T> {
    private final DeferredRegister<T> register;
    public Registry(IForgeRegistry<T> registry, String modid) {
        this.register = DeferredRegister.create(registry, modid);
    }
    public RegistryObject<T> addT(String name, T t) {
        return register.register(name, () -> t);
    }

    public void register(IEventBus event) {
        register.register(event);
    }

}
