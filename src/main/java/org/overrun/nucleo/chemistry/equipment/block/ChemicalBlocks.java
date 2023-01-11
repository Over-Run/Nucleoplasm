package org.overrun.nucleo.chemistry.equipment.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.BLOCK;
import static net.minecraft.registry.Registries.ITEM;
import static net.minecraft.registry.Registry.register;
import static org.overrun.nucleo.Nucleoplasm.NAMESPACE;

public enum ChemicalBlocks {
    test_tube_15_150(new TestTube(FabricBlockSettings.of(Material.GLASS), 15,150),
        new FabricItemSettings())
    ;
    private final Identifier id;
    private final String entryName;
    private final Block block;
    private final Item item;
    ChemicalBlocks(Block block, FabricItemSettings item) {

        this.entryName = name();
        this.id = new Identifier(NAMESPACE, entryName);
        this.block = block;
        this.item = new BlockItem(this.block, item);
    }

    public String getEntryName() {
        return entryName;
    }

    public Identifier getId() {
        return id;
    }

    public Block getBlock() {
        return block;
    }

    public Item getItem() {
        return item;
    }

    public static void regChemicalBlocks() {
        for (var v : values()) {
            register(BLOCK, v.id, v.block);
            register(ITEM, v.id, v.item);
        }
    }
}
