
package controladores;

import dao.DaoRol;
import dao.DaoUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.Hash;
import modelos.ModeloTipoUsuario;
import modelos.ModeloUsuario;
import vistas.AgregarUser;
import vistas.MenuPrincipal;
import vistas.VerUsuarios;
import vistas.login;


public class Controlador implements ActionListener, KeyListener, MouseListener {
    
    //Declarar mis vistas
    login Login = new login();
    AgregarUser add = new AgregarUser();
    MenuPrincipal Menu = new MenuPrincipal();
    ModeloUsuario modusuario = new ModeloUsuario();
    DaoUsuario daousuario = new DaoUsuario();
    VerUsuarios veruser = new VerUsuarios();
    DaoRol daorol = new DaoRol();
    
    //para cmbRol
    String[][] roles = new String[2][10];
    

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
    
    public Controlador(int parametro){
        if(parametro==1){
            veruser.setVisible(true);
            cargarol();
            tablaverusuario(veruser.tblData);
            
            //definir escucha de evento
            this.veruser.tblData.addMouseListener(this);
            this.veruser.btnEditar.addActionListener(this);
        } 
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
            modusuario.setId_tipo(Integer.parseInt(cambioidrol(1,0,veruser.cmbRolVer.getItemAt(veruser.cmbRolVer.getSelectedIndex()))));
            
            if (daousuario.add(modusuario)){
                limpiar();
                add.setVisible(false);
                add.dispose();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void edituser(){
        if (veruser.txtUserVer.getText().equals("") || veruser.txtNombreVer.getText().equals("") || veruser.txtCorreoVer.getText().equals("") || veruser.txtDireccionVer.getText().equals("") || veruser.txtTelefonoVer.getText().equals("") || veruser.txtDpiVer.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            modusuario.setId(Integer.parseInt(veruser.txtIDVer.getText()));
            modusuario.setUsuario(veruser.txtUserVer.getText());
            modusuario.setNombre(veruser.txtNombreVer.getText());
            modusuario.setCorreo(veruser.txtCorreoVer.getText());
            modusuario.setDireccion(veruser.txtDireccionVer.getText());
            modusuario.setTelefono(veruser.txtTelefonoVer.getText());
            modusuario.setDpi(veruser.txtDpiVer.getText());
            modusuario.setId_tipo(Integer.parseInt(cambioidrol(1,0,veruser.cmbRolVer.getItemAt(veruser.cmbRolVer.getSelectedIndex()))));
            
            boolean respuesta = daousuario.editar(modusuario);
            if (respuesta==true){
                JOptionPane.showMessageDialog(null, "Usuario actualizado");
                limpiaredit();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar usuario");
                
            }
            
        }
        
    }
    
    public void tablaverusuario(JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        
        mimodel.addColumn("Codigo");
        mimodel.addColumn("Nombre");
        mimodel.addColumn("Usuario");
        mimodel.addColumn("Correo");
        mimodel.addColumn("DPI");
        mimodel.addColumn("Direccion");
        mimodel.addColumn("Telefono");
        mimodel.addColumn("Rol");
        
        Object[] columna = new Object[8];
        int numeroregistro=daousuario.listarusuario().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daousuario.listarusuario().get(i).getId();
            columna[1]=daousuario.listarusuario().get(i).getNombre();
            columna[2]=daousuario.listarusuario().get(i).getUsuario();
            columna[3]=daousuario.listarusuario().get(i).getCorreo();
            columna[4]=daousuario.listarusuario().get(i).getDpi();
            columna[5]=daousuario.listarusuario().get(i).getDireccion();
            columna[6]=daousuario.listarusuario().get(i).getTelefono();
            columna[7]=daousuario.listarusuario().get(i).getNombre_tipo();
            mimodel.addRow(columna);
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
    
    public void limpiaredit(){
        veruser.txtCorreoVer.setText("");
        veruser.txtDireccionVer.setText("");
        veruser.txtDpiVer.setText("");
        veruser.txtIDVer.setText("");
        veruser.txtNombreVer.setText("");
        veruser.txtTelefonoVer.setText("");
        veruser.txtUserVer.setText("");
        tablaverusuario(veruser.tblData);
    }
    
    public void validarnumeros(String valor){
        
        if(valor.matches("^[0-9]{1,8}")) {
            } else {
                JOptionPane.showMessageDialog(null, "El valor ingresado en el teléfono es inválido");
                add.txtTelefonoRegistro.setText("");
            }
    }
    
    //cargar roles conexion con dao tiporol
    public void cargarol(){
        int numeroreg=daorol.mostrar().size();
        
        for(int i=0;i<numeroreg;i++){
            roles[0][i]=String.valueOf(daorol.mostrar().get(i).getId_tipousuario());
            roles[1][i]=daorol.mostrar().get(i).getDescrip_tipousuario();
            veruser.cmbRolVer.addItem(roles[1][i]);
        }
    }
    
    public String cambioidrol(int valorinicial, int valorfinal, String texto) {
        
        String Texto="";
        
        
        try {
            for (int i=0;i<roles[valorinicial].length;i++){
                if(roles[valorinicial][i]==null){
                    
                } else if (roles[valorinicial][i].equals(texto)){
                    Texto= roles[valorfinal][i];
                    break;
                }
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
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
        }else if (e.getSource()==veruser.btnEditar) {
            edituser();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
        int col=veruser.tblData.getColumnCount();
        String[] parametro = new String[col];
        
        for (int i=0;i<col;i++){
            parametro[i]=String.valueOf(veruser.tblData.getValueAt(veruser.tblData.getSelectedRow(), i));
        
        }
        veruser.txtIDVer.setText(parametro[0]);
        veruser.txtNombreVer.setText(parametro[1]);
        veruser.txtUserVer.setText(parametro[2]);
        veruser.txtCorreoVer.setText(parametro[3]);
        veruser.txtDpiVer.setText(parametro[4]);
        veruser.txtDireccionVer.setText(parametro[5]);
        veruser.txtTelefonoVer.setText(parametro[6]);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
    
}
