/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package booksmart.cashier.frames;

import booksmart.connection.connection;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BookUpdate extends javax.swing.JPanel {

    private final HashMap<String, Integer> bookMap;
    private final HashMap<String, Integer> categoryMap;
    private final HashMap<String, Integer> ageMap;

    public static String CategoryName = "Select Category";
    public static int CategoryId = 0;
    public static String ageName = "Select Age";
    public static int ageId = 0;

    public static String fileName;
    public static int languageId;
    public static int AuthorId;
    public static String BookImagePath;

    public BookUpdate() {
        this.bookMap = new HashMap<>();
        this.categoryMap = new HashMap<>();
        this.ageMap = new HashMap<>();
        initComponents();
        loadBooks();
        loadCategory();
        loadAges();
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

    private void loadCategory() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `category`");
            Vector<String> Category = new Vector();
            Category.add(CategoryName);
            categoryMap.put(CategoryName, CategoryId);
            while (rs.next()) {
                String CategoryName = rs.getString("Category_Name");
                categoryMap.put(CategoryName, rs.getInt("Category_ID"));
                Category.add(CategoryName);
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(Category);
            CategoryComboBox.setModel(dcm);

        } catch (Exception e) {
        }
    }

    private void loadAges() {
        try {
            ResultSet rs = connection.Search("SELECT * FROM `recomend_age`");
            Vector<String> ages = new Vector();
            ages.add(ageName);
            ageMap.put(ageName, ageId);
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

    private void empty() {
        loadCategory();
        loadBooks();
        loadAges();
        BookName.setText("");
        Author.setText("");
        Language.setText("");
        PaperCount.setText("");
        PublishDate.setText("");
        prImagePathInput.setText("");
        Description.setText("");

    }

    private void BookDetailsLoad() {
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

//        System.out.println(BookId);
        if (BookId != 0) {

            ResultSet rs;
            try {

                rs = connection.Search("SELECT * FROM `books` INNER JOIN `category` ON `books`.`Category_Category_ID` = `category`.`Category_ID` "
                        + "INNER JOIN `author` ON `books`.`Author_Author_id` = `author`.`Author_id`"
                        + "INNER JOIN `language` ON `books`.`Language_Language_ID` = `language`.`Language_ID` "
                        + "INNER JOIN `recomend_age` ON `books`.`Recomend_Age_R_Age_ID` = `recomend_age`.`R_Age_ID` WHERE `Book_id` = '" + BookId + "'");

                if (rs.next()) {

                    BookName.setText(rs.getString("Book_Name"));

                    CategoryName = rs.getString("Category_Name");
                    CategoryId = rs.getInt("Category_ID");

                    Language.setText(rs.getString("Language_Name"));
                    Author.setText(rs.getString("Author_Name"));
                    PaperCount.setText(rs.getString("Paper_Count"));
                    PublishDate.setText(rs.getString("Publish_Date"));
                    Description.setText(rs.getString("Book_Description"));
                    BookImagePath = rs.getString("Book_img");

                    ageName = rs.getString("Age");
                    ageId = rs.getInt("R_Age_ID");

//                    String image = rs.getString("Book_img");
                    System.out.println(BookImagePath);
//
//                    URL imageUrl = LoadImage.class.getResource(BookImagePath);
//
//                    if (imageUrl == null) {
//                        System.err.println("Error: Image not found at '" + BookImagePath + "'");
//                        System.err.println("Tip: Use absolute paths (e.g., '/images/logo.png')");
//                        return;
//                    }

                    ImageIcon icon = new ImageIcon(getClass().getResource(BookImagePath));

                    Image scaledImage = icon.getImage()
                            .getScaledInstance(
                                    ShowBookIMG.getWidth(), // Use JLabel's width
                                    ShowBookIMG.getHeight(), // Use JLabel's height
                                    Image.SCALE_SMOOTH
                            );
                    ShowBookIMG.setIcon(new ImageIcon(scaledImage));

                    loadCategory();
                    loadAges();

                } else {
                    System.out.println("Something went wrong😭");
                }

            } catch (SQLException ex) {
            }

        }
    }

    private void showImage(File imageFile) {

        ImageIcon icon = new ImageIcon(imageFile.getAbsolutePath());
        Image scaledImage = icon.getImage()
                .getScaledInstance(
                        ShowBookIMG.getWidth(),
                        ShowBookIMG.getHeight(),
                        Image.SCALE_SMOOTH
                );
        ShowBookIMG.setIcon(new ImageIcon(scaledImage));

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        BookComboBox = new javax.swing.JComboBox<>();
        ShowBookIMG = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CategoryComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        AgeComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Language = new javax.swing.JTextField();
        Author = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PaperCount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        PublishDate = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        prImagePathInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Select Book");

        BookComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        BookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Book Name :");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Category");

        CategoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Age");

        AgeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Language");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Author");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Paper Count");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Publish date");

        PublishDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(6, 6, 6));
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        prImagePathInput.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Book Description");

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

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
        jButton3.setText("Update Book");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BookComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(121, 121, 121))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ShowBookIMG, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(prImagePathInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Author))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AgeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Language)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(PaperCount)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addComponent(PublishDate)))
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowBookIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prImagePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PaperCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookComboBoxActionPerformed
        BookDetailsLoad();
    }//GEN-LAST:event_BookComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        empty();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String selectedCategoryName = (String) CategoryComboBox.getSelectedItem();
        int CategoryID = categoryMap.get(selectedCategoryName);
        String selectedAgeName = (String) AgeComboBox.getSelectedItem();
        int AgeLevelId = ageMap.get(selectedAgeName);
        String selectedBookName = (String) BookComboBox.getSelectedItem();
        int BookId = bookMap.get(selectedBookName);

        String Name = BookName.getText().trim();
        String paperCount = PaperCount.getText().trim();
        String publishDate = PublishDate.getText().trim();
        String language = Language.getText().trim();
        String author = Author.getText().trim();
        String description = Description.getText().trim();
        String imagePath = prImagePathInput.getText().trim();

        if (CategoryID == 0) {
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

            File delimageFile = new File("C:/Users/kisha/OneDrive/Documents/NetBeansProjects/BookSmart/src" + BookImagePath);

            if (delimageFile.exists()) {
                if (delimageFile.delete()) {
                    System.out.println("Image file deleted successfully.");
                } else {
                    System.out.println("Failed to delete the image file.");
                }
            } else {
                System.out.println("Image file does not exist at the specified path.");
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

            connection.IUD("UPDATE `books` SET `Book_Name` = '" + Name + "' ,`Paper_Count` = '" + paperCount + "' ,`Publish_Date` = '" + publishDate + "' ,"
                    + "`Book_Description` = '" + description + "' ,`Book_img` = '" + filepath + "' ,`Category_Category_ID` = '" + CategoryID + "' ,"
                    + "`Language_Language_ID` = '" + languageId + "'  ,`Author_Author_id` = '" + AuthorId + "'  ,`Recomend_Age_R_Age_ID` = '" + AgeLevelId + "' WHERE `Book_id` = '" + BookId + "' ");

            JOptionPane.showMessageDialog(null,
                    "Book Updated Successfull",
                    "Book Added",
                    JOptionPane.INFORMATION_MESSAGE);

            empty();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Please contact the devoloper",
                    "DBMS error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (.png)",
                "png");
        chooser.setFileFilter(filter);
        int option = chooser.showOpenDialog(ShowBookIMG);
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgeComboBox;
    private javax.swing.JTextField Author;
    private javax.swing.JComboBox<String> BookComboBox;
    private javax.swing.JTextField BookName;
    private javax.swing.JComboBox<String> CategoryComboBox;
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField Language;
    private javax.swing.JTextField PaperCount;
    private javax.swing.JFormattedTextField PublishDate;
    private javax.swing.JLabel ShowBookIMG;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField prImagePathInput;
    // End of variables declaration//GEN-END:variables
}
