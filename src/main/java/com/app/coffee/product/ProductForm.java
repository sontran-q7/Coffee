/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import com.app.coffee.category.CustomHeaderRenderer;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

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
        ProductTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        ProductTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        // Đặt căn giữa tất cả các cột
//        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//        for (int i = 0; i < ProductTable.getColumnCount(); i++) {
//            ProductTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }
        // TRONG DESIGN Propreties tìm SHOWGRID ĐỂ HIỂN THỊ ĐƯỜNG VIỀN
//        JTableHeader header = ProductTable.getTableHeader();
        // Tạo đường viền cho tiêu đề
//        Border headerBorder = BorderFactory.createLineBorder(Color.BLACK, 1); // Đường viền, độ dày
//        header.setBorder(headerBorder);
        // Đặt đường viền cho tiêu đề của từng cột
//        header.setDefaultRenderer(new CustomHeaderRenderer());
        // Tạo đường viền cho bảng
//        Border tableBorder = BorderFactory.createLineBorder(Color.BLACK, 1); // Đường viền, độ dày
//        ProductTable.setBorder(tableBorder);
        // Đặt màu sắc cho đường viền giữa các ô trong bảng
//        ProductTable.setGridColor(Color.BLACK); // màu đường viền
        //  màu nền và màu chữ cho bảng
//        ProductTable.setBackground(Color.WHITE);
//        CategoryTable.setForeground(Color.BLACK); // màu nền 
//        ProductTable.setSelectionBackground(Color.LIGHT_GRAY); // màu nền của ô được chọn
//        ProductTable.setSelectionForeground(Color.BLACK); // màu chữ của ô được chọn
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
                    setHorizontalAlignment(JLabel.CENTER);
                } else {
                    setHorizontalAlignment(JLabel.CENTER);
                }
                
                // Đặt căn giữa cho tiêu đề của cột
                setHorizontalAlignment(SwingConstants.CENTER);

                // Đặt đường viền cho từng cột trong tiêu đề
                JTableHeader header = ProductTable.getTableHeader();
                if (header != null) {
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.LIGHT_GRAY)); // Đường viền đen giữa các cột
                }
                // Đặt cỡ chữ cho tiêu đề của cột
                setFont(new Font("Arial", Font.BOLD, 14)); // Thay "Arial" và 14 bằng font và kích thước mong muốn

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
        comboSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = ProductTable.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedSize = (String) comboSize.getSelectedItem();
                    int price = sizePriceMap.get(selectedSize);
                    ProductTable.setValueAt(price, selectedRow, 6);
                }
            }
        });
        ProductTable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboSize));

    // Lấy mô hình cột của JTable
//    TableColumnModel columnModel = ProductTable.getColumnModel();

    // Ẩn cột có chỉ số 7
//    TableColumn column = columnModel.getColumn(7);
//    columnModel.removeColumn(column);
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
//         Thêm MouseListener để lắng nghe sự kiện click vào bảng
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
        
//        ProductTable.setRowHeight(80);
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
                "No", "Image", "Category name", "Product name", "Description", "Size", "Price", "Title 8"
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
        ProductTable.setShowHorizontalLines(false);
        ProductTable.setShowVerticalLines(false);
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
        jPanel2.add(ProductFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 430, 640));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Product form:");
        jLabel2.setMaximumSize(new java.awt.Dimension(120, 22));
        jLabel2.setMinimumSize(new java.awt.Dimension(120, 22));
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, 120, 30));

        EditProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProduct.setForeground(new java.awt.Color(255, 102, 0));
        EditProduct.setText("Edit");
        EditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProductActionPerformed(evt);
            }
        });
        jPanel2.add(EditProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, 90, 30));

        DeleteProduct.setBackground(new java.awt.Color(51, 51, 51));
        DeleteProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProduct.setText("Delete");
        DeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 30, 90, 30));

        AddProduct.setBackground(new java.awt.Color(255, 102, 0));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(255, 255, 255));
        AddProduct.setText("Add");
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });
        jPanel2.add(AddProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 90, 30));

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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void EditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProductActionPerformed
        int row = ProductTable.getSelectedRow();
        if (row != -1) {
            //            product_id_select = (int) ProductTable.getValueAt(row, 7);
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