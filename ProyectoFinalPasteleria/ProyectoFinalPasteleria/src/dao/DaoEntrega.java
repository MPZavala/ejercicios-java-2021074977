
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.ModeloEntrega;


public class DaoEntrega {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public ArrayList<ModeloEntrega> tipoentrega() {
        //Cargar la info del array en el combobox
        ArrayList<ModeloEntrega> listaentrega=null;
        con=connect.getConnection();
        
        
        try {
            String sql="select * from entrega";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listaentrega=new ArrayList();
            
            while(rs.next()){
                ModeloEntrega entrega = new ModeloEntrega();
                entrega.setId_entrega(rs.getInt("id_entrega"));
                entrega.setNombre_entrega(rs.getString("nombre_tipo_entrega"));
                listaentrega.add(entrega);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listaentrega;
    }
    
}
