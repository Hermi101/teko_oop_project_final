package vociapp

import java.util.*

interface View {
    fun showInitialMenue()
    fun showAddMenue(fremdsprache: String)
    fun showRemoveMenue(fremdsprache: String)
}

