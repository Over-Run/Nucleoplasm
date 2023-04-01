package org.overrun.nucleoplasm_nuclide.common.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

import static net.minecraft.text.Text.empty;

public class ElementItem extends Item {
    private final int proton;
    private final float max_nuclear_mass_number;
    private final float max_neutron;
    private final Map<Float, Long> decay;//nuclear_mass_number and timer
    private final @NotNull Map<Float, @NotNull DefaultedList<ItemStack>> decayOut;
    public ElementItem(Settings settings, int proton, int maxNeutron, float max_nuclear_mass_number, @NotNull Map<Float, Long> map, @NotNull Map<Float, @NotNull DefaultedList<ItemStack>> decayOut) {
        super(settings);
        this.proton = proton;
        this.decayOut = decayOut;
        this.max_neutron = max_nuclear_mass_number - proton;
        this.max_nuclear_mass_number = max_nuclear_mass_number;
        this.decay = map;
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack defaultStack = super.getDefaultStack();
        NbtCompound nbt = defaultStack.getNbt() != null ? defaultStack.getNbt() : new NbtCompound();
        nbt.putInt("proton", proton);
        nbt.putFloat("neutron", max_neutron);
        nbt.putFloat("nuclear_mass_number", max_nuclear_mass_number);
        defaultStack.setNbt(nbt);
        return defaultStack;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        NbtCompound nbt = stack.getNbt() != null ? stack.getNbt() : new NbtCompound();
        MinecraftServer server = entity.getServer();
        if (server != null && entity instanceof PlayerEntity player) {
            long second = server.getTimeReference() / 1000;
            if (!nbt.contains("create_time")) {
                nbt.putLong("create_time", second);
                stack.setNbt(nbt);
            }
            if (second - decay.get(nbt.getFloat("nuclear_mass_number")) >= nbt.getLong("create_time")) {
                DefaultedList<ItemStack> nuclearMassNumber = decayOut.get(nbt.getFloat("nuclear_mass_number"));
                int count = stack.getCount();
                player.getInventory().removeStack(slot);
                for (ItemStack itemStack : nuclearMassNumber) {
                    itemStack.setCount(count);
                    player.giveItemStack(itemStack);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        if (nbt != null) {
            tooltip.add(empty().append(Text.translatable("nuclide.tooltip.proton")).append(Text.of(String.valueOf(nbt.getInt("proton")))));
            tooltip.add(empty().append(Text.translatable("nuclide.tooltip.neutron")).append(Text.of(String.valueOf(nbt.getFloat("neutron")))));
            tooltip.add(empty().append(Text.translatable("nuclide.tooltip.nuclear.mass.number")).append(Text.of(String.valueOf(nbt.getFloat("nuclear_mass_number")))));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
