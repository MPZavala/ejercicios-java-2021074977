
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.ModeloUsuario;
import vistas.AgregarUser;
import vistas.MenuPrincipal;
import vistas.login;


public class ControladorMenu implements ActionListener {
    
    MenuPrincipal menuprincipal = new MenuPrincipal();
    ModeloUsuario modelousuario = new ModeloUsuario();
    AgregarUser add = new AgregarUser();
    login login = new login();
    
    //controlador con el que se accede al mismo
    public ControladorMenu (MenuPrincipal menuprincipal) {
        
    }
    
    //constructos con el que se accede a login desde menu
    public ControladorMenu(ModeloUsuario modusuario) {
        menuprincipal.setVisible(true);
        
        this.menuprincipal.btnSalir.addActionListener(this);
        this.menuprincipal.btnAgregar.addActionListener(this);
        this.menuprincipal.jmbRegistroUsuario.addActionListener(this);
    }
    
    public void agregar(){
        add.setVisible(true);
        Controlador addUser = new Controlador(add);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menuprincipal.btnSalir) {
            login.setVisible(true);
            Controlador log = new Controlador(login);
            menuprincipal.setVisible(false);
            
        } else if (e.getSource()==menuprincipal.btnAgregar) {
            agregar();
        } else if(e.getSource()==menuprincipal.jmbRegistroUsuario) {
            agregar();
        }
    }
    
}
