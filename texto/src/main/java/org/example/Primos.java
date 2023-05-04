package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Primos {
    public static void escribirPrimos(){
        int num = 10;
        boolean primo;

        try {
            FileWriter fw = new FileWriter("C:\\ficheros\\numPrimos.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int n = 2; n <= num; n++) {
                primo = true;
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        primo = false;
                        break;
                    }
                }
                if (primo) {
                    pw.println(n);
                    System.out.println(n);
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Excecpción " + e);
        }
    }
}



