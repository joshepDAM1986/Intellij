package org.example;

import java.io.InputStream;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net. MalformedURLException;
import java.io.IOException;
public class Main {
    static String urlStr = "https://pokeapi.co/api/v2/type/14/";
    public static void main(String[] args) {
        try {
            URL url = new URL(urlStr);
            try (InputStream is = url.openConnection().getInputStream();
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)) {
                System.out.printf("Contenidos de %s\n", urlStr);
                System.out.println("- ----\n");
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("-- \n");
            } catch (IOException ex) {
                System.out.printf("Error de E/S obteniendo contenidos de URL.\n"); ex.printStackTrace();
            }
        } catch (MalformedURLException ex) {
            System.out.printf("URL mal formada: %s.\n");
            ex.printStackTrace();
        }
    }
}