package udp_presentacionclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UDP_PresentacionClient {

  private final static int MAX_BYTES = 1400;
  private final static String COD_TEXTO = "UTF-8";

  public static void main(String[] args) {

    if (args.length < 3) {
      System.err.println("ERROR, indicar: host_servidor puerto nombre");
      System.exit(1);
    }

    String nomHost = args[0];
    int numPuerto = Integer.parseInt(args[1]);
    String miNombre = args[2];

    try (DatagramSocket clientSocket = new DatagramSocket()) {

      InetAddress IPServidor = InetAddress.getByName(nomHost);

      String mensaje = "@hola#" + miNombre + "@";
      byte[] b = mensaje.getBytes(COD_TEXTO);
      DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length,
              IPServidor, numPuerto);

      clientSocket.connect(IPServidor, numPuerto);
      clientSocket.send(paqueteEnviado);

      byte[] datosRecibidos = new byte[MAX_BYTES];
      DatagramPacket paqueteRecibido
              = new DatagramPacket(datosRecibidos, datosRecibidos.length);
      clientSocket.receive(paqueteRecibido);
      String respuesta
              = new String(paqueteRecibido.getData(),
                      0, paqueteRecibido.getLength(), COD_TEXTO);

      Pattern patSaludo = Pattern.compile("@hola#(.+)@");
      Matcher m = patSaludo.matcher(respuesta);
      System.out.printf("Datagrama recibido de %s:%d: %s\n",
              paqueteRecibido.getAddress().getHostAddress(), paqueteRecibido.getPort(),
              respuesta);

      if (m.find()) {
        String suNombre = m.group(1);
        System.out.printf("Saludo contestado por: %s\n", suNombre);

      } else {
        System.out.printf("Formato incorrecto en respuesta: %s.\n", respuesta);
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
