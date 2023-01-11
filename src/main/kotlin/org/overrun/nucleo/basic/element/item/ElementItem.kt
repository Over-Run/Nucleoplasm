package org.overrun.nucleo.basic.element.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.text.Text.of
import net.minecraft.text.Text.translatable
import net.minecraft.world.World
import org.overrun.nucleo.Nucleoplasm
import org.overrun.nucleo.Nucleoplasm.toTranslationKey

class ElementItem(settings: Settings) : Item(settings) {
    val timer = HashMap<String, HashMap<Int, HashMap<Int, Int>>>()
    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {

//        val decayJson = ElementGroup.jsonDefine.decayJson
//        println(decayJson)

        super.inventoryTick(stack, world, entity, slot, selected)
    }

    val itemStacksMap = HashMap<Int, HashMap<Int, HashMap<Int, HashMap<Float, List<ItemStack?>>>>>()

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
                    add(of("mc_half_life:${getDouble("mc_half_life")}"))
                }
            }
        }
        super.appendTooltip(stack, world, tooltip, context)
    }

    override fun getName(stack: ItemStack?): Text {
        stack?.apply {
            var nbt_ : NbtCompound
            (if (hasNbt()) nbt!! else NbtCompound()).also { nbt_ = it }
            nbt_.apply {
                setCustomName(
                    translatable("item.${toTranslationKey(getString("translate"))}${nbt_.getInt("proton") + nbt_.getInt("neutron")}")
                        .setStyle(
                            Style.EMPTY.withFont(Nucleoplasm.identifier("uniform")).withColor(0xFFFFFF))

                )
            }
        }
        return super.getName(stack)
    }
}
