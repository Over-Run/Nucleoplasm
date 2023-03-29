package org.overrun.nucleoplasm_api;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.javafmlmod.FMLModContainer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.overrun.nucleoplasm_api.utils.RegisterAll;
import org.slf4j.Logger;

import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Nucleoplasm_api.MODID)
public class Nucleoplasm_api {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "nucleoplasm_api";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final RegisterAll registerAll = new RegisterAll();
    // Create a Deferred Register to hold Blocks which will all be registered under the "nucleoplasm_api" namespace

    public Nucleoplasm_api() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        modEventBus.addListener(this::register);
        MinecraftForge.EVENT_BUS.register(new Server());
        MinecraftForge.EVENT_BUS.register(this);

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Server {
        public Server() {

            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::register);
        }
        public void register(RegisterEvent event) {

            event.register(ForgeRegistries.Keys.ITEMS, helper -> {
                registerAll.invokeT("test_item", new Item(new Item.Properties()));
                for (var entry : registerAll.itemsMap.entrySet()) {
                    helper.register(new ResourceLocation(MODID, entry.getKey()), entry.getValue());
                }
            });
        }
    }
}
