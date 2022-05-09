
package main;

import controladores.Controlador;
import vistas.login;


public class main {
    
    public static void main(String args[]) {
        
        //creo las instancias de vista y controlador
        login Login = new login();
        Controlador usuario = new Controlador(Login);
        Login.setVisible(true);
        
    }
    
}
