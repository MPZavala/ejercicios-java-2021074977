
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.ModeloEmpleado;


public class DaoEmpleado {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion connect = new Conexion();
    
    public boolean login (ModeloEmpleado modempleado) {
        con=connect.getConnection();
        String sql="select * from empleado where usuario_empleado = ? and pass_empleado = ?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, modempleado.getUsuario_empleado());
            ps.setString(2, modempleado.getPass_empleado());
            
            rs=ps.executeQuery();
            System.out.println(modempleado.getUsuario_empleado()+","+modempleado.getPass_empleado());
            
            if(rs.next()) {
                if(modempleado.getUsuario_empleado().equals(rs.getString("usuario_empleado"))) {
                    if(modempleado.getPass_empleado().equals(rs.getString("pass_empleado"))) {
                        modempleado.setNombre_empleado(rs.getString("nombre_empleado"));
                        JOptionPane.showMessageDialog(null, "Bienvenid@ "+modempleado.getNombre_empleado());
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Usuario y/o contraseña incorrectos");
                    return false;
                }
                
            }
            
        } catch (SQLException error){
            System.out.println(error);
        }
        return false;
    }
    
}
