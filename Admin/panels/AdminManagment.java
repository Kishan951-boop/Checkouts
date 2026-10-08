package booksmart.Admin.panels;

import booksmart.connection.connection;
import java.awt.Color;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class AdminManagment extends javax.swing.JPanel {

    public AdminManagment() {
        initComponents();
        LoadTable();
    }

    private void LoadTable() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `cashier` INNER JOIN `gender` ON `cashier`.`C_Gender` = `gender`.`gender_ID` INNER JOIN `status` ON `cashier`.`C_Status` = `status`.`Status_ID`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("Fname") + " " + rs.getString("Lname"));
                v.add(rs.getString("Nic"));
                v.add(rs.getString("Email"));
                v.add(rs.getString("Mobile"));
                v.add(rs.getString("Gender_Name"));
                v.add(rs.getString("status"));
                dtm.addRow(v);

            }

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }

    private void SearchTable() {

        String NIC = CashierNic.getText().trim();

        if (NIC.isBlank()) {
            LoadTable();
            ActiveDeactiveBTN.setText("Activate Or Deactivate");
            ActiveDeactiveBTN.setBackground(Color.YELLOW);
        } else {

            try {
                ResultSet rs = connection.Search("SELECT * FROM `cashier` "
                        + "INNER JOIN `gender` ON `cashier`.`C_Gender` = `gender`.`gender_ID` "
                        + "INNER JOIN `status` ON `cashier`.`C_Status` = `status`.`Status_ID` "
                        + "WHERE `cashier`.`Nic` LIKE '%" + NIC + "%'");

                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.setRowCount(0);

                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    v.add(rs.getString("Fname") + " " + rs.getString("Lname"));
                    v.add(rs.getString("Nic"));
                    v.add(rs.getString("Email"));
                    v.add(rs.getString("Mobile"));
                    v.add(rs.getString("Gender_Name"));
                    v.add(rs.getString("status"));
                    dtm.addRow(v);

                    if (rs.getInt("C_Status") == 1) {
                        ActiveDeactiveBTN.setText("Deactivate User");
                        ActiveDeactiveBTN.setBackground(Color.red);
                    } else {
                        ActiveDeactiveBTN.setText("Activate User");
                        ActiveDeactiveBTN.setBackground(Color.green);
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
        CashierNic = new javax.swing.JTextField();
        ActiveDeactiveBTN = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(50, 50));
        setMinimumSize(new java.awt.Dimension(1000, 1000));

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("Worker Managment");

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > Admin Managment");

        CashierNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CashierNicKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashierNicKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CashierNicKeyTyped(evt);
            }
        });

        ActiveDeactiveBTN.setBackground(new java.awt.Color(255, 255, 0));
        ActiveDeactiveBTN.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ActiveDeactiveBTN.setForeground(new java.awt.Color(12, 11, 11));
        ActiveDeactiveBTN.setText("Activate Or Deactivate");
        ActiveDeactiveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiveDeactiveBTNActionPerformed(evt);
            }
        });

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
        jLabel1.setText("Enter The NIC To Activate Or Deactivate Admin :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "NIC", "Email", "Mobile", "Gender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1332, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CashierNic, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ActiveDeactiveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CashierNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActiveDeactiveBTN)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(340, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CashierNicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashierNicKeyPressed
        SearchTable();
    }//GEN-LAST:event_CashierNicKeyPressed

    private void CashierNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashierNicKeyReleased
        SearchTable();
    }//GEN-LAST:event_CashierNicKeyReleased

    private void CashierNicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashierNicKeyTyped
        SearchTable();
    }//GEN-LAST:event_CashierNicKeyTyped

    private void ActiveDeactiveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiveDeactiveBTNActionPerformed
        String NIC = CashierNic.getText().trim();

        if (NIC.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The National Identification Number",
                    "Worker managment",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ResultSet rs = connection.Search("SELECT * FROM `cashier` WHERE `cashier`.`Nic` = '" + NIC + "'");

            if (rs.next()) {

                int StatusId;
                String status;

                if (rs.getInt("C_Status") == 1) {
                    StatusId = 0;
                    status = "Deactivated";
                } else {
                    StatusId = 1;
                    status = "Activated";
                }

                connection.IUD("UPDATE `cashier` SET `C_Status` = '" + StatusId + "' WHERE `cashier`.`Nic` = '" + NIC + "'");

                JOptionPane.showMessageDialog(null,
                        "Worker Has Been" + status,
                        "Worker managment",
                        JOptionPane.PLAIN_MESSAGE);
                LoadTable();
                SearchTable();

            } else {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The Correct Nic",
                        "Worker managment",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact The Devoloper",
                    "Worker managment",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ActiveDeactiveBTNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoadTable();
        try {
            InputStream filePath = getClass()
                    .getClassLoader()
                    .getResourceAsStream("booksmart/Report/BookSmart_Cashier.jasper");
            HashMap<String, Object> parameters = new HashMap<>();

            JRTableModelDataSource jrTableModelDataSource = new JRTableModelDataSource(jTable1.getModel());
            JasperPrint fillReport = JasperFillManager.fillReport(filePath, parameters, jrTableModelDataSource);
            JasperViewer.viewReport(fillReport, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActiveDeactiveBTN;
    private javax.swing.JTextField CashierNic;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
