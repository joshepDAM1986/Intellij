import java.util.Set;

public class Encuesta {
    private static final int NUM_ZONAS = 20;

    public static void main(String[] args) {
        ResultadosEncuesta resultados = new ResultadosEncuesta();

        Thread[] encuestadores = new Thread[NUM_ZONAS];
        for (int i = 0; i < NUM_ZONAS; i++) { //Crea hilos
            Thread encuestador = new Thread(
                    new EncuestadorZona("zona" + (i + 1), resultados));
            encuestadores[i] = encuestador;
        }
        for (Thread encuestador : encuestadores) { //Lanza hilos
            encuestador.start();
        }
        for (Thread encuestador : encuestadores) { //Espera que terminen
            try {
                encuestador.join();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("Encuestados por zonas");
        Set<String> zonas = resultados.obtenZonas();
        int granTotalPorZonas = 0;
        for (String zona : zonas) {
            int totalParaZona = resultados.obtenNumRespuestasZona(zona);
            System.out.printf("%s: %d\n", zona, totalParaZona);
            granTotalPorZonas += totalParaZona;
        }
        System.out.printf("TOTAL: %d\n", granTotalPorZonas);
        System.out.println("Resultados por respuesta:");
        Set<String> respuestas = resultados.obtenRespuestas();
        int granTotalPorRespuestas = 0;
        for (String respuesta : respuestas) {
            int totalParaRespuesta = resultados.obtenNumRespuestas(respuesta);
            System.out.printf("%s: %d\n",
                    respuesta != null ? respuesta : "NS/NC", totalParaRespuesta);
            granTotalPorRespuestas += totalParaRespuesta;
        }
        System.out.printf("TOTAL: %d\n", granTotalPorRespuestas);
    }
}
