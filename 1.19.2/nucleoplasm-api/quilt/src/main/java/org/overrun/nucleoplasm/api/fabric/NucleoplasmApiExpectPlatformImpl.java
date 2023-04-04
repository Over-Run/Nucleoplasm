package org.overrun.nucleoplasm.api.fabric;

import org.overrun.nucleoplasm.api.NucleoplasmApiExpectPlatform;
import org.quiltmc.loader.api.QuiltLoader;

import java.nio.file.Path;

public class NucleoplasmApiExpectPlatformImpl {
    /**
     * This is our actual method to {@link NucleoplasmApiExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return QuiltLoader.getConfigDir();
    }
}
