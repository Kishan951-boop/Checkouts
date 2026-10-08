package booksmart.Admin.panels;

import static booksmart.Admin.panels.AdminProfile.fileName;
import booksmart.Validtions.Validator;
import static booksmart.cashier.frames.Books.fileName;
import booksmart.connection.connection;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddAdmin extends javax.swing.JPanel {

    private final HashMap<String, Integer> GenderMap;
    public static String fileName;

    public AddAdmin() {
        this.GenderMap = new HashMap<>();
        initComponents();
        loadGender();
    }

    private void loadGender() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `gender`");
            Vector<String> genders = new Vector();
            genders.add("Select Gender");
            GenderMap.put("Select Gender", 0);
            while (rs.next()) {
                String GenderName = rs.getString("Gender_Name");
                GenderMap.put(GenderName, rs.getInt("gender_ID"));
                genders.add(GenderName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(genders);
            GenderComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void showImage(File imageFile) {
        productImgPanel.setPreferredSize(new Dimension(productImage.getWidth(), productImage.getHeight()));
        ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
        Image image = icon.getImage().getScaledInstance(productImgPanel.getPreferredSize().width,
                productImgPanel.getPreferredSize().height, Image.SCALE_SMOOTH);
        productImage.setIcon(new ImageIcon(image));

    }

    private void empty() {
        F_Name.setText("");
        L_Name.setText("");
        Email.setText("");
        Mobile.setText("");
        NIC.setText("");
        DOB.setText("");
        Address_No.setText("");
        Street_One.setText("");
        Street_Two.setText("");
        City.setText("");
        Password.setText("");
        ImagePathInput.setText("");
        loadGender();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productImgPanel = new javax.swing.JPanel();
        productImage = new javax.swing.JLabel();
        ImagePathInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Mobile = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        NIC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        DOB = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Address_No = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Street_One = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Street_Two = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        City = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        GenderComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        L_Name = new javax.swing.JTextField();
        F_Name = new javax.swing.JTextField();

        jLabel4.setFont(new java.awt.Font("Candara Light", 0, 14)); // NOI18N
        jLabel4.setText("Admin > Add Admin");

        jLabel3.setFont(new java.awt.Font("Candara Light", 0, 20)); // NOI18N
        jLabel3.setText("Add Worker");

        ImagePathInput.setEditable(false);
        ImagePathInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagePathInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productImgPanelLayout = new javax.swing.GroupLayout(productImgPanel);
        productImgPanel.setLayout(productImgPanelLayout);
        productImgPanelLayout.setHorizontalGroup(
            productImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        productImgPanelLayout.setVerticalGroup(
            productImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImgPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ImagePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(8, 8, 8));
        jButton1.setText("Browse.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("last Name");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Email");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Mobile");

        try {
            Mobile.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("NIC");

        NIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NICActionPerformed(evt);
            }
        });
        NIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NICKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Birth Date");

        DOB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Adress Details.");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("No :");

        Address_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Address_NoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Street One :");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Street Two :");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("City :");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(248, 242, 242));
        jButton2.setText("Cancel.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("STXihei", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(11, 10, 10));
        jButton3.setText("Add A Worker");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Gender");

        Password.setEditable(false);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Password :");

        GenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("First Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Street_Two)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(GenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Address_No, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Street_One, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(F_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Email)
                                        .addComponent(NIC)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                                .addComponent(L_Name, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Mobile)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Address_No, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Street_One, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Street_Two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(796, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (.png)",
                "png");
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(productImgPanel);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try {
                File imageFolder = new File("product_images");
                if (!imageFolder.exists()) {
                    imageFolder.mkdir();
                }
                fileName = System.currentTimeMillis() + ".png";
                File destinationFile = new File("C:\\Users\\kisha\\OneDrive\\Documents\\NetBeansProjects\\BookSmart\\src\\booksmart\\img\\books", fileName);
                ImagePathInput.setText(destinationFile.getAbsolutePath());
                Files.copy(selectedFile.toPath(),
                        destinationFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                showImage(destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        empty();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String Fname = F_Name.getText().trim();
        String Lname = L_Name.getText().trim();
        String EMail = Email.getText().trim();
        String Nic = NIC.getText().trim();
        String MobileNumber = Mobile.getText().trim();
        String Dob = DOB.getText().trim();
        String AdNo = Address_No.getText().trim();
        String SOne = Street_One.getText().trim();
        String STwo = Street_Two.getText().trim();
        String CityName = City.getText().trim();
        String Pw = Password.getText().trim();
        String ImagePath = ImagePathInput.getText().trim();

        String selectedGender = (String) GenderComboBox.getSelectedItem();
        int GenderId = GenderMap.get(selectedGender);

        if (Fname.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The First Name",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Lname.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Last Name",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Validator.isEmailValid(EMail)) {
            return;
        }
        if (Nic.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The National Idetification Number",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (MobileNumber.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Mobile Number",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Dob.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Birth Date",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (AdNo.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Addreess No",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (SOne.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Street",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (STwo.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Street",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (CityName.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The City",
                    "Admin Profile",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (ImagePath.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Worker Picture",
                    "Add Workers",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (GenderId == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Gender",
                    "Admin Profile",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            ResultSet rs = connection.Search("SELECT * FROM `city` WHERE `City_Name` = '" + CityName + "' ");

            int CityId;

            if (rs.next()) {
                CityId = rs.getInt("City_ID");
            } else {

                connection.IUD("INSERT INTO `city` (`City_Name`) VALUES ('" + CityName + "')");

                ResultSet rs2 = connection.Search("SELECT * FROM `city` WHERE `City_Name` = '" + CityName + "' ");

                if (!rs2.next()) {
                    JOptionPane.showMessageDialog(null,
                            "Please Contact One who Devoloped this sh*t",
                            "Admin Profile",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    CityId = rs2.getInt("City_ID");
                }

                connection.IUD("INSERT INTO `address`(`NO`,`Street_1`,`Street_2`,`City`) VALUES ('" + AdNo + "','" + SOne + "','" + STwo + "','" + CityId + "')");
                ResultSet rs3 = connection.Search("SELECT * FROM `address` WHERE `NO` = '" + AdNo + "' AND `Street_1` = '" + SOne + "' AND `Street_2` = '" + STwo + "' AND `City` = '" + CityId + "'");

                int AddressId;

                if (!rs3.next()) {
                    JOptionPane.showMessageDialog(null,
                            "Please Contact One who Devoloped this sh*t",
                            "Admin Profile",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    AddressId = rs3.getInt("Address_ID");
                }

                String filepath = "/booksmart/img/people/" + fileName;

                connection.IUD("INSERT INTO `cashier` (`Fname`,`Lname`,`Nic`,`Email`,`Mobile`,`DOB`,`Profile_Img`,`Password`,`C_Address`,`C_Status`,`C_Gender`) "
                        + "VALUES ('" + Fname + "','" + Lname + "','" + Nic + "','" + EMail + "','" + MobileNumber + "','" + Dob + "','" + filepath + "','" + Pw + "','" + AddressId + "','1','" + GenderId + "')");

                JOptionPane.showMessageDialog(null,
                        "Worker Added Successfull!",
                        "Admin Profile",
                        JOptionPane.INFORMATION_MESSAGE);

                empty();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please Contact One who Devoloped this sh*t",
                    "Admin Profile",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AddAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void NICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NICKeyPressed
        String Fname = F_Name.getText().trim();
        String Nic = NIC.getText().trim();

        Password.setText(Fname + "@" + Nic);

    }//GEN-LAST:event_NICKeyPressed

    private void NICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NICActionPerformed

    private void Address_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Address_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Address_NoActionPerformed

    private void ImagePathInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagePathInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImagePathInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address_No;
    private javax.swing.JTextField City;
    private javax.swing.JFormattedTextField DOB;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField F_Name;
    private javax.swing.JComboBox<String> GenderComboBox;
    private javax.swing.JTextField ImagePathInput;
    private javax.swing.JTextField L_Name;
    private javax.swing.JFormattedTextField Mobile;
    private javax.swing.JTextField NIC;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Street_One;
    private javax.swing.JTextField Street_Two;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel productImage;
    private javax.swing.JPanel productImgPanel;
    // End of variables declaration//GEN-END:variables
}
