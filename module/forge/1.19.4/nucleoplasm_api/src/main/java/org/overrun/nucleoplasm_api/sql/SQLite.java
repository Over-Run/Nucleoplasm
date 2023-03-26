package org.overrun.nucleoplasm_api.sql;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.server.ServerStartingEvent;
import org.overrun.nucleoplasm_api.Nucleoplasm_api;

import javax.annotation.Nonnull;
import java.io.File;

public class SQLite {
    public final  File serverDir;
    public SQLite(File dir) {
        serverDir = new File(dir, "sqlite-lib");
        if (!serverDir.exists()) {
            serverDir.mkdirs();
        }
    }
}
