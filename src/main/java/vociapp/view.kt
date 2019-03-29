package vociapp

interface View {
    fun showInitialMenu()
    fun showActiveMenu()
    fun showAddMenue(fremdsprache: String)
    fun showRemoveMenue(fremdsprache: String)
    fun getTestInput(announcement: String, wort: String): String
    fun showtestResult(points: Int, amount: Int)
    fun testNotPossible(amount: Int)
    fun vociAlreadyExists(fremdsprache: String)
    fun vociDoesntExist(fremdsprache: String)
    fun wrongAddCommand(command:String)
    fun wrongRemoveCommand(command:String)
    fun wrongCommand(command:String)
}

