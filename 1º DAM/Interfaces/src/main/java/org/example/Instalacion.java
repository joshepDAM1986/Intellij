package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /**
     * Clase que simula la instalación de un programa con una barra de progreso.
     */
    public class Instalacion {

        private JFrame frame;
        private JProgressBar progressBar;
        private Timer timer;
        private int progreso;

        /**
         * Constructor de la clase SimuladorInstalacion.
         * Crea la interfaz gráfica y la barra de progreso, y comienza la simulación de instalación.
         */
        public Instalacion() {
            frame = new JFrame("Instalando Programa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 100);
            frame.setLayout(new FlowLayout());

            progressBar = new JProgressBar(0, 100);
            progressBar.setPreferredSize(new Dimension(250, 30));
            progressBar.setStringPainted(true);
            frame.add(progressBar);

            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progreso += 5; // Aumenta el progreso en un 5% cada segundo
                    progressBar.setValue(progreso);

                    if (progreso >= 100) {
                        timer.stop();
                        JOptionPane.showMessageDialog(frame, "La instalación se ha completado.");
                        frame.dispose();
                    }
                }
            });

            frame.setVisible(true);
            timer.start();
        }

        /**
         * Método principal que crea una instancia de SimuladorInstalacion y la muestra en la interfaz gráfica.
         * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
         */
        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Instalacion();
                }
            });
        }
    }
