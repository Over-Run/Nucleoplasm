package org.overrun.nucleo;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;
import org.overrun.nucleo.basic.element.groups.ElementGroup;
import org.overrun.nucleo.basic.element.remake.RegItem;
import org.overrun.nucleo.chemistry.equipment.block.ChemicalBlocks;
import org.overrun.nucleo.command.SelectEvent;
import org.overrun.nucleo.command.SetBlocksCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@code 从现在开始配置基础完毕}
 *
 * @author baka4n
 * @since 1.0.0
 */
public final class Nucleoplasm implements ModInitializer {
    public static final String NAMESPACE = "nucleoplasm";
    public static final Logger logger = LoggerFactory.getLogger("Nucleoplasm");

    public static Identifier identifier(String path) {
        return new Identifier(NAMESPACE, path);
    }
    public static String toTranslationKey(String path) {
        return identifier(path).toTranslationKey();
    }

    @Override
    public void onInitialize() {
        SelectEvent.register();
        CommandRegistrationCallback.EVENT.register(SetBlocksCommand::register);
        RegItem.init();



        ElementGroup.INSTANCE.initGroup();
        ChemicalBlocks.regChemicalBlocks();

    }
}
