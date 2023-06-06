/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package electrical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Lorelei
 */
public class Signup extends javax.swing.JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/final";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    String result = null;
    public void ctd() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
    // Define a connection object
    private Connection conn;
    /**
     * Creates new form Signup
     */
    public Signup() {
        ctd();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        srIN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nameIN = new javax.swing.JTextField();
        Sign = new javax.swing.JButton();
        passIN = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NEW ACCOUNT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 230, 49));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ENTER NAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 201, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER SR-CODE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 224, -1));

        srIN.setBackground(new java.awt.Color(0, 0, 0));
        srIN.setForeground(new java.awt.Color(255, 255, 255));
        srIN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            private void updateButtonState() {
                // Check if all three text fields have at least one character
                boolean enableButton = !nameIN.getText().isEmpty() &&
                !srIN.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                Sign.setEnabled(enableButton);
            }
        });
        jPanel1.add(srIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 230, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 224, -1));

        nameIN.setBackground(new java.awt.Color(0, 0, 0));
        nameIN.setForeground(new java.awt.Color(255, 255, 255));
        nameIN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            private void updateButtonState() {
                // Check if all three text fields have at least one character
                boolean enableButton = !nameIN.getText().isEmpty() &&
                !srIN.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                Sign.setEnabled(enableButton);
            }
        });
        jPanel1.add(nameIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 230, -1));

        Sign.setBackground(new java.awt.Color(0, 255, 204));
        Sign.setText("Sign up");
        Sign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignActionPerformed(evt);
            }
        });
        jPanel1.add(Sign, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 90, -1));

        passIN.setBackground(new java.awt.Color(0, 0, 0));
        passIN.setForeground(new java.awt.Color(255, 255, 255));
        passIN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            private void updateButtonState() {
                // Check if all three text fields have at least one character
                boolean enableButton = !nameIN.getText().isEmpty() &&
                !srIN.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                Sign.setEnabled(enableButton);
            }
        });
        jPanel1.add(passIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 230, -1));

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 90, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electrical/1aaa.gif"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 650, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 480));

        setSize(new java.awt.Dimension(664, 501));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignActionPerformed
    
            try {
                String selectSql = "SELECT * FROM accounts WHERE name = ?";
                PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                selectStatement.setString(1, nameIN.getText());
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    // Item already exists, perform the update
                    JOptionPane.showMessageDialog(null, "Item already entered");
                    
                    
                } else {
                    String insertSql = "INSERT INTO accounts (name, pass, sr) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
                    preparedStatement.setString(1, nameIN.getText());
                    preparedStatement.setString(2, new String(passIN.getPassword()));
                    preparedStatement.setString(3, srIN.getText());
                    preparedStatement.executeUpdate();
                }} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter entries");
                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }  
            App newForm = new App();
            newForm.setVisible(true);

            // Dispose the existing form
            dispose();
    // TODO add your handling code here:
    }//GEN-LAST:event_SignActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login newForm = new Login();
    newForm.setVisible(true);

    // Dispose the existing form
    dispose();    // TODO add your handling 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Sign;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameIN;
    private javax.swing.JPasswordField passIN;
    private javax.swing.JTextField srIN;
    // End of variables declaration//GEN-END:variables
}
