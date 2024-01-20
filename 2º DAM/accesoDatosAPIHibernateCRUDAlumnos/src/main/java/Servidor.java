import dao.AlumnoDAO;
import servicios.AlumnoAPIREST;

public class Servidor {

    public static void main(String[] args) {

        AlumnoAPIREST api=new AlumnoAPIREST(new AlumnoDAO());
    }
}
