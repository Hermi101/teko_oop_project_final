package vociapp

import java.util.*

class VociView : View {

    lateinit var controller: Controller

    fun setController(controller: VociController) {
        this.controller = controller
    }


    override fun showInitialMenu() {
        println(
            """
                 - - - - - - - - - - - - - - - - - - - -
                | Willkommen zu der Voci-Lern App.      |
                |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|
                test e/f ohne anzahl Wörter startet einen Test mit 10 Wörtern (sofern so viele existieren).
                Commands:
                test [f/e]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]
                exit
                |---------------------------------------------------------------------------------------------------------|
            """.trimIndent()
        )
        askForCommand()
    }

    override fun showActiveMenu() {
        println(
            """

                test e/f ohne anzahl Wörter startet einen Test mit 10 Wörtern (sofern so viele existieren).
                Commands:
                test [f/e] [amount]
                add [f/e] [deutsch] [fremdsprache]
                remove [f/e] [fremdsprache]
                exit
                |---------------------------------------------------------------------------------------------------------|
            """.trimIndent()
        )
        askForCommand()
    }

    override fun showRemoveMenue(fremdsprache: String) {
        println(
            """
                Das Wort $fremdsprache wurde gelöscht.

            """.trimIndent()
        )
        showActiveMenu()
    }

    override fun showAddMenue(fremdsprache: String) {
        println(
            """
                Du hast erfolgreich das Fremdwort $fremdsprache hinzugefügt.
            """.trimIndent()
        )
        showActiveMenu()
    }

    override fun getTestInput(announcement: String, wort: String): String {
        println(
            """
            $announcement

            Bitte gib das Fremdwort für folgendes Wort ein:
            $wort
            |---------------------------------------------------------------------------------------------------------|
        """.trimIndent()
        )
        return askForInput()
    }

    override fun showtestResult(points: Int, amount: Int) {
        println(
            """
            Du hast $points von $amount Punkten erhalten.

        """.trimIndent()
        )
        showActiveMenu()
    }
    override fun testNotPossible(amount: Int){
        println("""
            Leider exisitieren nur $amount Wörter.

        """.trimMargin())
        showActiveMenu()
    }
    override fun vociAlreadyExists(fremdsprache: String) {
        println("""
            Das Wort $fremdsprache ist bereits erfasst.

        """.trimIndent())
        showActiveMenu()
    }
    override fun vociDoesntExist(fremdsprache: String) {
        println("""
            Das Wort $fremdsprache existiert nicht und kann demnach nicht entfernt werden.

            """.trimIndent())
        showActiveMenu()
    }
    override fun wrongAddCommand(command: String) {
        println("""
            Der Befehl $command ist im falschen Format.
            Diese müsste z.B. folgendermassen aussehen:

            add e Sieg victory

        """.trimIndent())
        showActiveMenu()
    }
    override fun wrongRemoveCommand(command: String) {
        println("""
            Der Befehl $command ist im falschen Format.
            Diese müsste z.B. folgendermassen aussehen:

            remove e victory

        """.trimIndent())
        showActiveMenu()
    }

    override fun wrongCommand(command: String) {
        println("""
            Der Befehl $command ist im falschen Format.
            Das Format kann hier entnommen werden:

        """.trimIndent())
        showActiveMenu()
    }

    private fun askForCommand() {
        val scanner = Scanner(System.`in`)

        val command: String

        command = scanner.nextLine()
        (controller.execute(command))

    }

    private fun askForInput(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

}