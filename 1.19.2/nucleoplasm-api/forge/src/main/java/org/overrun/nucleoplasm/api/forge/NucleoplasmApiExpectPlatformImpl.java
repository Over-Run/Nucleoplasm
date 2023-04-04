package org.overrun.nucleoplasm.api.forge;

import net.minecraftforge.fml.loading.FMLPaths;
import org.overrun.nucleoplasm.api.NucleoplasmApiExpectPlatform;

import java.nio.file.Path;

public class NucleoplasmApiExpectPlatformImpl {
    /**
     * This is our actual method to {@link NucleoplasmApiExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
