import dao.AsociacionesDAO;
import dao.ClienteDAO;
import dao.MuebleDAO;
import dao.ProveedorDAO;
import servicios.MueblesAPIREST;

public class Servidor {

    public static void main(String[] args) {
        MueblesAPIREST api=new MueblesAPIREST(new MuebleDAO(),new ProveedorDAO(),new ClienteDAO(),new AsociacionesDAO());
    }
}
