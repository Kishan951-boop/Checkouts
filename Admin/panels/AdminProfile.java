package booksmart.Admin.panels;

import static booksmart.Admin.HomePage.AdminID;
import static booksmart.Admin.HomePage.makeRoundedImage;
import booksmart.Validtions.Validator;
import static booksmart.cashier.frames.Books.fileName;
import booksmart.connection.connection;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdminProfile extends javax.swing.JPanel {

    private final HashMap<String, Integer> genderMap;
    public static String fileName;

    public AdminProfile() {
        this.genderMap = new HashMap<>();
        initComponents();
        datas();
        design();
    }

    private void datas() {

        try {
            ResultSet rs = connection.Search("SELECT * FROM `admin` "
                    + "INNER JOIN `address` ON `address`.`Address_ID` = `admin`.`Address` "
                    + "INNER JOIN `city` ON `address`.`City` = `city`.`City_ID` "
                    + "INNER JOIN  `gender` ON `admin`.`Gender` = `gender`.`gender_ID` WHERE `Admin_ID` = '" + AdminID + "'");

            if (rs.next()) {

                AdminPFName.setText(rs.getString("F_Name"));
                AdminPLName.setText(rs.getString("L_Name"));
                AdminPNIC.setText(rs.getString("NIC"));
                AdminPEMail.setText(rs.getString("Email"));
                AdminPMobile.setText(rs.getString("Mobile"));
                AdminPDOB.setText(rs.getString("DOB"));
                AdminPAddressNo.setText(rs.getString("NO"));
                AdminPSOne.setText(rs.getString("Street_1"));
                AdminPSTwo.setText(rs.getString("Street_2"));
                AdminPCity.setText(rs.getString("City_Name"));

                ResultSet genderrs = connection.Search("SELECT * FROM `gender`");
                Vector<String> Gender = new Vector();
                Gender.add(rs.getString("Gender_Name"));

                genderMap.put(rs.getString("Gender_Name"), rs.getInt("gender_ID"));

                while (genderrs.next()) {
                    String genderName = genderrs.getString("Gender_Name");
                    genderMap.put(genderName, genderrs.getInt("gender_ID"));
                    Gender.add(genderName);
                }

                DefaultComboBoxModel dcm = new DefaultComboBoxModel(Gender);
                AdminPGenderCombo.setModel(dcm);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void design() {

        try {
            ResultSet admin = connection.Search("SELECT * FROM `admin` WHERE `Admin_ID` = '" + AdminID + "'");

            if (admin.next()) {

                URL imgURL = getClass().getResource(admin.getString("Admin_IMG"));
                if (imgURL != null) {

                    ImageIcon icon = new ImageIcon(imgURL);
                    Image image = icon.getImage();
                    Image roundImage = makeRoundedImage(image);
                    Image scaledImage = roundImage.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
                    profileImage.setIcon(new ImageIcon(scaledImage));

                } else {
                    System.err.println("Image not found!");
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Oops something Went Wrong, Please Contact The Devoloper...",
                    "DBMS_Connection Faild",
                    JOptionPane.ERROR_MESSAGE);
        }

        jButton1.putClientProperty(FlatClientProperties.STYLE, "arc: 100");
        jButton1.setIcon(new FlatSVGIcon("booksmart/img/pen-solid.svg", 15, 15));
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

    private void showImage(File imageFile) {
        profileImgPanel.setPreferredSize(new Dimension(profileImage.getWidth(), profileImage.getHeight()));
        ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
        Image image = icon.getImage().getScaledInstance(profileImgPanel.getPreferredSize().width,
                profileImgPanel.getPreferredSize().height, Image.SCALE_SMOOTH);
        profileImage.setIcon(new ImageIcon(image));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AdminPFName = new javax.swing.JTextField();
        AdminPLName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AdminPNIC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AdminPEMail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        AdminPMobile = new javax.swing.JTextField();
        AdminPDOB = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        AdminPAddressNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        AdminPSOne = new javax.swing.JTextField();
        AdminPSTwo = new javax.swing.JTextField();
        AdminPCity = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        AdminPGenderCombo = new javax.swing.JComboBox<>();
        AdminPPassword = new javax.swing.JPasswordField();
        profileImgPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        profileImage = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("My Profile");

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > My Profile");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("First Name");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("NIC");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Email");

        AdminPEMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPEMailActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Birth Date");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Mobile");

        AdminPMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPMobileActionPerformed(evt);
            }
        });

        AdminPDOB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat(""))));
        AdminPDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPDOBActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Gender");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Address No");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Street One");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Street Two");

        AdminPSTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminPSTwoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("City");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Password");

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(11, 10, 10));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        AdminPGenderCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        profileImgPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        profileImgPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 40, 36));

        profileImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileImgPanel.add(profileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 240, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdminPNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdminPGenderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdminPSOne, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdminPCity, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AdminPFName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                                        .addComponent(AdminPAddressNo)
                                        .addComponent(AdminPLName)
                                        .addComponent(AdminPEMail)
                                        .addComponent(AdminPSTwo)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                                    .addComponent(AdminPPassword)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdminPMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AdminPDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profileImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addComponent(profileImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel11)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPEMail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPGenderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPAddressNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPSOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPSTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminPCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AdminPPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(306, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (.png)",
                "png");
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(profileImgPanel);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try {
                File imageFolder = new File("product_images");
                if (!imageFolder.exists()) {
                    imageFolder.mkdir();
                }
                fileName = System.currentTimeMillis() + ".png";
                File destinationFile = new File("C:\\Users\\kisha\\OneDrive\\Documents\\NetBeansProjects\\BookSmart\\src\\booksmart\\img\\people", fileName);
                Files.copy(selectedFile.toPath(),
                        destinationFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                showImage(destinationFile);
//                System.out.println(fileName);//made name
//                System.out.println(destinationFile + selectedFile.getName()); //absolute path

                String filepath = "/booksmart/img/people/" + fileName;

                connection.IUD("UPDATE `admin` SET `Admin_IMG` = '" + filepath + "' WHERE `Admin_ID` = '" + AdminID + "'");

                datas();
                design();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            System.out.println("update");

            String FirstName = AdminPFName.getText().trim();
            String LastName = AdminPLName.getText().trim();
            String Nic = AdminPNIC.getText().trim();
            String Email = AdminPEMail.getText().trim();
            String Mobile = AdminPMobile.getText().trim();
            String DOB = AdminPDOB.getText().trim();
            String AddressNo = AdminPAddressNo.getText().trim();
            String StreetOne = AdminPSOne.getText().trim();
            String StreeTwo = AdminPSTwo.getText().trim();
            String City = AdminPCity.getText().trim();

            String selectedGender = (String) AdminPGenderCombo.getSelectedItem();
            int GenderId = genderMap.get(selectedGender);
            String password = String.valueOf(this.AdminPPassword.getPassword());

            if (FirstName.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (LastName.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Nic.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Email.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Mobile.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (DOB.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (AddressNo.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (StreetOne.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (StreeTwo.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (City.isBlank()) {
                JOptionPane.showMessageDialog(null,
                        "Please Enter The First Name",
                        "Admin Profile",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!Validator.isEmailValid(Email)) {
                return;
            }

            if (!Validator.isPasswordValid(password)) {
                return;
            }

            connection.IUD("UPDATE `admin` SET `F_Name` = '" + FirstName + "' , `L_Name` = '" + LastName + "' ,"
                    + " `NIC` = '" + Nic + "' , `Email` = '" + Email + "' , `Mobile` = '" + Mobile + "' ,"
                    + " `DOB` = '" + DOB + "' , `Password` = '" + password + "' , `Gender` = '" + GenderId + "' WHERE `Admin_ID` = '" + AdminID + "'");

            int CityId;

            ResultSet rs = connection.Search("SELECT * FROM `city` WHERE `City_Name` = '" + City + "' ");

            if (rs.next()) {
                CityId = rs.getInt("City_ID");
            } else {

                connection.IUD("INSERT INTO `city`(`City_Name`) VALUES ('" + City + "')");
                ResultSet rs2 = connection.Search("SELECT * FROM `city` WHERE `City_Name` = '" + City + "' ");
                CityId = rs2.getInt("City_ID");

            }

            connection.IUD("UPDATE `address` SET `NO` = '" + AddressNo + "' , `Street_1` = '" + StreetOne + "' , `Street_2` = '" + StreeTwo + "' , `City` = '" + CityId + "'");

            JOptionPane.showMessageDialog(null,
                    "Profile Update Successfull",
                    "Admin Profile",
                    JOptionPane.INFORMATION_MESSAGE);

            datas();
            design();
            AdminPPassword.setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact One who Devoloped this sh*t",
                    "Admin Profile",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void AdminPSTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPSTwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPSTwoActionPerformed

    private void AdminPEMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPEMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPEMailActionPerformed

    private void AdminPDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPDOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPDOBActionPerformed

    private void AdminPMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminPMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPMobileActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        datas();
        AdminPPassword.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdminPAddressNo;
    private javax.swing.JTextField AdminPCity;
    private javax.swing.JFormattedTextField AdminPDOB;
    private javax.swing.JTextField AdminPEMail;
    private javax.swing.JTextField AdminPFName;
    private javax.swing.JComboBox<String> AdminPGenderCombo;
    private javax.swing.JTextField AdminPLName;
    private javax.swing.JTextField AdminPMobile;
    private javax.swing.JTextField AdminPNIC;
    private javax.swing.JPasswordField AdminPPassword;
    private javax.swing.JTextField AdminPSOne;
    private javax.swing.JTextField AdminPSTwo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel profileImage;
    private javax.swing.JPanel profileImgPanel;
    // End of variables declaration//GEN-END:variables
}
