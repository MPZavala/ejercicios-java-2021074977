
package ejercicio27042022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con;
    String driver="com.mysql.jdbc.Driver";
    String user="root";
    String pass="";
    String BD="colegiointecap";
    String datocon="jdbc:mysql://localhost:3306/";
    
    public Connection conectorDB() {
        con = null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(datocon+BD, user, pass);
            
            if (con!=null){
                System.out.println("Conexion Exitosa");
                return con;
            }
            
            
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Imposible conectar");
            return con;
        }
        
        return con;
    }
    
}
