package EjercicioPropuesto.Ej2;


import java.util.Random;

public class Persona implements Runnable {
    private DepositoPintura[] colores;
    private String nombre;
    private Random rand = new Random();

    public Persona(String nombre, DepositoPintura[] colores) {
        this.nombre = nombre;
        this.colores = colores;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(rand.nextInt(1400) + 100);


                int indice1 = rand.nextInt(3);
                int indice2 = (indice1 + rand.nextInt(2) + 1) % 3;

                    DepositoPintura[] coloresOrdenados = ordenarColores(colores[indice1], colores[indice2]);
                synchronized (coloresOrdenados[0]) {
                    synchronized (coloresOrdenados[1]) {
                        String color1 = coloresOrdenados[0].getColor();
                        String color2 = coloresOrdenados[1].getColor();

                        prepararColor(color1, color2);

                        Thread.sleep(rand.nextInt(1000) + 1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void prepararColor(String color1, String color2) {
        String colorSecundario = obtenerColorSecundario(color1, color2);
        System.out.println(nombre + " preparó " + colorSecundario + " usando " + color1 + " y " + color2);
    }

    private String obtenerColorSecundario(String color1, String color2) {
        if ((color1.equals("amarillo") && color2.equals("magenta")) || (color1.equals("magenta") && color2.equals("amarillo"))) {
            return "rojo";
        } else if ((color1.equals("magenta") && color2.equals("cian")) || (color1.equals("cian") && color2.equals("magenta"))) {
            return "azul";
        } else if ((color1.equals("amarillo") && color2.equals("cian")) || (color1.equals("cian") && color2.equals("amarillo"))) {
            return "verde";
        } else {
            return "desconocido";
        }
    }
    private DepositoPintura[] ordenarColores(DepositoPintura color1, DepositoPintura color2) {
        DepositoPintura[] coloresOrdenados = { color1, color2 };
        if (color1.getColor().compareTo(color2.getColor()) > 0) {
            coloresOrdenados[0] = color2;
            coloresOrdenados[1] = color1;
        }
        return coloresOrdenados;
    }

}
