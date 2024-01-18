package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana2 {

    private JFrame frame;

    public Ventana2(String nombre, String apellidos, String edad, String nacionalidad, String sexo, String carrera) {
        frame = new JFrame("Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(7, 2));

        frame.add(new JLabel("Nombre:"));
        frame.add(new JLabel(nombre));

        frame.add(new JLabel("Apellidos:"));
        frame.add(new JLabel(apellidos));

        frame.add(new JLabel("Edad:"));
        frame.add(new JLabel(edad));

        frame.add(new JLabel("Nacionalidad:"));
        frame.add(new JLabel(nacionalidad));

        frame.add(new JLabel("Sexo:"));
        frame.add(new JLabel(sexo));

        frame.add(new JLabel("Carrera:"));
        frame.add(new JLabel(carrera));

        JButton volverButton = new JButton("Volver");
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana2();
            }
        });
        frame.add(volverButton);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void cerrarVentana2() {
        frame.dispose(); // Cerrar la segunda ventana antes de volver a la primera
        new Ventana1(); // Volver a abrir la primera ventana
    }
}

