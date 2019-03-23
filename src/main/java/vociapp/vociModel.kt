package vociapp

class VociModel(val view: View) : VociFunctions {
        val vociRepository = VociRepository.getRepo()

    override fun startTest(language: String, amount: Int) {
        var rnd: Int
        var vociList = ArrayList<Voci>()
        if (language == "f") {
            vociList = vociRepository.listFrench()
        } else if (language == "e") {
            vociList = vociRepository.listEnglish()
        }
        var points = 0
        if (vociList.size >= amount) {
            for (i in 1..amount) {
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
        } else {
            view.testNotPossible(vociList.size)
        }
    }

    override fun addFrench(german: String, fremdsprache: String) {
        if(vociRepository.addFrench(german, fremdsprache) == true){
            view.showAddMenue(fremdsprache)
        } else {
            view.vociAlreadyExists(fremdsprache)
        }
    }

    override fun addEnglish(german: String, fremdsprache: String) {
        if(vociRepository.addEnglish(german, fremdsprache) == true){
            view.showAddMenue(fremdsprache)
        } else {
            view.vociAlreadyExists(fremdsprache)
        }
    }

    override fun removeFrench(french: String) {
        if (vociRepository.removeFrench(french) == true) {
            view.showRemoveMenue(french)
        } else{
            view.vociDoesntExist(french)
        }
    }

    override fun removeEnglish(english: String) {
        if (vociRepository.removeEnglish(english) == true) {
            view.showRemoveMenue(english)
        } else{
            view.vociDoesntExist(english)
        }
    }

    override fun wrongCommand(command: String, type: String) {
        if (type == "add"){
            view.wrongAddCommand(command)
        } else if (type == "remove") {
            view.wrongRemoveCommand(command)
        } else if (type == "unknown"){
            view.wrongCommand(command)
        }
    }


}

data class Person(val name: String) {

    fun greet(): String {
        return "Hello, $name"
    }
}