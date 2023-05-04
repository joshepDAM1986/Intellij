
package com.mycompany._interfaz_abstract_game;

/**
 *
 * @author garci
 */

class Poker extends Juego implements iJugable {
    @Override
    void comenzar() {
        System.out.println("¡Comienza el juego de poker!");
    }

    @Override
    void terminar() {
        System.out.println("Fin del juego de poker");
    }

    @Override
    public void jugar() {
        System.out.println("¡Jugando poker!");
    }
}