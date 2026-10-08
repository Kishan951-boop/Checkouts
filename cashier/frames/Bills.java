package booksmart.cashier.frames;

import static booksmart.cashier.cashierPortal.CashierID;
import booksmart.connection.connection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Bills extends javax.swing.JPanel {

    private final HashMap<String, Integer> bookMap;
    public static String Invoice_Id;
    public static String formattedDateTime;
    public static boolean ReportToOk = false;

    public Bills() {
        this.bookMap = new HashMap<>();
        initComponents();
        loadBooks();
    }

    private void loadBooks() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `books` "
                    + "INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID`"
                    + "INNER JOIN `stock` ON `stock`.`S_Book_id` = `books`.`Book_id`");
            Vector<String> Books = new Vector();
            Books.add("Select Book");
            bookMap.put("Select Book", 0);
            while (rs.next()) {
                String BookName = rs.getString("Book_Name") + " | Id : " + rs.getString("Stock_ID") + " | Price : " + rs.getString("Public_Price");
                bookMap.put(BookName, rs.getInt("Stock_ID"));
                Books.add(BookName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Books);
            BookComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void customerDataLoad() {
        String nic = NIC.getText().trim();

        try {
            ResultSet rs = connection.Search("SELECT * FROM `cutomer` WHERE `NIC` = '" + nic + "'");
            if (rs.next()) {
                CustomerName.setText(rs.getString("C_F_Name") + " " + rs.getString("C_L_Name"));
            } else {
                CustomerName.setText("");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Something went wrong. Please Contact The Devoloper..",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void loadTable() {
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int StockID = bookMap.get(selectedBookName);
        String qty = QTY.getText().trim();

        if (StockID == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Bokk and stocks",
                    "Teacher",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (qty.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Qty",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String query = "SELECT * FROM `books` INNER JOIN `stock` ON `stock`.`S_Book_id` = `books`.`Book_id` WHERE `stock`.`Stock_ID` = '" + StockID + "'";
            ResultSet r = connection.Search(query);

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            while (r.next()) {

                double price = r.getDouble("Public_Price");
                int calAmount = (int) (price * Integer.parseInt(qty));
                String Amount = Integer.toString(calAmount);

                String Fullamount = FullAmount.getText().trim();
                if (Fullamount.isBlank()) {
                    FullAmount.setText(Amount);
                } else {
                    int Idonthavenames = Integer.parseInt(Fullamount);
                    int Idonthavenames2 = Integer.parseInt(Amount);
                    int something = Idonthavenames2 + Idonthavenames;
                    String pleasework = Integer.toString(something);
                    FullAmount.setText(pleasework);
                }

                Vector<String> row = new Vector<>();

                row.add(r.getString("Stock_ID"));
                row.add(r.getString("Book_Name"));
                row.add(qty);
                row.add(String.format("%.2f", price));
                row.add(Amount + "/=");

                dtm.addRow(row);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Database error. Please contact the developer",
                    "DBMS error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }

    private void empty() {

        loadBooks();
        QTY.setText("");
        NIC.setText("");
        CustomerName.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

    }

    private void DataUpdate() {

        String CusName = CustomerName.getText().trim();
        String nic = NIC.getText().trim();
        String amount = FullAmount.getText().trim();

        if (CusName.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Customer Id To Check Customer alredy registered else register the customer first.",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Add the Book To Make Bill.",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = LocalDateTime.now().format(formatter);

        Invoice_Id = "BookSmart_" + System.currentTimeMillis();

        ResultSet rs;
        try {

            rs = connection.Search("SELECT * FROM `cutomer` WHERE `NIC` = '" + nic + "'");

            if (rs.next()) {

                int customerId = rs.getInt("Cutomer_Id");

                connection.IUD("INSERT INTO `bought` (`Invoice_Id`,`Amount`,`Order_Date`,`Cutomer`,`Cashier`) "
                        + "VALUES ('" + Invoice_Id + "','" + amount + "','" + formattedDateTime + "','" + customerId + "','" + CashierID + "')");

                ResultSet invoice = connection.Search("SELECT * FROM `bought` WHERE `Invoice_Id` = '" + Invoice_Id + "'");

                if (invoice.next()) {

                    int invoiceTableId = invoice.getInt("Bought_Id");

                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    int rowCount = model.getRowCount();
                    int colCount = model.getColumnCount();
                    for (int row = 0; row < rowCount; row++) {

                        String stockID = model.getValueAt(row, 0).toString();
                        String qty = model.getValueAt(row, 2).toString();

                        connection.IUD("INSERT INTO `bought_item` (`qty`,`Order_Stock_ID`,`B_Invoice_Id`) "
                                + "VALUES ('" + qty + "','" + stockID + "','" + invoiceTableId + "')");

                        ResultSet stocky = connection.Search("SELECT * FROM `stock` WHERE `Stock_ID` = '" + stockID + "'");

                        if (stocky.next()) {

                            int soldPlusQty = Integer.parseInt(qty);
                            int updatesold = stocky.getInt("Sold") + soldPlusQty;
                            connection.IUD("UPDATE `stock` SET `Sold` = '" + updatesold + "' WHERE `Stock_ID` = '" + stockID + "'");

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Oops.. Something Went Wrong, Please Contact the devoloper.....",
                                    "Bills",
                                    JOptionPane.ERROR_MESSAGE);
                        }

                        ReportToOk = true;

                    }

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Oops.. Something Went Wrong, Please Try Again Later.....",
                            "Bills",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(null,
                        "Please Enter The Customer Id To Check Customer alredy registered else register the customer first.",
                        "Bills",
                        JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact your stupid devoloper.",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }

    private void Report() {

        String nic = NIC.getText().trim();
        try {
            ResultSet rs = connection.Search("SELECT * FROM `cutomer` WHERE `NIC` = '" + nic + "'");
            if (rs.next()) {
                String Name = CustomerName.getText().trim();
                String Total = FullAmount.getText().trim();
                String Email = rs.getString("Email");
                String Mobile = rs.getString("Mobile");

                try {
                    InputStream filePath = getClass()
                            .getClassLoader()
                            .getResourceAsStream("booksmart/Report/BookSmart_Pay.jrxml");

                    if (filePath == null) {
                        JOptionPane.showMessageDialog(null,
                                "File not found! check the f**king file bro.",
                                "Bills",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    HashMap<String, Object> parameters = new HashMap<>();
                    parameters.put("Name", Name);
                    parameters.put("Nic", nic);
                    parameters.put("Mobile", Mobile);
                    parameters.put("Email", Email);
                    parameters.put("Amount", Total + "/=");
                    parameters.put("InvoiceId", Invoice_Id);
                    parameters.put("Date", formattedDateTime);

                    JasperReport compileReport = JasperCompileManager.compileReport(filePath);
                    JasperPrint fillReport = JasperFillManager.fillReport(compileReport, parameters, new JRTableModelDataSource(jTable1.getModel()));
                    JasperViewer.viewReport(fillReport, false);

                } catch (JRException e) {
                    JOptionPane.showMessageDialog(null,
                            "Please Contact your stupid devoloper.",
                            "Bills",
                            JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact your stupid devoloper.",
                    "Bills",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BookComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        QTY = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        NIC = new javax.swing.JTextField();
        CustomerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        FullAmount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Book");

        BookComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Quantity");

        QTY.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        QTY.setText("1");

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(11, 10, 10));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Enter Customer NIC");

        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });
        NIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NICKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NICKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NICKeyTyped(evt);
            }
        });

        CustomerName.setEditable(false);
        CustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Customer Name");

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Book Name", "Quantity", "One Book", "Amount"
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

        FullAmount.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Amount :");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(249, 246, 246));
        jButton2.setText("Cancel.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(13, 13, 13));
        jButton3.setText("Print Bill.");
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookComboBox, 0, 478, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QTY)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NIC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerName)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FullAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NICActionPerformed
    }//GEN-LAST:event_NICActionPerformed

    private void CustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameActionPerformed

    private void NICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NICKeyPressed
        customerDataLoad();
    }//GEN-LAST:event_NICKeyPressed

    private void NICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NICKeyReleased
        customerDataLoad();
    }//GEN-LAST:event_NICKeyReleased

    private void NICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NICKeyTyped
        customerDataLoad();
    }//GEN-LAST:event_NICKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DataUpdate();

        if (ReportToOk) {

            JOptionPane.showMessageDialog(null,
                    "Bill Will Print Soon.....",
                    "Bills",
                    JOptionPane.INFORMATION_MESSAGE);
            Report();
            empty();

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookComboBoxActionPerformed
        QTY.setText("1");
    }//GEN-LAST:event_BookComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        empty();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookComboBox;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField FullAmount;
    private javax.swing.JTextField NIC;
    private javax.swing.JFormattedTextField QTY;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
