

package com.mycompany._interfaz_abstract_game;

public class _interfaz_abstract_game {

    public static void main(String[] args) {
        Juego ajedrez = new Ajedrez();
        iJugable jugador1 = new Ajedrez();
        Juego poker = new Poker();
        iJugable jugador2 = new Poker();

        ajedrez.jugar(jugador1);
        poker.jugar(jugador2);
    }
}
