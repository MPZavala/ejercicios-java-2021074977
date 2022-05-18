
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
import modelos.ModeloRelleno;


public class DaoRelleno {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean add(ModeloRelleno modrelleno) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into relleno(nombre_relleno) value(?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modrelleno.getNombre_relleno());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Relleno añadido");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir relleno");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(ModeloRelleno modrelleno) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from relleno where id_relleno=?";
            ps=con.prepareStatement(removesql);
            ps.setInt(1, modrelleno.getId_relleno());
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Relleno eliminado con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar relleno");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean edit(ModeloRelleno modrelleno) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update relleno set nombre_relleno=? where id_relleno=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modrelleno.getNombre_relleno());
            ps.setInt(2, modrelleno.getId_relleno());
            
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Relleno editado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar relleno");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<ModeloRelleno> tiporelleno() {
        
        ArrayList<ModeloRelleno> listarelleno=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from relleno";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listarelleno=new ArrayList();
            
            while(rs.next()){
                ModeloRelleno relleno = new ModeloRelleno();
                relleno.setId_relleno(rs.getInt("id_relleno"));
                relleno.setNombre_relleno(rs.getString("nombre_relleno"));
                listarelleno.add(relleno);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listarelleno;
    }
    
}
