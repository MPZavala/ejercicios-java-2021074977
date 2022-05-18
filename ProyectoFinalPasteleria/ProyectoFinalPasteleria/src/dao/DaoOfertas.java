
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
import modelos.ModeloOferta;


public class DaoOfertas {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    
    public ArrayList<ModeloOferta> ofertas() {
        
        ArrayList<ModeloOferta> listaoferta=null;
        con=connect.getConnection();
        
        try {
            String sql="select * from oferta";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            listaoferta=new ArrayList();
            
            while(rs.next()){
                ModeloOferta oferta = new ModeloOferta();
                oferta.setId_oferta(rs.getInt("id_oferta"));
                oferta.setValor_oferta(rs.getDouble("valor_oferta"));
                oferta.setDetalles_oferta(rs.getString("detalles_oferta"));
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
        String addsql="insert into oferta(valor_oferta, detalles_oferta) value(?,?)";
        
        try {
            ps=con.prepareStatement(addsql);
            ps.setDouble(1, oferta.getValor_oferta());
            ps.setString(2, oferta.getDetalles_oferta());
            
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
