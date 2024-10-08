/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import com.app.coffee.category.CategoryDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import static javax.swing.JDialog.setDefaultLookAndFeelDecorated;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author anhso
 */
public class AddProductDetail extends javax.swing.JDialog {

    public CategoryDao cd = new CategoryDao();
    ProductDao pd = new ProductDao();
    private ProductForm productForm;
    private AddProduct parent;
    public int id;

    private void setScreen() {
        setDefaultLookAndFeelDecorated(true);
        setMinimumSize(new java.awt.Dimension(450, 630));
        setPreferredSize(new java.awt.Dimension(450, 630));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
    }

    public AddProductDetail(AddProduct parent, ProductForm productForm, int idProduct) {
        this.productForm = productForm;
        this.parent = parent;
        this.id = idProduct;
        setScreen();
        initComponents();
        fillComboboxCategory();
        getDataAddProduct();
    }

    private void getDataAddProduct() {
        Product p = pd.fillAllAddProductDetail(id);
        txtImage.setText(p.getImage());
        txtDescription.setText(p.getDescription());
        txtProduct.setText(p.getProduct_name());
//        comboBoxCategory.setSelectedIndex();
    // Tìm chỉ số của danh mục
        Category productCategory = p.getCategory();
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) comboBoxCategory.getModel();
        int selectedIndex = -1;

        for (int i = 0; i < comboModel.getSize(); i++) {
            Category category = (Category) comboModel.getElementAt(i);
            if (category.getCategory_id()== productCategory.getCategory_id()) {
                selectedIndex = i;
                break;
            }
        }

        // Đặt chỉ số đã chọn của combo box
        if (selectedIndex != -1) {
            comboBoxCategory.setSelectedIndex(selectedIndex);
        }
    
        txtImage.setEnabled(false);
        comboBoxCategory.setEnabled(false);
        txtProduct.setEnabled(false);
        txtDescription.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Image = new javax.swing.JLabel();
        Product = new javax.swing.JLabel();
        Category_name = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        comboBoxCategory = new javax.swing.JComboBox<>();
        txtProduct = new javax.swing.JTextField();
        btnAddProduct = new javax.swing.JButton();
        Description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        Size = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        txtPriceS = new javax.swing.JTextField();
        txtPriceL = new javax.swing.JTextField();
        jLabelSizeS = new javax.swing.JLabel();
        jLabelSizeL = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Setup Product Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        Image.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Image.setText("Image :");

        Product.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Product.setText("Product:");

        Category_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Category_name.setText("Category:");

        txtImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageActionPerformed(evt);
            }
        });

        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoryActionPerformed(evt);
            }
        });

        btnAddProduct.setBackground(new java.awt.Color(255, 102, 0));
        btnAddProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Save");
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        Description.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Description.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        Size.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Size.setText("Size:");

        Price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Price.setText("Price:");

        jLabelSizeS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSizeS.setText("S");

        jLabelSizeL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSizeL.setText("L");

        btnCancel.setBackground(new java.awt.Color(51, 51, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Description, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Image, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Product, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImage, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProduct, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Category_name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxCategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Price)
                                .addGap(18, 18, 18)
                                .addComponent(txtPriceS, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Size)
                                .addGap(23, 23, 23)
                                .addComponent(jLabelSizeS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPriceL, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabelSizeL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Product, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Category_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Size, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSizeS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSizeL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPriceS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPriceL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        if (!checkvalidate()) { // Kiểm tra nếu không hợp lệ
            return;
        } else {
            try {
                ProductDetail pDetailtL = addProductDetailSizeL();
                ProductDetail pDetailtS = addProductDetailSizeS();
                Integer addS = pd.insertProductDetail(pDetailtS);
                Integer addL = pd.insertProductDetail(pDetailtL);
                if (addS != null && addL != null) {
                    JOptionPane.showMessageDialog(null, "Add success!");
                    dispose();
                    if (productForm != null) {
                        productForm.reloadTable(); // Gọi phương thức reloadTable từ form cha
                    }
                    parent.resetFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Add failure!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void txtImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void comboBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoryActionPerformed

    private boolean checkvalidate() {
        String imagePath = txtImage.getText();  // Assuming you have a text field for the image path
        String product = txtProduct.getText();
        String description = txtDescription.getText();
        String priceL = txtPriceL.getText();
        String priceS = txtPriceS.getText();


        if (product.isEmpty() || description.isEmpty() || priceL.isEmpty() || priceS.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
            return false;
        }
        
        if (!isFloat(priceL) || !isFloat(priceS)) {
            JOptionPane.showMessageDialog(null, "Price must be a valid float number!");
            return false;
        }
         
        try {
            float priceLarge = Float.parseFloat(priceL);
            float priceSmall = Float.parseFloat(priceS);

            if (priceLarge <= 0 || priceSmall <= 0) {
                JOptionPane.showMessageDialog(null, "Price must be a positive integer!");
                return false;
            }
            if (priceLarge <= priceSmall) {
                JOptionPane.showMessageDialog(null, "The price of size L must be higher than the price of size S");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price format! Please enter valid integers.");
            return false;
        }

        return true;
    }

    private boolean isFloat(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ProductDetail addProductDetailSizeS() {
        ProductDetail pDetail = new ProductDetail();
        float priceS = Float.parseFloat(txtPriceS.getText());
        Product p = pd.fillAllAddProductDetail(id);
        pDetail.setProduct(p);
        pDetail.setPrice(priceS);
        pDetail.setSize("S");
        return pDetail;
    }

    public ProductDetail addProductDetailSizeL() {
        ProductDetail pDetail = new ProductDetail();
        float priceL = Float.parseFloat(txtPriceL.getText());
        Product p = pd.fillAllAddProductDetail(id);
        pDetail.setProduct(p);
        pDetail.setPrice(priceL);
        pDetail.setSize("L");
        return pDetail;
    }

    private void fillComboboxCategory() {
        DefaultComboBoxModel combo = (DefaultComboBoxModel) comboBoxCategory.getModel();
        combo.removeAllElements();
        List<Category> list = cd.getAllCategories();
        for (Category c : list) {
            combo.addElement(c);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category_name;
    private javax.swing.JLabel Description;
    private javax.swing.JLabel Image;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel Product;
    private javax.swing.JLabel Size;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSizeL;
    private javax.swing.JLabel jLabelSizeS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtPriceL;
    private javax.swing.JTextField txtPriceS;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables

}
