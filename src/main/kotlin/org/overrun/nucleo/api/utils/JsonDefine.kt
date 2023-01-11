package org.overrun.nucleo.api.utils

import com.google.gson.Gson
import org.overrun.nucleo.api.utils.decayJson.DecayJson
import org.overrun.nucleo.api.utils.elementJson.ElementJson
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import kotlin.reflect.KClass

class JsonDefine(file: String, file1: String) {
    companion object {
        private val GSON = Gson()
    }
    var elementJson: ElementJson? = null
    var decayJson: DecayJson? = null

    init {
        elementJson = loadElement(file)
        decayJson = loadDecay(file1).apply {

        }
    }

    private fun loadDecay(file: String) : DecayJson? {
        try {
            StringBuilder().also { sb ->
                InputStreamReader(
                    javaClass.classLoader.getResourceAsStream(file)!!,
                    StandardCharsets.UTF_8
                ).forEachLine { sb.appendLine(it) }
            }.toString().also { s ->
                return GSON.fromJson(s, DecayJson::class.java)
                    // debug
                    .also(::println)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun loadElement(file: String) : ElementJson? {
        try {
            StringBuilder().also { sb ->
                InputStreamReader(
                    javaClass.classLoader.getResourceAsStream(file)!!,
                    StandardCharsets.UTF_8
                ).forEachLine { sb.appendLine(it) }
            }.toString().also { s ->
                return GSON.fromJson(s, ElementJson::class.java)
                    // debug
                    .also(::println)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
//        try {
//            buildString {
//                InputStreamReader(javaClass
//                    .classLoader
//                    .getResourceAsStream(file)!!)
//                    .forEachLine(this::appendLine)
//            }.also { s ->
//                val v = GSON.fromJson(s, ElementJson::class.java)
//                println(v)
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
        return null
    }
}