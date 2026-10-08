/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package booksmart.home;

import com.formdev.flatlaf.FlatDarculaLaf;

/**
 *
 * @author kisha
 */
public class SplashScreen extends javax.swing.JFrame {

    public static SplashScreen splashScreen;

    public SplashScreen() {
        initComponents();
        init();
        loadingAnimation();
    }

    private void init() {
        booksmart.home.appicon.AppIcon.applyIcon(this);
    }

    private void loadingAnimation() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    jProgressBar1.setValue(i);
                    if (i < 30) {
                        loadingLabel.setText("Starting modules: " + i + "%");
                    } else if (i > 30 && i < 50) {
                        loadingLabel.setText("Database connection established...: " + i + "%");
                    } else if (i > 80) {
                        loadingLabel.setText("Done...: " + i + "%");
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {

                    }
                }
                if (booksmart.home.CashierLoginPage.CashierloginScreen == null) {
                    booksmart.home.CashierLoginPage.CashierloginScreen = new CashierLoginPage();
                }
                booksmart.home.CashierLoginPage.CashierloginScreen.setVisible(true);
                
                splashScreen.dispose();
            }
        });

        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        loadingLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Splash Screen");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BookSmart");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 660, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart/img/logo-favicon.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 110, 70));

        jLabel4.setFont(new java.awt.Font("Bauhaus 93", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("To");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 660, -1));

        jLabel5.setFont(new java.awt.Font("STXihei", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Well Come");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 660, 50));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 670, 10));

        loadingLabel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        loadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        loadingLabel.setText("Loading...........");
        getContentPane().add(loadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 560, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/booksmart/img/post-item18.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatDarculaLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (splashScreen == null) {
                    splashScreen = new SplashScreen();
                }
                splashScreen.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel loadingLabel;
    // End of variables declaration//GEN-END:variables
}
