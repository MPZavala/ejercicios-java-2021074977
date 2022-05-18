
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.ModeloBizcocho;


public class DaoBizcocho {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean add(ModeloBizcocho modbizcocho) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into bizcocho(nombre_bizcocho) value(?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modbizcocho.getNombre_bizcocho());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Bizcocho añadido");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir bizcocho");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(ModeloBizcocho modbizcocho) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from bizcocho where id_bizcocho=?";
            ps=con.prepareStatement(removesql);
            ps.setInt(1, modbizcocho.getId_bizcocho());
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Bizcocho eliminado con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar bizcocho");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean edit(ModeloBizcocho modbizcocho) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update bizcocho set nombre_bizcocho=? where id_bizcocho=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modbizcocho.getNombre_bizcocho());
            ps.setInt(2, modbizcocho.getId_bizcocho());
            
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Bizcocho editado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar bizcocho");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<ModeloBizcocho> tipobizcocho() {
        
        ArrayList<ModeloBizcocho> listabizcocho=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from bizcocho";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listabizcocho=new ArrayList();
            
            while(rs.next()){
                ModeloBizcocho bizcocho = new ModeloBizcocho();
                bizcocho.setId_bizcocho(rs.getInt("id_bizcocho"));
                bizcocho.setNombre_bizcocho(rs.getString("nombre_bizcocho"));
                listabizcocho.add(bizcocho);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listabizcocho;
    }
    
}
