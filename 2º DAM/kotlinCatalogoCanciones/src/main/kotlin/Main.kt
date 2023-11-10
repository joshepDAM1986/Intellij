import java.util.Scanner

// Definir la clase Song con propiedades y métodos solicitados
class Cancion(val titulo: String, val artista: String, val año: Int, val reproducciones: Int) {

    // Propiedad para verificar si la canción es popular
    val esPopular: Boolean
        get() = reproducciones < 1000

    // Método para imprimir la descripción de la canción
    fun imprimirDescripcion() {
        println("\"$titulo\", interpretada por $artista, se lanzó en $año")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Solicitar al usuario que ingrese los datos de la canción
    print("Ingresa el título de la canción: ")
    val titulo = scanner.nextLine()

    print("Ingresa el nombre del artista: ")
    val artista = scanner.nextLine()

    print("Ingresa el año de lanzamiento: ")
    val año = scanner.nextInt()

    print("Ingresa el recuento de reproducciones: ")
    val reproducciones = scanner.nextInt()

    // Crear una instancia de la canción con los datos ingresados por el usuario
    val miCancion = Cancion(titulo, artista, año, reproducciones)

    // Imprimir la descripción de la canción
    miCancion.imprimirDescripcion()

    // Verificar si la canción es popular
    if (miCancion.esPopular==true) {
        println("Esta canción no es muy popular.")
    } else {
        println("Esta canción es popular.")
    }
}
