
package controladores;

import dao.DaoEmpleado;
import dao.DaoRol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloEmpleado;
import vistas.Login;
import vistas.MenuPrincipal;
import vistas.UserAdmin;


public class ControladorLogin implements ActionListener, MouseListener{
    
    Login login = new Login();
    ModeloEmpleado modempleado = new ModeloEmpleado();
    MenuPrincipal menu = new MenuPrincipal();
    DaoEmpleado daoempleado = new DaoEmpleado();
    UserAdmin usuarios = new UserAdmin();
    DaoRol daorol = new DaoRol();
    
    String[][] rango = new String[2][10];
    int fila=-1;
    
    public ControladorLogin(Login boton) {
        this.login=boton;
        this.login.btnLogin.addActionListener(this);
        this.login.btnSalir.addActionListener(this);
    }

    public ControladorLogin() {
        usuarios.setVisible(true);
        usuarios.txtId.setEditable(false);
        usuarios.btnEditar.setEnabled(false);
        usuarios.btnEliminar.setEnabled(false);
        usuarios.btnDeseleccionar.setEnabled(false);
        tabla(usuarios.tblData);
        rango();
        
        
        this.usuarios.btnAgregar.addActionListener(this);
        this.usuarios.btnEditPw.addActionListener(this);
        this.usuarios.btnEditar.addActionListener(this);
        this.usuarios.btnEliminar.addActionListener(this);
        this.usuarios.btnSalir.addActionListener(this);
        this.usuarios.tblData.addMouseListener(this);
        this.usuarios.btnDeseleccionar.addActionListener(this);
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
    
    public void agregar(){
        
        if (usuarios.txtNombre.getText().equals("") || usuarios.txtCorreo.getText().equals("") || usuarios.txtTelefono.getText().equals("") || usuarios.txtUser.getText().equals("") || usuarios.txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            //System.out.println(cambioidrol(1,0,usuarios.cmbRango.getItemAt(usuarios.cmbRango.getSelectedIndex())));
            modempleado.setNombre_empleado(usuarios.txtNombre.getText());
            modempleado.setRango_empleado(Integer.parseInt(cambioidrol(1,0,usuarios.cmbRango.getItemAt(usuarios.cmbRango.getSelectedIndex()))));
            modempleado.setTelefono_empleado(Integer.parseInt(usuarios.txtTelefono.getText()));
            modempleado.setUsuario_empleado(usuarios.txtUser.getText());
            modempleado.setCorreo_empleado(usuarios.txtCorreo.getText());
            modempleado.setPass_empleado(usuarios.txtPass.getText());
            
            if (daoempleado.add(modempleado)){
                limpiar();
            } else {
                System.out.println("error en controlador");
                
            }
        }
        
    }
    
    public void editar(){
        if (usuarios.txtNombre.getText().equals("") || usuarios.txtCorreo.getText().equals("") || usuarios.txtTelefono.getText().equals("") || usuarios.txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No puede haber datos en blanco al editar un empleado");
        } else {
            int rol = Integer.parseInt(cambioidrol(1,0,usuarios.cmbRango.getItemAt(usuarios.cmbRango.getSelectedIndex())));
            String id = usuarios.txtId.getText();
            modempleado.setNombre_empleado(usuarios.txtNombre.getText());
            modempleado.setRango_empleado(rol);
            modempleado.setTelefono_empleado(Integer.parseInt(usuarios.txtTelefono.getText()));
            modempleado.setUsuario_empleado(usuarios.txtUser.getText());
            modempleado.setCorreo_empleado(usuarios.txtCorreo.getText());
            modempleado.setPass_empleado(usuarios.txtPass.getText());
            
            
            
            if (daoempleado.edit(modempleado, id)){
                limpiar();
            } else {
                
                
            }
        }
        
    }
    
    public void newpw(){
        if (usuarios.txtId.getText().equals("") || usuarios.txtPass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Necesita seleccionar un usuario e ingresar una contraseña para proceder con el cambio");
        } else {
            String id = usuarios.txtId.getText();
            modempleado.setPass_empleado(usuarios.txtPass.getText());
            
            
            
            if (daoempleado.edit(modempleado, id)){
                limpiar();
            } else {
                
                
            }
        }
        
    }
    
    public void eliminar(){
        if (usuarios.txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione en la tabla el empleado a eliminar");
        } else {
            String id = usuarios.txtId.getText();
            
            if (daoempleado.delete(modempleado, id)){
                limpiar();
            } else {
                System.out.println("error en controlador");
                
            }
        }
        
    }
    
    public void limpiar() {
        usuarios.txtCorreo.setText("");
        usuarios.txtId.setText("");
        usuarios.txtNombre.setText("");
        usuarios.txtPass.setText("");
        usuarios.txtTelefono.setText("");
        usuarios.txtUser.setText("");
        usuarios.btnAgregar.setEnabled(true);
        usuarios.btnEditar.setEnabled(false);
        usuarios.btnEliminar.setEnabled(false);
        usuarios.btnDeseleccionar.setEnabled(false);
        usuarios.tblData.clearSelection();
        tabla(usuarios.tblData);
    }
    
    public void tabla(JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        
        mimodel.addColumn("ID empleado");
        mimodel.addColumn("Nombre");
        mimodel.addColumn("Usuario");
        mimodel.addColumn("Correo");
        mimodel.addColumn("Telefono");
        mimodel.addColumn("Rango");
        
        Object[] columna = new Object[7];
        int numeroregistro=daoempleado.tabla().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daoempleado.tabla().get(i).getId_empleado();
            columna[1]=daoempleado.tabla().get(i).getNombre_empleado();
            columna[2]=daoempleado.tabla().get(i).getUsuario_empleado();
            columna[3]=daoempleado.tabla().get(i).getCorreo_empleado();
            columna[4]=daoempleado.tabla().get(i).getTelefono_empleado();
            columna[5]=daoempleado.tabla().get(i).getDescripcionrol();
            mimodel.addRow(columna);
        }
    }
    
    public String cambioidrol(int valorinicial, int valorfinal, String texto) {
        
        String Texto="";
        
        
        try {
            for (int i=0;i<rango[valorinicial].length;i++){
                if(rango[valorinicial][i]==null){
                    
                } else if (rango[valorinicial][i].equals(texto)){
                    Texto= rango[valorfinal][i];
                    break;
                }
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public void rango(){
        int contador=0;
        int count=daorol.roles().size();
            for(int i=0;i<count;i++){
                rango[0][i]=String.valueOf(daorol.roles().get(i).getId_rango());
                rango[1][i]=daorol.roles().get(i).getNombre_rango();
                usuarios.cmbRango.addItem(rango[1][i]);
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==login.btnLogin) {
            //System.out.println("Se presionó boton login");
            access();
        } else if (e.getSource()==login.btnSalir){
            System.exit(0);
        } else if (e.getSource()==usuarios.btnSalir) {
            usuarios.setVisible(false);
            usuarios.dispose();
        } else if (e.getSource()==usuarios.btnEliminar) {
            eliminar();
        } else if (e.getSource()==usuarios.btnAgregar){
            agregar();
        } else if (e.getSource()==usuarios.btnDeseleccionar) {
            limpiar();
        } else if (e.getSource()==usuarios.btnEditar) {
            editar();
        } else if (e.getSource()==usuarios.btnEditPw){
            newpw();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource()==usuarios.tblData) {
            String dniSeleccion=null;
            int row = usuarios.tblData.rowAtPoint(e.getPoint());
            int col = usuarios.tblData.columnAtPoint(e.getPoint());
            usuarios.btnAgregar.setEnabled(false);
            usuarios.btnEditar.setEnabled(true);
            usuarios.btnEliminar.setEnabled(true);
            usuarios.btnDeseleccionar.setEnabled(true);
            if (row > -1){
                dniSeleccion = String.valueOf(usuarios.tblData.getValueAt(row, col));
                fila=usuarios.tblData.getSelectedRow();
        
            if (usuarios.tblData.getSelectedRow() != -1){
                //Buscar seleccionando la tabla
                usuarios.txtId.setText(usuarios.tblData.getValueAt(fila, 0).toString());
                usuarios.txtNombre.setText(usuarios.tblData.getValueAt(fila, 1).toString());
                usuarios.txtUser.setText(usuarios.tblData.getValueAt(fila, 2).toString());
                usuarios.txtCorreo.setText(usuarios.tblData.getValueAt(fila, 3).toString());
                usuarios.txtTelefono.setText(usuarios.tblData.getValueAt(fila, 4).toString());
            
                usuarios.cmbRango.setSelectedItem(usuarios.tblData.getValueAt(fila, 5).toString());
            
                usuarios.btnAgregar.setEnabled(false);
                usuarios.btnEditar.setEnabled(true);
                usuarios.btnEliminar.setEnabled(true);
            
            }
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
