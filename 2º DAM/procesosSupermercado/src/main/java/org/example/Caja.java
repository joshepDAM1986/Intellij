package org.example;

    public class Caja{

        private String nombre;
        // Constructor, getter y setter

        public Caja(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void procesarCompra(Cliente cliente, long timeStamp) {
            System.out.println("Empleado/a " + this.nombre +
                    " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() +
                    " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +
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
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

