
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
import modelos.ModeloDisponible;
import modelos.ModeloProducto;


public class DaoProducto {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean add(ModeloProducto modproducto) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into producto(costo_unidad_producto, disponible_producto, nombre_producto) value(?,?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setDouble(1, modproducto.getCosto_unidad_producto());
            ps.setInt(2, modproducto.getDisponible_producto());
            ps.setString(3, modproducto.getNombre_producto());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Producto añadido al inventario");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir producto al inventario");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(ModeloProducto modproducto, String id) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from producto where id_producto=?";
            ps=con.prepareStatement(removesql);
            ps.setString(1, id);
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado del inventario con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean edit(ModeloProducto modproducto, String id) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update producto set costo_unidad_producto=?, nombre_producto=? where id_producto=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setDouble(1, modproducto.getCosto_unidad_producto());
            ps.setString(2, modproducto.getNombre_producto());
            ps.setString(3, id);
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Producto editado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar producto");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean cambioestado(ModeloProducto modproducto) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="update producto set disponible_producto=? where id_producto=?";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setInt(1, modproducto.getDisponible_producto());
            ps.setInt(2, modproducto.getId_producto());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al editar estado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<ModeloProducto> producto() {
        
        ArrayList<ModeloProducto> listaproducto=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from producto INNER JOIN disponible on disponible.id_disponible = disponible_producto";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listaproducto=new ArrayList();
            
            while(rs.next()){
                ModeloProducto producto = new ModeloProducto();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setCosto_unidad_producto(rs.getDouble("costo_unidad_producto"));
                producto.setNombre_disponible(rs.getString("disponibilidad"));
                listaproducto.add(producto);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listaproducto;
    }
    
}
