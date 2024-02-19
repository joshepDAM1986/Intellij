package udp_presentacionclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UDP_PresentacionClient {

  private final static int MAX_BYTES = 1400;
  private final static String COD_TEXTO = "UTF-8";
  private final static int TIMEOUT = 1000; // Tiempo límite en milisegundos

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

      // Detecta si es dir. broadcast de la red de alguna interfaz
      boolean esDirBroadcast = false;
      try {
        Enumeration<NetworkInterface> eIfs = NetworkInterface.getNetworkInterfaces();
        Iterator<NetworkInterface> iIfs = eIfs.asIterator();
        while (iIfs.hasNext()) {
          NetworkInterface nIf = iIfs.next();
          List<InterfaceAddress> lDir = nIf.getInterfaceAddresses();
          for (InterfaceAddress dirIf : lDir) {
            InetAddress dirIP = dirIf.getAddress();
            if (dirIP.isSiteLocalAddress() && IPServidor.equals(dirIf.getBroadcast())) {
              esDirBroadcast = true;
            }
          }
        }
      } catch (SocketException ex) {
        System.err.println("ERROR: Excepción SocketException");
        ex.printStackTrace();
      }

      if (esDirBroadcast) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
          String mensaje = "@hola#" + miNombre + "@";
          byte[] b = mensaje.getBytes(COD_TEXTO);
          DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length,
                  IPServidor, numPuerto);

          clientSocket.connect(IPServidor, numPuerto);
          clientSocket.send(paqueteEnviado);

          long startTime = System.currentTimeMillis();

          while (System.currentTimeMillis() - startTime < TIMEOUT) {
            byte[] datosRecibidos = new byte[MAX_BYTES];
            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos, datosRecibidos.length);

            clientSocket.setSoTimeout((int) (TIMEOUT - (System.currentTimeMillis() - startTime)));
            try {
              clientSocket.receive(paqueteRecibido);

              // Procesar respuesta en un hilo separado
              executorService.submit(() -> {
                String respuesta = null;
                try {
                  respuesta = new String(paqueteRecibido.getData(),
                          0, paqueteRecibido.getLength(), COD_TEXTO);
                } catch (UnsupportedEncodingException e) {
                  throw new RuntimeException(e);
                }

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
              });

            } catch (IOException e) {
              // Timeout de recepción, no se recibió ninguna respuesta más
              break;
            }
          }

        } catch (IOException ex) {
          System.out.println("Excepción de E/S");
          ex.printStackTrace();
        } finally {
          executorService.shutdown();
        }

      } else {
        System.err.println("La dirección proporcionada no es un broadcast en la red local.");
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
