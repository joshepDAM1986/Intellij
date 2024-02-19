import dao.*;
import servicios.APIREST;

public class Servidor {

    public static void main(String[] args) {

        APIREST api=new APIREST(new AlumnoDAO(), new CursoDAO(), new ProfesorDAO(), new AcademiaDAO(), new AsociacionesDAO());
    }
}
