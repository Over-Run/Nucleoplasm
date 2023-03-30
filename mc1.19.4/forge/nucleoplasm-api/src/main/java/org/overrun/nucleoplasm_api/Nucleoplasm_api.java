package org.overrun.nucleoplasm_api;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.overrun.nucleoplasm_api.utils.ModSettings;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Nucleoplasm_api.MODID)
public class Nucleoplasm_api {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "nucleoplasm_api";
    public static final String allModid = "nucleoplasm";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "nucleoplasm_api" namespace

    public Nucleoplasm_api() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//        ModAll.init(modEventBus);
        ModSettings.ModItems.register(modEventBus);

//        modEventBus.addListener(this::register);
//        MinecraftForge.EVENT_BUS.register(new Server());

        MinecraftForge.EVENT_BUS.register(this);


    }


//    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//    public static class Server {
//        public Server() {
//
//            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::register);
//        }
//        public void register(RegisterEvent event) {
//            registerAll.invokeT("test_item", new Item(new Item.Properties()));
//
//            event.register(ForgeRegistries.Keys.ITEMS, helper -> {
//                for (var entry : registerAll.itemsMap.entrySet()) {
//                    helper.register(new ResourceLocation(MODID, entry.getKey()), entry.getValue());
//                }
//            });
//
//        }
//    }
}
