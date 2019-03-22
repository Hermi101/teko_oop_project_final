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
                test [f/e]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]








            """.trimIndent())
        askForCommand()
    }

    override fun showRemoveMenue(fremdsprache: String) {
        println("""
                Das Wort $fremdsprache wurde gelöscht, sofern dieses existierte.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]









            """.trimIndent())
        askForCommand()
    }

    override fun showAddMenue(fremdsprache: String) {
        println("""
                Du hast erfolgreich das Fremdwort $fremdsprache hinzugefügt.
                Commands:
                test [francais/english]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]









            """.trimIndent())
        askForCommand()
    }

    override fun getTestInput(announcement: String, wort: String) : String{
        println("""
            $announcement

            Bitte gib das Fremdwort für folgendes Wort ein:
            $wort

        """.trimIndent())
        return askForInput()
    }

    override fun showtestResult(points: Int, amount: Int) {
        println("""
            Du hast $points von $amount Punkten erhalten.

        """.trimIndent())
        showInitialMenue()
    }

    private fun askForCommand() {
        val scanner = Scanner(System.`in`)

        val command:String

        command = scanner.nextLine()
        (controller.execute(command))

    }
    private fun askForInput() : String{
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

}