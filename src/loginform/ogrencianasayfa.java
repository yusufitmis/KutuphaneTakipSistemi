/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginform;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author monster
 */
public class ogrencianasayfa extends javax.swing.JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:1234/kutuphaneyonetim";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    
   
    
    public ogrencianasayfa() {
        initComponents();
        showBooksInTable(tblOgrÜzerimdekiler, "SELECT * FROM oduncKitaplar");
        showBooksInTable(jTable1, "SELECT * FROM kitaplar");
         
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                tableMouseClicked(jTable1, txtOgrAnasayfaKitapAdi, txtOgrAnasayfaIsbn, txtOgrAnasayfaYazarAdi);
                
            }
        });
        btnOgrAnasayfaAramaButonu.addActionListener((e) -> {
            String aramaKelimesi = txtOgrAnasayfaAramaCubugu.getText();
            searchBooks(aramaKelimesi);
        });
    }
    private void showBooksInTable(javax.swing.JTable table, String query, String... params) {
    try {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setString(i + 1, params[i]);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        
        while (resultSet.next()) {
            String kitapAdi = resultSet.getString("kitapAdi");
            String yazar = resultSet.getString("yazar");
            String isbn = resultSet.getString("ISBN");
            
            String durum = resultSet.getString("durum");

            Object[] row = {isbn, kitapAdi, yazar, durum};
            model.addRow(row);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private boolean oduncAl(String isbn) {
    try {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String insertQuery = "INSERT INTO oduncKitaplar (ISBN, kitapAdi, yazar, durum) SELECT ISBN, kitapAdi, yazar, 'ÖDÜNÇ ALINDI' FROM kitaplar WHERE ISBN = ?";
        String deleteQuery = "DELETE FROM kitaplar WHERE ISBN = ?";


        
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            
            insertStatement.setString(1, isbn);
            int insertResult = insertStatement.executeUpdate();
            deleteStatement.setString(1, isbn);
            int deleteResult = deleteStatement.executeUpdate();

            return insertResult > 0 && deleteResult > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    
}
    private void searchBooks(String keyword) {
    String query = "SELECT * FROM kitaplar WHERE kitapAdi LIKE ? OR yazar LIKE ? OR ISBN LIKE ?";
    showBooksInTable(jTable1, query, "%" + keyword + "%", "%" + keyword + "%", "%" + keyword + "%");
}
    private void updateBookStatus(String isbn, String newStatus) {
    try {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        String updateQuery = "UPDATE kitaplar SET durum = ? WHERE ISBN = ?";

        
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            
            updateStatement.setString(1, newStatus);
            updateStatement.setString(2, isbn);
            updateStatement.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    

        
private void tableMouseClicked(javax.swing.JTable table, javax.swing.JTextField txtKitapAdi, javax.swing.JTextField txtIsbn, javax.swing.JTextField txtYazarAdi) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String kitapAdi = table.getValueAt(selectedRow, 1).toString();
            String isbn = table.getValueAt(selectedRow, 0).toString();
            String yazarAdi = table.getValueAt(selectedRow, 2).toString();

            txtKitapAdi.setText(kitapAdi);
            txtIsbn.setText(isbn);
            txtYazarAdi.setText(yazarAdi);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOgrÜzerimdekiler = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtOgrAnasayfaAramaCubugu = new javax.swing.JTextField();
        btnOgrAnasayfaAramaButonu = new javax.swing.JButton();
        btnOgrAnasayfaOduncAl1 = new javax.swing.JButton();
        btnOgrAnasayfaIadeEt1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOgrAnasayfaKitapAdi = new javax.swing.JTextField();
        txtOgrAnasayfaIsbn = new javax.swing.JTextField();
        txtOgrAnasayfaYazarAdi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/profil.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("ÜZERİMDEKİLER");

        tblOgrÜzerimdekiler.setBackground(new java.awt.Color(0, 102, 102));
        tblOgrÜzerimdekiler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "KİTAP ADI", "YAZAR", "DURUM"
            }
        ));
        tblOgrÜzerimdekiler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOgrÜzerimdekilerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOgrÜzerimdekiler);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "KİTAP ADI", "YAZAR", "DURUM"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("KİTAPLAR");

        txtOgrAnasayfaAramaCubugu.setBackground(new java.awt.Color(102, 102, 102));
        txtOgrAnasayfaAramaCubugu.setForeground(new java.awt.Color(255, 255, 255));

        btnOgrAnasayfaAramaButonu.setBackground(new java.awt.Color(102, 102, 102));
        btnOgrAnasayfaAramaButonu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOgrAnasayfaAramaButonu.setForeground(new java.awt.Color(255, 255, 255));
        btnOgrAnasayfaAramaButonu.setText("ARA");

        btnOgrAnasayfaOduncAl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOgrAnasayfaOduncAl1.setForeground(new java.awt.Color(0, 102, 102));
        btnOgrAnasayfaOduncAl1.setText("KİTAP ÖDÜNÇ AL");
        btnOgrAnasayfaOduncAl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOgrAnasayfaOduncAl1ActionPerformed(evt);
            }
        });

        btnOgrAnasayfaIadeEt1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOgrAnasayfaIadeEt1.setForeground(new java.awt.Color(0, 102, 102));
        btnOgrAnasayfaIadeEt1.setText("İADE ET");
        btnOgrAnasayfaIadeEt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOgrAnasayfaIadeEt1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("ÇIKIŞ YAP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOgrAnasayfaIadeEt1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(txtOgrAnasayfaAramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnOgrAnasayfaAramaButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOgrAnasayfaOduncAl1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOgrAnasayfaAramaButonu, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtOgrAnasayfaAramaCubugu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOgrAnasayfaOduncAl1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOgrAnasayfaIadeEt1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 950, 630));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("KİTAP ADI:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("ISBN :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("YAZAR :");

        txtOgrAnasayfaYazarAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOgrAnasayfaYazarAdiActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ödüncall.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOgrAnasayfaIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOgrAnasayfaKitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOgrAnasayfaYazarAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtOgrAnasayfaKitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtOgrAnasayfaIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtOgrAnasayfaYazarAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 300, 430));

        setSize(new java.awt.Dimension(1245, 630));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login logn = new login();
        logn.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnOgrAnasayfaOduncAl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOgrAnasayfaOduncAl1ActionPerformed
      int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String selectedISBN = jTable1.getValueAt(selectedRow, 0).toString();

        
        boolean success = oduncAl(selectedISBN);

        if (success) {
            
            updateBookStatus(selectedISBN, "ODUNC ALINDI");

            
            showBooksInTable(tblOgrÜzerimdekiler, "SELECT * FROM oduncKitaplar");
            
            showBooksInTable(jTable1, "SELECT * FROM kitaplar");
        } else {
           
            JOptionPane.showMessageDialog(this, "Kitabı ödünç almak başarısız!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        
        JOptionPane.showMessageDialog(this, "Lütfen ödünç almak istediğiniz kitabı seçin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnOgrAnasayfaOduncAl1ActionPerformed
   private boolean kitapIadeEt(String isbn, String kitapAdi, String yazar) {
    try {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        
        String insertQuery = "INSERT INTO kitaplar (ISBN, kitapAdi, yazar, durum) VALUES (?, ?, ?, 'RAFTA')";
        String deleteQuery = "DELETE FROM oduncKitaplar WHERE ISBN = ?";

        
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {

            
            insertStatement.setString(1, isbn);
            insertStatement.setString(2, kitapAdi);
            insertStatement.setString(3, yazar);
            int insertResult = insertStatement.executeUpdate();

            
            deleteStatement.setString(1, isbn);
            int deleteResult = deleteStatement.executeUpdate();

            return insertResult > 0 && deleteResult > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    private void btnOgrAnasayfaIadeEt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOgrAnasayfaIadeEt1ActionPerformed
    int selectedRow = tblOgrÜzerimdekiler.getSelectedRow();
    if (selectedRow != -1) {
        String isbn = tblOgrÜzerimdekiler.getValueAt(selectedRow, 0).toString();
        String kitapAdi = tblOgrÜzerimdekiler.getValueAt(selectedRow, 1).toString();
        String yazar = tblOgrÜzerimdekiler.getValueAt(selectedRow, 2).toString();

       
        boolean success = kitapIadeEt(isbn, kitapAdi, yazar);

        if (success) {
            
            showBooksInTable(tblOgrÜzerimdekiler, "SELECT * FROM oduncKitaplar");
            showBooksInTable(jTable1, "SELECT * FROM kitaplar");
        } else {
            
            JOptionPane.showMessageDialog(this, "Kitapları iade etmek başarısız!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        
        JOptionPane.showMessageDialog(this, "Lütfen iade etmek istediğiniz kitabı seçin.", "Uyarı", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnOgrAnasayfaIadeEt1ActionPerformed

    private void txtOgrAnasayfaYazarAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOgrAnasayfaYazarAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOgrAnasayfaYazarAdiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void tblOgrÜzerimdekilerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOgrÜzerimdekilerMouseClicked
         int selectedRow = tblOgrÜzerimdekiler.getSelectedRow();
    if (selectedRow != -1) {
        String kitapAdi = tblOgrÜzerimdekiler.getValueAt(selectedRow, 1).toString();
        String isbn = tblOgrÜzerimdekiler.getValueAt(selectedRow, 0).toString();
        String yazarAdi = tblOgrÜzerimdekiler.getValueAt(selectedRow, 2).toString();

        
        txtOgrAnasayfaKitapAdi.setText(kitapAdi);
        txtOgrAnasayfaIsbn.setText(isbn);
        txtOgrAnasayfaYazarAdi.setText(yazarAdi);
    }

    }//GEN-LAST:event_tblOgrÜzerimdekilerMouseClicked

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
            java.util.logging.Logger.getLogger(ogrencianasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ogrencianasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ogrencianasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ogrencianasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ogrencianasayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOgrAnasayfaAramaButonu;
    private javax.swing.JButton btnOgrAnasayfaIadeEt1;
    private javax.swing.JButton btnOgrAnasayfaOduncAl1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblOgrÜzerimdekiler;
    private javax.swing.JTextField txtOgrAnasayfaAramaCubugu;
    private javax.swing.JTextField txtOgrAnasayfaIsbn;
    private javax.swing.JTextField txtOgrAnasayfaKitapAdi;
    private javax.swing.JTextField txtOgrAnasayfaYazarAdi;
    // End of variables declaration//GEN-END:variables
}
