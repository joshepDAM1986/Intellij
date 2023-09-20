package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 * Esta clase representa una aplicación de formateo de texto con características como cambiar el color,
 * alineación, negrita, cursiva y subrayado en un JTextPane.
 */
public class Formato extends JFrame {
    private JTextPane textPane;
    private JButton colorButton;
    private JRadioButton leftAlign, centerAlign, rightAlign;
    private JCheckBox boldCheckBox, italicCheckBox, underlineCheckBox;

    /**
     * Constructor de la clase Formato que inicializa la interfaz de usuario y los componentes.
     */
    public Formato() {
        setTitle("Formateador de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        colorButton = new JButton("Color de Texto");
        panel.add(colorButton);

        ButtonGroup alignmentGroup = new ButtonGroup();
        leftAlign = new JRadioButton("Izquierda");
        centerAlign = new JRadioButton("Centro");
        rightAlign = new JRadioButton("Derecha");
        alignmentGroup.add(leftAlign);
        alignmentGroup.add(centerAlign);
        alignmentGroup.add(rightAlign);
        panel.add(leftAlign);
        panel.add(centerAlign);
        panel.add(rightAlign);

        boldCheckBox = new JCheckBox("Negrita");
        italicCheckBox = new JCheckBox("Cursiva");
        underlineCheckBox = new JCheckBox("Subrayado");
        panel.add(boldCheckBox);
        panel.add(italicCheckBox);
        panel.add(underlineCheckBox);

        textPane = new JTextPane();
        getContentPane().add(new JScrollPane(textPane), BorderLayout.CENTER);

        colorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeTextColor(e);
            }
        });

        leftAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alignText(StyleConstants.ALIGN_LEFT);
            }
        });

        centerAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alignText(StyleConstants.ALIGN_CENTER);
            }
        });

        rightAlign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alignText(StyleConstants.ALIGN_RIGHT);
            }
        });

        boldCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setBold();
            }
        });

        italicCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setItalic();
            }
        });

        underlineCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUnderline();
            }
        });
    }

    /**
     * Cambia el color del texto en el JTextPane.
     *
     * @param e El evento de acción del botón de color.
     */
    private void changeTextColor(ActionEvent e) {
        Color textColor = JColorChooser.showDialog(null, "Selecciona un Color de Texto", Color.BLACK);
        if (textColor != null) {
            AttributeSet attrs = textPane.getCharacterAttributes();
            SimpleAttributeSet attributes = new SimpleAttributeSet(attrs);
            StyleConstants.setForeground(attributes, textColor);
            textPane.setCharacterAttributes(attributes, false);
        }
    }

    /**
     * Alinea el texto en el JTextPane según la alineación especificada.
     *
     * @param alignment La alineación deseada (StyleConstants.ALIGN_LEFT, StyleConstants.ALIGN_CENTER
     *                  o StyleConstants.ALIGN_RIGHT).
     */
    private void alignText(int alignment) {
        AttributeSet attrs = textPane.getParagraphAttributes();
        SimpleAttributeSet attributes = new SimpleAttributeSet(attrs);
        StyleConstants.setAlignment(attributes, alignment);
        textPane.setParagraphAttributes(attributes, false);
    }

    /**
     * Establece o desactiva la negrita para el texto seleccionado en el JTextPane.
     */
    private void setBold() {
        AttributeSet attrs = textPane.getCharacterAttributes();
        SimpleAttributeSet attributes = new SimpleAttributeSet(attrs);
        StyleConstants.setBold(attributes, boldCheckBox.isSelected());
        textPane.setCharacterAttributes(attributes, false);
    }

    /**
     * Establece o desactiva la cursiva para el texto seleccionado en el JTextPane.
     */
    private void setItalic() {
        AttributeSet attrs = textPane.getCharacterAttributes();
        SimpleAttributeSet attributes = new SimpleAttributeSet(attrs);
        StyleConstants.setItalic(attributes, italicCheckBox.isSelected());
        textPane.setCharacterAttributes(attributes, false);
    }

    /**
     * Establece o desactiva el subrayado para el texto seleccionado en el JTextPane.
     */
    private void setUnderline() {
        AttributeSet attrs = textPane.getCharacterAttributes();
        SimpleAttributeSet attributes = new SimpleAttributeSet(attrs);
        StyleConstants.setUnderline(attributes, underlineCheckBox.isSelected());
        textPane.setCharacterAttributes(attributes, false);
    }

    /**
     * Método principal para iniciar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Formato frame = new Formato();
                frame.setVisible(true);
            }
        });
    }
}
