package ej_3_4;

import java.net.*;
import java.util.Enumeration;


// Este programa recorre todas las interfaces de red y selecciona la primera interfaz que tiene una dirección IP de red
// local. Luego, calcula y muestra la dirección de broadcast correspondiente a esa interfaz. Ten en cuenta que este
// programa asume que la interfaz tiene al menos una dirección IPv4 y utiliza la primera dirección encontrada.

public class BroadcastAddress {
    public static void main(String[] args) {
        try {
            System.out.println("Obteniendo la dirección de broadcast para la red local...");

            // Obtén todas las interfaces de red disponibles
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                // Selecciona una interfaz con una dirección IP de red local
                if (hasSiteLocalAddress(networkInterface)) {
                    InetAddress broadcastAddress = getBroadcastAddress(networkInterface);
                    if (broadcastAddress != null) {
                        System.out.println("Interfaz seleccionada: " + networkInterface.getName());
                        System.out.println("Dirección de broadcast: " + broadcastAddress.getHostAddress());
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    static boolean hasSiteLocalAddress(NetworkInterface networkInterface) {
        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress address = addresses.nextElement();
            if (address.isSiteLocalAddress()) {
                return true;
            }
        }
        return false;
    }

    static InetAddress getBroadcastAddress(NetworkInterface networkInterface) throws SocketException {
        Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
        while (addresses.hasMoreElements()) {
            InetAddress address = addresses.nextElement();
            if (address instanceof Inet4Address) {
                short maskLength = networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength();
                int subnetMask = 0xffffffff << (32 - maskLength);

                byte[] rawAddress = address.getAddress();
                byte[] broadcast = new byte[4];

                for (int i = 0; i < 4; i++) {
                    broadcast[i] = (byte) (rawAddress[i] | (~subnetMask & 0xff));
                }

                try {
                    return InetAddress.getByAddress(broadcast);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}