package capturasalidaproceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CapturaSalidaProceso {
  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("ERROR: indicar directorio");
      System.exit(1);
    }

    String nomDir = args[0];

    File f = new File(nomDir);
    if (!f.isDirectory()) {
      System.out.printf("ERROR: No existe directorio %s\n", nomDir);
      System.exit(2);
    }

//    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", "/w", nomDir);
    try {
//      Process p = pb.start();
//      La siguiente es una alternativa a ProcessBuilder
      Process p = Runtime.getRuntime().exec(new String[] {"cmd.exe", "/c", "dir", "/w", nomDir});
      p.waitFor();
      try (InputStream is = p.getInputStream();
              InputStreamReader isr = new InputStreamReader(is);
              BufferedReader br = new BufferedReader(isr)) {

        int numLin = 1;
        String linea = null;
        while ((linea = br.readLine()) != null) {
          System.out.printf("%d: %s\n", numLin++, linea);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException ex) {
    }
  }
}