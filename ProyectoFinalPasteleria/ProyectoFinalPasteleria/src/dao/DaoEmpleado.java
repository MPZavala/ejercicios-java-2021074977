
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
import modelos.ModeloEmpleado;


public class DaoEmpleado {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean login (ModeloEmpleado modempleado) {
        con=connect.getConnection();
        String sql="select * from empleado INNER JOIN rango on rango.id_rango=rango_empleado where usuario_empleado = ? and pass_empleado = ?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, modempleado.getUsuario_empleado());
            ps.setString(2, modempleado.getPass_empleado());
            
            rs=ps.executeQuery();
            
            if(rs.next()) {
                if(modempleado.getUsuario_empleado().equals(rs.getString("usuario_empleado"))) {
                    if(modempleado.getPass_empleado().equals(rs.getString("pass_empleado"))) {
                        //Asignar datos a variables empleado
                        modempleado.setNombre_empleado(rs.getString("nombre_empleado"));
                        modempleado.setRango_empleado(Integer.parseInt(rs.getString("id_rango")));
                        modempleado.setDescripcionrol(rs.getString("nombre_rango"));
                        modempleado.setId_empleado(rs.getInt("id_empleado"));
                        modempleado.setTelefono_empleado(rs.getInt("telefono_empleado"));
                        modempleado.setCorreo_empleado(rs.getString("correo_empleado"));
                        
                        JOptionPane.showMessageDialog(null, "Bienvenid@ "+modempleado.getNombre_empleado());
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
                        return false;
                    }
                } 
                
            }else {
                    JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
                    return false;
                }
            
        } catch (SQLException error){
            System.out.println(error);
        }finally{
            connect.CloseConnection();
        }
        return false;
    }
    
    public boolean add(ModeloEmpleado modempleado) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into empleado(nombre_empleado, rango_empleado, telefono_empleado, usuario_empleado, pass_empleado, correo_empleado) value(?,?,?,?,?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(1, modempleado.getNombre_empleado());
            ps.setInt(2, modempleado.getRango_empleado());
            ps.setInt(3, modempleado.getTelefono_empleado());
            ps.setString(4, modempleado.getUsuario_empleado());
            ps.setString(5, modempleado.getPass_empleado());
            ps.setString(6, modempleado.getCorreo_empleado());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Empleado añadido");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir empleado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean delete(ModeloEmpleado modempleado, String id) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from empleado where id_empleado=?";
            ps=con.prepareStatement(removesql);
            ps.setString(1, id);
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar empleado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean edit(ModeloEmpleado modempleado, String id) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update empleado set nombre_empleado=?,rango_empleado=?,telefono_empleado=?,usuario_empleado=?,correo_empleado=? where id_empleado=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(6, id);
            ps.setString(1, modempleado.getNombre_empleado());
            ps.setInt(2, modempleado.getRango_empleado());
            ps.setInt(3, modempleado.getTelefono_empleado());
            ps.setString(4, modempleado.getUsuario_empleado());
            ps.setString(5, modempleado.getCorreo_empleado());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Empleado editado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar empleado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean newpass(ModeloEmpleado modempleado, String id) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update empleado set pass_empleado=? where id_empleado=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setString(2, id);
            ps.setString(1, modempleado.getPass_empleado());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Contraseña actualizada");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al modificar la contraseña del usuario seleccionado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public ArrayList<ModeloEmpleado> tabla(){
        ArrayList<ModeloEmpleado> lista=null;
        con=connect.getConnection();
        String addsql="select * from empleado INNER JOIN rango on rango.id_rango=rango_empleado";
        
        try {
            ps=con.prepareStatement(addsql);
            rs=ps.executeQuery();
            
            lista=new ArrayList();
            
            while(rs.next()) {
                ModeloEmpleado empleado = new ModeloEmpleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre_empleado(rs.getString("nombre_empleado"));
                empleado.setUsuario_empleado(rs.getString("usuario_empleado"));
                empleado.setCorreo_empleado(rs.getString("correo_empleado"));
                empleado.setTelefono_empleado(rs.getInt("telefono_empleado"));
                empleado.setDescripcionrol(rs.getString("nombre_rango"));
                lista.add(empleado);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.CloseConnection();
        }
        
        return lista;
    }
    
    
    
}
