/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package santosoadinugroho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Andi Kusumah
 */
public class JavaChat extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;
    private Socket client;
    private ServerSocket server;
    private BufferedReader server_reader;
    private BufferedWriter Server_write;
    private BufferedWriter server_write;

    /**
     * Creates new form JavaChat
     */
    public JavaChat() {
        initComponents();
        listModel = new DefaultListModel<>();
        listMassage.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboConnection = new javax.swing.JComboBox<>();
        btnConnect = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMassage = new javax.swing.JList<>();
        txtMessage = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SANTOSO ADI NUGROHO-Java Socket");
        setResizable(false);

        cboConnection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Server", "Client" }));
        cboConnection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboConnectionItemStateChanged(evt);
            }
        });
        cboConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboConnectionActionPerformed(evt);
            }
        });

        btnConnect.setText("On");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        txtUser.setText("Server");

        jScrollPane1.setViewportView(listMassage);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConnect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboConnectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboConnectionItemStateChanged
        // TODO add your handling code here:
        if (cboConnection.getSelectedItem().equals("Server")) {
            btnConnect.setText("ON");
            txtUser.setText("Server");
        } else {
            btnConnect.setText("Hubungkan");
            txtUser.setText("Client");
        }
    }//GEN-LAST:event_cboConnectionItemStateChanged

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        // TODO add your handling code here:
        if (btnConnect.getText().equals("Hubungkan")) {
            btnConnect.setText("Putuskan");
            client_connection();
            new Thread(new ClientThread()).start();
        } else if (cboConnection.getSelectedItem().equals("Server")) {
            btnConnect.setText("OFF");
            read_connection();
            new Thread(new ServerThread()).start();
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        try {
        if (client != null) {
            BufferedWriter server_write = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            server_write.write(txtUser.getText() + " : " + txtMessage.getText());
            server_write.newLine();
            server_write.flush();
        } else {
            System.err.println("client is null");
        }
    } catch (Exception e) {
        e.printStackTrace();
        Logger.getLogger(JavaChat.class.getName()).log(Level.SEVERE, null, e);
    }
    listModel.addElement("Me : " + txtMessage.getText());
    txtMessage.setText("");
    }//GEN-LAST:event_btnSendActionPerformed

    private void cboConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboConnectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboConnectionActionPerformed

   private void client_connection() {
     try {
        String ip = JOptionPane.showInputDialog("Masukkan Alamat IP Server!");
        client = new Socket(ip, 2000);
        cboConnection.setEnabled(false);
        server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        server_write = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        btnConnect.setText("Putuskan");
        Thread thread = new Thread(new ClientThread());
        thread.start();
    } catch (IOException e) {
        System.err.println("Akses Ke Server Gagal!");
        e.printStackTrace();
        System.exit(-1);
    }
}


    private void read_connection() {
        try {
            try {
                try {
                    server = new ServerSocket(2000);
                    this.setTitle("Mohon Tunggu Sebentar.......");
                } catch (IOException e) {
                    System.err.println("Gagal Memuat Server!");
                    System.exit(-1);
                }
                client = server.accept();
                this.setTitle("Terhubung Ke " + client.getInetAddress());
            } catch (IOException e) {
                System.err.println("Akses Ditolak!");
                System.exit(-1);
            }
            server_reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            server_write = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            System.err.println("Tidak Dapat Membaca Pesan");
            System.exit(-1);
        }
    }

    private void disconnected_by_client() {
        try {
        if (client != null) {
            client.close();
            server_reader.close();
            server_write.close();
        }
        cboConnection.setEnabled(true);
        btnConnect.setText("Hubungkan");
    } catch (IOException e) {
        Logger.getLogger(JavaChat.class.getName()).log(Level.SEVERE, null, e);
    }
    }

    private void stopped_by_server() {
        try {
            server_reader.close();
            server_write.close();
            btnConnect.setText("ON");
            this.setTitle("Terputus");
        } catch (IOException e) {
            Logger.getLogger(JavaChat.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private class ClientThread extends Thread {

        @Override
        public void run() {
            try {
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));

                while (true) {
                    String message = clientReader.readLine();
                    if (message == null) {
                        break;
                    }
                    listModel.addElement(message);
                }

            } catch (IOException e) {
                Logger.getLogger(JavaChat.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                disconnected_by_client();
            }
        }
    }

    private class ServerThread extends Thread {

        @Override
        public void run() {
            try {
                BufferedWriter serverWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                while (true) {
                    String message = server_reader.readLine();
                    if (message == null) {
                        break;
                    }
                    listModel.addElement(message);
                }

            } catch (IOException e) {
                Logger.getLogger(JavaChat.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                stopped_by_server();
            }
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
            java.util.logging.Logger.getLogger(JavaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cboConnection;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listMassage;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
