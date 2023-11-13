import java.util.HashMap;
import java.util.Set;

public class ResultadosEncuesta {
    private final HashMap<String, Integer> totalPorRespuesta = new HashMap<>();
    private final HashMap<String, Integer> totalPorZona = new HashMap<>();

    //Suma uno a número de repuestas para la zona y para la respuesta
    synchronized public void anotaRespuesta(String idZona, String respuesta) {
        Integer numRespValor = this.totalPorRespuesta.get(respuesta);
        this.totalPorRespuesta.put(respuesta, numRespValor == null ?  1 : numRespValor+1);

        Integer numRespZona = this.totalPorRespuesta.get(idZona);
        this.totalPorRespuesta.put(idZona,numRespZona == null ?  1 : numRespZona+1);
    }
    synchronized public Set<String> obtenZonas() {
        return this.totalPorZona.keySet();
    }
    synchronized public Set<String> obtenRespuestas() {
        return this.totalPorRespuesta.keySet();
    }
    synchronized public int obtenNumRespuestasZona(String zona){
        return this.totalPorZona.get(zona);
    }
    synchronized public int obtenNumRespuestas(String respuesta) {
        return this.totalPorRespuesta.get(respuesta);
    }
}
