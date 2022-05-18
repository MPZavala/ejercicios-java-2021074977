
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.ModeloTipoUsuario;


public class DaoRol implements crud{
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    ModeloTipoUsuario modtiporol = new ModeloTipoUsuario();
    
    //arraylist
    ArrayList<ModeloTipoUsuario> data = new ArrayList<>();
    
    //respuesta booleana
    boolean mensaje=true;
    
    /***************************************************************************/
    /******Mis consultas a BD************/
    String consultartodo = "select * from tipo_usuario";
    String insertsql = "insert into tipo_usuario(descripcion_tipousuario) value(?)";

    @Override
    public boolean agregar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean erliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean consultarid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ModeloTipoUsuario> mostrar() {
        data=null;
        data=new ArrayList();
        
        try {
            con=connect.getConnection();
            ps=con.prepareStatement(consultartodo);
            rs=ps.executeQuery();
            
            
            while(rs.next()){
                ModeloTipoUsuario rol = new ModeloTipoUsuario();
                rol.setId_tipousuario(rs.getInt("id_tipousuario"));
                rol.setDescrip_tipousuario(rs.getString("descripcion_tipousuario"));
                data.add(rol);
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        } finally {
            connect.CloseConnection();
        }
        
        return data;
    }
    
    
    /***************************************************************************/
    
    
    
    
}
