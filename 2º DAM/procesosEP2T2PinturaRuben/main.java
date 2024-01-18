package EjercicioPropuesto.Ej2;

public class main {


    public static void main(String[] args) {
        DepositoPintura cian = new DepositoPintura("cian");
        DepositoPintura magenta = new DepositoPintura("magenta");
        DepositoPintura amarillo = new DepositoPintura("amarillo");

        DepositoPintura[] colores = {cian, magenta, amarillo};

        Thread p1 = new Thread( new Persona("Persona 1", colores));
        Thread p2 = new Thread( new Persona("Persona 2", colores));
        Thread p3 = new Thread( new Persona("Persona 3", colores));

        p1.start();
        p2.start();
        p3.start();
    }

}
