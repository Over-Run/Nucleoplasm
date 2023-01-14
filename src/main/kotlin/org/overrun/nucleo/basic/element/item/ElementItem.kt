package org.overrun.nucleo.basic.element.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Text
import net.minecraft.text.Text.of
import net.minecraft.text.Text.translatable
import net.minecraft.world.World
import org.overrun.nucleo.Nucleoplasm
import org.overrun.nucleo.Nucleoplasm.toTranslationKey
import net.minecraft.text.Style.EMPTY as defaultStyle

class ElementItem(settings: Settings) : Item(settings) {
    val decayOut = HashMap<String, ArrayList<ItemStack?>>()
    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {

        stack!!.apply {
            val compound:NbtCompound
            (if (hasNbt()) {nbt!!.copy()} else NbtCompound()).also { compound = it }
            val t: Int

            nbt = compound.apply {
                if (!contains("create_tick")) {
                    putInt("create_tick", world!!.time.toInt())
                }
                setCustomName(
                    translatable("item.${toTranslationKey(compound.getString("translate"))}${compound.getInt("proton") + compound.getInt("neutron")}")
                        .setStyle(defaultStyle.withFont(Nucleoplasm.identifier("uniform")).withColor(0xFFFFFF))
                )
            }
            val pastTick = world!!.time - compound.getInt("create_tick")
            println(pastTick)

            if (pastTick >= compound.getDouble("mc_half_life").toInt()) {
                if (decayOut.containsKey("${compound.getInt("proton")}_${compound.getInt("neutron")}")) {
                    val itemStacks = decayOut["${compound.getInt("proton")}_${compound.getInt("neutron")}"]
                    for (i in 0 until itemStacks!!.size) {
                        if (i == 0) {
                            nbt = itemStacks[i]!!.nbt

                        }
                        entity!!.dropStack(itemStacks[i])
                    }
                }
            }




        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        if (stack != null) {
            stack.nbt!!.apply {
                tooltip!!.apply {
                    add(translatable("item.nucleoplasm.cf"))
                    add(of(String.format("%02d", (getInt("proton") + getInt("neutron")))))
                    add(of("    ${getString("abbreviation")}    "))
                    add(of(String.format("%02d", getInt("proton"))))
                    add(of(""))
                    add(of("decay:${getBoolean("decay")}"))
                    add(translatable("item.nucleoplasm.ram"))//relative_atomic_mass:
                    add(of("${getDouble("relative_atomic_mass")}"))
                    add(translatable("item.nucleoplasm.mc.half.life").append(of("${getDouble("mc_half_life")}")))
//                    add(of("mc_half_life:${getDouble("mc_half_life")}"))
                }
            }
        }
        super.appendTooltip(stack, world, tooltip, context)
    }

    override fun getName(stack: ItemStack?): Text {
        stack?.apply {
            var compound : NbtCompound
            (if (hasNbt()) nbt!! else NbtCompound()).also { compound = it }
            compound.apply {
                setCustomName(
                    translatable("item.${toTranslationKey(getString("translate"))}${compound.getInt("proton") + compound.getInt("neutron")}")
                        .setStyle(defaultStyle.withFont(Nucleoplasm.identifier("uniform")).withColor(0xFFFFFF))
                )
            }
        }
        return super.getName(stack)
    }

    override fun getTranslationKey(stack: ItemStack?): String {
        stack?.also { itemStack ->
            var compound : NbtCompound
            (if (itemStack.hasNbt()) itemStack.nbt!! else NbtCompound()).also { compound = it }
            compound.apply {
                itemStack.setCustomName(
                    translatable("item.${toTranslationKey(getString("translate"))}${compound.getInt("proton") + compound.getInt("neutron")}")
                        .setStyle(defaultStyle.withFont(Nucleoplasm.identifier("uniform")).withColor(0xFFFFFF))
                )
            }
        }
        return super.getTranslationKey(stack)
    }
}
