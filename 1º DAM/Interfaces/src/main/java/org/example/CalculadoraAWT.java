package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa una calculadora con una interfaz de usuario simple.
 */
public class CalculadoraAWT extends Frame implements ActionListener {
    private TextField pantalla;
    private double operando1, operando2;
    private char operador;

    /**
     * Constructor de la calculadora. Inicializa la interfaz de usuario y los valores iniciales.
     */
    public CalculadoraAWT() {
        operando1 = operando2 = 0;
        operador = ' ';
        pantalla = new TextField(10);
        pantalla.setEditable(true);
        Button botonSumar = new Button("+");
        Button botonRestar = new Button("-");
        Button botonMultiplicar = new Button("*");
        Button botonDividir = new Button("/");
        Button botonPotencia = new Button("^");
        Button botonIgual = new Button("=");
        Button botonLimpiar = new Button("C");

        setLayout(new FlowLayout());
        add(pantalla);
        add(botonSumar);
        add(botonRestar);
        add(botonMultiplicar);
        add(botonDividir);
        add(botonPotencia);
        add(botonIgual);
        add(botonLimpiar);

        botonSumar.addActionListener(this);
        botonRestar.addActionListener(this);
        botonMultiplicar.addActionListener(this);
        botonDividir.addActionListener(this);
        botonPotencia.addActionListener(this);
        botonIgual.addActionListener(this);
        botonLimpiar.addActionListener(this);

        setTitle("CalculadoraAWT");
        setSize(200, 200);
        setVisible(true);
    }

    /**
     * Método que se ejecuta cuando se hace clic en un botón de la calculadora.
     *
     * @param e El evento de acción que desencadena el método.
     */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (Character.isDigit(comando.charAt(0))) {
            pantalla.setText(pantalla.getText() + comando);
        } else if (comando.charAt(0) == 'C') {
            pantalla.setText("");
            operando1 = operando2 = 0;
            operador = ' ';
        } else if (comando.charAt(0) == '=') {
            operando2 = Double.parseDouble(pantalla.getText());
            double resultado = calcularResultado();
            pantalla.setText(Double.toString(resultado));
            operando1 = resultado;
            operando2 = 0;
            operador = ' ';
        } else {
            operando1 = Double.parseDouble(pantalla.getText());
            operador = comando.charAt(0);
            pantalla.setText("");
        }
    }

    /**
     * Calcula el resultado de la operación actual.
     *
     * @return El resultado de la operación.
     */
    private double calcularResultado() {
        double resultado = 0;
        switch (operador) {
            case '+':
                resultado = operando1 + operando2;
                break;
            case '-':
                resultado = operando1 - operando2;
                break;
            case '*':
                resultado = operando1 * operando2;
                break;
            case '/':
                if (operando2 != 0) {
                    resultado = operando1 / operando2;
                } else {
                    pantalla.setText("Error: División por cero");
                }
                break;
            case '^':
                resultado = Math.pow(operando1, operando2);
                break;
        }
        return resultado;
    }

    /**
     * Método principal que crea una instancia de la calculadora.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        new CalculadoraAWT();
    }
}
