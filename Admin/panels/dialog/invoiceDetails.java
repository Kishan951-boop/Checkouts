/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package booksmart.Admin.panels.dialog;

import java.sql.ResultSet;
import java.sql.SQLException;
import static booksmart.Admin.panels.purchaseHistory.boughtId;
import booksmart.connection.connection;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author kisha
 */
public class invoiceDetails extends javax.swing.JFrame {

    public static invoiceDetails invoicedetails;

    public invoiceDetails() {
        initComponents();
        setDefaultCloseOperation(invoicedetails.HIDE_ON_CLOSE);
        System.out.println(boughtId);
        loadDetails();

    }

    private void loadDetails() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `bought_item` "
                    + "INNER JOIN `bought` ON `bought_item`.`B_Invoice_Id` = `bought`.`Bought_Id` "
                    + "INNER JOIN `stock` ON `stock`.`Stock_ID` = `bought_item`.`Order_Stock_ID` "
                    + "INNER JOIN `books` ON `books`.`Book_id` = `stock`.`S_Book_id`"
                    + "WHERE `bought`.`Bought_Id` = '" + boughtId + "'");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                invoiceIDText.setText("Invoice ID : " + rs.getString("Invoice_Id"));
                Amount.setText("Amount : " + rs.getString("Amount"));

                String BookAmount = Integer.toString(rs.getInt("qty") * rs.getInt("Public_Price"));

                Vector<String> v = new Vector<>();
                v.add(rs.getString("Stock_ID"));
                v.add(rs.getString("Book_Name"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("Public_Price"));
                v.add(BookAmount);

                dtm.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(invoiceDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void Report() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `bought` "
                    + "INNER JOIN `cutomer` ON `bought`.`Cutomer` = `cutomer`.`Cutomer_Id` "
                    + "INNER JOIN `cashier` ON `bought`.`Cashier` = `cashier`.`Cashier_Id` WHERE `bought`.`Bought_Id` = '" + boughtId + "'");
            if (rs.next()) {

                String Name = rs.getString("C_F_Name") + " " + rs.getString("C_L_Name");
                String Total = rs.getString("Amount");
                String Email = rs.getString("Email");
                String Mobile = rs.getString("Mobile");
                String nic = rs.getString("NIC");
                String formattedDateTime = rs.getString("Order_Date");
                String InvoiceID = rs.getString("Invoice_Id");

                try {
                    InputStream filePath = getClass()
                            .getClassLoader()
                            .getResourceAsStream("booksmart/Report/BookSmart_Pay.jrxml");

                    if (filePath == null) {
                        JOptionPane.showMessageDialog(null,
                                "File not found! check the f**king file bro.",
                                "Invoice",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("Name", Name);
                    parameters.put("Nic", nic);
                    parameters.put("Mobile", Mobile);
                    parameters.put("Email", Email);
                    parameters.put("Amount", Total + "/=");
                    parameters.put("InvoiceId", InvoiceID);
                    parameters.put("Date", formattedDateTime);

                    JasperReport compileReport = JasperCompileManager.compileReport(filePath);
                    JasperPrint fillReport = JasperFillManager.fillReport(compileReport, parameters, new JRTableModelDataSource(jTable1.getModel()));
                    JasperViewer.viewReport(fillReport, false);

                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null,
                            "Please Contact your stupid devoloper.",
                            "Invoice",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact your stupid devoloper.",
                    "Invoice",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invoiceIDText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Amount = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setTitle("Invoice");

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("Invoice");

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > Purchase History > Invoice");

        invoiceIDText.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        invoiceIDText.setText("Invoice ID ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stock Id", "Book Name", "Quantity", "Price", "Total"
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

        Amount.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Amount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Amount.setText("Amount :");

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(13, 13, 13));
        jButton1.setText("Check Invoice.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(invoiceIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceIDText)
                    .addComponent(Amount))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Report();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amount;
    private javax.swing.JLabel invoiceIDText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
