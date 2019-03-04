package vociapp

class VociModel(val view: View) : Model{

    override fun addfrench(german: String, secondLanguage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addenglish(german: String, secondLanguage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun testfrench() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun testenglish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

data class Person(val name:String) {

    fun greet() :String {
        return "Hello, $name"
    }
}