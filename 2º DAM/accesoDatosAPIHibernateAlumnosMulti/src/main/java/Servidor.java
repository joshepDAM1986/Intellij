import dao.*;
import servicios.AlumnoAPIREST;

public class Servidor {

    public static void main(String[] args) {

        AlumnoAPIREST api=new AlumnoAPIREST(new AlumnoDAO(), new CursoDAO(), new ProfesorDAO(), new AcademiaDAO(), new AsociacionesDAO());
    }
}
