fun main() {
    //Importo la clase Java ReproductorMidi para que se oiga una música de fondo mientras jugamos
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Bienvenido al juego del AHORCADO. Cargando juego...")
    Thread.sleep(7000) //La empleo para sincronizar el inicio del juego con la música
    println("Intenta adivinar el nombre de una fruta")

    //Creo un array de frutas y selecciono una de ellas de forma aleatoria
    val frutas = arrayOf("kiwi", "manzana", "pera", "fresa", "naranja", "uva", "mango")
    val fruta: String = frutas.random()

    //Oculto la cantidad de letras que forman la fruta seleccionada con '*'
    val palabraSecreta = StringBuffer()
    for (letra in fruta) {
        palabraSecreta.append("*")
    }

    //Implemento la lógica del juego
    var numeroErrores = 0
    while (numeroErrores < 7 && palabraSecreta.contains("*")) {
        println("Tu palabra con letras descubiertas por el momento es -> $palabraSecreta")
        println("Llevas $numeroErrores fallos (máximo número de fallos permitido 7). " +
                "Introduce una letra que creas que está en la palabra secreta: ")

        val letra: String = readln()
        var acierto = false
        var contador = 0
        for (i in fruta) {
            if (i.toString() == letra) {
                acierto = true
                palabraSecreta.replace(contador, contador + 1, letra)
            }
            contador++
        }

        if (acierto) {
            println("Has acertado")
        } else {
            println("Has fallado")
            numeroErrores++
            when (numeroErrores) {
                1 -> DibujoAhorcado.dibujar(1)
                2 -> DibujoAhorcado.dibujar(2)
                3 -> DibujoAhorcado.dibujar(3)
                4 -> DibujoAhorcado.dibujar(4)
                5 -> DibujoAhorcado.dibujar(5)
                6 -> DibujoAhorcado.dibujar(6)
                7 -> DibujoAhorcado.dibujar(7)
            }
        }
    }

    //El usuario recibe un mensaje final tras finalizar el juego
    if (numeroErrores == 7) {
        println("\nLo siento, has perdido. La palabra secreta era $fruta")
    } else {
        println("\nEnhorabuena, has ganado! La palabra secreta era $fruta")
    }

    rm.cerrar()
}