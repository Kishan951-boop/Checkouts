/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package booksmart.cashier;

import booksmart.cashier.frames.Bills;
import booksmart.cashier.frames.BookUpdate;
import booksmart.cashier.frames.Books;
import booksmart.cashier.frames.Customer;
import booksmart.cashier.frames.Setting;
import booksmart.cashier.frames.StockUpdate;
import booksmart.cashier.frames.Stocks;
import booksmart.connection.connection;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.SwingUtilities;

public class cashierPortal extends javax.swing.JFrame {

    public static cashierPortal cashierPortal;
    public static int CashierID;
    private Bills cashierBills;
    private Books cashierBooks;
    private BookUpdate cashierBookUpdate;
    private Stocks cashierStocks;
    private StockUpdate cashierStockUpdate;
    private Customer cashierCustomer;
    private Setting cashierSetting;
    private CardLayout contentPanelLayout;

    public cashierPortal(int id) {
        initComponents();
        booksmart.home.appicon.AppIcon.applyIcon(this);
        CashierID = id;
        design();
        loadPanel();
    }

    public static Image makeRoundedImage(Image image) {
        int size = Math.min(image.getWidth(null), image.getHeight(null));
        BufferedImage rounded = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = rounded.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillOval(0, 0, size, size);
        g2.setComposite(AlphaComposite.SrcIn);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return rounded;
    }

    private void design() {

        billsBtn.setIcon(new FlatSVGIcon("booksmart/img/money-bills-solid.svg", 15, 15));

        booksbtn.setIcon(new FlatSVGIcon("booksmart/img/book-solid.svg", 15, 15));
        bookUpsbtn.setIcon(new FlatSVGIcon("booksmart/img/book-medical-solid.svg", 15, 15));

        stocksbtn.setIcon(new FlatSVGIcon("booksmart/img/cubes-stacked-solid.svg", 15, 15));
        stockUpsbtn.setIcon(new FlatSVGIcon("booksmart/img/boxes-stacked-solid.svg", 15, 15));

        customerbtn.setIcon(new FlatSVGIcon("booksmart/img/users-solid.svg", 15, 15));
        settingBtn.setIcon(new FlatSVGIcon("booksmart/img/gear-solid.svg", 15, 15));

        try {

            ResultSet rs = connection.Search("SELECT * FROM `cashier` WHERE `Cashier_Id` = '1'");

            if (rs.next()) {

                cashierName.setText(rs.getString("Fname") + " " + rs.getString("Lname"));
                Email.setText(rs.getString("Email"));

                URL imgURL = getClass().getResource(rs.getString("Profile_Img"));

                boolean ifurl = rs.getString("Profile_Img") == "";
                
                if (imgURL != null | ifurl) {

                    ImageIcon icon = new ImageIcon(imgURL);
                    Image image = icon.getImage();
                    Image roundImage = makeRoundedImage(image);
                    Image scaledImage = roundImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    ProfilePic.setIcon(new ImageIcon(scaledImage));

                } else {
                    ImageIcon icon2 = new ImageIcon(getClass().getResource("/booksmart/img/profile.png"));
                    Image image2 = icon2.getImage();
                    Image roundImage2 = makeRoundedImage(image2);
                    Image scaledImage2 = roundImage2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    ProfilePic.setIcon(new ImageIcon(scaledImage2));
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Oops something Went Wrong, Please Contact The Devoloper...",
                    "DBMS_Connection Faild",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void loadPanel() {
        if (contentPanelLayout == null && cashierPanel.getLayout() instanceof CardLayout) {
            this.contentPanelLayout = (CardLayout) cashierPanel.getLayout();
        }

        this.cashierBills = new Bills();
        this.cashierBooks = new Books();
        this.cashierBookUpdate = new BookUpdate();
        this.cashierStocks = new Stocks();
        this.cashierStockUpdate = new StockUpdate();
        this.cashierCustomer = new Customer();
        this.cashierSetting = new Setting();

        this.cashierBills.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierBooks.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierBookUpdate.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierStocks.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierStockUpdate.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierCustomer.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.cashierSetting.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        this.cashierPanel.add(cashierBills, "bills_panel");
        this.cashierPanel.add(cashierBooks, "book_panel");
        this.cashierPanel.add(cashierBookUpdate, "bookUpdate_panel");
        this.cashierPanel.add(cashierStocks, "stock_panel");
        this.cashierPanel.add(cashierStockUpdate, "stockUpdate_panel");
        this.cashierPanel.add(cashierCustomer, "customer_panel");
        this.cashierPanel.add(cashierSetting, "setting_panel");

        SwingUtilities.updateComponentTreeUI(cashierPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cashierPanel = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        settingBtn = new javax.swing.JButton();
        billsBtn = new javax.swing.JButton();
        stocksbtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        customerbtn = new javax.swing.JButton();
        cashierName = new javax.swing.JLabel();
        ProfilePic = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        PageName = new javax.swing.JLabel();
        booksbtn = new javax.swing.JButton();
        bookUpsbtn = new javax.swing.JButton();
        stockUpsbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cashier Portal");

        mainpanel.setBackground(new java.awt.Color(37, 37, 37));
        mainpanel.setToolTipText("");

        cashierPanel.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(cashierPanel);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart/img/logo-favico-small.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BookSmart");

        settingBtn.setBackground(new java.awt.Color(35, 35, 35));
        settingBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        settingBtn.setForeground(new java.awt.Color(255, 255, 255));
        settingBtn.setText("   Settings.");
        settingBtn.setBorder(null);
        settingBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        settingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBtnActionPerformed(evt);
            }
        });

        billsBtn.setBackground(new java.awt.Color(35, 35, 35));
        billsBtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        billsBtn.setForeground(new java.awt.Color(255, 255, 255));
        billsBtn.setText("   Bills.");
        billsBtn.setBorder(null);
        billsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        billsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billsBtnActionPerformed(evt);
            }
        });

        stocksbtn.setBackground(new java.awt.Color(35, 35, 35));
        stocksbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stocksbtn.setForeground(new java.awt.Color(255, 255, 255));
        stocksbtn.setText("   Stocks.");
        stocksbtn.setBorder(null);
        stocksbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        stocksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksbtnActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        customerbtn.setBackground(new java.awt.Color(35, 35, 35));
        customerbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        customerbtn.setForeground(new java.awt.Color(255, 255, 255));
        customerbtn.setText("   Customers.");
        customerbtn.setBorder(null);
        customerbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        customerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerbtnActionPerformed(evt);
            }
        });

        cashierName.setFont(new java.awt.Font("STXihei", 0, 16)); // NOI18N
        cashierName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cashierName.setText("jLabel3");

        Email.setFont(new java.awt.Font("STXihei", 0, 12)); // NOI18N
        Email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Email.setText("jLabel5");

        PageName.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        PageName.setForeground(new java.awt.Color(255, 255, 255));
        PageName.setText("Cashier");

        booksbtn.setBackground(new java.awt.Color(35, 35, 35));
        booksbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        booksbtn.setForeground(new java.awt.Color(255, 255, 255));
        booksbtn.setText("   Books.");
        booksbtn.setBorder(null);
        booksbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        booksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksbtnActionPerformed(evt);
            }
        });

        bookUpsbtn.setBackground(new java.awt.Color(35, 35, 35));
        bookUpsbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        bookUpsbtn.setForeground(new java.awt.Color(255, 255, 255));
        bookUpsbtn.setText("   Book Update.");
        bookUpsbtn.setBorder(null);
        bookUpsbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bookUpsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookUpsbtnActionPerformed(evt);
            }
        });

        stockUpsbtn.setBackground(new java.awt.Color(35, 35, 35));
        stockUpsbtn.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        stockUpsbtn.setForeground(new java.awt.Color(255, 255, 255));
        stockUpsbtn.setText("   Stocks Update.");
        stockUpsbtn.setBorder(null);
        stockUpsbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        stockUpsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockUpsbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(PageName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(503, 503, 503)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cashierName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(billsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(customerbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stockUpsbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookUpsbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(booksbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(stocksbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(settingBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(PageName)))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProfilePic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                                .addComponent(cashierName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Email)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(billsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(booksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bookUpsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stocksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stockUpsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(settingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void settingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingBtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "setting_panel");
        PageName.setText("Setting");
    }//GEN-LAST:event_settingBtnActionPerformed

    private void stocksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksbtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "stock_panel");
        PageName.setText("Stocks");
    }//GEN-LAST:event_stocksbtnActionPerformed

    private void customerbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerbtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "customer_panel");
        PageName.setText("Customers");
    }//GEN-LAST:event_customerbtnActionPerformed

    private void billsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billsBtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "bills_panel");
        PageName.setText("Bills");
    }//GEN-LAST:event_billsBtnActionPerformed

    private void booksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksbtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "book_panel");
        PageName.setText("Books");
    }//GEN-LAST:event_booksbtnActionPerformed

    private void bookUpsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookUpsbtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "bookUpdate_panel");
        PageName.setText("Book Update");
    }//GEN-LAST:event_bookUpsbtnActionPerformed

    private void stockUpsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockUpsbtnActionPerformed
        this.contentPanelLayout.show(cashierPanel, "stockUpdate_panel");
        PageName.setText("Stock Update");
    }//GEN-LAST:event_stockUpsbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel PageName;
    private javax.swing.JLabel ProfilePic;
    private javax.swing.JButton billsBtn;
    private javax.swing.JButton bookUpsbtn;
    private javax.swing.JButton booksbtn;
    private javax.swing.JLabel cashierName;
    private javax.swing.JPanel cashierPanel;
    private javax.swing.JButton customerbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton settingBtn;
    private javax.swing.JButton stockUpsbtn;
    private javax.swing.JButton stocksbtn;
    // End of variables declaration//GEN-END:variables

}
