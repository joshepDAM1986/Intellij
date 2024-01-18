package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana1 {

    private JFrame frame;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField edadField;
    private JTextField nacionalidadField;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femeninoRadioButton;
    private JComboBox<String> cursoComboBox;

    public Ventana1() {
        frame = new JFrame("Formulario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nombreField = new JTextField(15);
        frame.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Apellidos:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        apellidosField = new JTextField(15);
        frame.add(apellidosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        edadField = new JTextField(15);
        frame.add(edadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Nacionalidad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        nacionalidadField = new JTextField(15);
        frame.add(nacionalidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START; // Alineación vertical al inicio
        ButtonGroup grupoSexo = new ButtonGroup();
        masculinoRadioButton = new JRadioButton("Masculino");
        femeninoRadioButton = new JRadioButton("Femenino");
        grupoSexo.add(masculinoRadioButton);
        grupoSexo.add(femeninoRadioButton);
        JPanel sexoPanel = new JPanel();
        sexoPanel.setLayout(new GridLayout(2, 1));
        sexoPanel.add(masculinoRadioButton);
        sexoPanel.add(femeninoRadioButton);
        frame.add(sexoPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(new JLabel("Curso:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        String[] opcionesCurso = {"DAM", "DAW"};
        cursoComboBox = new JComboBox<>(opcionesCurso);
        cursoComboBox.setSelectedIndex(-1);
        frame.add(cursoComboBox, gbc);


        gbc.gridx = 1;
        gbc.gridy = 6;
        JButton abrirVentana2Button = new JButton("Mostrar");
        abrirVentana2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentana2();
            }
        });
        frame.add(abrirVentana2Button, gbc);

        frame.setVisible(true);
    }

    private void abrirVentana2() {
        // Obtener la información del formulario de la primera ventana
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        String edad = edadField.getText();
        String nacionalidad = nacionalidadField.getText();
        String sexo = getSelectedSexo();
        String curso = getSelectedCurso();




        // Cerrar la ventana actual antes de abrir la segunda ventana
        frame.dispose();

        // Crear la segunda ventana y pasar la información
        Ventana2 ventana2 = new Ventana2(nombre, apellidos, edad, nacionalidad, sexo, curso);
        ventana2.mostrarVentana();
    }

    private String getSelectedSexo() {
        if (masculinoRadioButton.isSelected()) {
            return "Masculino";
        } else if (femeninoRadioButton.isSelected()) {
            return "Femenino";
        } else {
            return "No especificado";
        }
    }
    private String getSelectedCurso() {
        Object seleccion = cursoComboBox.getSelectedItem();
        if (seleccion != null) {
            return seleccion.toString();
        } else {
            return "No especificado";
        }
    }
}
