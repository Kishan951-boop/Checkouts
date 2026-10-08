/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package booksmart.Admin.panels;

import booksmart.Admin.panels.dialog.invoiceDetails;
import static booksmart.Admin.panels.dialog.invoiceDetails.invoicedetails;
import booksmart.connection.connection;
import java.awt.Color;
import java.awt.Cursor;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class purchaseHistory extends javax.swing.JPanel {

    public static String boughtId;

    public purchaseHistory() {
        initComponents();
        LoadTable();
    }

    private void LoadTable() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `bought` "
                    + "INNER JOIN `cutomer` ON `bought`.`Cutomer` = `cutomer`.`Cutomer_Id` "
                    + "INNER JOIN `cashier` ON `bought`.`Cashier` = `cashier`.`Cashier_Id`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("Invoice_Id"));
                v.add(rs.getString("Amount"));
                v.add(rs.getString("Order_Date"));
                v.add(rs.getString("C_F_Name") + " " + rs.getString("C_L_Name"));
                v.add(rs.getString("Fname") + " " + rs.getString("Lname"));

                dtm.addRow(v);

            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    private void SearchTable() {

        String InvoiceID = InvoiceId.getText().trim();

        if (InvoiceID.isBlank()) {
            LoadTable();
        } else {

            try {

                int rowcount;

                ResultSet rs = connection.Search("SELECT * FROM `bought` "
                        + "INNER JOIN `cutomer` ON `bought`.`Cutomer` = `cutomer`.`Cutomer_Id` "
                        + "INNER JOIN `cashier` ON `bought`.`Cashier` = `cashier`.`Cashier_Id` WHERE `bought`.`Invoice_Id` LIKE '%" + InvoiceID + "%'");
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    v.add(rs.getString("Invoice_Id"));
                    v.add(rs.getString("Amount"));
                    v.add(rs.getString("Order_Date"));
                    v.add(rs.getString("C_F_Name") + " " + rs.getString("C_L_Name"));
                    v.add(rs.getString("Fname") + " " + rs.getString("Lname"));

                    dtm.addRow(v);

                    if (rs.getRow() == 1) {
                        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        jButton3.setBackground(Color.green);
                        boughtId = rs.getString("Bought_Id");
                    } else {
                        jButton3.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    }

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
        jLabel1 = new javax.swing.JLabel();
        InvoiceId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1592, 594));

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("Purchases");

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > Purchase History");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Enter The Invoice id to search :");

        InvoiceId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InvoiceIdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InvoiceIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                InvoiceIdKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID ", "Amount", "Date", "Customer", "Cashier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(13, 13, 13));
        jButton3.setText("Search.");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InvoiceIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvoiceIdKeyPressed
        SearchTable();
    }//GEN-LAST:event_InvoiceIdKeyPressed

    private void InvoiceIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvoiceIdKeyReleased
        SearchTable();
    }//GEN-LAST:event_InvoiceIdKeyReleased

    private void InvoiceIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvoiceIdKeyTyped
        SearchTable();
    }//GEN-LAST:event_InvoiceIdKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoadTable();
        try {
            InputStream filePath = getClass()
                    .getClassLoader()
                    .getResourceAsStream("booksmart/Report/BookSmart_Bills.jasper");
            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int rowCount = jTable1.getRowCount();

        if (rowCount == 1) {

//            boughtId = (String) jTable1.getValueAt(1, 1);
            if (invoicedetails == null) {
                invoicedetails = new invoiceDetails();
            }

            invoicedetails.setVisible(true);

        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InvoiceId;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
