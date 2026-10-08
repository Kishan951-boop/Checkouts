package booksmart.Admin;

import booksmart.Admin.panels.AddAdmin;
import booksmart.Admin.panels.AdminDashBoard;
import booksmart.Admin.panels.AdminManagment;
import booksmart.Admin.panels.AdminProfile;
import booksmart.Admin.panels.StocksManagment;
import booksmart.Admin.panels.BookManagment;
import booksmart.Admin.panels.purchaseHistory;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingUtilities;

public class HomePage extends javax.swing.JFrame {

    public static int AdminID;
    private AdminDashBoard adminDashBoard;
    private AdminProfile adminProfile;
    private AddAdmin addAdmin;
    private AdminManagment adminManagment;
    private StocksManagment stockManagment;
    private BookManagment bookManagment;
    private purchaseHistory purchasehistory;
    private CardLayout contentPanelLayout;

    public HomePage(int id) {

        AdminID = id;
        initComponents();
        booksmart.home.appicon.AppIcon.applyIcon(this);
        init();
        loadPanel();
        design();
        jScrollPane1.setSize(600, 400);

    }

    private void design() {

        NavBar.putClientProperty(FlatClientProperties.STYLE, "arc: 60");
        SideBar.putClientProperty(FlatClientProperties.STYLE, "arc: 40");
        SideBarSecond.putClientProperty(FlatClientProperties.STYLE, "arc: 40");
        jButton1.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        jButton2.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        jButton3.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        jButton4.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        jButton5.putClientProperty(FlatClientProperties.STYLE, "arc: 10");
        jButton6.putClientProperty(FlatClientProperties.STYLE, "arc: 10");

        jButton1.setIcon(new FlatSVGIcon("booksmart/img/circle-user-solid.svg", 15, 15));
        jButton2.setIcon(new FlatSVGIcon("booksmart/img/user-plus-solid.svg", 15, 15));
        jButton3.setIcon(new FlatSVGIcon("booksmart/img/user-tie-solid.svg", 15, 15));
        jButton4.setIcon(new FlatSVGIcon("booksmart/img/book-open-solid.svg", 15, 15));
        jButton5.setIcon(new FlatSVGIcon("booksmart/img/boxes-stacked-solid.svg", 15, 15));
        jButton6.setIcon(new FlatSVGIcon("booksmart/img/money-bills-solid.svg", 15, 15));

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

    private void init() {

        try {
            ResultSet admin = connection.Search("SELECT * FROM `admin` WHERE `Admin_ID` = '" + AdminID + "'");

            if (admin.next()) {

                URL imgURL = getClass().getResource(admin.getString("Admin_IMG"));
                if (imgURL != null) {

                    ImageIcon icon = new ImageIcon(imgURL);
                    Image image = icon.getImage();
                    Image roundImage = makeRoundedImage(image);
                    Image scaledImage = roundImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    profilePic.setIcon(new ImageIcon(scaledImage));

                } else {
                    System.err.println("Image not found!");
                }

                String gender;

                if (admin.getInt("Gender") == 1) {
                    gender = "Mr. ";
                } else {
                    gender = "Ms. ";
                }

                AdminName.setText("BookSmart | Admin |" + gender + admin.getString("F_Name") + " " + admin.getString("L_Name"));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Oops something Went Wrong, Please Contact The Devoloper...",
                    "DBMS_Connection Faild",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void loadPanel() {
        if (contentPanelLayout == null && adminPanels.getLayout() instanceof CardLayout) {
            this.contentPanelLayout = (CardLayout) adminPanels.getLayout();
        }

        this.adminDashBoard = new AdminDashBoard();
        this.adminProfile = new AdminProfile();
        this.addAdmin = new AddAdmin();
        this.adminManagment = new AdminManagment();
        this.stockManagment = new StocksManagment();
        this.bookManagment = new BookManagment();
        this.purchasehistory = new purchaseHistory();

        this.adminDashBoard.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.adminProfile.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.addAdmin.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.adminManagment.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.stockManagment.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.bookManagment.putClientProperty(FlatClientProperties.STYLE, "arc:20");
        this.purchasehistory.putClientProperty(FlatClientProperties.STYLE, "arc:20");

        this.adminPanels.add(adminDashBoard, "adminDashBoard_panel");
        this.adminPanels.add(adminProfile, "adminProfile_panel");
        this.adminPanels.add(addAdmin, "adminAddAdmin_panel");
        this.adminPanels.add(adminManagment, "adminAdminManagment_panel");
        this.adminPanels.add(stockManagment, "adminStockManagment_panel");
        this.adminPanels.add(bookManagment, "adminBookManagment_panel");
        this.adminPanels.add(purchasehistory, "purchaseHistory_panel");

        SwingUtilities.updateComponentTreeUI(adminPanels);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JButton();
        SideBarSecond = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        NavBar = new javax.swing.JPanel();
        profilePic = new javax.swing.JLabel();
        AdminName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminPanels = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Portal");

        jPanel3.setBackground(new java.awt.Color(52, 52, 52));

        SideBar.setBackground(new java.awt.Color(43, 43, 43));
        SideBar.setForeground(new java.awt.Color(8, 8, 8));

        dashboardBtn.setBackground(new java.awt.Color(34, 34, 34));
        dashboardBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dashboardBtn.setForeground(new java.awt.Color(239, 239, 239));
        dashboardBtn.setText("     DashBoard");
        dashboardBtn.setBorder(null);
        dashboardBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnActionPerformed(evt);
            }
        });

        SideBarSecond.setBackground(new java.awt.Color(51, 51, 51));
        SideBarSecond.setForeground(new java.awt.Color(51, 51, 51));

        jButton1.setBackground(new java.awt.Color(34, 34, 34));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(237, 237, 237));
        jButton1.setText("My Profile.");
        jButton1.setBorder(null);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(34, 34, 34));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(237, 237, 237));
        jButton2.setText("Add Workers.");
        jButton2.setBorder(null);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(34, 34, 34));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(237, 237, 237));
        jButton3.setText("Admin Managment.");
        jButton3.setBorder(null);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(34, 34, 34));
        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(237, 237, 237));
        jButton4.setText("Book Managment.");
        jButton4.setBorder(null);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(34, 34, 34));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(237, 237, 237));
        jButton5.setText("Stock Managment.");
        jButton5.setBorder(null);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(34, 34, 34));
        jButton6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton6.setForeground(new java.awt.Color(237, 237, 237));
        jButton6.setText("Purchase History.");
        jButton6.setBorder(null);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SideBarSecondLayout = new javax.swing.GroupLayout(SideBarSecond);
        SideBarSecond.setLayout(SideBarSecondLayout);
        SideBarSecondLayout.setHorizontalGroup(
            SideBarSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarSecondLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(SideBarSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SideBarSecondLayout.createSequentialGroup()
                        .addGroup(SideBarSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addGroup(SideBarSecondLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        SideBarSecondLayout.setVerticalGroup(
            SideBarSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarSecondLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SideBarLayout = new javax.swing.GroupLayout(SideBar);
        SideBar.setLayout(SideBarLayout);
        SideBarLayout.setHorizontalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SideBarSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SideBarLayout.setVerticalGroup(
            SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideBarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SideBarSecond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        NavBar.setBackground(new java.awt.Color(34, 34, 34));
        NavBar.setForeground(new java.awt.Color(255, 255, 255));

        profilePic.setBackground(new java.awt.Color(255, 255, 255));

        AdminName.setBackground(new java.awt.Color(128, 128, 128));
        AdminName.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        AdminName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminName.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BookSmart");

        javax.swing.GroupLayout NavBarLayout = new javax.swing.GroupLayout(NavBar);
        NavBar.setLayout(NavBarLayout);
        NavBarLayout.setHorizontalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addComponent(AdminName, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        NavBarLayout.setVerticalGroup(
            NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NavBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setMaximumSize(new java.awt.Dimension(2000, 2000));

        adminPanels.setBackground(new java.awt.Color(153, 153, 153));
        adminPanels.setAutoscrolls(true);
        adminPanels.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        adminPanels.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(adminPanels);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminAddAdmin_panel");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminProfile_panel");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminAdminManagment_panel");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminDashBoard_panel");
    }//GEN-LAST:event_dashboardBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminBookManagment_panel");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.contentPanelLayout.show(adminPanels, "adminStockManagment_panel");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.contentPanelLayout.show(adminPanels, "purchaseHistory_panel");
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminName;
    private javax.swing.JPanel NavBar;
    private javax.swing.JPanel SideBar;
    private javax.swing.JPanel SideBarSecond;
    private javax.swing.JPanel adminPanels;
    private javax.swing.JButton dashboardBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel profilePic;
    // End of variables declaration//GEN-END:variables
}
