fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        var res="Nombre:$name \nAge:$age"
        if(hobby==null) res=res+"\nHasn't specified a hobby. "
        else res=res+"\nLikes to $hobby. "
        if(referrer==null) res=res+"Doesn't have a referrer."
        else res=res+"Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}."
        println(res)
    }
}