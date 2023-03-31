package org.overrun.nucleoplasm_nuclide.common.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import org.overrun.nucleoplasm_nuclide.common.Nucleoplasm_nuclide;

import java.util.Locale;

public class Registry {
    public enum RegistryBlock {
        test_block(
                new Block(FabricBlockSettings.of(Material.STONE)),
                true
        ),
        ;
        private final Item item;
        RegistryBlock(Block block, boolean hasBlock) {
            item = Utils.BLOCK_NUCLIDE_BLOCK_REGISTRY.add(name(), block, hasBlock);
        }

        public Item getItem() {
            return item;
        }

        public static void init() {
            for (var value : values()) {
                Nucleoplasm_nuclide.logger.info("register " + value.name());
            }
        }

    }
    public enum RegistryItem {
        test_item(new Item(new Item.Settings())),
        ;
        private final Item item;
        RegistryItem(Item t) {

            this.item = Utils.ITEM_NUCLIDE_ITEM_REGISTRY.add(name().toLowerCase(Locale.ROOT), t);
        }

        public Item getItem() {
            return item;
        }

        public static void init() {
            for (var value : values()) {
                Nucleoplasm_nuclide.logger.info("register " + value.name());
            }
        }
    }
}
