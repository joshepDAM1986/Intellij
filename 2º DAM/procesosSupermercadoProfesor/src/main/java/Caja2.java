public class Caja2 implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long timeStamp;
    // Constructor, getter y setter
    @Override
    public void run() {
        System.out.println("Empleado/a " + this.nombre +
                " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
                " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
                "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                    "seg");
        }
        System.out.println("Empleado/a " + this.nombre + " HA TERMINADO DE PROCESAR " +
                cliente.getNombre() + " EN EL TIEMPO: " +
                (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Caja2(String nombre, Cliente cliente, long timeStamp) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.timeStamp = timeStamp;
    }
}