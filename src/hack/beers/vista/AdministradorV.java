package hack.beers.vista;

import hack.beers.Administrador;
import hack.beers.controlCibercafe;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import ventasbd.dao.exception.ErrorConexionBD;

public class AdministradorV extends javax.swing.JFrame {

    Administrador admin;
    controlCibercafe ccc;

    String cabeceraPedidos[] = {"DNI", "Ordenador", "idConsumible", "Cantidad", "Precio"};
    String[][] vaciaPedidos = {};
    DefaultTableModel tablaPedidos;
    DefaultTableModel tablaVacia;
    Timer timer;

    /**
     * Creates new form AdministradoV2
     *
     * @throws ventasbd.dao.exception.ErrorConexionBD
     */
    public AdministradorV() throws ErrorConexionBD {
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        ccc = new controlCibercafe();
        admin = ccc.verDatosAdministrador();
        Administrador a = ccc.verDatosAdministrador();
        this.setUndecorated(true);

        this.timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jRadioButtonRealizado.isSelected()) {
                    actualizarTablaRealizados();
                } else if (jRadioButtonPendientes.isSelected()) {
                    actualizarTablaPendientes();
                }
            }
        });
        timer.start();
        initComponents();
        this.setAlwaysOnTop(true);
        getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.RED));
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        setTitle("Administrador");
        jLabelNombreAdmin.setText(a.getNombre() + " " + a.getApellidos());
        Fecha.setText("" + dia + "/" + mes + "/" + ano);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        inventario = new javax.swing.JButton();
        confirmarPedido = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        Usuario = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        jLabelNombreAdmin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonRealizado = new javax.swing.JRadioButton();
        jRadioButtonPendientes = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jTable1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        cerrar.setBackground(new java.awt.Color(0, 0, 0));
        cerrar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        cerrar.setForeground(new java.awt.Color(255, 255, 255));
        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cruz.png"))); // NOI18N
        cerrar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        cerrar.setBorderPainted(false);
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedidos:");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        inventario.setBackground(new java.awt.Color(0, 0, 0));
        inventario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        inventario.setForeground(new java.awt.Color(255, 255, 255));
        inventario.setText("Inventario");
        inventario.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        inventario.setBorderPainted(false);
        inventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioActionPerformed(evt);
            }
        });

        confirmarPedido.setBackground(new java.awt.Color(0, 0, 0));
        confirmarPedido.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        confirmarPedido.setForeground(new java.awt.Color(255, 255, 255));
        confirmarPedido.setText("Confirmar Pedido");
        confirmarPedido.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        confirmarPedido.setBorderPainted(false);
        confirmarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarPedidoActionPerformed(evt);
            }
        });

        modificar.setBackground(new java.awt.Color(0, 0, 0));
        modificar.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("Gestionar");
        modificar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        modificar.setBorderPainted(false);
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        Usuario.setBackground(new java.awt.Color(0, 0, 0));
        Usuario.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        Usuario.setText("Administrador:");

        Fecha.setBackground(new java.awt.Color(0, 0, 0));
        Fecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        Fecha.setForeground(new java.awt.Color(255, 255, 255));
        Fecha.setText("01/01/1990");

        jLabelNombreAdmin.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombreAdmin.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabelNombreAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreAdmin.setText("jLabel3");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuarios");

        jRadioButtonRealizado.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButtonRealizado);
        jRadioButtonRealizado.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jRadioButtonRealizado.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonRealizado.setText("Realizados");
        jRadioButtonRealizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonRealizadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPendientes);
        jRadioButtonPendientes.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jRadioButtonPendientes.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonPendientes.setText("Pendientes");
        jRadioButtonPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPendientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNombreAdmin)
                                .addComponent(Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(39, 39, 39)
                            .addComponent(jRadioButtonRealizado)
                            .addGap(48, 48, 48)
                            .addComponent(jRadioButtonPendientes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(confirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonRealizado)
                    .addComponent(jRadioButtonPendientes))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Usuario)
                .addGap(1, 1, 1)
                .addComponent(jLabelNombreAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Fecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioActionPerformed
        try {
            InventarioV inventarioV = new InventarioV();
            inventarioV.setVisible(true);
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_inventarioActionPerformed

    private void confirmarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarPedidoActionPerformed
        try {
            String dni = ((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0)).trim();
            System.out.println(dni);
            int idConsumible = Integer.parseInt(((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2)).trim());
            int cantidad = Integer.parseInt(((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3)).trim());
            ccc.confirmarPedido(cantidad, idConsumible, dni);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmarPedidoActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        ModificarV mv;
        try {
            mv = new ModificarV(this, rootPaneCheckingEnabled);
            mv.setVisible(rootPaneCheckingEnabled);
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_modificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jRadioButtonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPendientesActionPerformed
        // TODO add your handling code here:
        actualizarTablaPendientes();
    }//GEN-LAST:event_jRadioButtonPendientesActionPerformed

    private void jRadioButtonRealizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonRealizadoActionPerformed
        // TODO add your handling code here:
        actualizarTablaRealizados();
    }//GEN-LAST:event_jRadioButtonRealizadoActionPerformed

    public void actualizarTablaPendientes() {
        try {
            tablaVacia = new DefaultTableModel(vaciaPedidos, cabeceraPedidos);
            jTable1.setModel(tablaVacia);

            ccc.actualizarTablaPedidos(admin);

            tablaPedidos = new DefaultTableModel(admin.crearArrayPedidos(), cabeceraPedidos);
            jTable1.setModel(tablaPedidos);

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarTablaRealizados() {
        try {
            tablaVacia = new DefaultTableModel(vaciaPedidos, cabeceraPedidos);
            jTable1.setModel(tablaVacia);

            ccc.actualizarTablaPedidosRealizados(admin);

            tablaPedidos = new DefaultTableModel(admin.crearArrayPedidosRealizados(), cabeceraPedidos);
            jTable1.setModel(tablaPedidos);

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(AdministradorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdministradorV().setVisible(true);
                } catch (ErrorConexionBD ex) {
                    Logger.getLogger(AdministradorV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel Usuario;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton confirmarPedido;
    private javax.swing.JButton inventario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNombreAdmin;
    private javax.swing.JRadioButton jRadioButtonPendientes;
    private javax.swing.JRadioButton jRadioButtonRealizado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables
}
