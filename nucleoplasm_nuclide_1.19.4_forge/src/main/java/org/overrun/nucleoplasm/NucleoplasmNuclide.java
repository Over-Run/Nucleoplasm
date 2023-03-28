package org.overrun.nucleoplasm;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static org.overrun.nucleoplasm.NucleoplasmNuclide.MODID;


@Mod(MODID)
public class NucleoplasmNuclide {
    protected static final String MODID = "nucleoplasm_nuclide";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NucleoplasmNuclide() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
