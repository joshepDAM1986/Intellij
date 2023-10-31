import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){
        try{
        Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost/empresas","root","");
        Statement consulta= conexion.createStatement();
        String sql_insert="INSERT INTO departamentos "+
                          "VALUES (null,'I.T.','MADRID')";

        String sql_delete="DELETE FROM departamentos "+
                "WHERE nombre= 'I.T.'";

        String anterior="DALLAS";
        String nueva="MARACENA";

        String sql_update="UPDATE departamentos "+
                "SET localizacion='MARACENA' " +
                "WHERE localizacion='NEW YORK'";

        String sql_update2="UPDATE departamentos "+
                "SET localizacion='"+nueva+ "'" +
                "WHERE localizacion='"+anterior+"'";


//        consulta.executeUpdate(sql_insert);
//        consulta.executeUpdate(sql_delete);
//        consulta.executeUpdate(sql_update);
          consulta.executeUpdate(sql_update2);
        consulta.close();
        conexion.close();
        } catch (SQLException sql) {
            throw new RuntimeException("Error de SQL");
        }
    }
}
