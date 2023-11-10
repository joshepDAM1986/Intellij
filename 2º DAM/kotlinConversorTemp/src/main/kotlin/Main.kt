fun main() {
    printFinalTemperature(27.0, "Celsius", "Farenheit"){9.0/5.0*it+32.0}
    printFinalTemperature(350.0, "Kelvin", "Celsius"){kelvin->kelvin-273.15}
    printFinalTemperature(10.0, "Farenheit", "Kelvin"){(5/9.0)*(it-32)+273.15}

}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement grados $initialUnit son $finalMeasurement grados $finalUnit.")
}