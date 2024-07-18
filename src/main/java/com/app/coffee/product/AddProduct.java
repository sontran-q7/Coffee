/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import javax.swing.JOptionPane;

import com.app.coffee.category.CategoryDao;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author anhso
 */
public class AddProduct extends javax.swing.JPanel {

    public int idProduct;
    private ProductForm productForm;
    public CategoryDao cd = new CategoryDao();
    public ProductDao pd = new ProductDao();
    public File anh = null;

    /**
     * Creates new form
     */
    public AddProduct(ProductForm productForm) {
        initComponents();
        this.productForm = productForm;
        fillComboboxCategory();

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        comboBoxCategory = new javax.swing.JComboBox<>();
        txtProduct = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnSetupProduct = new javax.swing.JButton();
        btnChooseImage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesscription = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(430, 640));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Product");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Image:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Category:");

        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSetupProduct.setBackground(new java.awt.Color(255, 102, 0));
        btnSetupProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSetupProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnSetupProduct.setText("Next");
        btnSetupProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupProductActionPerformed(evt);
            }
        });

        btnChooseImage.setBackground(new java.awt.Color(204, 204, 204));
        btnChooseImage.setText("Choose image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Description");

        txtDesscription.setColumns(20);
        txtDesscription.setRows(5);
        jScrollPane1.setViewportView(txtDesscription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 289, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnChooseImage)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSetupProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetupProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetupProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupProductActionPerformed
        if (!checkvalidate()) { 
            return;
        } else {
            try {
                Product p = addProduct();
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?", "Notification", JOptionPane.YES_NO_OPTION);
                if (i == 0) {
                    Integer productId = pd.insertProduct(p);
                    if (productId != null) {
                        idProduct = productId;
                        System.out.println("addPRoduct: " + idProduct);
                        new AddProductDetail(this, productForm, idProduct).setVisible(true);

                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSetupProductActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        String initialDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
        JFileChooser fileChooser = new JFileChooser(new File(initialDir));
        fileChooser.setDialogTitle("Choose an image file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String imageName = selectedFile.getName(); 

            String destinationDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
            File destinationDirFile = new File(destinationDir);

            if (!destinationDirFile.exists()) {
                destinationDirFile.mkdirs();
            }
            //Xử lý tên file duy nhất nếu nó không nằm trong thư mục /src/main/java/com/app/coffee/image
            if (!selectedFile.getParent().equals(destinationDirFile.getAbsolutePath())) {
                String baseFileName = imageName.substring(0, imageName.lastIndexOf("."));
                String extension = imageName.substring(imageName.lastIndexOf(".") + 1);
                int counter = 1;
                File destinationFile = new File(destinationDir, imageName);
                while (destinationFile.exists()) {
                    String newFileName = baseFileName + "_" + counter + "." + extension;
                    destinationFile = new File(destinationDir, newFileName);
                    counter++;
                }
                try {          
                    Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    ImageIcon selectedImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image selectedImage = selectedImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon resizedImageIcon = new ImageIcon(selectedImage);
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(resizedImageIcon);
                    JOptionPane.showMessageDialog(null, imageLabel, "Selected Image", JOptionPane.PLAIN_MESSAGE);

                    txtImage.setText(destinationFile.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to copy the image!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
      
                try {
                  
                    Files.copy(selectedFile.toPath(), new File(destinationDir, imageName).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    ImageIcon selectedImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image selectedImage = selectedImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon resizedImageIcon = new ImageIcon(selectedImage);
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(resizedImageIcon);
                    JOptionPane.showMessageDialog(null, imageLabel, "Selected Image", JOptionPane.PLAIN_MESSAGE);
                    txtImage.setText(imageName);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to copy the image!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

     private void fillComboboxCategory() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) comboBoxCategory.getModel();
        combo.removeAllElements();
        List<Category> list = cd.getAllCategories();
        for (Category c : list) {
            combo.addElement(c);
        }
    }
    private boolean checkvalidate() {
        ProductDao productDao = new ProductDao();
        String imagePath = txtImage.getText();  // Assuming you have a text field for the image path
        String image = txtImage.getText();
        String product = txtProduct.getText();
        String description = txtDesscription.getText();
        if (image.isEmpty() || product.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot be empty!");
            return false;
        }

        if (!isImageFile(imagePath)) {
            JOptionPane.showMessageDialog(null, "Invalid image file! Please provide a valid image.");
            return false;
        }

        if (productDao.isProductExists(product)) {
            JOptionPane.showMessageDialog(null, "Product name already exists!");
            return false;
        }
        return true;
    }

    private boolean isImageFile(String path) {
        String[] imageExtensions = {"jpg", "jpeg", "png", "gif", "bmp"};
        for (String extension : imageExtensions) {
            if (path.toLowerCase().endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }

    public Product addProduct() {
        Product product = new Product();
        String image = txtImage.getText();
        String productName = txtProduct.getText();
        String description = txtDesscription.getText();
        Category selectedCategory = (Category) comboBoxCategory.getSelectedItem();

        product.setCategory(selectedCategory);
        product.setImage(image);
        product.setDescription(description);
        product.setProduct_name(productName);
        return product;
    }

    public int getIDAddProduct(int id) {
        System.out.println(id);
        return id;

    }
    public void resetFields() {
        txtImage.setText("");
        txtProduct.setText("");
        txtDesscription.setText("");
        comboBoxCategory.setSelectedIndex(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSetupProduct;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDesscription;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables

}
