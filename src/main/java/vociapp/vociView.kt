package vociapp

import java.util.*

class VociView() : View {
    override fun vociUpdated(fremdsprache: String) {
        println("""
                Du hast erfolgreich das Fremdwort $fremdsprache hinzugefügt.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]
            """.trimIndent())
        askForCommand()
    }

    lateinit var controller: Controller

    fun setController(controller: VociController) {
        this.controller = controller
    }


    override fun showInitialMenue() {
        println("""
                Welcome to my Voci learning Console-App.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]
            """.trimIndent())
        askForCommand()
    }

    override fun showRemoveMenue() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAddMenue() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun askForCommand() {
        val scanner = Scanner(System.`in`)

        var command:String
        do {
            command = scanner.nextLine()
        } while (!controller.execute(command))

    }

}