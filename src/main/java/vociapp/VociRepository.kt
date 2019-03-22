package vociapp

import java.io.File
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlin.collections.ArrayList

interface VociRepository {
    fun addFrench(deutsch:String, fremdsprache:String) : Voci
    fun addEnglish(deutsch:String, fremdsprache:String) : Voci
    fun removeFrench(fremdsprache:String)
    fun removeEnglish(fremdsprache:String)
    fun listEnglish() : ArrayList<Voci>
    fun listFrench() : ArrayList<Voci>

    companion object {

        fun getRepo() : VociRepository {
            return VociJsonRepository()
        }

    }
}

data class Voci(val deutsch:String, val fremdsprache:String)

class VociJsonRepository : VociRepository {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val listTypeEnglish = object : TypeToken<ArrayList<Voci>>() { }.type
    val jsonFileEnglish = File("english.json")
    val listTypeFrench = object : TypeToken<ArrayList<Voci>>() { }.type
    val jsonFileFrench = File("french.json")


    override fun addFrench(deutsch: String, fremdsprache: String): Voci {
        val newVoci = Voci(deutsch, fremdsprache)
        val vociList = listFrench()
        vociList.add(newVoci)
        save(vociList, "f")
        return newVoci
    }

    override fun addEnglish(deutsch: String, fremdsprache: String): Voci {
        val newVoci = Voci(deutsch, fremdsprache)
        val vociList = listEnglish()
        vociList.add(newVoci)
        save(vociList, "e")
        return newVoci
    }

    override fun removeFrench(fremdsprache: String){
        val vociList= listFrench().filterNot {v -> v.fremdsprache == fremdsprache}
        save(vociList, "f")
    }

    override fun removeEnglish(fremdsprache: String){
        val vociList= listEnglish().filterNot {v -> v.fremdsprache == fremdsprache}
        save(vociList, "e")
    }

    override fun listEnglish(): ArrayList<Voci> {
        if (!jsonFileEnglish.exists() || jsonFileEnglish.readLines().isEmpty()) {
            return arrayListOf()
        }

        val jsonText = readFile(jsonFileEnglish)

        return gson.fromJson(jsonText, listTypeEnglish)
    }

    override fun listFrench(): ArrayList<Voci> {
        if (!jsonFileFrench.exists() || jsonFileFrench.readLines().isEmpty()) {
            return arrayListOf()
        }

        val jsonText = readFile(jsonFileFrench)

        return gson.fromJson(jsonText, listTypeFrench)
    }

    fun save(vociList:List<Voci>, type:String){
        if (type == "f"){
            if (!jsonFileFrench.exists()) {
                jsonFileFrench.createNewFile()
            }
            val vociJsonText = gson.toJson(vociList)
            jsonFileFrench.writeText(vociJsonText)
        } else if (type == "e"){
            if (!jsonFileEnglish.exists()) {
                jsonFileEnglish.createNewFile()
            }
            val vociJsonText = gson.toJson(vociList)
            jsonFileEnglish.writeText(vociJsonText)
        }



    }

    private fun readFile(jsonFile: File): String {
        return jsonFile.bufferedReader().use { it.readText() }
    }

}