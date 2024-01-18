package ej_3_3;

import java.net.*;

// Este programa escanea todas las direcciones IP dentro del rango especificado (192.168.1.1 a 192.168.1.254) y
// verifica si son alcanzables utilizando el método isReachable. Ten en cuenta que algunos sistemas operativos
// pueden bloquear la respuesta a ping, lo que podría afectar la capacidad del programa para determinar la
// accesibilidad de las direcciones IP. Además, asegúrate de tener permisos suficientes para ejecutar este programa.
// Puedes necesitar ejecutarlo con privilegios de administrador/root para escanear la red local.

public class ScanLocalNetwork {
    public static void main(String[] args) {
        try {
            // Especifica el prefijo de la red local
            String networkPrefix = "192.168.1.";  // Cambia esto según tu configuración

            // Máscara de red de 24 bits
            int subnetMask = 24;

            System.out.println("Escaneando la red local...");

            for (int i = 1; i <= 254; i++) {
                String ipAddress = networkPrefix + i;

                InetAddress inetAddress = InetAddress.getByAddress(toByteArray(ipAddress));

                // Verifica si la dirección es alcanzable
                if (inetAddress.isReachable(1000)) {
                    System.out.println("Dirección alcanzable: " + ipAddress);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Convierte una dirección IP en formato de cadena a un arreglo de bytes
    static byte[] toByteArray(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        byte[] result = new byte[4];
        for (int i = 0; i < 4; i++) {
            result[i] = (byte) Integer.parseInt(ipAddressInArray[i]);
        }

        return result;
    }
}