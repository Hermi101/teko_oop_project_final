package vociapp

class VociModel(val view: View) : VociFunctions{

    val vociRepository = VociRepository.getRepo()

    override fun startTest(language: String, amount: Int) {
        var rnd: Int
        var vociList = ArrayList<Voci>()
        if(language == "f"){
            vociList= vociRepository.listFrench()
        } else if(language == "e") {
            vociList= vociRepository.listEnglish()
        }

        var points = 0
        if (vociList.size >= amount - 1){
            for (i in 1..amount){
                rnd = (0..(amount - 1)).random()
                val currentArray = vociList.get(rnd)
                if (view.getTestInput("Tesfrage $i von $amount", currentArray.deutsch) == currentArray.fremdsprache) {
                    println("Korrekt!")
                    points = points + 1
                } else {
                    println("Leider nein..")
                }

            }
            view.showtestResult(points, amount)
        }
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