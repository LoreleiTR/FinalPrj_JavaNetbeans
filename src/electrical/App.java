/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package electrical;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/**
 *
 * @author Lorelei
 */
public class App extends javax.swing.JFrame implements Runnable,ThreadFactory{
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    
    Result result = null;
    BufferedImage image = null;
            
    String txtstatus = "Scanning...";
    String status = "Unknown";
    int B_R = 0;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/final";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    // Define a connection object
    private Connection conn;
    private HashMap<String, ArrayList<String>> optionsMap;
    // Establish the database connection
    public void ctd() {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
    /**
     * Creates new form App
     */
    public App() {
        ctd();
        initComponents();
        initWebcam();
        table_update();
    }
    
    private void table_update(){
        

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM item");
            ResultSet stcRs = pst.executeQuery();
            
            
            ResultSetMetaData stcRSMD = stcRs.getMetaData();
            int stcCC = stcRSMD.getColumnCount();
            DefaultTableModel stcDFT = (DefaultTableModel) Check.getModel();
            stcDFT.setRowCount(0);
            
            while (stcRs.next()){
                Vector stcV2 = new Vector();
                
                for(int ii = 1; ii <= stcCC; ii++){
                    stcV2.add(stcRs.getString("ID"));
                    stcV2.add(stcRs.getString("Name"));
                    stcV2.add(stcRs.getString("Possession"));
                    stcV2.add(stcRs.getString("Status"));
                }
                stcDFT.addRow(stcV2);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        camera = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        qr = new javax.swing.JTextField();
        lbStart = new javax.swing.JLabel();
        Exit2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Exit1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pathDIR = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eqNAME = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        passIN = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        requestbtn = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Check = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane5.setBackground(new java.awt.Color(0, 255, 204));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        camera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(camera, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 350, 230));

        start.setBackground(new java.awt.Color(0, 255, 204));
        start.setText("START");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        jPanel1.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));
        jPanel1.add(qr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 400, -1));

        lbStart.setFont(new java.awt.Font("Tekton Pro Cond", 1, 48)); // NOI18N
        lbStart.setForeground(new java.awt.Color(255, 102, 102));
        lbStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStart.setText(txtstatus);
        jPanel1.add(lbStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 400, 101));

        Exit2.setBackground(new java.awt.Color(255, 51, 102));
        Exit2.setText("Exit");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });
        jPanel1.add(Exit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electrical/1aaaA.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 470));

        jTabbedPane5.addTab("Scanner", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Exit1.setBackground(new java.awt.Color(255, 51, 102));
        Exit1.setText("Exit");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });
        jPanel2.add(Exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PASSWORD");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 218, -1));

        pathDIR.setBackground(new java.awt.Color(0, 0, 0));
        pathDIR.setForeground(new java.awt.Color(255, 255, 255));
        // Add a document listener to the text field
        pathDIR.getDocument().addDocumentListener(new DocumentListener() {
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
                boolean enableButton = !eqNAME.getText().isEmpty() &&
                !pathDIR.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                add.setEnabled(enableButton);
            }
        });
        jPanel2.add(pathDIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 224, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER PATH OF DOCUMENT FILE");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 218, -1));

        eqNAME.setBackground(new java.awt.Color(0, 0, 0));
        eqNAME.setForeground(new java.awt.Color(255, 255, 255));
        // Add a document listener to the text field
        eqNAME.getDocument().addDocumentListener(new DocumentListener() {
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
                boolean enableButton = !eqNAME.getText().isEmpty() &&
                !pathDIR.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                add.setEnabled(enableButton);
            }
        });
        jPanel2.add(eqNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 224, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ENTER NAME OF LAB EQUIPMENT");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 215, -1));

        add.setBackground(new java.awt.Color(0, 255, 204));
        add.setText("ADD");
        add.setEnabled(false); // Initially disable the button
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 90, -1));

        passIN.setBackground(new java.awt.Color(0, 0, 0));
        passIN.setForeground(new java.awt.Color(255, 255, 255));
        // Add a document listener to the text field
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
                boolean enableButton = !eqNAME.getText().isEmpty() &&
                !pathDIR.getText().isEmpty() &&
                passIN.getPassword().length > 0;
                add.setEnabled(enableButton);
            }
        });
        jPanel2.add(passIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 224, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("GENERATE QR FOR LAB EQUIPMENTS ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lorelei\\Downloads\\1aaaA.jpg")); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 460));

        jTabbedPane5.addTab("Generator", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestbtn.setBackground(new java.awt.Color(0, 255, 204));
        requestbtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        requestbtn.setText(status);
        requestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestbtnActionPerformed(evt);
            }
        });
        jPanel3.add(requestbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 170, 30));

        Exit.setBackground(new java.awt.Color(255, 51, 102));
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jPanel3.add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        documentArea.setColumns(20);
        documentArea.setRows(5);
        jScrollPane1.setViewportView(documentArea);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 378, 420));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electrical/1aaa A1.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 650, 470));

        jTabbedPane5.addTab("More Info", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Check.setBackground(new java.awt.Color(0, 102, 102));
        Check.setForeground(new java.awt.Color(255, 255, 255));
        Check.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Item", "Possession", "Status"
            }
        ));
        jScrollPane2.setViewportView(Check);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 457));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/electrical/1aaa C.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 470));

        jTabbedPane5.addTab("Overview", jPanel4);

        getContentPane().add(jTabbedPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 520));

        setSize(new java.awt.Dimension(664, 502));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String pass = "Shared Password";
        
        if (pass.equals(new String(passIN.getPassword()))) {
            
            try {
                generateQRcode(eqNAME.getText(), 1250,1250, outputQr);       // TODO add your handling code here:
            } catch (WriterException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                String selectSql = "SELECT * FROM item WHERE name = ?";
                PreparedStatement selectStatement = conn.prepareStatement(selectSql);
                selectStatement.setString(1, eqNAME.getText());
                ResultSet resultSet = selectStatement.executeQuery();

                if (resultSet.next()) {
                    // Item already exists, perform the update
                    JOptionPane.showMessageDialog(null, "Item already entered");
                    
                    
                } else {
                    String insertSql = "INSERT INTO item (name, path, possession, status) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
                    preparedStatement.setString(1, eqNAME.getText());
                    preparedStatement.setString(2, pathDIR.getText());
                    preparedStatement.setString(3, "");
                    preparedStatement.setString(4, "Available");
                    preparedStatement.executeUpdate();
                }} catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter entries");
                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println("done");
            
        table_update();
        } else {
            
        }
        eqNAME.setText("");
        pathDIR.setText("");
        passIN.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
    webcam.close();
        SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            // Create a new instance of your JFrame form
            App newForm = new App();
            newForm.setVisible(true);

            // Dispose the existing form
            dispose();
        }
    });   // TODO add your handling code here:
    }//GEN-LAST:event_startActionPerformed

    private void requestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestbtnActionPerformed
    if (B_R == 0) {
        
    } else if (B_R == 1) {
        
        String Name = JOptionPane.showInputDialog(null, "Enter Borrower's name:");
        if (Name != null && !Name.isEmpty()) {
        
        try {
            String updateSql = "UPDATE item SET status = ?, possession = ? WHERE name = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setString(1, "Borrowed");
            updateStatement.setString(2, Name);
            updateStatement.setString(3, result.getText());
            updateStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } 
        status = "Return";
        requestbtn.setText(status);
        B_R = 2;
        } else {
            JOptionPane.showMessageDialog(null, "You didn't enter a name.");
        }
    } else if (B_R == 2) {
        String namedb = getname(result.getText());
        String Name = JOptionPane.showInputDialog(null, "Enter Borrower's name:");
        if (namedb.equals(Name)) {
        try {
            String updateSql = "UPDATE item SET status = ?, possession = ? WHERE name = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateSql);
            updateStatement.setString(1, "Available");
            updateStatement.setString(2, "");
            updateStatement.setString(3, result.getText());
            updateStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        status = "Borrow";
        requestbtn.setText(status);
        B_R = 1;
      
    }
    }
    table_update();    // TODO add your handling code here:
    }//GEN-LAST:event_requestbtnActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_ExitActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit1ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_Exit2ActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
    private void initWebcam(){
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getDefault();
        webcam.setViewSize(size);
        
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        
        camera.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,350,230));
        
        executor.execute(this);
        
    }
        

        
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Check;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton add;
    private javax.swing.JPanel camera;
    private javax.swing.JTextArea documentArea;
    private javax.swing.JTextField eqNAME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lbStart;
    private javax.swing.JPasswordField passIN;
    private javax.swing.JTextField pathDIR;
    private javax.swing.JTextField qr;
    private javax.swing.JButton requestbtn;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        start.setEnabled(false);
        do{
            txtstatus = "Scanning...";
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            if(webcam.isOpen()){
                if((image =webcam.getImage()) == null){
                    continue;
                }
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                
            }
            
            if(result != null){
                qr.setText(result.getText());
                txtstatus = "Scan Complete!";
                lbStart.setText(txtstatus);
                start.setEnabled(true);
                
                
                String filePath = getfile(result.getText());
                XWPFDocument document;
            try {
                FileInputStream fis = new FileInputStream(filePath);
                document = new XWPFDocument(fis);
                
                String docs = "";
                // Extract the content from the document
                List<XWPFParagraph> paragraphList = document.getParagraphs();
                for (XWPFParagraph paragraph: paragraphList) {
                    docs = docs + "\n" + paragraph.getText();
                }
                documentArea.setText(docs);
                

            } catch (FileNotFoundException e){
                System.out.println(filePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Failed to load the document.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                
                return;
            }
            if (filePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a file path.", "Error", JOptionPane.ERROR_MESSAGE);   
            }
            String stats = getstats(result.getText());
            
            if  ("Available".equals(stats)) {
                status = "Borrow";
                requestbtn.setText(status);
                B_R = 1;
            } else {
                status = "Return";
                requestbtn.setText(status);
                B_R = 2;
            }
            
        
                break;
            }
        }while(true);
        
    }
    public static final String outputQr= "C:\\Users\\Lorelei\\Downloads\\outputqr.png"; //placeholder file path
    public static void generateQRcode(String text, int width, int height, String filepath) throws WriterException{
        QRCodeWriter qc = new QRCodeWriter();
        BitMatrix bm = qc.encode(text,BarcodeFormat.QR_CODE,width, height);
        Path pobj = FileSystems.getDefault().getPath(filepath);
        try {
            MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private String getname(String selectedItem) {
        String file = null;
        
        try {
            String query = "SELECT possession FROM item WHERE name = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, selectedItem);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                file = resultSet.getString("Possession");
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return file;
    }
    private String getstats(String selectedItem) {
        String file = null;
        
        try {
            String query = "SELECT status FROM item WHERE name = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, selectedItem);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                file = resultSet.getString("Status");
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return file;
    }
    private String getfile(String selectedItem) {
        String file = null;
        
        try {
            String query = "SELECT path FROM item WHERE name = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, selectedItem);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                file = resultSet.getString("Path");
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }


    
}
