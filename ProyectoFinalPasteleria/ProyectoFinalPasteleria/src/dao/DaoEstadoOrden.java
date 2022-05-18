
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.ModeloEstado;


public class DaoEstadoOrden {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public ArrayList<ModeloEstado> estadoorden() {
        //Cargar la info del array en el combobox
        ArrayList<ModeloEstado> listaestado=null;
        con=connect.getConnection();
        
        
        try {
            String sql="select * from estado";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listaestado=new ArrayList();
            
            while(rs.next()){
                ModeloEstado estado = new ModeloEstado();
                estado.setId_Estado(rs.getInt("id_estado"));
                estado.setNombre_Estado(rs.getString("nombre_estado"));
                listaestado.add(estado);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listaestado;
    }
    
}
