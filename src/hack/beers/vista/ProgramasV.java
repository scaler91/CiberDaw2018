/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.vista;

import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Alumno
 */
public class ProgramasV extends javax.swing.JFrame {

    ImageIcon iconLogo = new ImageIcon("imagenes/firefox.png");

    /**
     * Creates new form Programas
     */
    public ProgramasV() {
        this.setUndecorated(true);
        initComponents();
        this.getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        iconLogo = new ImageIcon("imagenes/firefox.png");
        jLabel1.setIcon(iconLogo);
        setTitle("Programas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mozilla Firefox", "Google Chrome", "Microsft Word", "Microsoft PowerPont", "Counter-Strike", " " }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 0, 0)));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        switch (jComboBox1.getSelectedIndex()) {
            case 0:

                //Felipee si no pones la imagen esta se queda en blanco
                iconLogo = new ImageIcon("imagenes/firefox.png");
                jLabel1.setIcon(iconLogo);

                break;
            case 1:
                iconLogo = new ImageIcon("imagenes/chrome.png");
                jLabel1.setIcon(iconLogo);

                break;
            case 2:
                iconLogo = new ImageIcon("imagenes/word.jpg");
                jLabel1.setIcon(iconLogo);

                break;
            case 3:
                iconLogo = new ImageIcon("imagenes/word.jpg");
                jLabel1.setIcon(iconLogo);

                break;
            case 4:
                iconLogo = new ImageIcon("imagenes/counter.jpg");
                jLabel1.setIcon(iconLogo);

                break;
            default:
                throw new AssertionError();
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                iconLogo = new ImageIcon("imagenes/firefox.png");
                jLabel1.setIcon(iconLogo);

                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    Process p = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                } catch (IOException e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                break;
            case 1:
                iconLogo = new ImageIcon("imagenes/chrome.png");
                jLabel1.setIcon(iconLogo);
                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                } catch (IOException e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                break;
            case 2:
                iconLogo = new ImageIcon("imagenes/word.jpg");
                jLabel1.setIcon(iconLogo);
                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    Process p = Runtime.getRuntime().exec("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
                } catch (IOException e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                break;
            case 3:
                iconLogo = new ImageIcon("imagenes/word.jpg");
                jLabel1.setIcon(iconLogo);
                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    Process p = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                } catch (IOException e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                break;
            case 4:
                iconLogo = new ImageIcon("imagenes/counter.jpg");
                jLabel1.setIcon(iconLogo);
                try {
                    /* directorio/ejecutable es el path del ejecutable y un nombre */
                    Process p = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                } catch (IOException e) {
                    /* Se lanza una excepción si no se encuentra en ejecutable o el fichero no es ejecutable. */
                }
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProgramasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProgramasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProgramasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProgramasV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProgramasV().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
