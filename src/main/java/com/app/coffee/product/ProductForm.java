/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhso
 */
public class ProductForm extends javax.swing.JPanel {

    /**
     * Creates new form ProductForm
     */
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
        ProductTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);

    }

    ProductForm(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void customJtable() {
        ProductTable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
                super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
                if (column != 4) {
                    setHorizontalAlignment(JLabel.LEFT);
                } else {
                    setHorizontalAlignment(JLabel.CENTER);
                }
                return this;
            }
        });
        //set combobox for table
        JComboBox<String> comboSize = new JComboBox();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        ArrayList<ProductDetail> listProductSizeByID = pd.fillAllProductDetailByID(product_id_select);
        // Khởi tạo một map để lưu giá theo kích thước
        Map<String, Integer> sizePriceMap = new HashMap<>();
        for (ProductDetail c : listProductSizeByID) {
            comboBoxModel.addElement(c.getSize());
            sizePriceMap.put(c.getSize(), c.getPrice());
        }
        comboSize.setModel(comboBoxModel);
        comboSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedRow = ProductTable.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy dữ liệu từ dòng được chọn
                        int productId = (int) ProductTable.getValueAt(selectedRow, 7);
                        String selectedSize = (String) e.getItem();
                        int price = sizePriceMap.get(selectedSize);
                        ProductTable.setValueAt(price, selectedRow, 6);
                    }
                }
            }
        });
        ProductTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboSize));

        //an cot thu 7
//        ProductTable.removeColumn(ProductTable.getColumnModel().getColumn(7));
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
//                        Icon image = (ImageIcon) o;
//                        JLabel label = new JLabel(image);
//                        label.setHorizontalAlignment(JLabel.CENTER);
//                        label.setOpaque(selected);
//                        label.setBackground(com.getBackground());
//                        return label;
                        ImageIcon imageIcon = (ImageIcon) o;
                        int rowHeight = jtable.getRowHeight();
                        Image img = imageIcon.getImage().getScaledInstance(rowHeight, rowHeight, Image.SCALE_SMOOTH);
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
        // Thêm MouseListener để lắng nghe sự kiện click vào bảng
        ProductTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = ProductTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Lấy idProduct từ cột tương ứng (giả sử là cột thứ 7)
                    int productId = (int) ProductTable.getValueAt(selectedRow, 7);
                }
            }
        });
        ProductTable.setRowHeight(80);
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
        Productpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        ProductFormPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EditProduct = new javax.swing.JButton();
        DeleteProduct = new javax.swing.JButton();
        AddProduct = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product Manager");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1072, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));

        Productpanel.setBackground(new java.awt.Color(255, 255, 255));
        Productpanel.setLayout(new java.awt.BorderLayout());

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
                "STT", "Image", "Category name", "Product name", "Description", "Size", "Price", "ID_Product"
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
            ProductTable.getColumnModel().getColumn(1).setMinWidth(120);
            ProductTable.getColumnModel().getColumn(1).setMaxWidth(120);
            ProductTable.getColumnModel().getColumn(5).setMinWidth(50);
            ProductTable.getColumnModel().getColumn(5).setMaxWidth(50);
            ProductTable.getColumnModel().getColumn(6).setMinWidth(100);
            ProductTable.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        Productpanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(Productpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 810, 540));

        ProductFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        ProductFormPanel.setLayout(new java.awt.CardLayout());
        add(ProductFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 430, 540));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Product form:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Product Table:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 210, 30));

        EditProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProduct.setForeground(new java.awt.Color(255, 102, 0));
        EditProduct.setText("Edit");
        EditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductActionPerformed(evt);
            }
        });
        add(EditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 110, 100, 30));

        DeleteProduct.setBackground(new java.awt.Color(51, 51, 51));
        DeleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProduct.setText("Delete");
        DeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductActionPerformed(evt);
            }
        });
        add(DeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 110, 100, 30));

        AddProduct.setBackground(new java.awt.Color(255, 102, 0));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProduct.setText("Add");
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });
        add(AddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 100, 30));

        btnLoadData.setText("Load Data");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });
        add(btnLoadData, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed

        AddProduct addproduct = new AddProduct(this);
//        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
        ProductFormPanel.add(addproduct, "addProduct");
        showPanel("addProduct");
    }//GEN-LAST:event_AddProductActionPerformed

    private void EditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductActionPerformed
        int row = ProductTable.getSelectedRow();
        if (row != -1) {
            product_id_select = (int) ProductTable.getValueAt(row, 7);
            EditProduct editProduct = new EditProduct(this, product_id_select);
//        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
            ProductFormPanel.add(editProduct, "editProduct");
            editProduct.getDataTable();
            showPanel("editProduct");
        } else {
            EditProduct editProduct = new EditProduct(this, product_id_select);
//        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
            ProductFormPanel.add(editProduct, "editProduct");
            showPanel("editProduct");
        }

    }//GEN-LAST:event_EditProductActionPerformed

    private void DeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductActionPerformed
        deleteProduct();
    }//GEN-LAST:event_DeleteProductActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
           fillAllProduct();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        // TODO add your handling code here:
        int row = ProductTable.getSelectedRow();
        // Kiểm tra nếu double-click vào dòng hợp lệ
        Product p = pd.fillAllProduct().get(row);
        product_id_select = p.getProduct_id();
        System.out.println("Pro_form:" + product_id_select);
        customJtable();
        if (evt.getClickCount() == 2) {
            // Nếu chưa có editProduct, tạo mới và thêm vào ProductFormPanel
            if (editProduct == null) {
                editProduct = new EditProduct(this, product_id_select);
                ProductFormPanel.add(editProduct, "editProduct");
                editProduct.getDataTable();
            } else {
                editProduct = new EditProduct(this, product_id_select);
                ProductFormPanel.add(editProduct, "editProduct");
                editProduct.getDataTable();
            }

            // Hiển thị panel editProduct và gọi getDataTable()
        }
        showPanel("editProduct");

    }//GEN-LAST:event_ProductTableMouseClicked

    private void ProductTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductTableMouseEntered

    private void loadPanels() {
        AddProduct addproduct = new AddProduct(this);
//        EditProduct editProduct = new EditProduct(this, product_id, image, description, name, price, catego_id, size);
        ProductFormPanel.add(addproduct, "addProduct");
//        ProductFormPanel.add(editProduct, "editProduct");
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
    private javax.swing.JPanel Productpanel;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
                p.getProductDetail().getSize(),
                p.getProductDetail().getPrice(),
                p.getProduct_id()
            });

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
//11111