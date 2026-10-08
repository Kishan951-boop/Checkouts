/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package booksmart.cashier.frames;

import static booksmart.cashier.cashierPortal.makeRoundedImage;
import booksmart.connection.connection;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author kisha
 */
public class Stocks extends javax.swing.JPanel {

    private final HashMap<String, Integer> bookMap;

    public Stocks() {
        this.bookMap = new HashMap<>();
        initComponents();
        loadBooks();
    }

    private void loadBooks() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `books`");
            Vector<String> Books = new Vector();
            Books.add("Select Book");
            bookMap.put("Select Book", 0);
            while (rs.next()) {
                String BookName = rs.getString("Book_Name");
                bookMap.put(BookName, rs.getInt("Book_id"));
                Books.add(BookName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Books);
            BookComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void empty() {

        Quantity.setText("");
        buyPriceInput.setText("");
        sellingPriceInput.setText("");

    }

    private void BookDetailsLoad() {
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

        System.out.println(BookId);

        if (BookId != 0) {

            ResultSet rs;
            try {

                rs = connection.Search("SELECT * FROM `books` INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID` "
                        + "INNER JOIN `author` ON `books`.`Author_Author_id` = `author`.`Author_id`"
                        + "INNER JOIN `language` ON `books`.`Language_Language_ID` = `language`.`Language_ID` "
                        + "INNER JOIN `recomend_age` ON `books`.`Recomend_Age_R_Age_ID` = `recomend_age`.`R_Age_ID` WHERE `Book_id` = '" + BookId + "'");

                if (rs.next()) {

                    BookName.setText(rs.getString("Book_Name"));
                    Category.setText(rs.getString("Category_Name"));
                    Language.setText(rs.getString("Language_Name"));
                    Author.setText(rs.getString("Author_Name"));
                    Age.setText(rs.getString("Age"));

                    String image = rs.getString("Book_img");

                    System.out.println(image);

                    ImageIcon icon = new ImageIcon(getClass().getResource(image));
                    Image scaledImage = icon.getImage()
                            .getScaledInstance(
                                    ShowBookIMG.getWidth(), // Use JLabel's width
                                    ShowBookIMG.getHeight(), // Use JLabel's height
                                    Image.SCALE_SMOOTH
                            );
                    ShowBookIMG.setIcon(new ImageIcon(scaledImage));

                } else {
                    System.out.println("Something went wrong😭");
                }

            } catch (SQLException ex) {
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ShowBookIMG = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BookComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        Quantity = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buyPriceInput = new javax.swing.JFormattedTextField();
        sellingPriceInput = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Category = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Author = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Language = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Book");

        BookComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Qty");

        Quantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Buy Price");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Selling Price");

        buyPriceInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        sellingPriceInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Book Name :");

        BookName.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Category");

        Category.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Author");

        Author.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Language");

        Language.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Age");

        Age.setEditable(false);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setForeground(new java.awt.Color(11, 10, 10));
        jButton3.setText("Sumbit.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(243, 237, 237));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BookComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ShowBookIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookName)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Category)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Language)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Author)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Age, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buyPriceInput)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(sellingPriceInput)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
                    .addComponent(Quantity)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShowBookIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sellingPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        empty();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookComboBoxActionPerformed
        BookDetailsLoad();
    }//GEN-LAST:event_BookComboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

        String qty = Quantity.getText().trim();
        String bPrice = buyPriceInput.getText().trim();
        String sPrice = sellingPriceInput.getText().trim();
        double buyPrice = Double.parseDouble(bPrice);
        double sellPrice = Double.parseDouble(sPrice);

        if (BookId == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Book",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (qty.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Quantity",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (bPrice.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Book Buyed Price",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (sPrice.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Book Selling Price",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);

        connection.IUD("INSERT INTO `stock` (`Qty`,`Public_Price`,`Original_Price`,`Sold`,`Last_Stock_Update`,`S_Book_id`,`S_status`) "
                + "VALUES ('" + qty + "','" + sellPrice + "','" + buyPrice + "','0','" + formattedDateTime + "','" + BookId + "','1')");

        JOptionPane.showMessageDialog(null,
                "Book Stock Added Successfull",
                "Book",
                JOptionPane.INFORMATION_MESSAGE);
        
        empty();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Author;
    private javax.swing.JComboBox<String> BookComboBox;
    private javax.swing.JTextField BookName;
    private javax.swing.JTextField Category;
    private javax.swing.JTextField Language;
    private javax.swing.JFormattedTextField Quantity;
    private javax.swing.JLabel ShowBookIMG;
    private javax.swing.JFormattedTextField buyPriceInput;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField sellingPriceInput;
    // End of variables declaration//GEN-END:variables
}
