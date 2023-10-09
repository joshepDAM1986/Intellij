package file;

import java.io.File;

public class Ejemplo_Metadatos_Acceso {

    public static void main(String[] args) {
        String resultado="";
        System.out.println("INFORMACION SOBRE EL FICHERO:");
        File file = new File("src/main/java/file");
        if (file.exists()) {
            resultado += "Nombre del fichero  : " + file.getName() + "\n"
                    + "Ruta                : " + file.getPath() + "\n"
                    + "Ruta absoluta       : " + file.getAbsolutePath() + "\n"
                    + "Se puede leer       : " + file.canRead() + "\n"
                    + "Se puede escribir   : " + file.canWrite() + "\n"
                    + "Tamaño              : " + file.length() + "\n"
                    + "Es un directorio    : " + file.isDirectory() + "\n"
                    + "Es un fichero       : " + file.isFile() + "\n"
                    + "Nombre del directorio padre: " + file.getParent() + "\n";
        }
        System.out.println(resultado);

        String dir = ".";
        String res = "";
        File f = new File(dir);
        String[] archivos = f.list();
        System.out.println("Ficheros en el directorio actual:"
                + archivos.length + "\n");
        for (int i = 0; i < archivos.length; i++) {
            res+= archivos[i] + "\n";
        }
        System.out.println(res);
    }
}

