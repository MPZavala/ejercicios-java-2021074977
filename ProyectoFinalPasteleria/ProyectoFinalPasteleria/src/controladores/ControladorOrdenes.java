
package controladores;

import dao.DaoBetun;
import dao.DaoBizcocho;
import dao.DaoEntrega;
import dao.DaoEstadoOrden;
import dao.DaoOfertas;
import dao.DaoOrdenes;
import dao.DaoProducto;
import dao.DaoRelleno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.ModeloEmpleado;
import modelos.ModeloOferta;
import modelos.ModeloOrden;
import modelos.ModeloProducto;
import vistas.MenuPrincipal;
import vistas.NuevaOrden;
import vistas.Ordenes;


public class ControladorOrdenes implements ActionListener, KeyListener, MouseListener{
    
    ModeloEmpleado modempleado = new ModeloEmpleado();
    MenuPrincipal menu = new MenuPrincipal();
    NuevaOrden neworden = new NuevaOrden();
    DaoOrdenes daoorden = new DaoOrdenes();
    DaoBetun betun = new DaoBetun();
    DaoBizcocho bizcocho = new DaoBizcocho();
    DaoRelleno relleno = new DaoRelleno();
    DaoProducto product = new DaoProducto();
    DaoOfertas ofer = new DaoOfertas();
    DaoEstadoOrden estadoorden = new DaoEstadoOrden();
    DaoEntrega entrega = new DaoEntrega();
    ModeloOrden orden = new ModeloOrden();
    ModeloProducto modproduct = new ModeloProducto();
    ModeloOferta oferta = new ModeloOferta();
    Ordenes ordenes = new Ordenes();
    
    String[][] tipoentrega = new String[2][30];
    String[][] tipobizcocho = new String[2][30];
    String[][] tiporelleno = new String[2][30];
    String[][] tipobetun = new String[2][30];
    String[][] tipoestado = new String[2][30];
    String[][] productos = new String[4][30];
    String[][] ofertas = new String[3][30];
    Object[] columna = new Object[7];
    
    int fila=-1;
    int Empleado;
    
    // cambiar formato de fecha a YYYY-MM-DD
    SimpleDateFormat nuevoformato= new SimpleDateFormat("YYYY-MM-dd");
    
    public ControladorOrdenes(Ordenes ordenes){
        this.ordenes = ordenes;
        ordenes.setVisible(true);
        tabla(ordenes.tblData);
        
        this.ordenes.tblData.addMouseListener(this);
        
        this.ordenes.btnSalir.addActionListener(this);
    }
    
    public ControladorOrdenes(NuevaOrden edit, int id, Date date){
        this.neworden = edit;
        neworden.lblOrden.setVisible(true);
        neworden.setVisible(true);
        
        neworden.lblTitulo.setText("Editar Orden");
        neworden.cmbProducto.setEnabled(false);
        neworden.cmbBetun.setEnabled(false);
        neworden.cmbBizcocho.setEnabled(false);
        neworden.cmbOfer.setEnabled(false);
        neworden.cmbRelleno.setEnabled(false);
        neworden.btnAgregar.setVisible(false);
        neworden.btnTotal.setVisible(false);
        neworden.btnLimpiar.setVisible(false);
        neworden.btnCancelar.setVisible(false);
        neworden.jpnEdit.setVisible(true);
        neworden.txtCantidad.setEnabled(false);
        neworden.lblAtencion.setVisible(false);
        neworden.lblAtenttion.setVisible(false);
        neworden.lblingresada.setVisible(true);
        neworden.lblEmpleado.setVisible(true);
        neworden.lblOferta.setVisible(false);
        neworden.cmbOfer.setVisible(false);
        estado();
        productos();
        tipoentrega();
        tiporelleno();
        tipobetun();
        tipobizcocho();
        
        
        ordenes.setVisible(false);
        ordenes.dispose();
        
        this.ordenes.btnSalir.addActionListener(this);
        this.neworden.btnVolver.addActionListener(this);
        this.neworden.btnEditar.addActionListener(this);
        this.neworden.btnEliminar.addActionListener(this);
        this.neworden.txtCantidad.addKeyListener(this);
    }
        
    public ControladorOrdenes(NuevaOrden orden, int id){
        this.neworden = orden;
        neworden.setVisible(true);
        neworden.lblOrden.setVisible(false);
        productos();
        tipoentrega();
        tiporelleno();
        tipobetun();
        tipobizcocho();
        ofertas();
        Empleado = id;
        neworden.jpnEdit.setVisible(false);
        
        this.neworden.btnAgregar.addActionListener(this);
        this.neworden.btnCancelar.addActionListener(this);
        this.neworden.btnTotal.addActionListener(this);
        this.neworden.btnLimpiar.addActionListener(this);
        this.neworden.txtCantidad.addKeyListener(this);
        
        neworden.btnAgregar.setEnabled(false);
    }
    
    public void total(){
        if (neworden.txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el producto y su cantidad para calcular el total de la orden");
        } else {
            int seleccion = (Integer.parseInt(cambioproducto(1,0,neworden.cmbProducto.getItemAt(neworden.cmbProducto.getSelectedIndex()))))-1;
            int select =(Integer.parseInt(cambiooferta(1,0,neworden.cmbOfer.getItemAt(neworden.cmbOfer.getSelectedIndex()))))-1;
            orden.setCantidad_producto(Integer.parseInt(neworden.txtCantidad.getText()));
            modproduct.setCosto_unidad_producto(Double.parseDouble(productos[2][seleccion]));
            oferta.setValor_oferta(Double.parseDouble(ofertas[2][select]));
            double total = orden.valortotal(modproduct, oferta);
            neworden.txtTotal.setText(String.valueOf(total));
            neworden.btnAgregar.setEnabled(true);
            neworden.cmbBetun.setEnabled(false);
            neworden.cmbRelleno.setEnabled(false);
            neworden.cmbProducto.setEnabled(false);
            neworden.cmbBizcocho.setEnabled(false);
            neworden.cmbEntrega.setEnabled(false);
            neworden.txtCantidad.setEnabled(false);
            neworden.btnTotal.setEnabled(false);
            
            
            
        }
    }
    
    public void addorder(){
        
        if (neworden.txtCantidad.getText().equals("") || neworden.txtCliente.getText().equals("") || neworden.txtDireccion.getText().equals("") || neworden.txtFecha.getDate()==null) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos necesarios para la orden\nUnicos datos opcionales: Notas extras y código oferta");
        } else {
            orden.setProducto_orden(Integer.parseInt(cambioproducto(1,0,neworden.cmbProducto.getItemAt(neworden.cmbProducto.getSelectedIndex()))));
            orden.setTipo_entrega(Integer.parseInt(cambioentrega(1,0,neworden.cmbEntrega.getItemAt(neworden.cmbEntrega.getSelectedIndex()))));
            orden.setBetun_orden(Integer.parseInt(cambiobetun(1,0,neworden.cmbBetun.getItemAt(neworden.cmbBetun.getSelectedIndex()))));
            orden.setRelleno_orden(Integer.parseInt(cambiorelleno(1,0,neworden.cmbRelleno.getItemAt(neworden.cmbRelleno.getSelectedIndex()))));
            orden.setBizcocho_orden(Integer.parseInt(cambiobizcocho(1,0,neworden.cmbBizcocho.getItemAt(neworden.cmbBizcocho.getSelectedIndex()))));
            orden.setOferta_id(Integer.parseInt(cambiooferta(1,0,neworden.cmbOfer.getItemAt(neworden.cmbOfer.getSelectedIndex()))));
            orden.setFecha_entrega(nuevoformato.format(neworden.txtFecha.getDate()));
            orden.setNombre_cliente_orden(neworden.txtCliente.getText());
            orden.setDireccion_orden(neworden.txtDireccion.getText());
            orden.setExtras_orden(neworden.txtExtra.getText());
            orden.setCantidad_producto(Integer.parseInt(neworden.txtCantidad.getText()));
            orden.setCosto_total(Double.valueOf(neworden.txtTotal.getText()));
            orden.setEmpleado_orden(Empleado);
            
            
            if (daoorden.add(orden, modempleado)){
                limpiaradd();
            } else {
                
                
            }
        }
        
    }
    
    public void editorder(){
        
        if (neworden.txtCantidad.getText().equals("") || neworden.txtCliente.getText().equals("") || neworden.txtDireccion.getText().equals("") || neworden.txtFecha.getDate()==null || neworden.lblNumOrden.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos necesarios para realizar los cambios");
        } else {
            orden.setTipo_entrega(Integer.parseInt(cambioentrega(1,0,neworden.cmbEntrega.getItemAt(neworden.cmbEntrega.getSelectedIndex()))));
            orden.setFecha_entrega(nuevoformato.format(neworden.txtFecha.getDate()));
            orden.setNombre_cliente_orden(neworden.txtCliente.getText());
            orden.setDireccion_orden(neworden.txtDireccion.getText());
            orden.setExtras_orden(neworden.txtExtra.getText());
            orden.setNumero_orden(Integer.parseInt(neworden.lblNumOrden.getText()));
            orden.setEstado_orden(Integer.parseInt(cambioestado(1,0,neworden.cmbEstado.getItemAt(neworden.cmbEstado.getSelectedIndex()))));
            
            if (daoorden.edit(orden)){
                ControladorOrdenes order = new ControladorOrdenes(ordenes);
                neworden.setVisible(false);
                neworden.dispose();
            } else {
                
                
            }
        }
        
    }
    
    public void deleteorder(){
        
        if (neworden.lblNumOrden.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe tener una orden seleccionada para continuar. regrese a Menú e ingrese a Ordenes Actuales para seleccionarla.");
        } else {
            orden.setNumero_orden(Integer.parseInt(neworden.lblNumOrden.getText()));
            
            if (daoorden.delete(orden)){
                limpiaradd();
            } else {
                
                
            }
        }
        
    }
    
    
    
    public void limpiaradd(){
        neworden.txtTotal.setText("");
        neworden.btnAgregar.setEnabled(false);
        neworden.cmbBetun.setEnabled(true);
        neworden.cmbRelleno.setEnabled(true);
        neworden.cmbProducto.setEnabled(true);
        neworden.cmbBizcocho.setEnabled(true);
        neworden.cmbEntrega.setEnabled(true);
        neworden.txtCantidad.setEnabled(true);
        neworden.btnTotal.setEnabled(true);
        neworden.txtCantidad.setText("");
        neworden.txtCliente.setText("");
        neworden.txtDireccion.setText("");
        neworden.txtExtra.setText("");
        neworden.txtFecha.setDate(null);
        neworden.cmbOfer.setSelectedItem("n/a");
        
    }
    public void seleccion(Date date){
            neworden.lblNumOrden.setText(String.valueOf(orden.getNumero_orden()));
            neworden.txtCliente.setText(orden.getNombre_cliente_orden());
            neworden.cmbProducto.setSelectedItem(orden.getNombre_producto());
            neworden.txtFecha.setDate(date);
            neworden.txtDireccion.setText(orden.getDireccion_orden());
            neworden.cmbEntrega.setSelectedItem(orden.getNombre_entrega());
            neworden.txtExtra.setText(orden.getExtras_orden());
            neworden.txtCantidad.setText(String.valueOf(orden.getCantidad_producto()));
            neworden.cmbBizcocho.setSelectedItem(orden.getNombre_bizcocho());
            neworden.cmbBetun.setSelectedItem(orden.getNombre_betun());
            neworden.cmbRelleno.setSelectedItem(orden.getNombre_relleno());
            neworden.cmbEstado.setSelectedItem(orden.getNombre_estado_orden());
            neworden.txtTotal.setText(String.valueOf(orden.getCosto_total()));
            neworden.lblEmpleado.setText(orden.getNombre_empleado());
            
            System.out.println("seleccion "+orden.getNombre_bizcocho());
    }
    
    public void productos(){
        int count=product.producto().size();
            for(int i=0;i<count;i++){
                productos[0][i]=String.valueOf(product.producto().get(i).getId_producto());
                productos[1][i]=product.producto().get(i).getNombre_producto();
                productos[2][i]=String.valueOf(product.producto().get(i).getCosto_unidad_producto());
                productos[3][i]=product.producto().get(i).getNombre_disponible();
                neworden.cmbProducto.addItem(productos[1][i]);
            }
    }
    
    public void ofertas(){
        int count=ofer.ofertas().size();
            for(int i=0;i<count;i++){
                ofertas[0][i]=String.valueOf(ofer.ofertas().get(i).getId_oferta());
                ofertas[1][i]=ofer.ofertas().get(i).getDetalles_oferta();
                ofertas[2][i]=String.valueOf(ofer.ofertas().get(i).getValor_oferta());
                neworden.cmbOfer.addItem(ofertas[1][i]);
            }
    }
    
    public void tipoentrega(){
        int count=entrega.tipoentrega().size();
            for(int i=0;i<count;i++){
                tipoentrega[0][i]=String.valueOf(entrega.tipoentrega().get(i).getId_entrega());
                tipoentrega[1][i]=entrega.tipoentrega().get(i).getNombre_entrega();
                neworden.cmbEntrega.addItem(tipoentrega[1][i]);
            }
    }
    
    public void estado(){
        int count=estadoorden.estadoorden().size();
            for(int i=0;i<count;i++){
                tipoestado[0][i]=String.valueOf(estadoorden.estadoorden().get(i).getId_Estado());
                tipoestado[1][i]=estadoorden.estadoorden().get(i).getNombre_Estado();
                neworden.cmbEstado.addItem(tipoestado[1][i]);
            }
    }
    
    public void tipobetun(){
        int count=betun.tipobetun().size();
            for(int i=0;i<count;i++){
                tipobetun[0][i]=String.valueOf(betun.tipobetun().get(i).getId_betun());
                tipobetun[1][i]=betun.tipobetun().get(i).getNombre_betun();
                neworden.cmbBetun.addItem(tipobetun[1][i]);
            }
    }
    
    public void tiporelleno(){
        int count=relleno.tiporelleno().size();
            for(int i=0;i<count;i++){
                tiporelleno[0][i]=String.valueOf(relleno.tiporelleno().get(i).getId_relleno());
                tiporelleno[1][i]=relleno.tiporelleno().get(i).getNombre_relleno();
                neworden.cmbRelleno.addItem(tiporelleno[1][i]);
            }
    }
    
    public void tipobizcocho(){
        int count=bizcocho.tipobizcocho().size();
            for(int i=0;i<count;i++){
                tipobizcocho[0][i]=String.valueOf(bizcocho.tipobizcocho().get(i).getId_bizcocho());
                tipobizcocho[1][i]=bizcocho.tipobizcocho().get(i).getNombre_bizcocho();
                neworden.cmbBizcocho.addItem(tipobizcocho[1][i]);
            }
    }
    
    public void tabla(JTable tblData){
        DefaultTableModel mimodel = new DefaultTableModel();
        tblData.setModel(mimodel);
        
        mimodel.addColumn("# de orden");
        mimodel.addColumn("Nombre Cliente");
        mimodel.addColumn("Producto");
        mimodel.addColumn("Modo de entrega");
        mimodel.addColumn("Notas extras");
        mimodel.addColumn("Estado");
        
        
        int numeroregistro=daoorden.tabla().size();
        for(int i=0;i<numeroregistro;i++){
            columna[0]=daoorden.tabla().get(i).getNumero_orden();
            columna[1]=daoorden.tabla().get(i).getNombre_cliente_orden();
            columna[2]=daoorden.tabla().get(i).getNombre_producto();
            columna[3]=daoorden.tabla().get(i).getNombre_entrega();
            columna[4]=daoorden.tabla().get(i).getExtras_orden();
            columna[5]=daoorden.tabla().get(i).getNombre_estado_orden();
            mimodel.addRow(columna);
        }
    }
    
    public String cambioentrega(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<tipoentrega[valorinicial].length;i++){
                if(tipoentrega[valorinicial][i]==null){
                    
                } else if (tipoentrega[valorinicial][i].equals(texto)){
                    Texto= tipoentrega[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public String cambiooferta(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<ofertas[valorinicial].length;i++){
                if(ofertas[valorinicial][i]==null){
                    
                } else if (ofertas[valorinicial][i].equals(texto)){
                    Texto= ofertas[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public String cambioproducto(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<productos[valorinicial].length;i++){
                if(productos[valorinicial][i]==null){
                    
                } else if (productos[valorinicial][i].equals(texto)){
                    Texto= productos[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public String cambiorelleno(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<tiporelleno[valorinicial].length;i++){
                if(tiporelleno[valorinicial][i]==null){
                    
                } else if (tiporelleno[valorinicial][i].equals(texto)){
                    Texto= tiporelleno[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public String cambiobetun(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<tipobetun[valorinicial].length;i++){
                if(tipobetun[valorinicial][i]==null){
                    
                } else if (tipobetun[valorinicial][i].equals(texto)){
                    Texto= tipobetun[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public String cambiobizcocho(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<tipobizcocho[valorinicial].length;i++){
                if(tipobizcocho[valorinicial][i]==null){
                    
                } else if (tipobizcocho[valorinicial][i].equals(texto)){
                    Texto= tipobizcocho[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    public String cambioestado(int valorinicial, int valorfinal, String texto) {
        String Texto="";
        
        try {
            for (int i=0;i<tipoestado[valorinicial].length;i++){
                if(tipoestado[valorinicial][i]==null){
                    
                } else if (tipoestado[valorinicial][i].equals(texto)){
                    Texto= tipoestado[valorfinal][i];
                    break;
                }
            }
        } catch(Exception error){
            System.out.println(error.getMessage());
        }
        return Texto;
    }
    
    public void validarnumeros(){
        
        if(neworden.txtCantidad.getText().matches("^[0-9]*")) {
            } else {
                JOptionPane.showMessageDialog(null, "El valor ingresado es inválido");
                neworden.txtCantidad.setText("");
            }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==neworden.btnAgregar) {
            addorder();
            limpiaradd();
        } else if (e.getSource()==neworden.btnCancelar){
            neworden.setVisible(false);
            neworden.dispose();
        }else if (e.getSource()==neworden.btnTotal){
            total();
            
        } else if (e.getSource()==ordenes.btnSalir){
            ordenes.setVisible(false);
            ordenes.dispose();
        } else if (e.getSource()==neworden.btnLimpiar){
            limpiaradd();
        } else if (e.getSource()==neworden.btnEditar){
            editorder();
        } else if (e.getSource()==neworden.btnEliminar){
            deleteorder();
        } else if (e.getSource()==neworden.btnVolver){
            ControladorOrdenes order = new ControladorOrdenes(ordenes);
            neworden.setVisible(false);
            neworden.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int col=ordenes.tblData.getColumnCount();
        String[] parametro = new String[col];
        
        for (int i=0;i<col;i++){
            parametro[i]=String.valueOf(ordenes.tblData.getValueAt(ordenes.tblData.getSelectedRow(), i));
        
        }
        int id = (Integer.parseInt(parametro[0]));
        try {
            if (daoorden.seleccion(orden, id)){
                Date date = nuevoformato.parse(orden.getFecha_entrega());
                ControladorOrdenes editorder = new ControladorOrdenes(neworden, id, date);
                seleccion(date);
                ordenes.setVisible(false);
                ordenes.dispose();
            } else {   
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ControladorOrdenes.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()==neworden.txtCantidad){
            validarnumeros();
        }
    }
    
    
}
