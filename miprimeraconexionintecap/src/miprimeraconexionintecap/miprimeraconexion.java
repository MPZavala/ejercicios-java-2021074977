
package miprimeraconexionintecap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class miprimeraconexion {
    
    //declaracion de variable global
    Connection conexion;
    
    public miprimeraconexion() {
        
        try {
            //declaracion de driver de conexion a BD
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");
            System.out.println("si funciona");
        }
        catch(Exception error){
            System.out.println(error);
        }
        
        
    }
    
    public static void main(String[] args) {
         miprimeraconexion Cn=new miprimeraconexion();
         
         //variables Statement y Resultset.
         //Statement ejecuta querys o consultas a BD. Resultset para accesar a la BD
         Statement st;
         ResultSet rs;
         try{
             //creando consulta u operacion a BD
             st=Cn.conexion.createStatement();
             rs=st.executeQuery("Select * from city");
             while (rs.next()) {
                 System.out.println(rs.getInt("ID")+", "+rs.getString("Name")+", "+rs.getString("CountryCode")+", "+rs.getString("District")+", "+rs.getInt("Population"));
             }
             Cn.conexion.close();
             
         }
         catch (Exception error) {
             System.out.println(error);
         }
        }
    
}
