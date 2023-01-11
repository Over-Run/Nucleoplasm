package org.overrun.nucleo.command;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.block.Block;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.command.argument.BlockStateArgument;
import net.minecraft.command.argument.BlockStateArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;


public class SetBlocksCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment environment) {
        dispatcher.register(CommandManager.literal("/setblocks")
            .then( CommandManager.argument("pos1", BlockPosArgumentType.blockPos())
                .then(CommandManager.argument("pos2", BlockPosArgumentType.blockPos())
                    .then(CommandManager.argument("block", BlockStateArgumentType.blockState(commandRegistryAccess))
                        .executes(
                            context -> executes(
                                context.getSource(),
                                BlockPosArgumentType.getLoadedBlockPos(context, "pos1"),
                                BlockPosArgumentType.getLoadedBlockPos(context, "pos2"),
                                BlockStateArgumentType.getBlockState(context, "block")
                            )
                        )
                    )
                )
            )
        );
        dispatcher.register(CommandManager.literal("/set")
            .then(CommandManager.argument("block", BlockStateArgumentType.blockState(commandRegistryAccess))
                .executes(context -> executes(
                    context.getSource(),
                    BlockStateArgumentType.getBlockState(context, "block")
                ))));
    }

    public static int executes(ServerCommandSource source, BlockStateArgument blockState) {
        var world = source.getWorld();
        var player = source.getPlayer();
        if (player != null) {
            var t = player.getMainHandStack().getItem();
            if (t instanceof SelectItem) {
                BlockPos pos1 = ((SelectItem) t).getPos1();
                BlockPos pos2 = ((SelectItem) t).getPos2();
                var tps = tps(pos1, pos2);
                for (var temp : tps) {
                    blockState.setBlockState(world, temp, Block.NOTIFY_LISTENERS);
                    world.updateNeighbors(temp, blockState.getBlockState().getBlock());
                    source.sendFeedback(Text.translatable("commands.setblock.success", temp.getX(), temp.getY(), temp.getZ()), true);
                }
            } else {
                source.sendFeedback(Text.of("select item is not main hand"), true);
            }
        }
        return 1;
    }

    public static int executes(ServerCommandSource source, BlockPos pos1, BlockPos pos2, BlockStateArgument blockState) {
        var world = source.getWorld();
        var tps = tps(pos1, pos2);
        for (var temp : tps) {
            blockState.setBlockState(world, temp, Block.NOTIFY_LISTENERS);
            world.updateNeighbors(temp, blockState.getBlockState().getBlock());
            source.sendFeedback(Text.translatable("commands.setblock.success", temp.getX(), temp.getY(), temp.getZ()), true);
        }
        return 1;
    }

    public static Iterable<BlockPos> tps(BlockPos pos1, BlockPos pos2) {
        return BlockPos.iterate(pos1, pos2);
    }
}
