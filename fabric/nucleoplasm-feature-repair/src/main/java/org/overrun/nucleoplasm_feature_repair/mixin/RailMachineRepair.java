package org.overrun.nucleoplasm_feature_repair.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.overrun.nucleoplasm_api.common.Nucleoplasm_api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

@Mixin(BlockItem.class)
public class RailMachineRepair {
    Logger logger = LoggerFactory.getLogger(MODID);
    @Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;", at = @At("RETURN"), cancellable = true)
    public void place(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        BlockPos blockPos1 = context.getBlockPos();
        BlockPos blockPos = new BlockPos(blockPos1.getX(), blockPos1.getY()  - 1, blockPos1.getZ());
        PlayerEntity player = context.getPlayer();
        if (player != null) {
            World world = player.getWorld();
            ItemStack stack = context.getStack();
            BlockItem item = (BlockItem) stack.getItem();
            if (item.getBlock() instanceof AbstractRailBlock) {
                if (world.getBlockState(blockPos).getBlock() instanceof SlimeBlock s) {
                    world.setBlockState(blockPos1, Blocks.AIR.getDefaultState());
                    player.giveItemStack(stack);
                }
            }
        }
    }


}

