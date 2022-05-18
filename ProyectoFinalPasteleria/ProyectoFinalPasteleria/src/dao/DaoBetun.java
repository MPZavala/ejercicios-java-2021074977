
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
import modelos.ModeloBetun;


public class DaoBetun {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean add(ModeloBetun modbetun) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into betun(nombre_betun) value(?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modbetun.getNombre_betun());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Betun añadido");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir betun");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(ModeloBetun modbetun) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from betun where id_betun=?";
            ps=con.prepareStatement(removesql);
            ps.setInt(1, modbetun.getId_betun());
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Betun eliminado con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar betun");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean edit(ModeloBetun modbetun) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update betun set nombre_betun=? where id_betun=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modbetun.getNombre_betun());
            ps.setInt(2, modbetun.getId_betun());
            
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Betun editado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar betun");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<ModeloBetun> tipobetun() {
        
        ArrayList<ModeloBetun> listabetun=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from betun";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listabetun=new ArrayList();
            
            while(rs.next()){
                ModeloBetun betun = new ModeloBetun();
                betun.setId_betun(rs.getInt("id_betun"));
                betun.setNombre_betun(rs.getString("nombre_betun"));
                listabetun.add(betun);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listabetun;
    }
    
}
