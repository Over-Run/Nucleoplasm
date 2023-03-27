package org.overrun.nucleoplasm_api;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import org.overrun.nucleoplasm_api.sql.MySql;

import java.sql.SQLException;

import static org.overrun.nucleoplasm_api.utils.FinalUtil.LOGGER;
import static org.overrun.nucleoplasm_api.utils.FinalUtil.MODID;
import static org.overrun.nucleoplasm_api.utils.NoFinalUtil.dir;

@Mod(MODID)
public class Nucleoplasm_api {

    // Define mod id in a common place for everything to reference


    // Directly reference a slf4j logger

    // Create a Deferred Register to hold Blocks which will all be registered under the "nucleoplasm_api" namespace
//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
//    // Create a Deferred Register to hold Items which will all be registered under the "nucleoplasm_api" namespace
//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Creates a new Block with the id "nucleoplasm_api:example_block", combining the namespace and path
//    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
//    // Creates a new BlockItem with the id "nucleoplasm_api:example_block", combining the namespace and path
//    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));
    public Nucleoplasm_api() {

//        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

//        // Register the Deferred Register to the mod event bus so blocks get registered
//        BLOCKS.register(modEventBus);
//        // Register the Deferred Register to the mod event bus so items get registered
//        ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }
    private static MySql sql;

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
//        dir = event.getServer().getServerDirectory();
         sql = new MySql();
         

    }

    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
    }
    @SubscribeEvent
    public void onServerStopped(ServerStoppingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
    public static class ServerModEvents {
        @SubscribeEvent
        public static void onServerSetup(FMLDedicatedServerSetupEvent event) {
            LOGGER.info("HELLO FROM SERVER SETUP");
        }
    }
}
