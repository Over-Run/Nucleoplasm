package org.overrun.nucleo.basic.element.item

import net.fabricmc.loader.api.FabricLoader
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
import java.io.File
import java.io.FileOutputStream
import java.security.MessageDigest
import java.util.*
import net.minecraft.text.Style.EMPTY as defaultStyle

class ElementItem(settings: Settings) : Item(settings) {
    val decayOut = HashMap<String, ArrayList<ItemStack?>>()
    val properties: Properties = Properties()
    val file = FabricLoader.getInstance().configDir.resolve("decay").toFile()
    val path = File(file, MessageDigest.getInstance("MD5").apply {
        val apply = MessageDigest.getInstance("MD5").apply {
            update((Nucleoplasm.NAMESPACE.toByte()))
        }
        update(apply.toString().toByte())
    }.toString())
    init {

        if (!file.exists()) file.mkdirs()

        if (!path.exists()) {
            path.createNewFile()
        }
        properties.load(path.inputStream())
    }

    private fun getUUidDecay(key: String): Int {
        val instance = MessageDigest.getInstance("MD5").apply {
            update(key.toByte())
        }.toString()
        if (properties.contains(instance)) {
            return properties.getProperty(instance).toInt()
        }
        return Int.MIN_VALUE
    }
    private fun addAndSave(key:String, value:Int) {
        val instance = MessageDigest.getInstance("MD5").apply {
            update(key.toByte())
        }.toString()
        properties.setProperty(instance, value.toString())
        properties.store(FileOutputStream(path), "by baka4n")
    }
    override fun inventoryTick(stack: ItemStack?, world: World?, entity: Entity?, slot: Int, selected: Boolean) {

        var compound: NbtCompound
        var uidDecay:Int
//        val decayJson = ElementGroup.jsonDefine.decayJson
//        println(decayJson)
        stack!!.apply {
            compound = nbt!!.copy()//copy nbt
            compound.apply {
                if (!contains("decay_uid")) {
                    val uid = UUID.randomUUID().toString()
                    putString("decay_uid", uid)
                    addAndSave(uid, 0)
                }
            }
            nbt = compound // write nbt
        }
        stack.apply {
            compound = nbt!!.copy().apply {
                if (getBoolean("decay")) {
                    if (properties.containsKey(getString("decay_uid"))) {
                        uidDecay = getUUidDecay(getString("decay_uid"))
                        addAndSave(getString("decay_uid"), uidDecay + 1)
                    } else {
                        uidDecay = 0
                        addAndSave(getString("decay_uid"), 0)
                    }//tick累加
                } else {
                    uidDecay = -1
                }

            }
            if (compound.getBoolean("decay")) {
                if (uidDecay >= compound.getDouble("mc_half_life")) {
                    uidDecay = 0
                }
            }


//            if (compound.getBoolean("decay") && compound.contains("decay_uid")) {
//
//                if (compound.contains("last_decay")) {
//                    if (!properties.containsKey(compound.getString("decay_uid"))) {
//                        properties[compound.getString("decay_uid")] = compound.getInt("last_decay")
//                    }
//                } else {
//                    addAndSave(compound.getString("decay_uid"),)
//
//                    properties[compound.getString("decay_uid")]?.let { compound.putInt("last_decay", it) }
//                }
//            }
//            if (compound.getBoolean("decay")) {
//                compound.apply {
//                    if (!contains("decay_uuid")) {
//                        putString("decay_uid", UUID.randomUUID().toString())
//                        properties[getString("decay_uid")] = 0
//                        putInt("last_decay", getUUidDecay(getString("decay_uid")))
//                    }
//
//                    (if (decayUID.containsKey(getString("decay_uid"))) decayUID[getString("decay_uid")]!! else 0).also { uidDecay = it }
//                    decayUID[getString("decay_uid")] = uidDecay + 1
//                    println(uidDecay + 1)
//
//                }
//                if (uidDecay % 50 == 0) {
//                    compound.putInt("last_decay",uidDecay)
//                    nbt = compound
//                }
//                if (uidDecay >= compound.getDouble("mc_half_life")) {
//                    val stacks: ArrayList<ItemStack?>
//                    compound.apply {
//                        remove("last_decay")
//                        decayUID[getString("decay_uid")] = 0
//                        val proton = getInt("proton")
//                        val neutron = getInt("neutron")
//                        stacks = decayOut["${proton}_$neutron"]!!
//                    }
//                    for (i in 0 until stacks.size) {
//                        if (i == 0) nbt = stacks[i]?.nbt?.apply {
//                            putString("decay_uid", compound.getString("decay_uid"))
//                        }
//                        else entity?.dropStack(stacks[i])
//                    }
//                }
//            }
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
                        .setStyle(
                            defaultStyle.withFont(Nucleoplasm.identifier("uniform")).withColor(0xFFFFFF))

                )
            }
        }
        return super.getName(stack)
    }
}
