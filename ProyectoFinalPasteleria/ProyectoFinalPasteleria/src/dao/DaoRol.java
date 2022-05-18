
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.ModeloRango;


public class DaoRol {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public ArrayList<ModeloRango> roles() {
        //Cargar la info del array en el combobox
        ArrayList<ModeloRango> listarol=null;
        con=connect.getConnection();
        
        
        try {
            String rolsql="select * from rango";
            ps=con.prepareStatement(rolsql);
            rs=ps.executeQuery();
            listarol=new ArrayList();
            
            while(rs.next()){
                ModeloRango rango = new ModeloRango();
                rango.setId_rango(rs.getInt("id_rango"));
                rango.setNombre_rango(rs.getString("nombre_rango"));
                listarol.add(rango);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listarol;
    }
    
}
