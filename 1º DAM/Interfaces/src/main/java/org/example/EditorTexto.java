package org.example;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Esta clase representa un simple editor de texto con funciones básicas
 * como cargar y guardar archivos, reemplazar texto y mostrar información.
 * Es una aplicación de GUI construida con AWT y Swing.
 */
public class EditorTexto extends Frame {
    private TextArea textArea;
    private MenuBar menuBar;
    private Menu fileMenu;
    private Menu helpMenu;
    private MenuItem openItem;
    private MenuItem saveItem;
    private MenuItem replaceItem;
    private MenuItem aboutItem;

    /**
     * Constructor de la clase EditorTexto. Inicializa la interfaz gráfica
     * del editor de texto y configura los elementos de menú.
     */
    public EditorTexto() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        textArea = new TextArea();
        add(textArea);

        menuBar = new MenuBar();
        setMenuBar(menuBar);

        fileMenu = new Menu("Archivo");
        menuBar.add(fileMenu);

        helpMenu = new Menu("Información");
        menuBar.add(helpMenu);

        openItem = new MenuItem("Cargar Fichero");
        saveItem = new MenuItem("Guardar Fichero");
        replaceItem = new MenuItem("Reemplazar Texto");
        aboutItem = new MenuItem("Acerca del Editor");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(replaceItem);
        helpMenu.add(aboutItem);

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarArchivo();
            }
        });

        replaceItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reemplazarTexto();
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarAcercaDe();
            }
        });
    }

    /**
     * Método para cargar un archivo desde el sistema de archivos y mostrar
     * su contenido en el área de texto.
     */
    private void cargarArchivo() {
        FileDialog fileDialog = new FileDialog(this, "Cargar Fichero", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            String fileName = fileDialog.getDirectory() + fileDialog.getFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para guardar el contenido actual del área de texto en un archivo.
     */
    private void guardarArchivo() {
        FileDialog fileDialog = new FileDialog(this, "Guardar Fichero", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            String fileName = fileDialog.getDirectory() + fileDialog.getFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para reemplazar un texto especificado por otro texto en el
     * contenido del área de texto.
     */
    private void reemplazarTexto() {
        String buscar = JOptionPane.showInputDialog(this, "Texto a reemplazar:");
        if (buscar != null) {
            String reemplazar = JOptionPane.showInputDialog(this, "Texto de reemplazo:");
            if (reemplazar != null) {
                String contenido = textArea.getText();
                contenido = contenido.replace(buscar, reemplazar);
                textArea.setText(contenido);
            }
        }
    }

    /**
     * Método para mostrar una ventana de diálogo con información sobre el
     * editor de texto y su autor.
     */
    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(this, "Editor de Texto v1.5\nAutor: Joshepe", "Acerca del Editor", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método principal para iniciar la aplicación del editor de texto.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditorTexto editor = new EditorTexto();
                editor.setVisible(true);
            }
        });
    }
}
