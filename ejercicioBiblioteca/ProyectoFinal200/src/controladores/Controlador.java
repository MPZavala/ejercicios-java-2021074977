
package controladores;

import dao.DaoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelos.Hash;
import modelos.ModeloUsuario;
import vistas.AgregarUser;
import vistas.MenuPrincipal;
import vistas.login;


public class Controlador implements ActionListener, KeyListener {
    
    //Declarar mis vistas
    login Login = new login();
    AgregarUser add = new AgregarUser();
    MenuPrincipal Menu = new MenuPrincipal();
    ModeloUsuario modusuario = new ModeloUsuario();
    DaoUsuario daousuario = new DaoUsuario();
    

    public Controlador(login boton) {
        
        this.Login=boton;
        //Activar el escucha del evento click del btn
        this.Login.btnIngreso.addActionListener(this);
        this.Login.btnSalir.addActionListener(this);
        this.Login.txtUsuario.addKeyListener(this);
        
    }
    
    public Controlador(AgregarUser add) {
        add.setVisible(true);
        this.add=add;
        
        this.add.btnAdd.addActionListener(this);
        this.add.btnCancelar.addActionListener(this);
        this.add.txtTelefonoRegistro.addKeyListener(this);
    }
    
    public void ingresar(){
        String pass = new String(Login.txtPass.getPassword());
        
        if(Login.txtUsuario.getText().equals("") || Login.txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para continuar");
            
        } else {
            
            String nuevapass = Hash.sha1(pass);
            
            modusuario.setUsuario(Login.txtUsuario.getText());
            modusuario.setPass(nuevapass);
            
            
            boolean res=daousuario.login(modusuario);
            System.out.println(res);
            
            if (daousuario.login(modusuario)){
                Login.setVisible(false);
                ControladorMenu controladorprincipal = new ControladorMenu(modusuario);
                
                
            } else {
                System.out.println("No existe controlador");
                
            }
        }
    }
    
    public void agregar(){
        if (add.txtUserRegistro.getText().equals("") || add.txtPassRegistro.getText().equals("") || add.txtNombreRegistro.getText().equals("") || add.txtCorreoRegistro.getText().equals("") || add.txtDireccionRegistro.getText().equals("") || add.txtTelefonoRegistro.getText().equals("") || add.txtDpiRegistro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            String pass = new String(add.txtPassRegistro.getPassword());
            String nuevapass=Hash.sha1(pass);
            System.out.println(nuevapass);
            
            modusuario.setUsuario(add.txtUserRegistro.getText());
            modusuario.setPass(nuevapass);
            modusuario.setNombre(add.txtNombreRegistro.getText());
            modusuario.setCorreo(add.txtCorreoRegistro.getText());
            modusuario.setDireccion(add.txtDireccionRegistro.getText());
            modusuario.setTelefono(add.txtTelefonoRegistro.getText());
            modusuario.setDpi(add.txtDpiRegistro.getText());
            
            if (daousuario.add(modusuario)){
                limpiar();
                add.setVisible(false);
                add.dispose();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    
    
    public void validarletras(String valor, String valor2){
        if(valor.matches("^[a-zA-Z_ ]*")) {
        }else {
            JOptionPane.showMessageDialog(null, "El valor ingresado en el nombre no es válido");
            
        }
    }
    
    public void limpiar(){
        Login.txtPass.setText("");
        Login.txtUsuario.setText("");
    }
    
    public void limpiarAdd(){
        add.txtUserRegistro.setText("");
        add.txtPassRegistro.setText("");
        add.txtNombreRegistro.setText("");
        add.txtCorreoRegistro.setText("");
        add.txtDireccionRegistro.setText("");
        add.txtTelefonoRegistro.setText("");
        add.txtDpiRegistro.setText("");
    }
    
    public void validarnumeros(String valor){
        
        if(valor.matches("^[0-9]{1,8}")) {
            } else {
                JOptionPane.showMessageDialog(null, "El valor ingresado en el teléfono es inválido");
                add.txtTelefonoRegistro.setText("");
            }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==Login.btnIngreso) {
            ingresar();
        } else if (e.getSource()==Login.btnSalir) {
            System.out.println("Se presionó boton salir");
            System.exit(0);
        } else if (e.getSource()==add.btnAdd) {
            agregar();
        } else if(e.getSource()==add.btnCancelar) {
            add.setVisible(false);
            add.dispose();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==Login.txtUsuario) {
            String valor=Login.txtUsuario.getText();
            
        } else if (e.getSource()==add.txtTelefonoRegistro) {
            String valor=add.txtTelefonoRegistro.getText();
            validarnumeros(valor);
        }
    }
    
    
    
    
}
