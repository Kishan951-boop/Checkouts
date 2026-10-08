/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package booksmart.home;

import booksmart.Admin.HomePage;
import booksmart.Validtions.Validator;
import booksmart.cashier.cashierPortal;
import booksmart.connection.connection;
import static booksmart.home.LoginScreen.loginScreen;
import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierLoginPage extends javax.swing.JFrame {

    public static CashierLoginPage CashierloginScreen;

    public CashierLoginPage() {
        initComponents();
        booksmart.home.appicon.AppIcon.applyIcon(this);
        LoginPassword.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true;");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LoginEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LoginPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart/img/logo-favicon.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 70));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 27)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WellCome Back");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 670, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 450, -1));

        LoginEmail.setBackground(new java.awt.Color(204, 204, 204));
        LoginEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginEmail.setForeground(new java.awt.Color(16, 15, 15));
        LoginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginEmailActionPerformed(evt);
            }
        });
        getContentPane().add(LoginEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 590, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 450, -1));

        LoginPassword.setBackground(new java.awt.Color(204, 204, 204));
        LoginPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginPassword.setForeground(new java.awt.Color(15, 14, 14));
        LoginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(LoginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 590, -1));

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(13, 13, 13));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 361, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(566, 20, 90, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart/img/post-item18.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginEmailActionPerformed

    private void LoginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginPasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String email = LoginEmail.getText().trim();
            String password = String.valueOf(this.LoginPassword.getPassword());

            if (!Validator.isEmailValid(email)) {
                return;
            }

            ResultSet rs = connection.Search("SELECT * FROM `cashier` WHERE `cashier`.`Email` = '" + email + "' AND `cashier`.`Password` = '" + password + "' ");

            if (rs.next()) {

                if (rs.getInt("C_Status") == 1) {

                    JOptionPane.showMessageDialog(null,
                            "Login Successfull...",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    int id = rs.getInt("Cashier_Id");

                    if (booksmart.cashier.cashierPortal.cashierPortal == null) {
                        booksmart.cashier.cashierPortal.cashierPortal = new cashierPortal(id);
                    }
                    booksmart.cashier.cashierPortal.cashierPortal.setVisible(true);

                    CashierloginScreen.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please Ccontact the Admin You Account has been postponed",
                            "Success",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "Please Check The creditions",
                        "Failed",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Oops Something Went Wrong...",
                    "Database Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (loginScreen == null) {
            loginScreen = new LoginScreen();

        }
        loginScreen.setVisible(true);
        CashierloginScreen.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CashierloginScreen = new CashierLoginPage();
                CashierloginScreen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LoginEmail;
    private javax.swing.JPasswordField LoginPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
