package ej_3_1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InfoInterfacesRed {
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

        System.out.println();
    }
}

// ¿En qué cambia la salida del programa cuando se desconecta el cable de red o se desactiva la interfaz de red desde el
// sistema operativo?

// La salida del programa cambiará en la línea que indica si la interfaz está activa (isUp).
// Cuando desconectas el cable de red o desactivas la interfaz desde el sistema operativo, la interfaz dejará de
// estar activa y se mostrará "Es activa: false" para esa interfaz en particular.

// ¿Para qué tipos de interfaces se muestra información?

// La información se muestra para todas las interfaces de red presentes en el sistema, incluyendo interfaces físicas y
// virtuales. Esto puede incluir interfaces Ethernet, WiFi, interfaces de bucle local, entre otras.

// ¿Hay alguna que esté siempre activa? ¿Cuál?

// En general, la interfaz de bucle local (loopback) suele estar siempre activa, ya que es una interfaz virtual que se
// utiliza para las comunicaciones locales en el propio equipo. Puedes identificarla por el hecho de que isLoopback
// será true para esa interfaz.