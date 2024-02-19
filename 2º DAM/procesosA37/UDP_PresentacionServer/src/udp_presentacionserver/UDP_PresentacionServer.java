package udp_presentacionserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UDP_PresentacionServer {

  private final static int MAX_BYTES = 1400;
  private final static String COD_TEXTO = "UTF-8";

  public static void main(String[] args) {

    if (args.length < 2) {
      System.err.println("ERROR, indicar: puerto nombre.");
      System.exit(1);
    }

    int numPuerto = Integer.parseInt(args[0]);
    String miNombre = args[1];

    try (DatagramSocket serverSocket = new DatagramSocket(numPuerto)) {
      System.out.printf("Creado socket de datagramas para puerto %s.\n", numPuerto);

      while (true) {

        System.out.println("Esperando datagramas.");

        byte[] datosRecibidos = new byte[MAX_BYTES];
        DatagramPacket paqueteRecibido
                = new DatagramPacket(datosRecibidos, datosRecibidos.length);

        serverSocket.receive(paqueteRecibido);

        String lineaRecibida = new String(paqueteRecibido.getData(),
                0, paqueteRecibido.getLength(), COD_TEXTO);
        InetAddress IPCliente = paqueteRecibido.getAddress();
        int puertoCliente = paqueteRecibido.getPort();
        System.out.printf("Recibido datagrama de %s:%d (%s)\n",
                IPCliente.getHostAddress(), puertoCliente, lineaRecibida);

        Pattern patSaludo = Pattern.compile("@hola#(.+)@");
        Matcher m = patSaludo.matcher(lineaRecibida);

        if (m.find()) {

          String suNombre = m.group(1);
          System.out.printf("Es la presentación de: %s\n", suNombre);
          String respuesta = "@hola#" + miNombre + "@";

          byte[] b = respuesta.getBytes(COD_TEXTO);
          DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length,
                  IPCliente, puertoCliente);
          serverSocket.send(paqueteEnviado);

        } else {
          System.out.printf("Formato incorrecto en texto: %s.\n", lineaRecibida);
        }
      }
    } catch (SocketException ex) {
      System.out.println("Excepción de sockets");
      ex.printStackTrace();
    } catch (IOException ex) {
      System.out.println("Excepción de E/S");
      ex.printStackTrace();
    }
  }
}