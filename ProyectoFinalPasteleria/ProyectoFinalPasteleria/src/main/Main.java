
package main;

import controladores.ControladorLogin;
import vistas.Login;


public class Main {
    public static void main(String args[]) {
        
        Login login = new Login();
        ControladorLogin controllogin = new ControladorLogin(login);
        login.setVisible(true);
        
    }
    
}
