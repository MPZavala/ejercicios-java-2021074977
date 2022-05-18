
package controladores;

import dao.DaoEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloEmpleado;
import modelos.ModeloRango;
import vistas.Inventario;
import vistas.Login;
import vistas.MenuPrincipal;
import vistas.NuevaOrden;
import vistas.Ofertas;
import vistas.Ordenes;
import vistas.UserAdmin;


public class ControladorMenu implements ActionListener{
    
    MenuPrincipal menu = new MenuPrincipal();
    ModeloEmpleado modempleado = new ModeloEmpleado();
    Login login = new Login();
    UserAdmin usuarios = new UserAdmin();
    DaoEmpleado daoempleado = new DaoEmpleado();
    DefaultTableModel mimodel;
    ModeloRango modrango = new ModeloRango();
    NuevaOrden orden = new NuevaOrden();
    Ordenes ordenes = new Ordenes();
    Inventario inventario = new Inventario();
    Ofertas oferta = new Ofertas();
    
    ModeloRango [][] roles= new ModeloRango[2][2];
    
    
    public ControladorMenu(MenuPrincipal menu) {
        
    }
    
    public ControladorMenu(ModeloEmpleado modempleado) {
        menu.setVisible(true);
        
        this.menu.lblNombre.setText(modempleado.getNombre_empleado());
        this.menu.lblRango.setText(modempleado.getDescripcionrol());
        this.menu.lblIDEmpleado.setText(String.valueOf(modempleado.getId_empleado()));
        this.menu.btnCerrar.addActionListener(this);
        this.menu.btnAdministrar.addActionListener(this);
        this.menu.btnNueva.addActionListener(this);
        this.menu.btnOrdenes.addActionListener(this);
        this.menu.btnInventario.addActionListener(this);
        this.menu.btnOfertas.addActionListener(this);
        
        
        //visibilizar boton para administradores
        if (modempleado.getDescripcionrol().equals("Administracion")) {
            this.menu.btnAdministrar.setVisible(true);
            this.menu.btnAdministrar.enable(true);
        } else {
            this.menu.btnAdministrar.setVisible(false);
            this.menu.btnAdministrar.enable(false);
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu.btnCerrar) {
            login.setVisible(true);
            ControladorLogin log = new ControladorLogin(login);
            menu.setVisible(false);
            menu.dispose();
        } else if(e.getSource()==menu.btnAdministrar){
            ControladorLogin admin = new ControladorLogin();
            
        } else if (e.getSource()==menu.btnNueva){
            int id = Integer.parseInt(menu.lblIDEmpleado.getText());
            ControladorOrdenes neworder = new ControladorOrdenes(orden, id);
        } else if (e.getSource()==menu.btnOrdenes){
            ControladorOrdenes order = new ControladorOrdenes(ordenes);
        } else if (e.getSource()==menu.btnInventario){
            ControladorProducto inventory = new ControladorProducto(inventario);
        } else if (e.getSource()==menu.btnOfertas){
            ControladorOfertas ofer = new ControladorOfertas();
        }
    }
    
}
