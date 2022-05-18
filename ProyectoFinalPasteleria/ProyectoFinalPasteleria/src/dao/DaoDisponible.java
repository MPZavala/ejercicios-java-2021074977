
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.ModeloDisponible;


public class DaoDisponible {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public ArrayList<ModeloDisponible> disponibilidad() {
        
        ArrayList<ModeloDisponible> listadisponible=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from disponible";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listadisponible=new ArrayList();
            
            while(rs.next()){
                ModeloDisponible disponible = new ModeloDisponible();
                disponible.setId_disponible(rs.getInt("id_disponible"));
                disponible.setDisponibilidad(rs.getString("disponibilidad"));
                listadisponible.add(disponible);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listadisponible;
    }
    
}
