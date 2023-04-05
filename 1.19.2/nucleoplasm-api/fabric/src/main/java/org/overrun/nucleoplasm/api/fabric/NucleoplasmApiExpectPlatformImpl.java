package org.overrun.nucleoplasm.api.fabric;

import org.overrun.nucleoplasm.api.NucleoplasmApi;
import org.overrun.nucleoplasm.api.NucleoplasmApiExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class NucleoplasmApiExpectPlatformImpl {
    /**
     * This is our actual method to {@link NucleoplasmApiExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
