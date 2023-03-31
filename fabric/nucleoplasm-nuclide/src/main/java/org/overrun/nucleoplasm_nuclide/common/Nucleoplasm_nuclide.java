package org.overrun.nucleoplasm_nuclide.common;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.overrun.nucleoplasm_api.utils.NuclideBase;
import org.overrun.nucleoplasm_nuclide.common.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

public class Nucleoplasm_nuclide implements ModInitializer {
    public static final Logger logger = LoggerFactory.getLogger(MODID);
    @Override
    public void onInitialize() {
        Registry.RegistryBlock.init();
        Registry.RegistryItem.init();
    }
}
