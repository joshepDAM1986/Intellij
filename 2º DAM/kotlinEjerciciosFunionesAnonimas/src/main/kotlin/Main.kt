import java.lang.Math.sqrt

fun main() {
    println(multiplicar(2, 2))

    // Función anónima
    var funMultiplicar = fun(a: Int, b: Int): Int {
        return a * b
    }

    println(funMultiplicar(2, 2))

    // Función anónima
    var funMultiplicar2 = { a: Int, b: Int -> a * b }
    println(funMultiplicar2(2, 2))

    //Funcion anonima multioperacion

    var funSuma = { a: Int, b: Int -> a + b }
    var funResta = { a: Int, b: Int -> a - b }
    operacion(2, 2, funSuma)//meh
    operacion(2, 2, { a: Int, b: Int -> a + b })//niiiice
    operacion(2, 2, fun(a: Int, b: Int): Int = a + b)//ni harto vino

    operacion(2, 2, funResta)//meh!!
    operacion(2, 2, { a: Int, b: Int -> a - b })//niiiice
    operacion(2, 2, fun(a: Int, b: Int): Int = a - b)//ni harto vino

    //Operador it
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9).filter { it > 4 }
    for (i in list)
        println(i)

    operacionUnaria(2) { it * it }
    operacionUnaria(2) { a: Double -> a * a }
    operacionUnaria(2) { sqrt(it) }

}

fun operacionUnaria(a: Int, funOp: (Double) -> Double): Unit {
    println("resultado de la operacion ${funOp(a.toDouble())}")
}

fun multiplicar(a: Int, b: Int): Int {
    return a * b
}

// Función anónima
fun operacion(a: Int, b: Int, funOp: (Int, Int) -> Int): Unit {
    println("Resultado de la operacion: ${funOp(a, b)}")
}