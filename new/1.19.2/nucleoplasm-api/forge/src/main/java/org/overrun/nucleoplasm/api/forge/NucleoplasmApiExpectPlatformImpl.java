package org.overrun.nucleoplasm.api.forge;

import org.overrun.nucleoplasm.api.NucleoplasmApiExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class NucleoplasmApiExpectPlatformImpl {
    /**
     * This is our actual method to {@link NucleoplasmApiExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
