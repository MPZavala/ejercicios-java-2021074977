
package controladores;

import dao.DaoEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.ModeloEmpleado;
import vistas.Login;
import vistas.MenuPrincipal;


public class ControladorLogin implements ActionListener{
    
    Login login = new Login();
    ModeloEmpleado modempleado = new ModeloEmpleado();
    MenuPrincipal menu = new MenuPrincipal();
    DaoEmpleado daoempleado = new DaoEmpleado();
    
    public ControladorLogin(Login boton) {
        this.login=boton;
        this.login.btnLogin.addActionListener(this);
        this.login.btnSalir.addActionListener(this);
    }

    
    
    public void access(){
        if (login.txtUser.getText().equals("") || login.txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para continuar");
        } else {
            modempleado.setUsuario_empleado(login.txtUser.getText());
            modempleado.setPass_empleado(login.txtPass.getText());
            
            if (daoempleado.login(modempleado)) {
                ControladorMenu menu = new ControladorMenu(modempleado);
                login.setVisible(false);
            } else {
                
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==login.btnLogin) {
            //System.out.println("Se presionó boton login");
            access();
        } else if (e.getSource()==login.btnSalir)
            System.exit(0);
    }
    
    
    
    
}
