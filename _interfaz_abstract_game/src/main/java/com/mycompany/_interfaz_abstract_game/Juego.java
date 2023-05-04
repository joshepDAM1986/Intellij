
package com.mycompany._interfaz_abstract_game;

/**
 *
 * @author garci
 */

abstract class Juego {
    abstract void comenzar();
    abstract void terminar();

    void jugar(iJugable jugador) {
        comenzar();
        jugador.jugar();
        terminar();
    }
}
