
package dao;

import conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.ModeloUsuario;


public class DaoUsuario {
    
    //Conexion con la BD
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    //ModeloUsuario modusuario = new ModeloUsuario();
    
    public boolean login(ModeloUsuario usuario){
        
        con=connect.getConnection();
        String sql="select * from usuarios where usuario = ? and password = ?";
        
        try {
            
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            
            rs=ps.executeQuery();
            
            if(rs.first()) {
                
                if(usuario.getPass().equals(rs.getString("password"))) {
                        JOptionPane.showMessageDialog(null, "Bienvenid@ "+rs.getString("nombre"));
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        return false;
                    } 
            } else {
                    JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean add(ModeloUsuario usuario) {
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into usuarios(usuario, password, nombre, correo, direccion, telefono, dpi) value(?,?,?,?,?,?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPass());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setString(7, usuario.getDpi());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Usuario añadido");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir usuario");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
