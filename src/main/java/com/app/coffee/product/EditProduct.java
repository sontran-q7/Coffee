/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import com.app.coffee.category.CategoryDao;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author anhso
 */
public class EditProduct extends javax.swing.JPanel {

    private ProductForm productForm;
    public File anh = null;
    public CategoryDao cd = new CategoryDao();
    ProductDao pd = new ProductDao();
    public int id;

    public EditProduct(ProductForm productForm, int idProduct) {
        this.productForm = productForm;
        this.id = idProduct;
        initComponents();
        fillComboboxCategory();
        cboCategory.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        txtProduct = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        btnChooseImage = new javax.swing.JButton();
        Size = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        txtPriceS = new javax.swing.JTextField();
        txtPriceL = new javax.swing.JTextField();
        jLabelSizeS = new javax.swing.JLabel();
        jLabelSizeL = new javax.swing.JLabel();
        Description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        cboCategory = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(430, 640));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Product");
        jLabel1.setMaximumSize(new java.awt.Dimension(117, 25));
        jLabel1.setMinimumSize(new java.awt.Dimension(117, 25));
        jLabel1.setPreferredSize(new java.awt.Dimension(117, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Category:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Image:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Product:");

        txtImage.setActionCommand("<Not Set>");
        txtImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageActionPerformed(evt);
            }
        });

        txtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(51, 51, 51));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(75, 30));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdateProduct.setBackground(new java.awt.Color(255, 102, 0));
        btnUpdateProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProduct.setText("Save");
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        btnChooseImage.setBackground(new java.awt.Color(204, 204, 204));
        btnChooseImage.setText("Choose image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        Size.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Size.setText("Size:");

        Price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Price.setText("Price:");

        jLabelSizeS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSizeS.setText("S");

        jLabelSizeL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSizeL.setText("L");

        Description.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Description.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Description)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnChooseImage))
                        .addComponent(txtImage)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Price)
                                .addComponent(Size))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPriceS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelSizeS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(txtPriceL, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(81, 81, 81)
                                    .addComponent(jLabelSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1)
                        .addComponent(txtProduct)
                        .addComponent(cboCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSizeS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPriceL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageActionPerformed

    private void txtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed

        if (productForm != null && !productForm.checkRowSelection()) {
            JOptionPane.showMessageDialog(null, "No row is selected. Please select a row to edit!");
            return;
        }
        
        if (!checkvalidate()) { 
            return;
        } else {
            try {
                ProductDetail pdS = editProductDetailSizeS();
                ProductDetail pdL = editProductDetailSizeL();
                int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit?", "Notification", JOptionPane.YES_NO_OPTION);
                if (i == 0) {

                    if (pd.UpdateProductAndDetailSizeS(pdS, id) != null && pd.UpdateProductAndDetailSizeL(pdL, id) != null) {
                        JOptionPane.showMessageDialog(null, "Edited successfully!");
                        if (productForm != null) {
                            productForm.reloadTable(); // Gọi phương thức reloadTable từ form cha
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Add failure!");
                    }
                } else {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
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
         
            String destinationDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
            File destinationDirFile = new File(destinationDir);

            if (!destinationDirFile.exists()) {
                destinationDirFile.mkdirs();
            }

            String destinationPath = destinationDir + "/" + imageName;
            File destinationFile = new File(destinationPath);

            try {
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);      
                    ImageIcon selectedImageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                  // Thay đổi kích thước của hình ảnh
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
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
  
        resetFields();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Description;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Size;
    public javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelSizeL;
    private javax.swing.JLabel jLabelSizeS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    public static javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtPriceL;
    private javax.swing.JTextField txtPriceS;
    public static javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables

    private void fillComboboxCategory() {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model = (DefaultComboBoxModel) cboCategory.getModel();
        model.removeAllElements();
        List<Category> list = cd.getAllCategories();
        for (Category c : list) {
            model.addElement(c);
        }
    }

    public void getDataTable() {
        ArrayList<ProductDetail> listPD = pd.showDataProductDetail(id);
        System.out.println("edit:" + id);

        for (ProductDetail p : listPD) {
            txtDescription.setText(p.getProduct().getDescription());
            txtImage.setText(p.getProduct().getImage());
            txtProduct.setText(p.getProduct().getProduct_name());
            cboCategory.setSelectedIndex(1);
            if (p.getSize().equals("S")) {
                txtPriceS.setText(p.getPrice().toString());
            }
            if (p.getSize().equals("L")) {
                txtPriceL.setText(p.getPrice().toString());
            }
        }
    }

    private boolean checkvalidate() {
        String imagePath = txtImage.getText();
        String product = txtProduct.getText();
        String description = txtDescription.getText();
        String priceL = txtPriceL.getText();
        String priceS = txtPriceS.getText();
        if (imagePath.isEmpty() || product.isEmpty() || description.isEmpty() || priceL.isEmpty() || priceS.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cannot be empty!");
            return false;
        }
        if (!isNumeric(priceL) || !isNumeric(priceS)) {
            JOptionPane.showMessageDialog(null, "Price must be numeric!");
            return false;
        }
        if (!isImageFile(imagePath)) {
            JOptionPane.showMessageDialog(null, "Invalid image file! Please provide a valid image.");
            return false;
        }
        try {
            int priceLarge = Integer.parseInt(priceL);
            int priceSmall = Integer.parseInt(priceS);

            if (priceLarge <= 0 || priceSmall <= 0) {
                JOptionPane.showMessageDialog(null, "Price must be a positive integer!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price format! Please enter valid integers.");
            return false;
        }
        return true;
    }

    private boolean isImageFile(String path) {
        String[] imageExtensions = { "jpg", "jpeg", "png", "gif", "bmp" };
        for (String extension : imageExtensions) {
            if (path.toLowerCase().endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ProductDetail editProductDetailSizeS() {
        ProductDetail pDetail = new ProductDetail();
        Product p = new Product();
        p.setProduct_id(id);
        Category selectedCategory = (Category) cboCategory.getSelectedItem();
        p.setCategory(selectedCategory);
        p.setDescription(txtDescription.getText());
        p.setImage(txtImage.getText());
        p.setProduct_name(txtProduct.getText());
        pDetail.setProduct(p);
        pDetail.setPrice(Integer.parseInt(txtPriceS.getText()));
        return pDetail;
    }

    public ProductDetail editProductDetailSizeL() {
        ProductDetail pDetail = new ProductDetail();
        Product p = new Product();
        p.setProduct_id(id);
        Category selectedCategory = (Category) cboCategory.getSelectedItem();
        p.setCategory(selectedCategory);
        p.setDescription(txtDescription.getText());
        p.setImage(txtImage.getText());
        p.setProduct_name(txtProduct.getText());
        pDetail.setProduct(p);
        pDetail.setPrice(Integer.parseInt(txtPriceL.getText()));
        return pDetail;
    }

    public void resetFields() {
        txtImage.setText("");
        txtProduct.setText("");
        txtPriceS.setText("");
        txtPriceL.setText("");
        txtDescription.setText("");
        cboCategory.setSelectedIndex(0);
    }
}
