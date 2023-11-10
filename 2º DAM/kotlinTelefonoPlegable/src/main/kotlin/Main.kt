open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = false, isScreenLightOn: Boolean = false) : Phone(isScreenLightOn) {

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }

    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
            println("Unfolding the phone and turning on the screen.")
        } else {
            println("Cannot turn on the screen while the phone is folded.")
        }
    }

    fun main() {
        // Crear un teléfono plegable
        val foldablePhone = FoldablePhone()

        // Verificar el estado inicial de la pantalla
        foldablePhone.checkPhoneScreenLight()

        // Plegar el teléfono
        foldablePhone.fold()

        // Intentar encender la pantalla mientras está plegado
        foldablePhone.switchOn()

        // Desplegar el teléfono
        foldablePhone.unfold()

        // Encender la pantalla después de desplegarlo
        foldablePhone.switchOn()

        // Verificar el estado final de la pantalla
        foldablePhone.checkPhoneScreenLight()
    }
}