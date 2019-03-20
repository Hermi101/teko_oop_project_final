package vociapp

import java.util.*

class VociView() : View {
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

    override fun showRemoveMenue(fremdsprache: String) {
        println("""
                Du hast erfolgreich das Fremdwort $fremdsprache gelöscht.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]









            """.trimIndent())
    }

    override fun showAddMenue(fremdsprache: String) {
        println("""
                Du hast erfolgreich das Fremdwort $fremdsprache hinzugefügt.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]









            """.trimIndent())
    }

    private fun askForCommand() {
        val scanner = Scanner(System.`in`)

        var command:String
        do {
            command = scanner.nextLine()
        } while (controller.execute(command))

    }

}