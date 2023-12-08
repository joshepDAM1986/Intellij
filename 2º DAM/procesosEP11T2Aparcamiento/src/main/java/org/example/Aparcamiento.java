package org.example;

import java.util.ArrayList;
import java.util.List;

class Aparcamiento {
    private static final int NUMERO_PLAZAS = 50;
    private List<Integer> plazasOcupadas = new ArrayList<>();

    public synchronized void entrar(int matricula) {
        if (plazasOcupadas.size() < NUMERO_PLAZAS) {
            plazasOcupadas.add(matricula);
            System.out.println("Coche con matrícula " + matricula + " ha entrado. Plaza asignada: " + plazasOcupadas.size());
        } else {
            System.out.println("Aparcamiento completo. Coche con matrícula " + matricula + " no pudo entrar.");
        }
    }

    public synchronized void salir(int matricula) {
        plazasOcupadas.remove(Integer.valueOf(matricula));
        System.out.println("Coche con matrícula " + matricula + " ha salido. Plazas ocupadas: " + plazasOcupadas.size());
    }
}