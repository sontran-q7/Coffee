/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


/**
 *
 * @author anhso
 */
public class ProductForm extends javax.swing.JPanel {

    public ProductDao pd = new ProductDao();
    public int product_id_select;
    private EditProduct editProduct;

    public ProductForm() {
        initComponents();
        loadPanels();
        fillAllProduct();
        customJtable();
        
        // Đặt căn giữa cho cột
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ProductTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
      
    }

    ProductForm(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void customJtable() {
        ProductTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column != 4) {
                    setHorizontalAlignment(JLabel.CENTER);
                } else {
                    setHorizontalAlignment(JLabel.CENTER);
                }
                // Đặt căn giữa cho tiêu đề của cột
                setHorizontalAlignment(SwingConstants.CENTER);
//                // Đặt đường viền cho từng cột trong tiêu đề
                JTableHeader header = ProductTable.getTableHeader();
                if (header != null) {
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(204, 204, 204))); 
                }
                // Đặt cỡ chữ cho tiêu đề của cột
                setFont(new Font("Segoe ui", Font.PLAIN, 12)); 
                return this;
            }
        });
        //set image for column
        ProductTable.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                if (o == null) {
                    //  No Image
                    JLabel label = new JLabel("No Image");
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setOpaque(selected);
                    label.setBackground(com.getBackground());
                    return label;
                } else {
                    //  Has Image
                    if (o instanceof ImageIcon) {
//                       
                        ImageIcon imageIcon = (ImageIcon) o;
                        int rowHeight = jtable.getRowHeight();
                        Image img = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        JLabel label = new JLabel(new ImageIcon(img));
                        label.setHorizontalAlignment(JLabel.CENTER);
                        label.setOpaque(selected);
                        label.setBackground(com.getBackground());
                        return label;
                    } else {
                        return new JLabel("Invalid Image");
                    }

                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        productPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ProductFormPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        EditProduct = new javax.swing.JButton();
        DeleteProduct = new javax.swing.JButton();
        AddProduct = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Manager");
        jLabel1.setMaximumSize(new java.awt.Dimension(212, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(212, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(212, 32));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1089, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(1344, 718));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productPanel.setBackground(new java.awt.Color(255, 255, 255));
        productPanel.setLayout(new java.awt.BorderLayout());

        ProductTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "", null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Image", "Category name", "Product name", "Description", "Price S", "Price L", "Title 8"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ProductTable.setMaximumSize(new java.awt.Dimension(2147483647, 1500));
        ProductTable.setMinimumSize(new java.awt.Dimension(110, 1500));
        ProductTable.setPreferredSize(new java.awt.Dimension(375, 1500));
        ProductTable.setRowHeight(60);
        ProductTable.setShowGrid(true);
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProductTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setMinWidth(50);
            ProductTable.getColumnModel().getColumn(0).setMaxWidth(50);
            ProductTable.getColumnModel().getColumn(1).setMinWidth(100);
            ProductTable.getColumnModel().getColumn(1).setMaxWidth(100);
            ProductTable.getColumnModel().getColumn(2).setMinWidth(150);
            ProductTable.getColumnModel().getColumn(2).setMaxWidth(150);
            ProductTable.getColumnModel().getColumn(5).setMinWidth(60);
            ProductTable.getColumnModel().getColumn(5).setMaxWidth(60);
            ProductTable.getColumnModel().getColumn(6).setMinWidth(100);
            ProductTable.getColumnModel().getColumn(6).setMaxWidth(100);
            ProductTable.getColumnModel().getColumn(7).setMinWidth(0);
            ProductTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            ProductTable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        productPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(productPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 800, 640));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Product Table:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 30));

        ProductFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        ProductFormPanel.setLayout(new java.awt.CardLayout());
        jPanel2.add(ProductFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 430, 640));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Product form:");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 120, 30));

        EditProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProduct.setForeground(new java.awt.Color(255, 102, 0));
        EditProduct.setText("Edit");
        EditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductActionPerformed(evt);
            }
        });
        jPanel2.add(EditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 90, 30));

        DeleteProduct.setBackground(new java.awt.Color(51, 51, 51));
        DeleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProduct.setText("Delete");
        DeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 90, 30));

        AddProduct.setBackground(new java.awt.Color(255, 102, 0));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProduct.setText("Add");
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });
        jPanel2.add(AddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 90, 30));

        btnLoadData.setBackground(new java.awt.Color(255, 102, 0));
        btnLoadData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoadData.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadData.setText("Refresh");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });
        jPanel2.add(btnLoadData, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        int row = ProductTable.getSelectedRow();
        // Kiểm tra nếu row hợp lệ
        if (row >= 0) {
            // Lấy danh sách sản phẩm từ ProductDao
            List<Product> productList = pd.fillAllProduct();
            // Kiểm tra nếu row không vượt quá kích thước của danh sách
            if (row < productList.size()) {
                Product p = productList.get(row);
                product_id_select = p.getProduct_id();
                customJtable();
                if (evt.getClickCount() == 2) {
       
                    if (editProduct == null) {
                        editProduct = new EditProduct(this, product_id_select);
                        ProductFormPanel.add(editProduct, "editProduct");
//                        editProduct.getDataTable();
                    } else {
                        editProduct = new EditProduct(this, product_id_select);
                        ProductFormPanel.add(editProduct, "editProduct");
//                        editProduct.getDataTable();
                    }
                    // Hiển thị panel editProduct và gọi getDataTable()
//                    showPanel("editProduct");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid row selection! Row exceeds product list size.");
            }
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid row selection! No row selected.");
        }
                                        
    }//GEN-LAST:event_ProductTableMouseClicked

    private void ProductTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductTableMouseEntered

    private void EditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductActionPerformed
         int selectedRow = ProductTable.getSelectedRow();
        
        if (selectedRow != -1) {
            //            product_id_select = (int) ProductTable.getValueAt(row, 7);
            EditProduct editProduct = new EditProduct(this, product_id_select);
            ProductFormPanel.add(editProduct, "editProduct");
            editProduct.getDataTable();
            showPanel("editProduct");
        } else {
            EditProduct editProduct = new EditProduct(this, product_id_select);
//            //        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
            ProductFormPanel.add(editProduct, "editProduct");
//            showPanel("editProduct");
            JOptionPane.showMessageDialog(this, "Please select an item to edit.", "Thông báo", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_EditProductActionPerformed

    private void DeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductActionPerformed
        deleteProduct();
    }//GEN-LAST:event_DeleteProductActionPerformed

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed

        AddProduct addproduct = new AddProduct(this);
        //        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
        ProductFormPanel.add(addproduct, "addProduct");
        showPanel("addProduct");
    }//GEN-LAST:event_AddProductActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        fillAllProduct();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void loadPanels() {
        AddProduct addproduct = new AddProduct(this);
//        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
        ProductFormPanel.add(addproduct, "addProduct");
    }

    public void showPanel(String panelName) {

        ((CardLayout) ProductFormPanel.getLayout()).show(ProductFormPanel, panelName);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProduct;
    private javax.swing.JButton DeleteProduct;
    private javax.swing.JButton EditProduct;
    private javax.swing.JPanel ProductFormPanel;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel productPanel;
    // End of variables declaration//GEN-END:variables

    private void fillAllProduct() {
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        ArrayList<Product> listProduct = new ArrayList<>();
        int stt = 1;
        model.setRowCount(0);
//        String imageDir = "D:\\300\\500\\lan2\\Coffee\\Coffee\\src\\main\\java\\com\\app\\coffee\\image";
        String imageDir = System.getProperty("user.dir") + "/src/main/java/com/app/coffee/image";
        listProduct = pd.fillAllProduct();
        for (Product p : listProduct) {
            ImageIcon imageIcon = null;
            if (p.getImage() != null && !p.getImage().isEmpty()) {
                String imagePath = imageDir + "/" + p.getImage();
                imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            }
            model.addRow(new Object[]{
                stt++,
                imageIcon,
                p.getCategory().getCategory_name(),
                p.getProduct_name(),
                p.getDescription(),
                "",
                "",
                p.getProduct_id()
            });
        }
        fillAllPriceL();
        fillAllPriceS();
    }

    private void fillAllPriceS() {
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        ArrayList<ProductDetail> listProductDetailPriceS = pd.fillAllPriceS();

        int rowCount = model.getRowCount();
        int detailCount = listProductDetailPriceS.size();
        int minSize = Math.min(rowCount, detailCount);

        for (int i = 0; i < minSize; i++) {
            ProductDetail pd = listProductDetailPriceS.get(i);
            model.setValueAt(pd.getPrice(), i, 5); // Cột 5 là cột PriceS
        }
    }

    private void fillAllPriceL() {
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        ArrayList<ProductDetail> listProductDetailPriceL = pd.fillAllPriceL();

        int rowCount = model.getRowCount();
        int detailCount = listProductDetailPriceL.size();
        int minSize = Math.min(rowCount, detailCount);

        for (int i = 0; i < minSize; i++) {
            ProductDetail pd = listProductDetailPriceL.get(i);
            model.setValueAt(pd.getPrice(), i, 6); // Cột 6 là cột PriceL
        }
    }
    
    public void reloadTable() {
        try {
            // Xóa hết dữ liệu trên bảng
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            model.setRowCount(0);
            fillAllProduct();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkRowSelection() {
        int selectedRow = ProductTable.getSelectedRow();
        return selectedRow != -1;
    }

    private void deleteProduct() {
        int row = ProductTable.getSelectedRow();
        if (row != -1) {
            int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Notification", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                int idDelete = (int) ProductTable.getValueAt(row, 7);
                pd.DeleteMem(idDelete);
                 JOptionPane.showMessageDialog(null, "Delete success!");
                fillAllProduct();
            } else {

                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row is selected. Please select a row to delete!");
            return;
        }
    }

}