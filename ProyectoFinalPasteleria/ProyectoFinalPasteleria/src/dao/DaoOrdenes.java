
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
import modelos.ModeloEntrega;
import modelos.ModeloEstado;
import modelos.ModeloOferta;
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
            ps.setInt(1, modempleado.getId_empleado());
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
        }
        
        return false;
    }
    
    public boolean edit(ModeloOrden modorden, String orden) {
        
        int respuesta;
        con=connect.getConnection();
        String editsql="update orden set nombre_cliente_orden=?, producto_orden=?, extras_orden=?, fecha_entrega=?, tipo_entrega=?, costo_total=?, cantidad_producto=?, relleno_orden=?, betun_orden=?, bizcocho_orden=?, direccion_orden=? where numero_orden=?";
        
        try {
            ps=con.prepareStatement(editsql);
            ps.setString(1, modorden.getNombre_cliente_orden());
            ps.setInt(2, modorden.getProducto_orden());
            ps.setString(3, modorden.getExtras_orden());
            ps.setString(4, modorden.getFecha_entrega());
            ps.setInt(5, modorden.getTipo_entrega());
            ps.setDouble(6, modorden.getCosto_total());
            ps.setInt(7, modorden.getCantidad_producto());
            ps.setInt(8, modorden.getRelleno_orden());
            ps.setInt(9, modorden.getBetun_orden());
            ps.setInt(10, modorden.getBizcocho_orden());
            ps.setString(11, modorden.getDireccion_orden());
            ps.setString(12, orden);
            
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
                JOptionPane.showMessageDialog(null, "Error al actualizar el estado");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean delete(ModeloOrden modorden, String orden) {
        
        int respuesta;
        con=connect.getConnection();
        String deletesql="DELETE from orden where numero_orden=?";
        
        try {
            ps=con.prepareStatement(deletesql);
            ps.setString(1, orden);
            
            
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
                lista.add(orden);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connect.CloseConnection();
        }
        
        return lista;
    }
    
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
    
    public ArrayList<ModeloOferta> ofertas() {
        
        ArrayList<ModeloOferta> listaoferta=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from oferta INNER JOIN producto on producto.id_producto = producto_oferta";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listaoferta=new ArrayList();
            
            while(rs.next()){
                ModeloOferta oferta = new ModeloOferta();
                oferta.setId_oferta(rs.getInt("id_oferta"));
                oferta.setNombre_producto(rs.getString("nombre_producto"));
                oferta.setValor_oferta(rs.getDouble("valor_oferta"));
                oferta.setDetalles_oferta(rs.getString("detaller_oferta"));
                listaoferta.add(oferta);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        return listaoferta;
    }
    
    public boolean addOferta(ModeloOferta oferta) {
        
        int respuesta;
        con=connect.getConnection();
        String addsql="insert into oferta(producto_oferta, valor_oferta, detalles_oferta) value(?,?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setInt(1, oferta.getProducto_oferta());
            ps.setDouble(2, oferta.getValor_oferta());
            ps.setString(3, oferta.getDetalles_oferta());
            
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Oferta guardada");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al añadir oferta");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteOferta(ModeloOferta oferta, String id) {
        
        int respuesta;
        con=connect.getConnection();
        
        try {
            String removesql="DELETE from oferta where id_oferta=?";
            ps=con.prepareStatement(removesql);
            ps.setString(1, id);
             
            respuesta=ps.executeUpdate();
            
            if(respuesta==1) {
                JOptionPane.showMessageDialog(null, "Oferta eliminada con éxito");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "Error al eliminar oferta");
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
