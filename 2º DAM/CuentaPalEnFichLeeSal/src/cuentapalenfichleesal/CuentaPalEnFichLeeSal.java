package cuentapalenfichleesal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CuentaPalEnFichLeeSal {

  public static void main(String[] args) {

    try (InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
            BufferedReader brstdin = new BufferedReader(isstdin)) {

      ProcessBuilder pb = new ProcessBuilder("wc");
      pb.redirectError(ProcessBuilder.Redirect.INHERIT);

      System.out.printf("cuentapalenfich> ");
      String nomFichEntrada = brstdin.readLine();

      while (nomFichEntrada != null && nomFichEntrada.length() > 0) {

        try {
          pb.redirectInput(new File(nomFichEntrada));
          try {
            Process p = pb.start();
            p.waitFor();
            try (InputStream isp = p.getInputStream();
                    InputStreamReader isrp = new InputStreamReader(isp); // No se indica codificación
                    BufferedReader brp = new BufferedReader(isrp)) {
              String lineaSal = brp.readLine(); // wc solo una línea a salida estándar
              String[] datosRecuento = lineaSal.split(" +");
              // Tres números, según documentación de wc (man wc)
              //   número_líneas número_palabras número_bytes
              // Dos espacios antes del primer número y entre los números
              System.out.printf("Fichero tiene %s líneas, %s palabras y %s caracteres\n",
                      datosRecuento[1], datosRecuento[2], datosRecuento[3]);
            }
          } catch (InterruptedException ex) {
          }
        } catch (IOException ex) {
          System.err.printf("ERROR: %s\n", ex.getLocalizedMessage());
        }

        System.out.printf("cuentapalenfich> ");
        nomFichEntrada = brstdin.readLine();
      }

    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

}
