package vociapp


class VociController(val vociModel: VociFunctions) : Controller {
    override fun execute(command: String): Boolean {

        if (command.startsWith("test")) {
            if (parseCommand(command) == "f"){
                vociModel.startTest("f", getThirdInput(command).toInt())
            } else if (parseCommand(command) == "e"){
                vociModel.startTest("f", getThirdInput(command).toInt())
                println("Test")
            }
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "f") {
            vociModel.addFrench(getThirdInput(command), getFourthInput(command))
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "e") {
            vociModel.addEnglish(getThirdInput(command), getFourthInput(command))
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "f") {
            vociModel.removeFrench(getThirdInput(command))
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "e") {
            vociModel.removeEnglish(getThirdInput(command))
            return true
        }

        println("Befehl $command nicht erkannt!")

        return true
    }

    private fun parseCommand(command: String) : String {

        return command.split(" ")[1]
    }
    private fun getThirdInput(command:String) : String {
        return command.split(" ")[2]
    }
    private fun getFourthInput(command:String) : String {
        return command.split(" ")[3]
    }

}