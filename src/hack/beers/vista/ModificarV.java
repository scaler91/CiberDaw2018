/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.vista;

import hack.beers.Usuario;
import hack.beers.controlCibercafe;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author alxayu97
 */
public class ModificarV extends javax.swing.JDialog {
    public String DNI;
    controlCibercafe ccc;
    Usuario u;
    
    String [] cabecera = {"DNI", "idOrdenador", "FechaConexion"};
    String [] vacia = {};
    
    DefaultTableModel tablaConexiones;
    
    /**
     * Creates new form ModificarV
     */
    public ModificarV(java.awt.Frame parent, boolean modal) throws ErrorConexionBD {
        super(parent, modal);
        DNI = "Vacio";
        ccc = new controlCibercafe();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTextApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JCheckboxVIP1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        usuarioActual = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        jTextBuscarUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonBusqueda = new javax.swing.JButton();
        JTextNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Apellidos");

        JCheckboxVIP1.setText("Si / No");
        JCheckboxVIP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JCheckboxVIP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckboxVIP1ActionPerformed(evt);
            }
        });

        jLabel4.setText("VIP:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Usuario Actual:");

        usuarioActual.setText(DNI);

        jButtonCerrar.setText("X");
        jButtonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jTextBuscarUsuario.setForeground(new java.awt.Color(156, 156, 156));
        jTextBuscarUsuario.setText("Introduce el DNI");
        jTextBuscarUsuario.setToolTipText("Introduce el DNI");
        jTextBuscarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextBuscarUsuarioMouseClicked(evt);
            }
        });
        jTextBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarUsuarioActionPerformed(evt);
            }
        });
        jTextBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBuscarUsuarioKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombre");

        jButtonBusqueda.setToolTipText("Buscar");
        jButtonBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBusqueda.setFocusable(false);
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });

        jLabel5.setText("Registro del Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(JCheckboxVIP1)
                    .addComponent(JTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(JTextApellidos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuarioActual)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(usuarioActual)
                        .addComponent(jTextBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBusqueda))
                    .addComponent(jButtonCerrar))
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JCheckboxVIP1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCheckboxVIP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCheckboxVIP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCheckboxVIP1ActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jTextBuscarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioMouseClicked
        // TODO add your handling code here:
        jTextBuscarUsuario.setText("");
        jTextBuscarUsuario.setForeground(Color.black);
    }//GEN-LAST:event_jTextBuscarUsuarioMouseClicked

    private void jTextBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarUsuarioActionPerformed

    private void jTextBuscarUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarUsuarioKeyTyped
        // TODO add your handling code here:
        int limite = 9;
        if (jTextBuscarUsuario.getText().length() == limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextBuscarUsuarioKeyTyped

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        // TODO add your handling code here:
        DNI = jTextBuscarUsuario.getText();
        usuarioActual.setText(DNI);
        try {
            u = ccc.verUsuarioModificar(DNI);
            JTextNombre.setText(u.getNombre());
            JTextApellidos.setText(u.getApellidos());
            if(u.getVIP()==1){
                JCheckboxVIP1.setSelected(true);
            }
            
            String [][] conexiones = u.crearArrayConexiones();
            
            int linea = 0;
            for (linea=0; linea<=conexiones.length; linea ++){
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ModificarV dialog = new ModificarV(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (ErrorConexionBD ex) {
                    Logger.getLogger(ModificarV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCheckboxVIP1;
    private javax.swing.JTextField JTextApellidos;
    private javax.swing.JTextField JTextNombre;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscarUsuario;
    private javax.swing.JLabel usuarioActual;
    // End of variables declaration//GEN-END:variables
}
