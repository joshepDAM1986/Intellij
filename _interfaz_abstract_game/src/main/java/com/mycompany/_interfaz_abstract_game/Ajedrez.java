
package com.mycompany._interfaz_abstract_game;

/**
 *
 * @author garci
 */

// Implementación de la clase "Ajedrez" que extiende la clase "Juego" e implementa la interfaz "Jugable"
class Ajedrez extends Juego implements iJugable {
    @Override
    void comenzar() {
        System.out.println("¡Comienza el juego de ajedrez!");
    }

    @Override
    void terminar() {
        System.out.println("Fin del juego de ajedrez");
    }

    @Override
    public void jugar() {
        System.out.println("¡Jugando ajedrez!");
    }
}