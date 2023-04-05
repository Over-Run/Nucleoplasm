package org.overrun.nucleoplasm.nuclide.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.overrun.nucleoplasm.nuclide.NucleoplasmNuclide;

import static org.overrun.nucleoplasm.nuclide.NucleoplasmNuclide.MOD_ID;

@Mod(MOD_ID)
public class NucleoplasmNuclideForge {

    public NucleoplasmNuclideForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        NucleoplasmNuclide.init();
    }
}
