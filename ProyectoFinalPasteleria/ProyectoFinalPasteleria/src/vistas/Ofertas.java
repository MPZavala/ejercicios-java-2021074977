
package vistas;

import java.awt.MouseInfo;
import java.awt.Point;

public class Ofertas extends javax.swing.JFrame {
    
    int x,y;
   
    public Ofertas() {
        initComponents();
        setSize(820,550);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnFondo = new javax.swing.JPanel();
        jpnNuevo = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCostoUnidad = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextArea();
        jpnTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        jpnUser = new javax.swing.JPanel();
        lblMinimizar = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNumOrden = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnNuevo.setOpaque(false);

        lblNombre.setText("VALOR OFERTA:");

        lblCostoUnidad.setText("DETALLES:");

        lblEstado.setText("ID OFERTA:");

        btnAgregar.setText("Agregar Oferta");

        btnEliminar.setText("Eliminar Oferta");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar campos");

        txtID.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtID.setEnabled(false);

        txtDetalles.setColumns(20);
        txtDetalles.setRows(5);
        jScrollPane2.setViewportView(txtDetalles);

        javax.swing.GroupLayout jpnNuevoLayout = new javax.swing.GroupLayout(jpnNuevo);
        jpnNuevo.setLayout(jpnNuevoLayout);
        jpnNuevoLayout.setHorizontalGroup(
            jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNuevoLayout.createSequentialGroup()
                .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnNuevoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addGroup(jpnNuevoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstado)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(txtID))
                        .addGap(15, 15, 15)
                        .addComponent(lblCostoUnidad)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jpnNuevoLayout.setVerticalGroup(
            jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNuevoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnNuevoLayout.createSequentialGroup()
                        .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCostoUnidad)
                            .addGroup(jpnNuevoLayout.createSequentialGroup()
                                .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstado)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombre)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jpnNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnEliminar)
                            .addComponent(btnLimpiar))
                        .addGap(22, 22, 22))
                    .addGroup(jpnNuevoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jpnFondo.add(jpnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 740, 150));

        jpnTabla.setOpaque(false);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblData);

        btnSalir.setText("Salir");

        javax.swing.GroupLayout jpnTablaLayout = new javax.swing.GroupLayout(jpnTabla);
        jpnTabla.setLayout(jpnTablaLayout);
        jpnTablaLayout.setHorizontalGroup(
            jpnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTablaLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jpnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTablaLayout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTablaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        jpnTablaLayout.setVerticalGroup(
            jpnTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        jpnFondo.add(jpnTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 800, 300));

        jpnUser.setOpaque(false);
        jpnUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpnUserMouseDragged(evt);
            }
        });
        jpnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpnUserMousePressed(evt);
            }
        });

        lblMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button.png"))); // NOI18N
        lblMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizarMousePressed(evt);
            }
        });

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/button_x.png"))); // NOI18N
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("HP Simplified Hans Light", 1, 20)); // NOI18N
        lblTitulo.setText("Ofertas Disponibles");
        lblTitulo.setAlignmentX(5.0F);
        lblTitulo.setAlignmentY(10.0F);

        javax.swing.GroupLayout jpnUserLayout = new javax.swing.GroupLayout(jpnUser);
        jpnUser.setLayout(jpnUserLayout);
        jpnUserLayout.setHorizontalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblTitulo)
                .addGap(104, 104, 104)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(lblMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jpnUserLayout.setVerticalGroup(
            jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnUserLayout.createSequentialGroup()
                .addGroup(jpnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnFondo.add(jpnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 80));

        lblNumOrden.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpnFondo.add(lblNumOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 85, 140, 30));

        lblFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo1.png"))); // NOI18N
        lblFondo.setToolTipText("");
        jpnFondo.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizarMousePressed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizarMousePressed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void jpnUserMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnUserMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_jpnUserMouseDragged

    private void jpnUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnUserMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jpnUserMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Ofertas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ofertas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ofertas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ofertas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ofertas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JPanel jpnNuevo;
    private javax.swing.JPanel jpnTabla;
    private javax.swing.JPanel jpnUser;
    private javax.swing.JLabel lblCostoUnidad;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMinimizar;
    private javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblNumOrden;
    private javax.swing.JLabel lblSalir;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JTable tblData;
    public javax.swing.JTextArea txtDetalles;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
