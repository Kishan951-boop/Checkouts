/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package booksmart.Admin.panels;

import booksmart.connection.connection;
import java.awt.Color;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author kisha
 */
public class BookManagment extends javax.swing.JPanel {

    /**
     * Creates new form StockManagment
     */
    public BookManagment() {
        initComponents();
        LoadTable();
    }

    private void LoadTable() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `books` INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID` "
                    + "INNER JOIN `author` ON `books`.`Author_Author_id` = `author`.`Author_id` "
                    + "INNER JOIN `language` ON `books`.`Language_Language_ID` = `language`.`Language_ID` "
                    + "INNER JOIN `recomend_age` ON `books`.`Recomend_Age_R_Age_ID` = `recomend_age`.`R_Age_ID` ");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("Book_Name"));
                v.add(rs.getString("Publish_Date"));
                v.add(rs.getString("Category_Name"));
                v.add(rs.getString("Language_Name"));
                v.add(rs.getString("Author_Name"));
                v.add(rs.getString("Age"));
                dtm.addRow(v);

            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    private void SearchTable() {

        String Book_Name = BookName.getText().trim();

        if (Book_Name.isBlank()) {
            LoadTable();
        } else {

            try {

                ResultSet rs = connection.Search("SELECT * FROM `books` INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID` "
                        + "INNER JOIN `author` ON `books`.`Author_Author_id` = `author`.`Author_id` "
                        + "INNER JOIN `language` ON `books`.`Language_Language_ID` = `language`.`Language_ID` "
                        + "INNER JOIN `recomend_age` ON `books`.`Recomend_Age_R_Age_ID` = `recomend_age`.`R_Age_ID` WHERE `books`.`Book_Name` LIKE '%" + Book_Name + "%' ");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    v.add(rs.getString("Book_Name"));
                    v.add(rs.getString("Publish_Date"));
                    v.add(rs.getString("Category_Name"));
                    v.add(rs.getString("Language_Name"));
                    v.add(rs.getString("Author_Name"));
                    v.add(rs.getString("Age"));
                    dtm.addRow(v);

                }

            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("Book Managment");

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > Book Managment");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Book Name", "Publish Date", "Category", "Language", "Author", "Ages"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(13, 13, 13));
        jButton2.setText("Get A report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Search Book :");

        BookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BookNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BookNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BookNameKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(15, 15, 15));
        jButton1.setText("Search Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 282, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(717, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoadTable();
        try {
            InputStream filePath = getClass()
                    .getClassLoader()
                    .getResourceAsStream("booksmart/Report/Booksmart_Books.jasper");
            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SearchTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BookNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookNameKeyPressed
        SearchTable();
    }//GEN-LAST:event_BookNameKeyPressed

    private void BookNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookNameKeyReleased
        SearchTable();
    }//GEN-LAST:event_BookNameKeyReleased

    private void BookNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookNameKeyTyped
        SearchTable();
    }//GEN-LAST:event_BookNameKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
