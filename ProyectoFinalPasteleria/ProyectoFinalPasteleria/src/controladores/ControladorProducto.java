
package controladores;

import dao.DaoBetun;
import dao.DaoBizcocho;
import dao.DaoDisponible;
import dao.DaoProducto;
import dao.DaoRelleno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloBetun;
import modelos.ModeloBizcocho;
import modelos.ModeloDisponible;
import modelos.ModeloProducto;
import modelos.ModeloRelleno;
import vistas.DetallesInventario;
import vistas.Inventario;


public class ControladorProducto implements ActionListener, KeyListener, MouseListener{
    
    Inventario inventario = new Inventario();
    DetallesInventario detalles = new DetallesInventario();
    DaoProducto daoproduct = new DaoProducto();
    ModeloProducto modproduct = new ModeloProducto();
    DaoRelleno daorelleno = new DaoRelleno();
    DaoBetun daobetun = new DaoBetun();
    DaoBizcocho daobizcocho = new DaoBizcocho();
    ModeloBetun modbetun = new ModeloBetun();
    ModeloRelleno modrelleno = new ModeloRelleno();
    ModeloBizcocho modbizcocho = new ModeloBizcocho();
    ModeloDisponible moddisponible = new ModeloDisponible();
    DaoDisponible disponible = new DaoDisponible();
    
    
    
    int parametro=-1;
    int code=-1;
    
    public ControladorProducto(Inventario inventario){
        this.inventario = inventario;
        inventario.setVisible(true);
        tabla(inventario.tblData);
        inventario.btnEditar.setEnabled(false);
        inventario.btnEliminar.setEnabled(false);
        inventario.btnEstado.setVisible(false);
        inventario.lblNumOrden.setVisible(false);
        
        this.inventario.btnSalir.addActionListener(this);
        this.inventario.btnAgregar.addActionListener(this);
        this.inventario.btnEditar.addActionListener(this);
        this.inventario.btnEliminar.addActionListener(this);
        this.inventario.btnEstado.addActionListener(this);
        this.inventario.btnLimpiar.addActionListener(this);
        this.inventario.btnAdmin.addActionListener(this);
        this.inventario.tblData.addMouseListener(this);
        this.detalles.tblData.addMouseListener(this);
    }
    
    public ControladorProducto (DetallesInventario detalles){
        this.detalles = detalles;
        detalles.setVisible(true);
        detalles.btnAgregar.setEnabled(false);
        detalles.btnEditar.setEnabled(false);
        detalles.btnEliminar.setEnabled(false);
        detalles.btnLimpiar.setEnabled(false);
        detalles.lblId.setVisible(false);
        detalles.txtNombre.setEnabled(false);
        
        
        this.detalles.btnEditar.addActionListener(this);
        this.detalles.btnAgregar.addActionListener(this);
        this.detalles.btnEliminar.addActionListener(this);
        this.detalles.btnLimpiar.addActionListener(this);
        this.detalles.btnSalir.addActionListener(this);
        this.detalles.rbtBetun.addMouseListener(this);
        this.detalles.rbtBizcocho.addMouseListener(this);
        this.detalles.rbtRelleno.addMouseListener(this);
        this.detalles.tblData.addMouseListener(this);
        
        
    }
    
    public void agregar(){
        if (inventario.txtCostoUnidad.getText().equals("") || inventario.txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            modproduct.setCosto_unidad_producto(Double.parseDouble(inventario.txtCostoUnidad.getText()));
            modproduct.setNombre_producto(inventario.txtNombre.getText());
            
            if (daoproduct.add(modproduct)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void agregadetalle(int parametro){
        if (detalles.txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese la información antes de continuar");
        } else {
            
            switch(parametro){
            case(1):
                modbetun.setNombre_betun(detalles.txtNombre.getText());
                if (daobetun.add(modbetun)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(2):
                modbizcocho.setNombre_bizcocho(detalles.txtNombre.getText());
                if (daobizcocho.add(modbizcocho)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(3):
                modrelleno.setNombre_relleno(detalles.txtNombre.getText());
                if (daorelleno.add(modrelleno)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            }
            
        }
    }
    
    public void editar(){
        if (inventario.txtCostoUnidad.getText().equals("") || inventario.txtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            String id = inventario.lblId.getText();
            modproduct.setCosto_unidad_producto(Double.parseDouble(inventario.txtCostoUnidad.getText()));
            modproduct.setNombre_producto(inventario.txtNombre.getText());
            
            if (daoproduct.edit(modproduct, id)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void editdetalle(int parametro){
        if (detalles.txtNombre.getText().equals("") || detalles.lblId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un item para continuar");
        } else {
            
            switch(parametro){
            case(1):
                modbetun.setId_betun(Integer.parseInt(detalles.lblId.getText()));
                modbetun.setNombre_betun(detalles.txtNombre.getText());
                if (daobetun.edit(modbetun)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(2):
                modbizcocho.setNombre_bizcocho(detalles.txtNombre.getText());
                modbizcocho.setId_bizcocho(Integer.parseInt(detalles.lblId.getText()));
                if (daobizcocho.edit(modbizcocho)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(3):
                modrelleno.setNombre_relleno(detalles.txtNombre.getText());
                modrelleno.setId_relleno(Integer.parseInt(detalles.lblId.getText()));
                if (daorelleno.edit(modrelleno)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            }
            
        }
    }
    
    public void eliminar(){
        if (inventario.lblId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un producto para poder eliminar");
        } else {
            String id = inventario.lblId.getText();
            if (daoproduct.delete(modproduct, id)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void eliminadetalle(int parametro){
        if (detalles.lblId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un item para continuar");
        } else {
            
            switch(parametro){
            case(1):
                modbetun.setId_betun(Integer.parseInt(detalles.lblId.getText()));
                if (daobetun.delete(modbetun)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(2):
                modbizcocho.setId_bizcocho(Integer.parseInt(detalles.lblId.getText()));
                if (daobizcocho.delete(modbizcocho)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            case(3):
                modrelleno.setId_relleno(Integer.parseInt(detalles.lblId.getText()));
                if (daorelleno.delete(modrelleno)){
                    limpiaadmin();
                } else {
                    System.out.println("error en controlador");
                }
                break;
            }
            
        }
    }
    
    public void limpiaadmin(){
        detalles.btnAgregar.setEnabled(false);
        detalles.btnEditar.setEnabled(false);
        detalles.btnEliminar.setEnabled(false);
        detalles.btnLimpiar.setEnabled(false);
        detalles.lblId.setVisible(false);
        detalles.lblNumOrden.setVisible(false);
        detalles.txtNombre.setEnabled(false);
        detalles.txtNombre.setText("");
        tablaopciones(parametro);
    }
    
    public void reset(JTable tabladatos) {
        DefaultTableModel miModel = new DefaultTableModel();
        detalles.tblData.setModel(miModel);
        miModel.setRowCount(0);
    }
    
    public void tablaBetun (JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        mimodel.addColumn("ID");
        mimodel.addColumn("Nombre betún");
        
        Object[] columna = new Object[2];
        int numeroregistro=daobetun.tipobetun().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daobetun.tipobetun().get(i).getId_betun();
            columna[1]=daobetun.tipobetun().get(i).getNombre_betun();
            mimodel.addRow(columna);
        }
        
    }
    public void tablaBizcocho (JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        mimodel.addColumn("ID");
        mimodel.addColumn("Nombre bizcocho");
        
        Object[] columna = new Object[2];
        int numeroregistro=daobizcocho.tipobizcocho().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daobizcocho.tipobizcocho().get(i).getId_bizcocho();
            columna[1]=daobizcocho.tipobizcocho().get(i).getNombre_bizcocho();
            mimodel.addRow(columna);
        }
        
    }
    
    public void tablaRelleno (JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        mimodel.addColumn("ID");
        mimodel.addColumn("Nombre relleno");
        
        Object[] columna = new Object[2];
        int numeroregistro=daorelleno.tiporelleno().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daorelleno.tiporelleno().get(i).getId_relleno();
            columna[1]=daorelleno.tiporelleno().get(i).getNombre_relleno();
            mimodel.addRow(columna);
        }
        
    }
    
    public void tabla(JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        
        mimodel.addColumn("ID");
        mimodel.addColumn("Nombre producto");
        mimodel.addColumn("Costo unidad");
        mimodel.addColumn("Estado");
        
        Object[] columna = new Object[4];
        int numeroregistro=daoproduct.producto().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daoproduct.producto().get(i).getId_producto();
            columna[1]=daoproduct.producto().get(i).getNombre_producto();
            columna[2]=daoproduct.producto().get(i).getCosto_unidad_producto();
            columna[3]=daoproduct.producto().get(i).getNombre_disponible();
            mimodel.addRow(columna);
        }
    }
    
    public void estado(){
        if (inventario.lblId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione un producto de la tabla para poder cambiar su estado");
        } else {
            if (code==1){
                modproduct.setId_producto(Integer.parseInt(inventario.lblId.getText()));
                modproduct.nodisponible(moddisponible);
            } else if (code==2){
                modproduct.setId_producto(Integer.parseInt(inventario.lblId.getText()));
                modproduct.disponible(moddisponible);
            }
            if (daoproduct.cambioestado(modproduct)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
        }
    }
    
    public void limpiar(){
        inventario.lblNumOrden.setVisible(false);
        inventario.btnEstado.setVisible(false);
        inventario.btnEditar.setEnabled(false);
        inventario.btnEliminar.setEnabled(false);
        inventario.btnAgregar.setEnabled(true);
        inventario.btnEstado.setEnabled(false);
        inventario.lblNumOrden.setVisible(false);
        inventario.txtCostoUnidad.setText("");
        inventario.txtEstado.setText("");
        inventario.txtNombre.setText("");
        inventario.lblId.setText("");
        tabla(inventario.tblData);
    }
    
    public void tablaopciones(int parametro){
        switch(parametro){
            case(1):
                tablaBetun(detalles.tblData);
                detalles.btnAgregar.setEnabled(true);
                detalles.btnLimpiar.setEnabled(true);
                detalles.txtNombre.setEnabled(true);
                break;
            case(2):
                tablaBizcocho(detalles.tblData);
                detalles.btnAgregar.setEnabled(true);
                detalles.btnLimpiar.setEnabled(true);
                detalles.txtNombre.setEnabled(true);
                break;
            case(3):
                tablaRelleno(detalles.tblData);
                detalles.btnAgregar.setEnabled(true);
                detalles.btnLimpiar.setEnabled(true);
                detalles.txtNombre.setEnabled(true);
                break;
        }
    }
    
    public void selecttabla(){
        int col=inventario.tblData.getColumnCount();
            String[] par = new String[col];
        
        
            for (int i=0;i<col;i++){
                par[i]=String.valueOf(inventario.tblData.getValueAt(inventario.tblData.getSelectedRow(), i));
        
            }
            inventario.txtEstado.setVisible(true);
            inventario.lblEstado.setVisible(true);
            inventario.lblId.setText(par[0]);
            inventario.txtNombre.setText(par[1]);
            inventario.txtCostoUnidad.setText(par[2]);
            inventario.txtEstado.setText(par[3]);
        
            inventario.btnEliminar.setEnabled(true);
            inventario.btnLimpiar.setEnabled(true);
            inventario.btnAgregar.setEnabled(false);
            inventario.btnEstado.setEnabled(true);
            inventario.btnEditar.setEnabled(true);
            inventario.lblNumOrden.setVisible(true);
        
            if (inventario.txtEstado.getText().equals("Disponible")){
                inventario.btnEstado.setText("Marcar como agotado");
                inventario.btnEstado.setVisible(true);
                code=1;
            } else if (inventario.txtEstado.getText().equals("Agotado")) {
                inventario.btnEstado.setText("Marcar como disponible");
                inventario.btnEstado.setVisible(true);
                code=2;
            }
    }
    
    public void selectdetalle(){
        int col=detalles.tblData.getColumnCount();
            String[] par = new String[col];
        
        
            for (int i=0;i<col;i++){
                par[i]=String.valueOf(detalles.tblData.getValueAt(detalles.tblData.getSelectedRow(), i));
        
            }
            detalles.lblNumOrden.setVisible(true);
            detalles.lblId.setVisible(true);
            detalles.lblId.setText(par[0]);
            detalles.txtNombre.setText(par[1]);
        
            detalles.btnEliminar.setEnabled(true);
            inventario.btnLimpiar.setEnabled(true);
            detalles.btnAgregar.setEnabled(false);
            detalles.btnEditar.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==detalles.btnSalir){
            detalles.setVisible(false);
            detalles.dispose();
        } else if (e.getSource()==inventario.btnSalir){
            inventario.setVisible(false);
            inventario.dispose();
        } else if (e.getSource()==inventario.btnAdmin){
            ControladorProducto invent = new ControladorProducto(detalles);
        } else if (e.getSource()==inventario.btnEstado){
            estado();
        } else if (e.getSource()==inventario.btnLimpiar){
            limpiar();
        } else if (e.getSource()==inventario.btnAgregar){
            agregar();
        } else if (e.getSource()==inventario.btnEditar){
            editar();
        } else if (e.getSource()==inventario.btnEliminar){
            eliminar();
        } else if (e.getSource()==detalles.btnLimpiar){
            limpiaadmin();
        } else if (e.getSource()==detalles.btnAgregar){
            agregadetalle(parametro);
        } else if (e.getSource()==detalles.btnEditar){
            editdetalle(parametro);
        }else if (e.getSource()==detalles.btnEliminar){
            eliminadetalle(parametro);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
       
        
        if (e.getSource()==detalles.rbtBetun){
            if (detalles.rbtBetun.isSelected()){
                parametro=1;
                tablaopciones(parametro);
            }
        }else if (e.getSource()==detalles.rbtBizcocho){
            if (detalles.rbtBizcocho.isSelected()){
                parametro=2;
                tablaopciones(parametro);
            }
        }else if (e.getSource()==detalles.rbtRelleno){
            if (detalles.rbtRelleno.isSelected()){
                parametro=3;
                tablaopciones(parametro);
            }
        } else if (e.getSource()==inventario.tblData){
            selecttabla();
        } else if (e.getSource()==detalles.tblData){
            selectdetalle();
        }
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
