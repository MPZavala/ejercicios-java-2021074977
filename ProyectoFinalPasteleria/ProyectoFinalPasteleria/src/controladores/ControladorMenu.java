
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.ModeloEmpleado;
import vistas.MenuPrincipal;


public class ControladorMenu implements ActionListener{
    
    MenuPrincipal menu = new MenuPrincipal();
    ModeloEmpleado modempleado = new ModeloEmpleado();
    
    public ControladorMenu(MenuPrincipal menu) {
        
    }
    
    public ControladorMenu(ModeloEmpleado modempleado) {
        menu.setVisible(true);
        this.menu.lblNombre.setText(modempleado.getNombre_empleado());
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
