package vociapp


//Testkommentar
class VociController(val vociModel: Model) : Controller {
    override fun execute(command: String): Boolean {

        if (command.startsWith("test")) {
            if (command.endsWith("francais")){
                vociModel.testfrench()
            } else if (command.endsWith("english")){
                vociModel.testenglish()
            }
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "f") {
            vociModel.addfrench(getGerman(command), getSecondLanguage(command))
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "e") {
            vociModel.addenglish(getGerman(command), getSecondLanguage(command))
            return true
        }

        println("Befehl $command nicht erkannt!")

        return false
    }

    private fun parseCommand(command: String) : String {

        return command.split(" ")[1]
    }
    private fun getGerman(command:String) : String {
        return command.split(" ")[2]
    }
    private fun getSecondLanguage(command:String) : String {
        return command.split(" ")[3]
    }

}