package org.overrun.nucleoplasm_api;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.overrun.nucleoplasm_api.utils.Registry;

import static org.overrun.nucleoplasm_api.Nucleoplasm_api.MODID;

public class ModAll {
    public static final Registry<Block> blocks = new Registry<>(ForgeRegistries.BLOCKS, MODID);
    public static final Registry<Item> items = new Registry<>(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> test_item = items.addT("test_item", new Item(new Item.Properties()));
    public static final RegistryObject<Block> test_block;
    public static final RegistryObject<Item> test_block_item;

    static {
        Block t = new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL));
        test_block = blocks.addT("test_block", t);
        test_block_item = items.addT("test_block", new BlockItem(t, new Item.Properties()));
    }
    public static void registerAll(IEventBus eventBus) {
        blocks.register(eventBus);
        items.register(eventBus);
    }

}
