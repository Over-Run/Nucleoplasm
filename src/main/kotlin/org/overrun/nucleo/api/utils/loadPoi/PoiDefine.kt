package org.overrun.nucleo.api.utils.loadPoi

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream
import java.lang.IllegalStateException

class PoiDefine(val file: String) {

    val workbook : XSSFWorkbook

    init {
        val stream: InputStream? = javaClass.classLoader.getResourceAsStream(file)
        workbook = XSSFWorkbook(stream)
    }

}