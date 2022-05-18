
package ejercicio27042022;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.Date;


public class conexionconformulario extends javax.swing.JFrame {

    Conexion con = new Conexion();
    int respuesta;
    boolean valido = true;
    DefaultTableModel mimodel;
    int fila=-1;
    
    //array que siempre se hace para combobox desde BD
    //String[] roles=new String[2];
    
    //Matriz para los roles
    String [][] roles= new String[2][10];
    
    public conexionconformulario() {
        initComponents();
        setSize(800,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Personas Colegio INTECAP");
        
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtBuscar.setEnabled(false);
        roles();
        tabla();
        
    }
    
    public void conectar() {
        try {
            //crear instancia de clase conexion
            
            Connection miConexion=con.conectorDB();
        
            if(miConexion!=null) {
            //System.out.println("Conectando...");
                lblEstadoActual.setText("Conectado");
            } else {
                lblEstadoActual.setText("Error");
            }
        
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
    
    public void validarletras(){
        if(txtNombre.getText().matches("^[a-zA-Z_ ]*")) {
        }else {
            JOptionPane.showMessageDialog(this, "El valor ingresado en el nombre no es válido");
            txtNombre.setText("");
        }
    }
    
    public void validarnumeros(int valor){
        
        if (valor==1) {
            if(txtCodigo.getText().matches("^[0-9]*")) {
            } else {
                JOptionPane.showMessageDialog(this, "El valor ingresado es inválido, solo pueden ser números");
                txtCodigo.setText("");
            }
        } else if (valor==2) {
            if(txtTelefono.getText().matches("^[0-9]{1,8}")) {
            } else {
                JOptionPane.showMessageDialog(this, "El valor ingresado en el teléfono es inválido");
                txtTelefono.setText("");
            }
        }
    }
    
    public void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtFecha.setDate(null);
        txtFechaHora.setDate(null);
        tblData.clearSelection();
        gbtBuscar.clearSelection();
        txtBuscar.setText("");
        txtCodigo.setEnabled(true);
        txtBuscar.setEnabled(false);
        tabla();
    }
    
    
    
    public void tabla() {
        try {
            Connection miConexion=con.conectorDB();
        
            //crear encabezados
            String Titulo[]={"ID","Nombre","Direccion","Telefono","Fecha Ingreso","Fecha y hora ingreso","Rol"};
            String Registro[]=new String[7];
            
            //configurar tabla de BD en tabla del diseño
            mimodel=new DefaultTableModel(null,Titulo);
            String sql="select * from alumno INNER JOIN roles on roles.id_roles=alumno.rol";
            PreparedStatement ps = miConexion.prepareStatement(sql);
            ResultSet miresultadpbasedatos = ps.executeQuery(sql);
            
            while(miresultadpbasedatos.next()){
                Registro[0]=miresultadpbasedatos.getString("id_alumno");
                Registro[1]=miresultadpbasedatos.getString("Nombre");
                Registro[2]=miresultadpbasedatos.getString("Direccion");
                Registro[3]=miresultadpbasedatos.getString("Telefono");
                Registro[4]=miresultadpbasedatos.getString("Fecha_ingreso");
                Registro[5]=miresultadpbasedatos.getString("Fechayhoraingreso");
                Registro[6]=miresultadpbasedatos.getString("Descripcion_rol");
                mimodel.addRow(Registro);
            }
            
            tblData.setModel(mimodel);
        }
        catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
    
    public void roles() {
        //Cargar la info del array global en el combobox
        Connection miConexion=con.conectorDB();
        String sql="select * from roles";
        
        try {
            PreparedStatement ps = miConexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            int count=0;
            while(rs.next()){
                roles[0][count]=rs.getString(1);
                roles[1][count]=rs.getString(2);
                cbxRoles.addItem(roles[1][count]);
                count++;
            }
            
        } catch(Exception error){
            System.out.println(error.getMessage());
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
    
    public void seleccion() {
        if (rbtNombre.isSelected()==true || rbtCodigo.isSelected()==true){
            txtBuscar.setEnabled(true);
            
        } else {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gbtBuscar = new javax.swing.ButtonGroup();
        pnlData = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        lblEstadoActual = new javax.swing.JLabel();
        btnConectar = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblFechaHora = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtFechaHora = new com.toedter.calendar.JDateChooser();
        pnlBuscar = new javax.swing.JPanel();
        rbtNombre = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        rbtCodigo = new javax.swing.JRadioButton();
        cbxRoles = new javax.swing.JComboBox<>();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(470, 500));
        setResizable(false);

        lblEstado.setText("Estado:");

        btnConectar.setText("Conexion");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        btnConsulta.setText("Consultar Usuario");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar Formulario");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.setDoubleBuffered(true);
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });

        lblCodigo.setText("CODIGO:");

        lblNombre.setText("NOMBRE DE USUARIO:");

        lblDireccion.setText("DIRECCION DE USUARIO:");

        lblTelefono.setText("TELEFONO DE USUARIO:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblFecha.setText("Fecha:");

        lblFechaHora.setText("Fecha y hora:");

        pnlBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 153, 204))); // NOI18N

        gbtBuscar.add(rbtNombre);
        rbtNombre.setText("Por nombre");
        rbtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtNombreMouseClicked(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        gbtBuscar.add(rbtCodigo);
        rbtCodigo.setText("Por código ID");
        rbtCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtCodigoMouseClicked(evt);
            }
        });
        rbtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(rbtNombre)
                        .addGap(64, 64, 64)
                        .addComponent(rbtCodigo))
                    .addGroup(pnlBuscarLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtNombre)
                    .addComponent(rbtCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cbxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre)
                    .addComponent(lblCodigo)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono))
                .addGap(18, 18, 18)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDireccion)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDataLayout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConectar)
                        .addGap(30, 30, 30))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFechaHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(pnlBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btnGuardar)
                        .addGap(43, 43, 43)
                        .addComponent(btnEditar)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConectar)
                            .addComponent(lblEstado)
                            .addComponent(lblEstadoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsulta)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo)
                            .addComponent(cbxRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(txtFechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTelefono)
                                .addComponent(lblFecha))
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaHora))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnEditar)
                            .addComponent(btnEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        tblData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDataKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        conectar();
        tabla();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // cambiar formato de fecha a YYYY-MM-DD
        SimpleDateFormat nuevoformato= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat nuevoformato2= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        
        
        //Conectar a BD
        Connection miConexion=con.conectorDB();
        String Querysql="insert into alumno(Nombre,Direccion,Telefono,Fecha_ingreso,Fechayhoraingreso,Rol) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = miConexion.prepareStatement(Querysql);
            
            if(txtNombre.getText().equals("")||txtDireccion.getText().equals("")||txtTelefono.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos antes de continuar");
            } else if(txtFecha.getDate()==null) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese la fecha antes de continuar");
            } else if (txtFechaHora.getDate()==null){
                JOptionPane.showMessageDialog(this, "Por favor, ingrese ambas fechas antes de continuar");
            }else {
                String fecha=nuevoformato.format(txtFecha.getDate());
                String fechahora=nuevoformato2.format(txtFechaHora.getDate());
                int telefono = Integer.parseInt(txtTelefono.getText());
                
                //mandar rol  (valor fila BD, valor simbólico cambiante de columna,valor a evaluar)
                String rol = cambioidrol(1,0,cbxRoles.getItemAt(cbxRoles.getSelectedIndex()));
                    
                    //como mandar datos a la BD
                    ps.setString(1, txtNombre.getText());
                    ps.setString(2, txtDireccion.getText());
                    ps.setInt(3, telefono);
                    ps.setString(4, fecha);
                    ps.setString(5, fechahora);
                    ps.setString(6,rol);
            
                    respuesta=ps.executeUpdate();
            
                    if(respuesta==1) {
                        JOptionPane.showMessageDialog(null, "Usuario añadido");
                        tabla();
                        limpiar();
                    }else {
                        JOptionPane.showMessageDialog(null, "Error al añadir usuario");
                    }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(conexionconformulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        //click derecho en el txt, event, key, KeyReleased
        validarletras();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void tblDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDataKeyReleased
        
    }//GEN-LAST:event_tblDataKeyReleased

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        
        
        Connection miConexion=con.conectorDB();
        if (txtCodigo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "No ingresó el código para la búsqueda");
        } else if (txtCodigo.getText() != null) {
            
            //Buscar por Codigo
            try {
                int id=Integer.parseInt(txtCodigo.getText()); 
                String sqlid="select * from alumno INNER JOIN roles on roles.id_roles=alumno.rol where id_alumno="+id;
                PreparedStatement ps = miConexion.prepareStatement(sqlid);
                ResultSet miresultadobasedatos = ps.executeQuery(sqlid);
                
                if (miresultadobasedatos.first()){
                    txtCodigo.setText(miresultadobasedatos.getString("id_alumno"));
                    txtNombre.setText(miresultadobasedatos.getString("Nombre"));
                    txtDireccion.setText(miresultadobasedatos.getString("Direccion"));
                    txtTelefono.setText(miresultadobasedatos.getString("Telefono"));
                    txtFecha.setDate(miresultadobasedatos.getDate("Fecha_ingreso"));
                    txtFechaHora.setDate(miresultadobasedatos.getDate("Fechayhoraingreso"));
                    cbxRoles.setSelectedItem(miresultadobasedatos.getString("Descripcion_rol"));
                    
                    
                    //cambiar opcion del combobox
                    
                    btnGuardar.setEnabled(false);
                    btnEditar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnConsulta.setEnabled(false);
                    txtCodigo.setEnabled(false);
                } else{
                    JOptionPane.showMessageDialog(this, "No hay un usuario registrado con el código ingresado");
                }
                
            } catch (Exception error) {
                System.out.println(error);
            }
        } 
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        validarnumeros(1);
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        validarnumeros(2);
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        
        
        // cambiar formato de fecha a YYYY-MM-DD
        SimpleDateFormat nuevoformato= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat nuevoformato2= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        
        Connection miConexion=con.conectorDB();
        if (txtCodigo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "No ingresó el código para la búsqueda");
        } else {
            int id=Integer.parseInt(txtCodigo.getText()); 
            try {
                String sql="update alumno set Nombre=?,Direccion=?,Telefono=?,Fecha_ingreso=?,Fechayhoraingreso=?,Rol=? where id_alumno="+id;
                PreparedStatement ps = miConexion.prepareStatement(sql);
                
                
                if(txtNombre.getText().equals("")||txtDireccion.getText().equals("")||txtTelefono.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "No puede haber datos en blanco al editar un usuario");
                } else if(txtFecha.getDate()==null) {
                    JOptionPane.showMessageDialog(this, "No puede haber datos en blanco al editar un usuario");
                } else if (txtFechaHora.getDate()==null){
                    JOptionPane.showMessageDialog(this, "No puede haber datos en blanco al editar un usuario");
                }else {
                    String fecha=nuevoformato.format(txtFecha.getDate());
                    String fechahora=nuevoformato2.format(txtFechaHora.getDate());
                    int telefono = Integer.parseInt(txtTelefono.getText());
                    
                    String rol = cambioidrol(1,0,cbxRoles.getItemAt(cbxRoles.getSelectedIndex()));
                    
                    //como mandar datos a la BD
                    ps.setString(1, txtNombre.getText());
                    ps.setString(2, txtDireccion.getText());
                    ps.setInt(3, telefono);
                    ps.setString(4, fecha);
                    ps.setString(5, fechahora);
                    ps.setString(6,rol);
            
                    respuesta=ps.executeUpdate();
                    
            
                    if(respuesta==1) {
                        JOptionPane.showMessageDialog(null, "Usuario editado exitosamente");
                        tabla();
                        btnEditar.setEnabled(false);
                        btnEliminar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                        btnConsulta.setEnabled(true);
                        limpiar();
                    }else {
                        JOptionPane.showMessageDialog(null, "Error al editar la información del usuario");
                    }
                
                }
                
                
            } catch (Exception error) {
                System.out.println(error);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnConsulta.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Connection miConexion=con.conectorDB();
        if (txtCodigo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "No ingresó el código para la búsqueda");
        } else {
            int id=Integer.parseInt(txtCodigo.getText()); 
            try {
                String sql="delete from alumno where id_alumno="+id;
                PreparedStatement ps = miConexion.prepareStatement(sql);
                
                
                respuesta=ps.executeUpdate();
                    if(respuesta==1) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
                        tabla();
                        btnEditar.setEnabled(false);
                        btnEliminar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                        btnConsulta.setEnabled(true);
                        limpiar();
                    }else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar la información del usuario");
                    }
                
                
            } catch (Exception error) {
                System.out.println(error);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void rbtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtCodigoActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        fila=tblData.getSelectedRow();
        
        if (tblData.getSelectedRow() != -1){
            //Buscar seleccionando la tabla
            txtCodigo.setText(tblData.getValueAt(fila, 0).toString());
            txtNombre.setText(tblData.getValueAt(fila, 1).toString());
            txtDireccion.setText(tblData.getValueAt(fila, 2).toString());
            txtTelefono.setText(tblData.getValueAt(fila, 3).toString());
            
            cbxRoles.setSelectedItem(tblData.getValueAt(fila, 6).toString());
            
            try {
                Date fecha= new SimpleDateFormat("yyyy-MM-dd").parse((String)tblData.getValueAt(fila, 4).toString());
                Date fecha2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String)tblData.getValueAt(fila, 5).toString());
                txtFecha.setDate(fecha);
                txtFechaHora.setDate(fecha2);
            } catch (Exception e){
                
            }
            
            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(true);
            btnEliminar.setEnabled(true);
            btnConsulta.setEnabled(false);
        }
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String dato = null;
        Connection miConexion=con.conectorDB();
        if(rbtNombre.isSelected()==true){
            dato="Nombre";
            
        } else if (rbtCodigo.isSelected()==true) {
            dato="id_alumno";
            
        }
        
        if (txtBuscar.getText() != null){
            
            //Buscar por nombre
            String Titulo[]={"ID","Nombre","Direccion","Telefono","Fecha Ingreso","Fecha y hora ingreso","rol"};
            String Registro[]=new String[7];
            String Nombre = txtBuscar.getText();
            mimodel=new DefaultTableModel(null,Titulo);
            
            try {
                String sql="select * from alumno INNER JOIN roles on roles.id_roles=alumno.rol where "+dato+" like '%"+txtBuscar.getText()+"%'";
                PreparedStatement ps = miConexion.prepareStatement(sql);
                ResultSet miresultadpbasedatos = ps.executeQuery(sql);
            
                while(miresultadpbasedatos.next()){
                    Registro[0]=miresultadpbasedatos.getString("id_alumno");
                    Registro[1]=miresultadpbasedatos.getString("Nombre");
                    Registro[2]=miresultadpbasedatos.getString("Direccion");
                    Registro[3]=miresultadpbasedatos.getString("Telefono");
                    Registro[4]=miresultadpbasedatos.getString("Fecha_ingreso");
                    Registro[5]=miresultadpbasedatos.getString("Fechayhoraingreso");
                    Registro[6]=miresultadpbasedatos.getString("Descripcion_rol");
                    mimodel.addRow(Registro);
                    
            }
            
            tblData.setModel(mimodel);
            txtCodigo.setEnabled(false);
            } catch (Exception error) {
                System.out.println(error);
            }
            
        } else {
            
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void rbtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtNombreMouseClicked
        seleccion();
    }//GEN-LAST:event_rbtNombreMouseClicked

    private void rbtCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtCodigoMouseClicked
        seleccion();
    }//GEN-LAST:event_rbtCodigoMouseClicked

    private void cbxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolesActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(conexionconformulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(conexionconformulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(conexionconformulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(conexionconformulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new conexionconformulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbxRoles;
    private javax.swing.ButtonGroup gbtBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoActual;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaHora;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JRadioButton rbtCodigo;
    private javax.swing.JRadioButton rbtNombre;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFechaHora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
