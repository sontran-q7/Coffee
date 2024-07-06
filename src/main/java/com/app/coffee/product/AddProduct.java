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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Product");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Image :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Product:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Category:");

        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("reset");
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
        btnChooseImage.setText("choose image");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCategory, 0, 300, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChooseImage))
                            .addComponent(txtImage))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(btnSetupProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetupProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetupProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupProductActionPerformed

        if (!checkvalidate()) { // Kiểm tra nếu không hợp lệ
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
//        JFileChooser fileChooser = new JFileChooser("src/main/java/com/app/coffee/image"); // Không đặt đường dẫn cố định
//        fileChooser.setDialogTitle("Choose an image file");
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
//        int returnValue = fileChooser.showOpenDialog(null);
//
//        if (returnValue == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
//            anh = selectedFile;
//            String imageName = selectedFile.getName(); // Lấy tên của hình ảnh
//
//            // Đường dẫn đích bạn muốn sao chép tới
//            String destinationPath = "src/main/java/com/app/coffee/image/" + imageName;
//            File destinationFile = new File(destinationPath);
//
//            try {
//                // Sao chép tệp tin
//                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//                // Thay đổi kích thước ảnh trước khi hiển thị trên JLabel
//                ImageIcon originalImage = new ImageIcon(destinationFile.getAbsolutePath());
//                Image scaledImage = originalImage.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon selectedImage = new ImageIcon(scaledImage);
//                lblImage.setIcon(selectedImage);
//
//                // Hiển thị tên tệp tin đã sao chép vào JTextField
//                txtImage.setText(imageName);
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Failed to copy the image!", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }

        // Đường dẫn tương đối tới thư mục hình ảnh
        String initialDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";

        // Tạo JFileChooser và thiết lập thư mục mặc định
        JFileChooser fileChooser = new JFileChooser(new File(initialDir));
        fileChooser.setDialogTitle("Choose an image file");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            anh = selectedFile;
            String imageName = selectedFile.getName(); // Lấy tên của hình ảnh

            // Đường dẫn đích bạn muốn sao chép tới
            String destinationDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
            File destinationDirFile = new File(destinationDir);

            // Tạo thư mục nếu nó chưa tồn tại
            if (!destinationDirFile.exists()) {
                destinationDirFile.mkdirs();
            }

            // Đường dẫn đích bạn muốn sao chép tới
            String destinationPath = destinationDir + "/" + imageName;
            File destinationFile = new File(destinationPath);

            try {
                // Sao chép tệp tin
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Thay đổi kích thước ảnh trước khi hiển thị trên JLabel
//                ImageIcon originalImage = new ImageIcon(destinationFile.getAbsolutePath());
//                Image scaledImage = originalImage.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon selectedImage = new ImageIcon(scaledImage);
//                lblImage.setIcon(selectedImage);
                    ImageIcon selectedImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                  // Thay đổi kích thước của hình ảnh
                    Image selectedImage = selectedImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon resizedImageIcon = new ImageIcon(selectedImage);

                    // Xem trước hình ảnh đã chọn với kích thước cố định
                    JLabel imageLabel = new JLabel();
                    imageLabel.setIcon(resizedImageIcon);
                    JOptionPane.showMessageDialog(null, imageLabel, "Selected Image", JOptionPane.PLAIN_MESSAGE);

                // Hiển thị tên tệp tin đã sao chép vào JTextField
                txtImage.setText(imageName);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to copy the image!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed


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

    private void fillComboboxCategory() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) comboBoxCategory.getModel();
        combo.removeAllElements();
        List<Category> list = cd.getAllCategories();
        for (Category c : list) {
            combo.addElement(c);
        }
    }

    private boolean checkvalidate() {
        String image = txtImage.getText();
        String product = txtProduct.getText();
        String description = txtDesscription.getText();
        if (image.isEmpty() || product.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot be empty!");
            return false;
        }
        return true;
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
//        lblImage.setText("");
        txtDesscription.setText("");
        comboBoxCategory.setSelectedIndex(0);
    }
}
