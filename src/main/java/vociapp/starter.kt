package vociapp

fun main(args: Array<String>) {

    val vociView = VociView()
    val vociModel = VociModel(vociView)
    val vociController = VociController(vociModel)
    vociView.setController(vociController)


    vociView.showInitialMenu()


}