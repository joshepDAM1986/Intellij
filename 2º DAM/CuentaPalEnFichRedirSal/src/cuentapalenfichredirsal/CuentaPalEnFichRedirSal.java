package cuentapalenfichredirsal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuentaPalEnFichRedirSal {

  public static void main(String[] args) {

    try (InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
            BufferedReader brstdin = new BufferedReader(isstdin)) {

      ProcessBuilder pb = new ProcessBuilder("wc");
      pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
      pb.redirectError(ProcessBuilder.Redirect.INHERIT);

      System.out.printf("cuentapalenfich> ");
      String nomFichEntrada = brstdin.readLine();

      while (nomFichEntrada != null && nomFichEntrada.length() > 0) {

        try {
          pb.redirectInput(new File(nomFichEntrada));
          try {
            pb.start().waitFor();
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
