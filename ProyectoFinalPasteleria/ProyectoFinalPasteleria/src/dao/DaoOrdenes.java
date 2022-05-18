
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
import modelos.ModeloBizcocho;
import modelos.ModeloEmpleado;
import modelos.ModeloOrden;
import modelos.ModeloRelleno;


public class DaoOrdenes {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean add(ModeloOrden modorden, ModeloEmpleado modempleado) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into orden(empleado_orden, nombre_cliente_orden, producto_orden, extras_orden, fecha_entrega, tipo_entrega, costo_total, oferta_id, cantidad_producto, relleno_orden,betun_orden,bizcocho_orden,direccion_orden,estado_orden) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setInt(1, modorden.getEmpleado_orden());
            ps.setString(2, modorden.getNombre_cliente_orden());
            ps.setInt(3, modorden.getProducto_orden());
            ps.setString(4, modorden.getExtras_orden());
            ps.setString(5, modorden.getFecha_entrega());
            ps.setInt(6, modorden.getTipo_entrega());
            ps.setDouble(7, modorden.getCosto_total());
            ps.setInt(8, modorden.getOferta_id());
            ps.setInt(9, modorden.getCantidad_producto());
            ps.setInt(10, modorden.getRelleno_orden());
            ps.setInt(11, modorden.getBetun_orden());
            ps.setInt(12, modorden.getBizcocho_orden());
            ps.setString(13, modorden.getDireccion_orden());
            ps.setInt(14, modorden.getEstado_orden());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Orden agregada");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir orden");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean edit(ModeloOrden modorden) {
        
        int respuesta;
        con=connect.getConnection();
        String editsql="update orden set nombre_cliente_orden=?, extras_orden=?, fecha_entrega=?, tipo_entrega=?, direccion_orden=?, estado_orden=? where numero_orden=?";
        
        try {
            ps=con.prepareStatement(editsql);
            ps.setString(1, modorden.getNombre_cliente_orden());
            ps.setString(2, modorden.getExtras_orden());
            ps.setString(3, modorden.getFecha_entrega());
            ps.setInt(4, modorden.getTipo_entrega());
            ps.setString(5, modorden.getDireccion_orden());
            ps.setInt(6, modorden.getEstado_orden());
            ps.setInt(7, modorden.getNumero_orden());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Orden actualizada");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al actualizar orden");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean estado(ModeloOrden modorden, String orden) {
        
        int respuesta;
        con=connect.getConnection();
        String sql="update orden set estado_orden=? where numero_orden=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, modorden.getEstado_orden());
            ps.setString(2, orden);
            
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Estado actualizado");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado de su orden");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean delete(ModeloOrden modorden) {
        
        int respuesta;
        con=connect.getConnection();
        String deletesql="DELETE from orden where numero_orden=?";
        
        try {
            ps=con.prepareStatement(deletesql);
            ps.setInt(1, modorden.getNumero_orden());
            
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Orden eliminada");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar orden");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public boolean seleccion(ModeloOrden orden, int id){
        int respuesta;
        con=connect.getConnection();
        String sql="SELECT * from orden INNER JOIN empleado on empleado.id_empleado = empleado_orden INNER JOIN producto on producto.id_producto = producto_orden INNER JOIN entrega on entrega.id_entrega = tipo_entrega INNER JOIN relleno on relleno.id_relleno = relleno_orden INNER JOIN betun on betun.id_betun = betun_orden INNER JOIN bizcocho on bizcocho.id_bizcocho = bizcocho_orden INNER JOIN estado on estado.id_estado = estado_orden where numero_orden=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            
            
            rs=ps.executeQuery();
            
            while(rs.first()) {
                if (id == rs.getInt("numero_orden")){
                    
                    orden.setNumero_orden(rs.getInt("numero_orden"));
                    orden.setNombre_empleado(rs.getString("nombre_empleado"));
                    orden.setNombre_cliente_orden(rs.getString("nombre_cliente_orden"));
                    orden.setExtras_orden(rs.getString("extras_orden"));
                    orden.setFecha_entrega(rs.getDate("fecha_entrega").toString());
                    orden.setNombre_entrega(rs.getString("nombre_tipo_entrega"));
                    orden.setCosto_total(rs.getDouble("costo_total"));
                    orden.setCantidad_producto(rs.getInt("cantidad_producto"));
                    orden.setNombre_relleno(rs.getString("nombre_relleno"));
                    orden.setNombre_betun(rs.getString("nombre_betun"));
                    orden.setNombre_bizcocho(rs.getString("nombre_bizcocho"));
                    orden.setDireccion_orden(rs.getString("direccion_orden"));
                    orden.setNombre_estado_orden(rs.getString("nombre_estado"));
                    orden.setNombre_producto(rs.getString("nombre_producto"));
                    return true;
                }
                System.out.println("dao "+orden.getNombre_bizcocho());
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connect.CloseConnection();
        }
        
        return false;
    }
    
    public ArrayList<ModeloOrden> tabla(){
        ArrayList<ModeloOrden> lista=null;
        con=connect.getConnection();
        String addsql="select * from orden INNER JOIN empleado on empleado.id_empleado = empleado_orden INNER JOIN producto on producto.id_producto = producto_orden INNER JOIN entrega on entrega.id_entrega = tipo_entrega INNER JOIN relleno on relleno.id_relleno = relleno_orden INNER JOIN betun on betun.id_betun = betun_orden INNER JOIN bizcocho on bizcocho.id_bizcocho = bizcocho_orden INNER JOIN estado on estado.id_estado = estado_orden";
        
        try {
            ps=con.prepareStatement(addsql);
            rs=ps.executeQuery();
            
            lista=new ArrayList();
            
            while(rs.next()) {
                ModeloOrden orden = new ModeloOrden();
                orden.setNumero_orden(rs.getInt("numero_orden"));
                orden.setNombre_empleado(rs.getString("nombre_empleado"));
                orden.setNombre_cliente_orden(rs.getString("nombre_cliente_orden"));
                orden.setExtras_orden(rs.getString("extras_orden"));
                orden.setFecha_entrega(rs.getDate("fecha_entrega").toString());
                orden.setNombre_entrega(rs.getString("nombre_tipo_entrega"));
                orden.setCosto_total(rs.getDouble("costo_total"));
                orden.setCantidad_producto(rs.getInt("cantidad_producto"));
                orden.setNombre_relleno(rs.getString("nombre_relleno"));
                orden.setNombre_betun(rs.getString("nombre_betun"));
                orden.setNombre_bizcocho(rs.getString("nombre_bizcocho"));
                orden.setDireccion_orden(rs.getString("direccion_orden"));
                orden.setNombre_estado_orden(rs.getString("nombre_estado"));
                orden.setNombre_producto(rs.getString("nombre_producto"));
                lista.add(orden);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.CloseConnection();
        }
        
        return lista;
    }
    
}
