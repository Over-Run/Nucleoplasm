package org.overrun.nucleoplasm_feature_repair.mixin;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.overrun.nucleoplasm_api.common.Nucleoplasm_api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static org.overrun.nucleoplasm_api.common.Nucleoplasm_api.MODID;

@Mixin(PistonBlock.class)
public class RailMachineRepair {
    @Inject(method = "tryMove", at = @At("HEAD"))
    public void tryMove(World world, BlockPos pos, BlockState state, CallbackInfo ci) {
    }

}

