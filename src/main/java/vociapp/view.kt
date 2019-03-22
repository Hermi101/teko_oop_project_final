package vociapp

import java.util.*

interface View {
    fun showInitialMenue()
    fun showAddMenue(fremdsprache: String)
    fun showRemoveMenue(fremdsprache: String)
    fun getTestInput(announcement: String, wort: String): String
    fun showtestResult(points: Int, amount: Int)
}

