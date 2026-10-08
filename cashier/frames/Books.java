package booksmart.cashier.frames;

import booksmart.cashier.cashierPortal;
import booksmart.connection.connection;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Books extends javax.swing.JPanel {

    private final HashMap<String, Integer> categoryMap;
    private final HashMap<String, Integer> ageMap;
    public static int languageId;
    public static int AuthorId;
    public static String fileName;

    public Books() {
        this.categoryMap = new HashMap<>();
        this.ageMap = new HashMap<>();
        initComponents();
        loadCategory();
        loadAges();
    }

    private void loadCategory() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `category`");
            Vector<String> Category = new Vector();
            Category.add("Select Category");
            categoryMap.put("Select Category", 0);
            while (rs.next()) {
                String CategoryName = rs.getString("Category_Name");
                categoryMap.put(CategoryName, rs.getInt("Category_ID"));
                Category.add(CategoryName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Category);
            categoryComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void loadAges() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `recomend_age`");
            Vector<String> ages = new Vector();
            ages.add("Select Age");
            ageMap.put("Select Age", 0);
            while (rs.next()) {
                String AgeName = rs.getString("Age");
                ageMap.put(AgeName, rs.getInt("R_Age_ID"));
                ages.add(AgeName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(ages);
            AgeComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PublishDate = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        PaperCount = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        categoryComboBox = new javax.swing.JComboBox<>();
        AgeComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        prImagePathInput = new javax.swing.JTextField();
        productImgPanel = new javax.swing.JPanel();
        productImage = new javax.swing.JLabel();
        Language = new javax.swing.JTextField();
        Author = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel2.setText("Book Name :");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel3.setText("Publish Date :");

        PublishDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel4.setText("Paper Count :");

        PaperCount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel5.setText("Category :");

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel6.setText("Recomend Age :");

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel7.setText("Author");

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel8.setText("Language :");

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 13)); // NOI18N
        jLabel9.setText("Description");

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        AgeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(15, 15, 15));
        jButton1.setText("Browser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(19, 19, 19));
        jButton3.setText("Add Book");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        prImagePathInput.setEditable(false);

        javax.swing.GroupLayout productImgPanelLayout = new javax.swing.GroupLayout(productImgPanel);
        productImgPanel.setLayout(productImgPanelLayout);
        productImgPanelLayout.setHorizontalGroup(
            productImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productImgPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(productImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        productImgPanelLayout.setVerticalGroup(
            productImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productImgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prImagePathInput)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BookName)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addGap(54, 54, 54))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(categoryComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(PaperCount, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Language))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PublishDate)
                                    .addComponent(AgeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(Author))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PaperCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productImgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(prImagePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String selectedCategoryName = (String) categoryComboBox.getSelectedItem();
        int CategoryId = categoryMap.get(selectedCategoryName);
        String selectedAgeName = (String) AgeComboBox.getSelectedItem();
        int AgeLevelId = ageMap.get(selectedAgeName);

        String Name = BookName.getText().trim();
        String paperCount = PaperCount.getText().trim();
        String publishDate = PublishDate.getText().trim();
        String language = Language.getText().trim();
        String author = Author.getText().trim();
        String description = Description.getText().trim();
        String imagePath = prImagePathInput.getText().trim();

        if (CategoryId == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Book Category",
                    "Subject",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (AgeLevelId == 0) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Bokk Recomending Age",
                    "Teacher",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Name.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Book Name",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (paperCount.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Paper Count",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (publishDate.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Publish Date",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (language.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Book Wrote Language",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (author.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Enter The Author Name",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (imagePath.isBlank()) {
            JOptionPane.showMessageDialog(null,
                    "Please Select The Image",
                    "Book",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {

            ResultSet getLanguage = connection.Search("SELECT * FROM `language` WHERE `Language_Name` = '" + language + "' ");

            if (getLanguage.next()) {
                languageId = getLanguage.getInt("Language_ID");
            } else {
                connection.IUD("INSERT INTO `language` (`Language_Name`) VALUES ('" + language + "') ");

                ResultSet getLanguageId = connection.Search("SELECT * FROM `language` WHERE `Language_Name` = '" + language + "' ");

                if (getLanguageId.next()) {
                    languageId = getLanguageId.getInt("Language_ID");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Oops.. Something went Wrong Please try Again later.",
                            "DBMS error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

            ResultSet getAuthor = connection.Search("SELECT * FROM `author` WHERE `Author_Name` = '" + author + "' ");

            if (getAuthor.next()) {
                AuthorId = getAuthor.getInt("Author_id");
            } else {
                connection.IUD("INSERT INTO `author` (`Author_Name`) VALUES ('" + author + "') ");

                ResultSet getAuthorId = connection.Search("SELECT * FROM `author` WHERE `Author_Name` = '" + author + "' ");

                if (getAuthorId.next()) {
                    AuthorId = getAuthorId.getInt("Author_id");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Oops.. Something went Wrong Please try Again later.",
                            "DBMS error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

            String filepath = "/booksmart/img/books/" + fileName;

            ResultSet isBookExist = connection.Search("SELECT * FROM `books` WHERE `Book_Name` = '" + Name + "' AND `Paper_Count` = '" + paperCount + "' AND `Category_Category_ID` = '" + CategoryId + "'"
                    + "AND `Language_Language_ID` = '" + languageId + "' AND `Author_Author_id` = '" + AuthorId + "' AND `Recomend_Age_R_Age_ID` = '" + AgeLevelId + "'");

            if (isBookExist.next()) {

                JOptionPane.showMessageDialog(null,
                        "The Book is Alredy Exists",
                        "Book Added",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {

                connection.IUD("INSERT INTO `books` (`Book_Name`,`Paper_Count`,`Publish_Date`,`Book_Description`,`Book_img`,`Category_Category_ID`,`Language_Language_ID`,`Author_Author_id`,`Recomend_Age_R_Age_ID`)"
                        + " VALUES ('" + Name + "','" + paperCount + "','" + publishDate + "','" + description + "','" + filepath + "','" + CategoryId + "','" + languageId + "','" + AuthorId + "','" + AgeLevelId + "')");

                JOptionPane.showMessageDialog(null,
                        "Book Added Successfull",
                        "Book Added",
                        JOptionPane.INFORMATION_MESSAGE);

                empty();

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please contact the devoloper",
                    "DBMS error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

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
                prImagePathInput.setText(destinationFile.getAbsolutePath());
                Files.copy(selectedFile.toPath(),
                        destinationFile.toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
                showImage(destinationFile);
//                System.out.println(fileName);//made name
                System.out.println(destinationFile + selectedFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        empty();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showImage(File imageFile) {
        productImgPanel.setPreferredSize(new Dimension(productImage.getWidth(), productImage.getHeight()));
        ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
        Image image = icon.getImage().getScaledInstance(productImgPanel.getPreferredSize().width,
                productImgPanel.getPreferredSize().height, Image.SCALE_SMOOTH);
        productImgPanel.setPreferredSize(new Dimension(200, 300));
        productImgPanel.setMaximumSize(new Dimension(200, 300));
        productImgPanel.setMinimumSize(new Dimension(200, 300));
        productImage.setIcon(new ImageIcon(image));

    }

    private void empty() {
        BookName.setText("");
        PaperCount.setText("");
        PublishDate.setText("");
        Language.setText("");
        Author.setText("");
        Description.setText("");
    }

    private void fileMove(String path) {
        Path sourcePath = Paths.get(path); // Source file path
        Path targetPath = Paths.get("C:\\target_folder\\file.txt"); // Destination path

        try {
            // Standard move (throws exception if file exists)
            Files.move(sourcePath, targetPath);

            // To overwrite if the file already exists:
            // Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully!");
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
    }

    public String getPrImagePathInput() {
        return fileName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgeComboBox;
    private javax.swing.JTextField Author;
    private javax.swing.JTextField BookName;
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField Language;
    private javax.swing.JFormattedTextField PaperCount;
    private javax.swing.JFormattedTextField PublishDate;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prImagePathInput;
    private javax.swing.JLabel productImage;
    private javax.swing.JPanel productImgPanel;
    // End of variables declaration//GEN-END:variables
}
