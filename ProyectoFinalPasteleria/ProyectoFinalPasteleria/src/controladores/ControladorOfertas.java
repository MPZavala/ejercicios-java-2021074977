
package controladores;

import dao.DaoOfertas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloOferta;
import vistas.Ofertas;


public class ControladorOfertas implements ActionListener, KeyListener, MouseListener{
    
    ModeloOferta modoferta = new ModeloOferta();
    DaoOfertas daooferta = new DaoOfertas();
    Ofertas ofertas = new Ofertas();
    
    public ControladorOfertas(){
        ofertas.setVisible(true);
        ofertas.btnEliminar.setEnabled(false);
        tabla(ofertas.tblData);
        
        this.ofertas.btnAgregar.addActionListener(this);
        this.ofertas.btnEliminar.addActionListener(this);
        this.ofertas.btnLimpiar.addActionListener(this);
        this.ofertas.btnSalir.addActionListener(this);
        this.ofertas.txtValor.addKeyListener(this);
        this.ofertas.tblData.addMouseListener(this);
    }
    
    public void agregar(){
        if (ofertas.txtDetalles.getText().equals("") || ofertas.txtValor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos antes de continuar");
        } else {
            modoferta.setValor_oferta(Double.parseDouble(ofertas.txtValor.getText()));
            modoferta.setDetalles_oferta(ofertas.txtDetalles.getText());
            
            if (daooferta.addOferta(modoferta)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void eliminar(){
        if (ofertas.txtID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Seleccione una oferta para poder eliminar");
        } else {
            String id = ofertas.txtID.getText();
            if (daooferta.deleteOferta(modoferta,id)){
                limpiar();
                
            } else {
                System.out.println("error en controlador");
                
            }
            
        }
    }
    
    public void limpiar(){
        ofertas.txtDetalles.setText("");
        ofertas.txtID.setText("");
        ofertas.txtValor.setText("");
        tabla(ofertas.tblData);
        
        ofertas.btnEliminar.setEnabled(false);
        ofertas.btnAgregar.setEnabled(true);
    }
    
    public void validarnumeros(){
        
        if(ofertas.txtValor.getText().matches("^[0-9]+[^.]")) {
            } else {
                JOptionPane.showMessageDialog(null, "El valor ingresado es inválido");
                ofertas.txtValor.setText("");
            }
    }
    
    public void tabla(JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        
        mimodel.addColumn("ID");
        mimodel.addColumn("Valor oferta");
        mimodel.addColumn("Detalles");
        
        Object[] columna = new Object[3];
        int numeroregistro=daooferta.ofertas().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daooferta.ofertas().get(i).getId_oferta();
            columna[1]=daooferta.ofertas().get(i).getValor_oferta();
            columna[2]=daooferta.ofertas().get(i).getDetalles_oferta();
            mimodel.addRow(columna);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ofertas.btnSalir){
            ofertas.setVisible(false);
            ofertas.dispose();
        } else if (e.getSource()==ofertas.btnAgregar){
            agregar();
        } else if (e.getSource()==ofertas.btnEliminar){
            eliminar();
        } else if (e.getSource()==ofertas.btnLimpiar){
            limpiar();
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
        if (e.getSource()==ofertas.txtValor){
            //validarnumeros();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col=ofertas.tblData.getColumnCount();
        String[] parametro = new String[col];
        
        for (int i=0;i<col;i++){
            parametro[i]=String.valueOf(ofertas.tblData.getValueAt(ofertas.tblData.getSelectedRow(), i));
        
        }
        ofertas.txtID.setText(parametro[0]);
        ofertas.txtValor.setText(parametro[1]);
        ofertas.txtDetalles.setText(parametro[2]);
        
        ofertas.btnEliminar.setEnabled(true);
        ofertas.btnAgregar.setEnabled(false);
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
