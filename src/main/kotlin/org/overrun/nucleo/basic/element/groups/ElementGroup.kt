package org.overrun.nucleo.basic.element.groups

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import org.overrun.nucleo.Nucleoplasm
import org.overrun.nucleo.Nucleoplasm.logger
import org.overrun.nucleo.api.utils.loadPoi.PoiDefine
import org.overrun.nucleo.basic.element.remake.RegItem.elementera
import net.minecraft.item.ItemGroup as group

// TODO 2023/1/7/16/50 item group
object ElementGroup {
//    val jsonDefine = JsonDefine("element/element.json", "element/decay.json")
    private val group: group = FabricItemGroup.builder(Nucleoplasm.identifier("element"))
        .icon {
            // h
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(1) }
            }
        }
        .build()
    private val gas: group = FabricItemGroup.builder(Nucleoplasm.identifier("gas"))
        .icon {
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(1) }
            }
        }
        .build()
    private val liquid: group = FabricItemGroup.builder(Nucleoplasm.identifier("liquid"))
        .icon {
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(53) }
            }
        }
        .build()
    private val solid: group = FabricItemGroup.builder(Nucleoplasm.identifier("solid"))
        .icon {
            ItemStack(elementera.item).apply {
                //c
                nbt = NbtCompound().apply { putProton(6) }
            }
        }
        .build()
    private val metallicElements: group = FabricItemGroup.builder(Nucleoplasm.identifier("metallic_elements"))
        .icon {
            // li
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(3) }
            }
        }
        .build()
    private val nonMetallicElements: group =
        FabricItemGroup.builder(Nucleoplasm.identifier("non_metallic_elements"))
            .icon {
                // be
                ItemStack(elementera.item).apply {
                    nbt = NbtCompound().apply { putProton(4) }
                }
            }
            .build()
    private val noble_gas: group = FabricItemGroup.builder(Nucleoplasm.identifier("noble_gas"))
        .icon {
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(2) }
            }
        }
        .build()
    private val transition_elements: group = FabricItemGroup.builder(Nucleoplasm.identifier("transition_elements"))
        .icon {
            ItemStack(elementera.item).apply {
                nbt = NbtCompound().apply { putProton(21) }
            }
        }
        .build()

    private fun NbtCompound.putProton(proton: Int) {
        putInt("proton", proton)
    }

    val work = PoiDefine("element/element.xlsx")


    //元素分类分为 金属元素 非金属元素 惰性气体0族
    fun initGroup() {
//        val file = File(System.getProperty("user.dir"), "gen")
//        val bw = BufferedWriter(FileWriter(File(file, "zh_cn.json"), StandardCharsets.UTF_8))
//        bw.write("{")
//        bw.newLine()

        try {
            work.workbook.getSheet("nt").apply {
                println("this is ${getRow(1).getCell(1).stringCellValue}")
                println("thanks for ${getRow(0).getCell(1).stringCellValue}")
                println("link ${getRow(0).getCell(1).hyperlink.address}")
            }.forEach { row ->
                if (row.rowNum >= 3) {
                    val proton = row.getCell(0).numericCellValue.toInt()
                    val minNeutron = row.getCell(1).numericCellValue.toInt()
                    val maxNeutron = row.getCell(2).numericCellValue.toInt()
                    val decay = row.getCell(4).numericCellValue.toInt().toString()
                    println("$proton:$minNeutron:$maxNeutron")

//                    println(sheet.getRow(1).getCell(0).stringCellValue)//A2 -> 先读行在读列 name
                    try {
                        println(
                            "https://atom.kaeri.re.kr/${
                                work.workbook.getSheet(decay).getRow(0).getCell(1).hyperlink.address
                            }"
                        )
                    } catch (e: NullPointerException) {
                        logger.error("$proton isn't reader decay list")
                    }
                    for (neutron in minNeutron..maxNeutron) {

                        val stack = ItemStack(elementera.item).copy()
                        stack.nbt = NbtCompound().apply {
                            putInt("proton", proton)
                            putInt("neutron", neutron)
                            putString("translate", row.getCell(3).stringCellValue.lowercase())
                            putString("font", "nucleoplasm:uniform")
                            putString("abbreviation", row.getCell(6).stringCellValue)
                            try {
                                work.workbook.getSheet(decay).forEach { row1 ->
                                    if (row1.rowNum >= 3) {
                                        if (row1.getCell(0).numericCellValue.toInt() == neutron) {
                                            putBoolean("decay", row1.getCell(1).booleanCellValue)
                                            putDouble("relative_atomic_mass", row.getCell(2).numericCellValue)
                                            putDouble("mc_half_life", row.getCell(4).numericCellValue)

                                        }
                                    }
                                }
                            } catch (e: NullPointerException) {
                                print("null")
                            }
                            println()
                        }
                        addGroups(proton, stack)
                        addGroup(group, stack)

//                        bw.write(
//                            "  \"item.nucleoplasm." +
//                                "${row.getCell(3).stringCellValue.lowercase()}${proton + neutron}\": " +
//                                "\"${row.getCell(7).stringCellValue}-${proton + neutron}\","
//                        )
//                        bw.newLine()
                    }

                }
            }

        } catch (e: NullPointerException) {
            println("Failed to initialize the article group")
        }
//        bw.write("}")
//        bw.close()

    }

    private fun addGroups(proton: Int, stack: ItemStack?) {
        when (proton) {
            35, 53, 80 -> addGroup(liquid, stack)
            1, 2,
            in 7..10,
            17, 18, 36, 54, 86 -> addGroup(gas, stack)

            else -> addGroup(solid, stack)//固体
        }

        //判断惰性气体 金属 非金属
        when (proton) {
            2, 10, 18, 36, 54, 86, 118 -> addGroup(noble_gas, stack)//惰性气体
            3, 11, 12, 13,
            in 19..32,
            in 37..51,
            in 55..84,
            in 87..112 -> addGroup(metallicElements, stack)//金属元素
            5, 6, 14, 15, 16, 33, 34, 35, 52, 53, 85
            -> addGroup(nonMetallicElements, stack)//非金属元素
            else -> {}
        }
        //判断是否为过渡元素
        when (proton) {
            in 21..30,
            in 39..48,
            in 57..80,
            in 89..112 -> {
                addGroup(transition_elements, stack)
            }
            else -> {}
        }
    }
}
