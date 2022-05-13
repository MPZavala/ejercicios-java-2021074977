
package main;

import controladores.Controlador;
import controladores.ControladorMenu;
import vistas.MenuPrincipal;
import vistas.login;


public class main {
    
    public static void main(String args[]) {
        
        //creo las instancias de vista y controlador
        login Login = new login();
        MenuPrincipal menu = new MenuPrincipal();
        //ControladorMenu Menu = new ControladorMenu(menu);
        Controlador usuario = new Controlador(Login);
        Login.setVisible(true);
        
    }
    
}
