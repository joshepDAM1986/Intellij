package org.example;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hola Buenos días!");
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}