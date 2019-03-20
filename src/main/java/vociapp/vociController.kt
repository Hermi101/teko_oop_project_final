package vociapp


class VociController(val vociModel: VociFunctions) : Controller {
    override fun execute(command: String): Boolean {

        if (command.startsWith("test")) {
            if (command.endsWith("francais")){
                vociModel.testFrench()
            } else if (command.endsWith("english")){
                vociModel.testEnglish()
                println("Test")
            }
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "f") {
            vociModel.addFrench(getGerman(command), getSecondLanguage(command))
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "e") {
            vociModel.addEnglish(getGerman(command), getSecondLanguage(command))
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "f") {
            vociModel.removeFrench(getGerman(command))
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "e") {
            vociModel.removeEnglish(getGerman(command))
            return true
        }

        println("Befehl $command nicht erkannt!")

        return true
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