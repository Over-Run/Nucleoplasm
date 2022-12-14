package org.overrun.nucleo.basic.element.groups

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup as groupBuild
import net.minecraft.item.ItemGroup as group
import org.overrun.nucleo.Nucleoplasm.identifier as toIdentifier
import org.overrun.nucleo.Nucleoplasm.logger as nucleoplasm_log
import org.overrun.nucleo.api.utils.loadPoi.PoiDefine as poi
import org.overrun.nucleo.basic.element.remake.RegItem.elementera as items

// TODO 2023/1/7/16/50 item group
object ElementGroup {
//    val jsonDefine = JsonDefine("element/element.json", "element/decay.json")
    private val group: group = groupBuild.builder(toIdentifier("element"))
        .icon {
            // h
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(1) }
            }
        }
        .build()
    private val gas: group = groupBuild.builder(toIdentifier("gas"))
        .icon {
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(1) }
            }
        }
        .build()
    private val liquid: group = groupBuild.builder(toIdentifier("liquid"))
        .icon {
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(53) }
            }
        }
        .build()
    private val solid: group = groupBuild.builder(toIdentifier("solid"))
        .icon {
            ItemStack(items.item).apply {
                //c
                nbt = NbtCompound().apply { putProton(6) }
            }
        }
        .build()
//    private val metallicElements: group = groupBuild.builder(Nucleoplasm.toIdentifier("metallic_elements"))
//        .icon {
//            // li
//            ItemStack(items.item).apply {
//                nbt = NbtCompound().apply { putProton(3) }
//            }
//        }
//        .build()
//    private val nonMetallicElements: group =
//        groupBuild.builder(Nucleoplasm.toIdentifier("non_metallic_elements"))
//            .icon {
//                // be
//                ItemStack(items.item).apply {
//                    nbt = NbtCompound().apply { putProton(4) }
//                }
//            }
//            .build()
    private val noble_gas: group = groupBuild.builder(toIdentifier("noble_gas"))
        .icon {
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(2) }
            }
        }
        .build()
    private val transition_metal: group = groupBuild.builder(toIdentifier("transition_metal"))
        .icon {
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(21) }
            }
        }
        .build()

    private val alkali_metal : group = groupBuild.builder(toIdentifier("alkali_metal"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(3) }
            }
        }.build()
    private val alkali_earth_metal : group = groupBuild.builder(toIdentifier("alkali_earth_metal"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(4) }
            }
        }.build()
    private val other_metal : group = groupBuild.builder(toIdentifier("other_metal"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(13) }
            }
        }.build()
    private val other_non_metallic : group = groupBuild.builder(toIdentifier("other_non_metallic"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(6) }
            }
        }.build()
    private val metalloid : group = groupBuild.builder(toIdentifier("metalloid"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(5) }
            }
        }.build()
    private val halogen : group = groupBuild.builder(toIdentifier("halogen"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(9) }
            }
        }.build()
    private val lanthanide_series : group = groupBuild.builder(toIdentifier("lanthanide_series"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(57) }
            }
        }.build()
    private val actinide_series : group = groupBuild.builder(toIdentifier("actinide_series"))
        .icon{
            ItemStack(items.item).apply {
                nbt = NbtCompound().apply { putProton(89) }
            }
        }.build()

    private fun NbtCompound.putProton(proton: Int) {
        putInt("proton", proton)
    }

    private val work = poi("element/element.xlsx")


    //?????????????????? ???????????? ??????????????? ????????????0???
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

//                    println(sheet.getRow(1).getCell(0).stringCellValue)//A2 -> ?????????????????? name
                    try {
                        println(
                            "https://atom.kaeri.re.kr/${
                                work.workbook.getSheet(decay).getRow(0).getCell(1).hyperlink.address
                            }"
                        )
                    } catch (e: NullPointerException) {
                        nucleoplasm_log.error("$proton isn't reader decay list")
                    }
                    for (neutron in minNeutron..maxNeutron) {

                        val stack = ItemStack(items.item).copy()
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
                                            if (row1.getCell(1).booleanCellValue) {
                                                putDouble("mc_half_life", row.getCell(4).numericCellValue)
                                            }
                                        }
                                    }
                                }
                            } catch (e: NullPointerException) {
                                print("null")
                            }
                            println()
                        }
                        addGroup(group, stack)//?????????????????????
                        addGroups(proton, stack)//????????????

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

        when(proton) {
            3,11,19,37,55,87 -> addGroup(alkali_metal, stack)//??????
            4,12,20,38,56,88 -> addGroup(alkali_earth_metal, stack)//?????????
            in 21..30,
            in 39..48,
            in 72..80,
            in 104..112 -> addGroup(transition_metal, stack)//?????????
            13,31,49,50,81,82,83,
            in 113..116 -> addGroup(other_metal, stack)//????????????
            5,14,32,33,51,52,84 -> addGroup(metalloid, stack)//?????????
            6,7,8,15,16,34 -> addGroup(other_non_metallic, stack)//???????????????
            9,17,35,53,85,117 -> addGroup(halogen, stack)//??????
            2, 10, 18, 36, 54, 86, 118 -> addGroup(noble_gas, stack)//????????????
            in 57..71 -> addGroup(lanthanide_series, stack)//??????
            in 89..103 -> addGroup(actinide_series, stack)//??????
            else -> {}
        }

        when (proton) {
            35, 53, 80 -> addGroup(liquid, stack)//??????
            1, 2,
            in 7..10,
            17, 18, 36, 54, 86 -> addGroup(gas, stack)//??????
            else -> addGroup(solid, stack)//??????
        }
    }
}
