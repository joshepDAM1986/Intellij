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


open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "encendida" else "apagada"
        println("La pantalla esta $phoneScreenLight.")
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
            println("Desplegando el movil y encendiendo la pantalla.")
        } else {
            println("No puedo encender la pantalla mientras el telefono está plegado.")
        }
    }
}