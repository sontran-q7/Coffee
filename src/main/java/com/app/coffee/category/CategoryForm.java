/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.coffee.category;

import com.app.coffee.bill.Bill;
import com.app.coffee.dashboard.DashboardPage;
import com.app.coffee.employee.EmployeeManager;
import com.app.coffee.menu.MenuPanel;
import com.app.coffee.product.Product;
import com.app.coffee.product.ProductDao;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
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
public class CategoryForm extends javax.swing.JPanel {

    private int currentSTT = 1; // Biến để giữ số thứ tự hiện tại
    /**
     * Creates new form CategoryForm
     */
    public Category c;

    public CategoryForm() {
        initComponents();
        loadPanels();
        refreshCategoryTable();

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    CategoryTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        // Đặt căn giữa tất cả các cột
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < CategoryTable.getColumnCount(); i++) {
            CategoryTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

//        // TRONG DESIGN Propreties tìm SHOWGRID ĐỂ HIỂN THỊ ĐƯỜNG VIỀN
//        JTableHeader header = CategoryTable.getTableHeader();
//        // Tạo đường viền cho tiêu đề
//
//        header.setDefaultRenderer(new CustomHeaderRenderer());
        // Tạo đường viền cho bảng
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        CategoryPanel01 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoryTable = new javax.swing.JTable();
        CategoryFormPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DeleteCategory = new javax.swing.JButton();
        AddCategoryButton = new javax.swing.JButton();
        EditCategoryButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 81));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Category Manager");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(1344, 718));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CategoryPanel01.setBackground(new java.awt.Color(255, 255, 255));
        CategoryPanel01.setLayout(new java.awt.BorderLayout());

        CategoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Category name", "Description", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CategoryTable.setToolTipText("");
        CategoryTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CategoryTable.setRowHeight(30);
        CategoryTable.setShowGrid(true);
        jScrollPane1.setViewportView(CategoryTable);
        if (CategoryTable.getColumnModel().getColumnCount() > 0) {
            CategoryTable.getColumnModel().getColumn(0).setMinWidth(100);
            CategoryTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            CategoryTable.getColumnModel().getColumn(0).setMaxWidth(100);
            CategoryTable.getColumnModel().getColumn(1).setMinWidth(300);
            CategoryTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            CategoryTable.getColumnModel().getColumn(1).setMaxWidth(300);
            CategoryTable.getColumnModel().getColumn(3).setMinWidth(0);
            CategoryTable.getColumnModel().getColumn(3).setPreferredWidth(0);
            CategoryTable.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        CategoryPanel01.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(CategoryPanel01, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 800, 640));

        CategoryFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        CategoryFormPanel.setLayout(new java.awt.CardLayout());
        jPanel3.add(CategoryFormPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 430, 640));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Category Table :");
        jLabel1.setMaximumSize(new java.awt.Dimension(110, 22));
        jLabel1.setMinimumSize(new java.awt.Dimension(110, 22));
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 22));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Category Form :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 120, 30));

        DeleteCategory.setBackground(new java.awt.Color(0, 0, 0));
        DeleteCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DeleteCategory.setForeground(new java.awt.Color(255, 255, 255));
        DeleteCategory.setText("Delete");
        DeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCategoryActionPerformed(evt);
            }
        });
        jPanel3.add(DeleteCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 90, 30));

        AddCategoryButton.setBackground(new java.awt.Color(255, 102, 0));
        AddCategoryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddCategoryButton.setForeground(new java.awt.Color(255, 255, 255));
        AddCategoryButton.setText("Add");
        AddCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCategoryButtonActionPerformed(evt);
            }
        });
        jPanel3.add(AddCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 90, 30));

        EditCategoryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditCategoryButton.setForeground(new java.awt.Color(255, 102, 0));
        EditCategoryButton.setText("Edit");
        EditCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditCategoryButtonActionPerformed(evt);
            }
        });
        jPanel3.add(EditCategoryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 30, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCategoryButtonActionPerformed
        AddCategory newCategory = new AddCategory(this); // Truyền tham chiếu của CategoryForm vào AddCategory
        showPanel("addCategory");

    }//GEN-LAST:event_AddCategoryButtonActionPerformed

    private void EditCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditCategoryButtonActionPerformed
        int selectedRow = CategoryTable.getSelectedRow(); // Lấy hàng được chọn trong bảng

        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();

            // Lấy thông tin của category từ bảng
            String categoryName = model.getValueAt(selectedRow, 1).toString(); // Lấy tên danh mục
            String description = model.getValueAt(selectedRow, 2).toString(); // Lấy mô tả

            // Hiển thị form chỉnh sửa
            int categoryId = getCategoryIdByName(categoryName); // Lấy category_id từ cơ sở dữ liệu dựa trên tên danh mục
            EditCategory editCategory = new EditCategory(this, categoryId, categoryName, description);
            CategoryFormPanel.add(editCategory, "editCategory");
            showPanel("editCategory");
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to edit.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_EditCategoryButtonActionPerformed

    private void DeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCategoryActionPerformed
        int selectedRow = CategoryTable.getSelectedRow(); // Lấy hàng được chọn trong bảng

        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) { // Nếu người dùng xác nhận muốn xóa
                DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
                String category_id = model.getValueAt(selectedRow, 3).toString(); // Lấy ID của category từ model của bảng

                CategoryDao categoryDao = new CategoryDao();
                ProductDao productDao = new ProductDao();

                // Kiểm tra xem danh mục có sản phẩm liên quan không
                if (productDao.hasProductsForCategory(category_id)) {
                    int option2 = JOptionPane.showConfirmDialog(this, "Cannot delete! There are products currently associated with this category!", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                } else {
                    // Không có sản phẩm liên quan, chỉ cần xóa danh mục
                    if (categoryDao.deleteCategory(category_id)) {
                        model.removeRow(selectedRow); // Xóa hàng được chọn khỏi bảng
//                        refreshCategoryTable();
                        updateTableSTT(); // Cập nhật lại STT
                        JOptionPane.showMessageDialog(this, "Successfully deleted!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to delete category!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeleteCategoryActionPerformed

    private void loadPanels() {
        AddCategory addCategory = new AddCategory(this);
        CategoryFormPanel.add(addCategory, "addCategory");

    }

    private void showPanel(String panelName) {
        ((CardLayout) CategoryFormPanel.getLayout()).show(CategoryFormPanel, panelName);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCategoryButton;
    private javax.swing.JPanel CategoryFormPanel;
    private javax.swing.JPanel CategoryPanel01;
    private javax.swing.JTable CategoryTable;
    private javax.swing.JButton DeleteCategory;
    private javax.swing.JButton EditCategoryButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    void refreshCategoryTable() {
        DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu cũ trong bảng

        // Lấy danh sách các danh mục từ cơ sở dữ liệu và thêm vào bảng
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getAllCategories();
        // Thêm các hàng mới vào bảng với stt tự động tăng
        int stt = 1;
        for (Category category : categories) {
            Object[] row = {stt++, category.getCategory_name(), category.getDescription(), category.getCategory_id()}; //category.getCategory_id(), 
            model.addRow(row);
        }
    }

    private int getCategoryIdByName(String categoryName) {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getAllCategories();
        for (Category category : categories) {
            if (category.getCategory_name().equals(categoryName)) {
                return category.getCategory_id();
            }
        }
        return -1; // Nếu không tìm thấy, trả về -1 hoặc xử lý khác phù hợp
    }
    
    private void updateTableSTT() {
        DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // Cập nhật lại STT
        }
    }
}
