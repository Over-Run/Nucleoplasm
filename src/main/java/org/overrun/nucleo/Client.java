package org.overrun.nucleo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.overrun.nucleo.basic.element.remake.RegItem;
import org.overrun.nucleo.chemistry.equipment.block.ChemicalBlocks;

import static org.overrun.nucleo.basic.element.remake.RegItem.elementera;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModelPredicateProviderRegistry.register(elementera.getItem(),
            new Identifier("proton"),
            (itemStack, clientWorld, livingEntity, seed) -> {
            if (livingEntity == null) {
                return 0.0f;
            } else {
                NbtCompound nbt = itemStack.getNbt() != null ? itemStack.getNbt() : new NbtCompound();
                return nbt.contains("proton") ? nbt.getInt("proton") : 0.5f;
            }
            });

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
            ChemicalBlocks.test_tube_15_150.getBlock()
        );

    }

}
