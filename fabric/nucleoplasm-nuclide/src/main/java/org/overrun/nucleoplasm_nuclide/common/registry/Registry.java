package org.overrun.nucleoplasm_nuclide.common.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import org.overrun.nucleoplasm_nuclide.common.Nucleoplasm_nuclide;
import org.overrun.nucleoplasm_nuclide.common.enchantments.TestEnchantment;
import org.overrun.nucleoplasm_nuclide.common.items.BaseNuclideItem;

import java.util.Locale;

public class Registry {
    public enum RegistryEnchant {
        test_enchant(new TestEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, 1, EquipmentSlot.MAINHAND));
        private final Enchantment enchantment;
        RegistryEnchant(Enchantment enchantment) {
            this.enchantment = Utils.ENCHANTMENT_NUCLIDE_BLOCK_REGISTRY.add(name(), enchantment);
        }

        public static void init() {
            for (var value : values()) {
                Nucleoplasm_nuclide.logger.info("register " + value.name());
            }
        }

        public Enchantment getEnchantment() {
            return enchantment;
        }
    }
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
    public enum RegistryElementItem {

        ;
        private final BaseNuclideItem item;
        RegistryElementItem(BaseNuclideItem t) {
            this.item = Utils.ITEM_NUCLIDE_ITEM_REGISTRY.add(name().toLowerCase(Locale.ROOT), t);
        }

        public BaseNuclideItem getItem() {
            return item;
        }

        public static void init() {
            for (var value : values()) {
                Nucleoplasm_nuclide.logger.info("register " + value.name());
            }
        }
    }
}
