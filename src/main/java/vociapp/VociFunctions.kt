package vociapp

interface VociFunctions {
    fun addFrench(german: String, fremdsprache: String)
    fun addEnglish(german: String, fremdsprache: String)
    fun removeFrench(french:String)
    fun removeEnglish(english:String)
    fun startTest(language: String, amount: Int)
}