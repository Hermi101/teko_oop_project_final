package vociapp

class VociModel(val view: View) : VociFunctions{

    val vociRepository = VociRepository.getRepo()

    override fun testFrench() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun testEnglish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFrench(german: String, fremdsprache: String) {
        vociRepository.addFrench(german, fremdsprache)
        view.showAddMenue(fremdsprache)
    }

    override fun addEnglish(german: String, fremdsprache: String) {
        vociRepository.addEnglish(german, fremdsprache)
        view.showAddMenue(fremdsprache)
    }

    override fun removeFrench(french: String) {
        vociRepository.removeFrench(french)
        view.showRemoveMenue(french)
    }

    override fun removeEnglish(english: String) {
        vociRepository.removeFrench(english)
        view.showRemoveMenue(english)
    }


}

data class Person(val name:String) {

    fun greet() :String {
        return "Hello, $name"
    }
}