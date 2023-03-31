package org.overrun.nucleoplasm_feature_repair.mixin;

import net.minecraft.block.RailBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class RailMachineRepair {
    @Inject(method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;", at = @At("HEAD"), cancellable = true)
    public void place(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        BlockPos blockPos1 = context.getBlockPos();
        BlockPos blockPos = new BlockPos(blockPos1.getX(), blockPos1.getY(), blockPos1.getZ() - 1);
        PlayerEntity player = context.getPlayer();

        if (player != null) {
            World world = player.getWorld();
            Item item = context.getStack().getItem();

            if (
                    item.equals(Items.RAIL)
                    || item.equals(Items.ACTIVATOR_RAIL)
                    || item.equals(Items.POWERED_RAIL)
                    || item.equals(Items.DETECTOR_RAIL)
            ) {
                if (world.getBlockState(blockPos).getBlock() instanceof SlimeBlock) {
                    cir.setReturnValue(ActionResult.FAIL);
                }
            }
        }
    }
}

