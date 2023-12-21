/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package santosoadinugroho;

import java.io.File;
import java.security.CryptoPrimitive;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * @author adi
 */
public class ProteksiFile extends javax.swing.JFrame {

    private static String fileNameInput;
    private static String fileNameOutput;

    public ProteksiFile() {
        initComponents();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioProtect);
        buttonGroup.add(radioUnProtect);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        txtInput = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtOutput = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        btnInput = new javax.swing.JButton();
        btnOutput = new javax.swing.JButton();
        checkHapus = new javax.swing.JCheckBox();
        radioProtect = new javax.swing.JRadioButton();
        btnProses = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        radioUnProtect = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SANTOSO ADI NUGROHO- Proteksi File");
        setResizable(false);

        password.setText("Password");

        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnOutput.setText("Output");
        btnOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutputActionPerformed(evt);
            }
        });

        checkHapus.setText("Hapus File Asli");

        buttonGroup.add(radioProtect);
        radioProtect.setText("Protect");

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");

        buttonGroup.add(radioUnProtect);
        radioUnProtect.setText("UnProtect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtInput)
                            .addComponent(txtPass)
                            .addComponent(txtOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOutput)
                            .addComponent(btnInput)
                            .addComponent(password)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioProtect)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnProses)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKeluar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioUnProtect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(checkHapus)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInput))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOutput))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioProtect)
                    .addComponent(checkHapus)
                    .addComponent(radioUnProtect))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnProses)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        // TODO add your handling code here:
        JFileChooser inputFileChooser = new JFileChooser();
        inputFileChooser.showOpenDialog(null);
        fileNameInput = inputFileChooser.getSelectedFile().getAbsolutePath();
        if (fileNameInput != null)
            txtInput.setText(fileNameInput);
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutputActionPerformed
        // TODO add your handling code here:
        JFileChooser outFileChooser = new JFileChooser();
        outFileChooser.showOpenDialog(null);
        fileNameOutput = outFileChooser.getSelectedFile().getAbsolutePath();
        if (fileNameOutput != null)
            txtInput.setText(fileNameOutput);
    }//GEN-LAST:event_btnOutputActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        String strPassword = txtPass.getText().toString();

        if (fileNameInput != null && fileNameOutput != null) {
            File fInput = new File(fileNameInput);
            File fOutput = new File(fileNameOutput);

            if (radioProtect.isSelected()) {
                try {
                    CryptoUtils.encrypt(strPassword, fInput, fOutput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Proteksi Berhasil!");
            } else {
                try {
                    CryptoUtils.decrypt(strPassword, fInput, fOutput);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "UnProtect Berhasil!");
            }
            if (checkHapus.isSelected()) {
                fInput.delete();
                checkHapus.setSelected(false);
            }
            txtInput.setText("");
            txtOutput.setText("");
            txtPass.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "File input atau output tidak valid!");
        }
    }//GEN-LAST:event_btnProsesActionPerformed

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
            java.util.logging.Logger.getLogger(ProteksiFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProteksiFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProteksiFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProteksiFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProteksiFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnOutput;
    private javax.swing.JButton btnProses;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox checkHapus;
    private javax.swing.JLabel password;
    private javax.swing.JRadioButton radioProtect;
    private javax.swing.JRadioButton radioUnProtect;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
