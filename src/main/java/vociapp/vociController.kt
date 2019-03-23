package vociapp


class VociController(val vociModel: VociFunctions) : Controller {
    override fun execute(command: String): Boolean {

        if (command.startsWith("test")) {
            try {
                if (parseCommand(command) == "f") {
                    try {
                        vociModel.startTest("f", getThirdInput(command).toInt())
                    } catch (e: IndexOutOfBoundsException) {
                        vociModel.startTest("f", 10)
                    }

                } else if (parseCommand(command) == "e") {
                    try {
                        vociModel.startTest("e", getThirdInput(command).toInt())
                    } catch (e: IndexOutOfBoundsException) {
                        vociModel.startTest("e", 10)
                    }
                }
            } catch (e: java.lang.IndexOutOfBoundsException){
                vociModel.wrongCommand(command, "unkown")
            }

            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "f") {
            try {
                vociModel.addFrench(getThirdInput(command), getFourthInput(command))
            } catch (e: java.lang.IndexOutOfBoundsException){
                vociModel.wrongCommand(command, "add")
            }
            return true
        } else if (command.startsWith("add ") && parseCommand(command) == "e") {
            try {
                vociModel.addEnglish(getThirdInput(command), getFourthInput(command))
            } catch (e: java.lang.IndexOutOfBoundsException){
                vociModel.wrongCommand(command, "add")
            }
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "f") {
            try {
                vociModel.removeFrench(getThirdInput(command))
            } catch (e: java.lang.IndexOutOfBoundsException){
                vociModel.wrongCommand(command, "remove")
            }
            return true
        } else if (command.startsWith("remove ") && parseCommand(command) == "e") {
            try {
                vociModel.removeEnglish(getThirdInput(command))
            } catch (e: java.lang.IndexOutOfBoundsException){
                vociModel.wrongCommand(command, "remove")
            }
        } else if (command.startsWith("exit")) {
            System.exit(-1)
        }

        vociModel.wrongCommand(command, "unknown")

        return true
    }

    private fun parseCommand(command: String): String {

        return command.split(" ")[1]
    }

    private fun getThirdInput(command: String): String {
        return command.split(" ")[2]
    }

    private fun getFourthInput(command: String): String {
        return command.split(" ")[3]
    }

}