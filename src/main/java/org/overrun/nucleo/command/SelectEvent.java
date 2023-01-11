package org.overrun.nucleo.command;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;

import static org.overrun.nucleo.Nucleoplasm.NAMESPACE;

public class SelectEvent {
    public static void register() {
        SelectItem item = Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "select_item"), new SelectItem(new Item.Settings()));
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            var item_1 = player.getMainHandStack().getItem();
            if (item_1 instanceof SelectItem && item_1.equals(item)) {
                ((SelectItem) item_1).setPos1(pos);
                player.sendMessage(Text.of("pos1 " +pos.getX() + " " + pos.getY() + " " + pos.getZ()));
            }
            return ActionResult.PASS;
        });
        UseItemCallback.EVENT.register((player, world, hand) -> {
            var item_1 = player.getMainHandStack().getItem();
            if (item_1 instanceof SelectItem && item_1.equals(item)) {
                var tps = player.getSteppingPos();
                var climb = player.getClimbingPos();
                ((SelectItem) item_1).setPos2(tps);
//                player.sendMessage(Text.of("pos2 " + player.getClimbingPos().get().getX() + " " + player.getClimbingPos().get().getY() + " " + player.getClimbingPos().get().getZ()));
                player.sendMessage(Text.of("pos2 " +tps.getX() + " " + tps.getY() + " " + tps.getZ()));
            }
            return TypedActionResult.pass(player.getMainHandStack());
        });
    }
}
