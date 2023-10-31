import java.sql.*;

public class Select {
    public static void main(String[] args){
        Connection conexion=null;
        Statement consulta=null;
        ResultSet resultado=null;
    try{
        conexion= DriverManager.getConnection("jdbc:mysql://localhost/empresas","root","");
        consulta=conexion.createStatement();

        String sql_select="SELECT * FROM departamentos ";
        resultado = consulta.executeQuery(sql_select);

        String salida="";
        while (resultado.next()){
            salida+=resultado.getInt(1)+"\n"+
                    resultado.getString(2)+"\n"+
                    resultado.getString(3)+"\n"+
                    "----------------------------------\n";
        }
        System.out.printf(salida);
//        podemos hacerlo tambien con nombres de columnas en vez de posiciones

//        while (resultado.next()){
//            salida+=resultado.getInt("id")+"\n"+
//                    resultado.getString("nombre")+"\n"+
//                    resultado.getString("localizacion")+"\n"+
//                    "----------------------------------\n";
//        }
//        System.out.printf(salida);

    } catch (
    SQLException sql) {
        sql.printStackTrace();
        throw new RuntimeException("Error de SQL");
        }
    finally {
        try {
            if (resultado != null) resultado.close();
            if (consulta != null) consulta.close();
            if (conexion != null) conexion.close();
            } catch (SQLException sql) {
            sql.printStackTrace();
                throw new RuntimeException("Error de SQL");
            }
        }
    }
}

