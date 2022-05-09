
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    private static Connection con;
    String driver="com.mysql.jdbc.Driver";
    String user="root";
    String pass="";
    String BD="proyectofinalpasteleria";
    String datocon="jdbc:mysql://localhost:3306/";
    Boolean EstadoConexion=true;
    
    public Conexion() {
        
    }
    
    public Connection getConnection() {
        con = null;
        try {
            
            Class.forName(driver);
            con = DriverManager.getConnection(datocon+BD, user, pass);
            System.err.println("Conexión exitosa");
            
        } catch (Exception error) {
            System.err.println(error);
            System.out.println("Imposible conectar");
            EstadoConexion=false;
            return con;
        }
        
        
        return con;
    }
    
    public void CloseConnection() {
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
