/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.vista;

import hack.beers.Pedidos.Inventario;
import hack.beers.controlCibercafe;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author Alumno
 */
public class InventarioV extends javax.swing.JFrame {

    controlCibercafe ccc;
    String cabeceraInventario[] = {"ID", "Nombre", "Cantidad", "Precio"};
    String[][] vaciaInventario = {};
    DefaultTableModel tablaInventario;

    /**
     * Creates new form InventarioV
     *
     * @throws ventasbd.dao.exception.ErrorConexionBD
     */
    public InventarioV() throws ErrorConexionBD, ErrorConexionBD {
        ccc = new controlCibercafe();
        initComponents();
        setTitle("Inventario");

        tablaInventario = new DefaultTableModel(vaciaInventario, cabeceraInventario);
        jTable1.setModel(tablaInventario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        annadirConsumible = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        annadirConsumible.setText("Añadir Consumible");
        annadirConsumible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annadirConsumibleActionPerformed(evt);
            }
        });

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButtonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(49, Short.MAX_VALUE)
                        .addComponent(annadirConsumible)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(annadirConsumible)
                        .addGap(128, 128, 128)
                        .addComponent(jButtonActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annadirConsumibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annadirConsumibleActionPerformed
        try {
            // TODO add your handling code here:
            annadirConsumible ac = new annadirConsumible(this, true);
            ac.setVisible(true);
        } catch (ErrorConexionBD ex) {
            Logger.getLogger(InventarioV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_annadirConsumibleActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            tablaInventario = new DefaultTableModel(vaciaInventario, cabeceraInventario);
            jTable1.setModel(tablaInventario);

            Inventario I = new Inventario();
            ccc.verConsumible(I);

            String[][] inventarioTabla = I.getStock();

            int linea = 0;
            while (linea < inventarioTabla.length) {
                tablaInventario.addRow(vaciaInventario);
                jTable1.setValueAt(inventarioTabla[linea][0], linea, 0);
                jTable1.setValueAt(inventarioTabla[linea][1], linea, 1);
                jTable1.setValueAt(inventarioTabla[linea][2], linea, 2);
                jTable1.setValueAt(inventarioTabla[linea][3], linea, 3);
                linea++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InventarioV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed


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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InventarioV().setVisible(true);
                } catch (ErrorConexionBD ex) {
                    Logger.getLogger(InventarioV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annadirConsumible;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
