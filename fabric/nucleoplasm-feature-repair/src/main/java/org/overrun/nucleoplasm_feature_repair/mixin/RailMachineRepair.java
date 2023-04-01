package org.overrun.nucleoplasm_feature_repair.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//禁止粘液块附近放置铁轨，杜绝刷羊毛铁轨
@Mixin(BlockItem.class)
public class RailMachineRepair {
    @Inject(
            method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;",
            at = @At("RETURN")
    )
    public void place(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
        int r = 12;
        BlockPos placePos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        ItemStack stack = context.getStack();

        if (player != null) {
            World world = player.getWorld();
            for (int i = -12; i <= 12; i++) {
                if (i != 0) {
                    BlockPos pos1 = new BlockPos(placePos.getX() + i, placePos.getY(), placePos.getZ());
                    BlockPos pos2 = new BlockPos(placePos.getX(), placePos.getY() + i, placePos.getZ());
                    BlockPos pos3 = new BlockPos(placePos.getX(), placePos.getY(), placePos.getZ() + i);
                    hasSlimeBlock(player, world, pos1, stack, placePos);
                    hasSlimeBlock(player, world, pos2, stack, placePos);
                    hasSlimeBlock(player, world, pos3, stack, placePos);
                }
            }
        }

    }
    private void hasSlimeBlock(PlayerEntity player, World world, BlockPos pos, ItemStack stack, BlockPos placePos) {
        BlockState blockState = world.getBlockState(pos);
        if (
                stack.getItem() instanceof BlockItem blockItem
                        &&
                        (
                                blockItem.getBlock() instanceof AbstractRailBlock
                                        ||
                                        blockItem.getBlock() instanceof DyedCarpetBlock
                        )
        ) {
            if (blockState.getBlock() instanceof SlimeBlock || blockState.getBlock() instanceof PistonBlock) {
                world.setBlockState(placePos, Blocks.AIR.getDefaultState());
                player.giveItemStack(stack);

            }
        }

    }

}

