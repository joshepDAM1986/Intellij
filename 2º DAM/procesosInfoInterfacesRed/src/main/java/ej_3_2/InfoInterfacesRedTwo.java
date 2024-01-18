package ej_3_2;

import java.net.*;
import java.util.*;

// Este programa muestra información sobre direcciones IP, máscaras de red y direcciones de broadcast para cada
// interfaz. La función getSubnetMask convierte la longitud de prefijo de red en una máscara de subred legible.
// Ten en cuenta que la salida puede variar según el sistema operativo y las configuraciones específicas de la red.

public class InfoInterfacesRedTwo {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                displayInterfaceInformation(networkInterface);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    static void displayInterfaceInformation(NetworkInterface networkInterface) throws SocketException {
        System.out.println("Nombre de la interfaz: " + networkInterface.getName());
        System.out.println("Nombre de la interfaz mostrable: " + networkInterface.getDisplayName());

        System.out.println("Es bucle local: " + networkInterface.isLoopback());
        System.out.println("Es punto a punto: " + networkInterface.isPointToPoint());
        System.out.println("Es activa: " + networkInterface.isUp());
        System.out.println("Es virtual: " + networkInterface.isVirtual());

        System.out.println("Configuración IP:");
        List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
        for (InterfaceAddress interfaceAddress : interfaceAddresses) {
            InetAddress address = interfaceAddress.getAddress();
            InetAddress broadcast = interfaceAddress.getBroadcast();
            short maskLength = interfaceAddress.getNetworkPrefixLength();

            System.out.println("   Dirección IP: " + address.getHostAddress());
            System.out.println("   Máscara de red: " + getSubnetMask(maskLength));
            if (broadcast != null) {
                System.out.println("   Dirección de broadcast: " + broadcast.getHostAddress());
            }

            if (address instanceof Inet4Address) {
                System.out.println("   Tipo de IP: IPv4");
            } else if (address instanceof Inet6Address) {
                System.out.println("   Tipo de IP: IPv6");
            }

            System.out.println();
        }
    }

    static String getSubnetMask(short maskLength) {
        int mask = 0xffffffff << (32 - maskLength);
        return String.format("%d.%d.%d.%d",
                (mask & 0xff000000) >>> 24,
                (mask & 0x00ff0000) >>> 16,
                (mask & 0x0000ff00) >>> 8,
                (mask & 0x000000ff));
    }
}

