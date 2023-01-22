package org.overrun.nucleoplasm;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.overrun.nucleoplasm.item.NItemGroups;
import org.overrun.nucleoplasm.item.NbtAndGroupSettings;
import org.overrun.nucleoplasm.item.RegItem;
import org.slf4j.Logger;

import static org.overrun.nucleoplasm.Basic.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
@Mod.EventBusSubscriber
public final class Nucleoplasm {
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "nucleoplasm" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "nucleoplasm" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    static {
        RegItem.init(new ForgeNRegistry(ITEMS));
    }

    public Nucleoplasm() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the commonSetup method for modloading
//        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in

        ITEMS.register(modEventBus);
//        modEventBus.addListener(this::groupEvent);

//        MinecraftForge.EVENT_BUS.register(this);
    }

//    @SubscribeEvent
//    private static void commonSetup(final FMLCommonSetupEvent event) {
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public static void onServerStarting(ServerStartingEvent event) {
//    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event) {
//        }

        @SubscribeEvent
        public static void groupEvent(CreativeModeTabEvent.Register event) {
            NbtAndGroupSettings.init();
            for (NItemGroups value : NItemGroups.values()) {
                value.itemGroup = event.registerCreativeModeTab(new ResourceLocation(MOD_ID, value.name()), builder ->
                    value.register(builder)
                        .displayItems((pEnabledFeatures, pOutput, pDisplayOperatorCreativeTab) ->
                            pOutput.acceptAll(value.getStacks())));
            }
        }
    }
}
